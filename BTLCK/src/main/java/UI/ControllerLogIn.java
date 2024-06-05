package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLogIn implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String nameBtn = e.getActionCommand();
		if (nameBtn == "Đăng nhập") {
		} else if (nameBtn == "Tạo tài khoản mới") {
		}
	}
}
