package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import INF.Client;

public class ControllerLogIn implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String nameBtn = e.getActionCommand();
		if (nameBtn == "Đăng nhập") {
			String taiKhoan = ViewLogIn.txtTiKhon.getText();
			String matKhau = ViewLogIn.txtMtKhu.getText();
			if (!taiKhoan.equals("Tài khoản") && !taiKhoan.equals("") && !matKhau.equals("Mật khẩu")
					&& !matKhau.equals("")) {
				String serverIP = "192.168.1.3";
				int serverPort = 12345;
				String clientIP = "192.168.1.3";
				Client client = new Client(clientIP, serverIP, serverPort);
				List<String> list = new ArrayList<String>();
				list.add(taiKhoan);
				list.add(matKhau);
				list.add(clientIP);
				try {
					ViewLogIn.username = taiKhoan;
					client.start(nameBtn, list);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (nameBtn == "Tạo tài khoản mới") {
			ViewRegister.main(null);
		}
	}
}
