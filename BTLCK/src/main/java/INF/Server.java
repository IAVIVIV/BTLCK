package INF;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import APP.DTO_Message;
import APP.UseCase;

public class Server {

	private int port;
	private Set<ClientHandler> clientHandlers = new HashSet<>();

	public Server(int port) {
		this.port = port;
	}

	public void startServer() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server is listening on port " + port);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
				ClientHandler clientHandler = new ClientHandler(socket, this);
				clientHandlers.add(clientHandler);
				clientHandler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public synchronized void broadcast(DTO_Message message, ClientHandler excludeClient) {
//		for (ClientHandler client : clientHandlers) {
//			if (client != excludeClient) {
//				client.sendMessage(message);
//			}
//		}
//	}

//	public synchronized void broadcast(Message message) {
//		String destinationIP = message.getDestinationIP();
//		for (ClientHandler client : clientHandlers) {
//			if (client.getClientIP().equals(destinationIP)) {
//				client.sendMessage(message);
//				break; // Gửi tin nhắn chỉ đến một client duy nhất
//			}
//		}
//	}

	public synchronized void removeClient(ClientHandler clientHandler) {
		clientHandlers.remove(clientHandler);
	}

	private static class ClientHandler extends Thread {
		private Socket socket;
		private Server server;
		private ObjectOutputStream out;

		public ClientHandler(Socket socket, Server server) {
			this.socket = socket;
			this.server = server;
		}

		public void run() {
			try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
				out = new ObjectOutputStream(socket.getOutputStream());

//				while (true) {
				String nameButton = in.readUTF();
				List<String> message = (List<String>) in.readObject();

				// Xử lý hành động theo nameButton và gửi phản hồi hoặc broadcast
				if (nameButton.equals("Đăng ký")) {
					System.out.println(
							message.get(0) + "   " + message.get(1) + "   " + message.get(2) + "   " + message.get(3));
					UseCase.register(message.get(0), message.get(1), message.get(2), message.get(3));
//						server.broadcast(message, this);
				} else {
					// Thực hiện các hành động khác theo yêu cầu
				}
//				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				server.removeClient(this);
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		public void sendMessage(DTO_Message message) {
//			try {
//				out.writeObject(message);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	public static void main(String[] args) {
		int port = 12345;
		Server server = new Server(port);
		server.startServer();
	}
}
