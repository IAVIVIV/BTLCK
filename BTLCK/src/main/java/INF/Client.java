package INF;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import APP.DTO_Message;
import DOMAIN.Service;

public class Client {

	private String serverIP;
	private int serverPort;
	private String clientIP;
	private ObjectOutputStream out;

	public Client(String clientIP, String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.clientIP = clientIP; // Bạn có thể thay đổi IP của client nếu cần
	}

	public void start(String nameBtn, List<String> list) throws Exception {
		try (Socket socket = new Socket(serverIP, serverPort)) {
			out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			// Luồng lắng nghe tin nhắn từ server
			new Thread(new ReceiveMessageHandler(in)).start();

			// Luồng gửi tin nhắn tới server
//			Scanner scanner = new Scanner(System.in);

//			while (true) {
//				System.out.println("Enter the button name:");
//				String nameButton = scanner.nextLine();
//				System.out.println("Enter your message:");
//				String content = scanner.nextLine();

			if (nameBtn.equals("Đăng ký")) {
				String username = list.get(0);
				String email = list.get(1);
				String password = list.get(2);
				String key = Service.createKey();
				String encryptedStringPassword = Service.encrypt(key, password);
				List<String> encryptedList = new ArrayList<String>();
				encryptedList.add(username);
				encryptedList.add(email);
				encryptedList.add(encryptedStringPassword);
				encryptedList.add(key);
//					DTO_Register message = new DTO_Register(username, email, encryptedStringPassword);
				sendMessage(nameBtn, encryptedList);
			}
		}
//		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String nameButton, List<String> message) {
		try {
			out.writeUTF(nameButton);
			out.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class ReceiveMessageHandler implements Runnable {
		private ObjectInputStream in;

		public ReceiveMessageHandler(ObjectInputStream in) {
			this.in = in;
		}

		@Override
		public void run() {
			try {
				while (true) {
					DTO_Message message = (DTO_Message) in.readObject();
					System.out.println("Received message: " + message.getContent());
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
