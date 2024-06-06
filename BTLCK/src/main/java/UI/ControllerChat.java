package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import INF.Client;

public class ControllerChat implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameBtn = e.getActionCommand();
		if (nameBtn == "Send") {
			String sender = ViewLogIn.username;
			String receiver = ViewChat.selectUser;
			String content = ViewChat.txtT.getText();
			String destinationIP = ViewChat.txtNhpIp.getText();
			if (!content.equals("") && !content.equals(null) && !destinationIP.equals("Nhập địa chỉ để gửi")
					&& !destinationIP.equals("") && !destinationIP.equals(null)) {
				String serverIP = "192.168.1.3";
				int serverPort = 12345;
				String clientIP = "192.168.1.3";
				Client client = new Client(clientIP, serverIP, serverPort);
				List<String> list = new ArrayList<String>();
				list.add(sender);
				list.add(receiver);
				list.add(content);
				list.add(destinationIP);
				list.add(clientIP);
				ViewChat.txtrSdgd.setText(
						ViewChat.txtrSdgd.getText() + ViewLogIn.username + " :  " + ViewChat.txtT.getText() + "\n");
				ViewChat.txtT.setText("");
				try {
					client.start(nameBtn, list);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (nameBtn == "accept_e") {
			String email = ViewChat.txtNhpEmail.getText();
//			String content = ViewChat.txtT.getText();
//			String destinationIP = ViewChat.txtNhpIp.getText();
			if (!ViewChat.txtNhpEmail.getText().equals("Nhập email để kết bạn")
					&& !ViewChat.txtNhpEmail.getText().equals("") && !email.equals("Nhập email để kết bạn")
					&& !email.equals("") && !email.equals(null)
//					&& !content.equals("") && !content.equals(null)
//					&& !destinationIP.equals("Nhập địa chỉ để gửi") && !destinationIP.equals("")
//					&& !destinationIP.equals(null)
			) {
				String serverIP = "192.168.1.3";
				int serverPort = 12345;
				String clientIP = "192.168.1.3";
//				ViewChat.txtrSdgd.setText(
//						ViewChat.txtrSdgd.getText() + ViewLogIn.username + " : " + ViewChat.txtT.getText() + "\n");
				Client client = new Client(clientIP, serverIP, serverPort);
				List<String> list = new ArrayList<String>();
				list.add(email);
				list.add(clientIP);
				try {
					client.start(nameBtn, list);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
