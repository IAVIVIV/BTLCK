package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerChat implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameBtn = e.getActionCommand();
		if (nameBtn == "Send") {
		} else if (nameBtn == "accept_e") {
		}
	}
}
