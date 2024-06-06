package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import INF.Client;

public class ControllerRegister implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameBtn = e.getActionCommand();
		if (nameBtn == "Đăng ký") {
			String taiKhoan = ViewRegister.txtTiKhon.getText();
			String email = ViewRegister.txtEmail.getText();
			String matKhau = ViewRegister.txtMtKhu.getText();
			String matkhau2 = ViewRegister.txtNhpLiMt.getText();
			if (!taiKhoan.equals("Tài khoản") && !taiKhoan.equals("") && !email.equals("Email") && !email.equals("")
					&& !matKhau.equals("Mật khẩu") && !matKhau.equals("") && matkhau2.equals(matKhau)) {
				String serverIP = "192.168.1.3";
				int serverPort = 12345;
				String clientIP = "192.168.1.3";
				Client client = new Client(clientIP, serverIP, serverPort);
				List<String> list = new ArrayList<String>();
				list.add(taiKhoan);
				list.add(email);
				list.add(matKhau);
				try {
					client.start(nameBtn, list);
					ViewRegister.frame.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
