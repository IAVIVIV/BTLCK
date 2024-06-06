package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtTiKhon;
	public static JTextField txtEmail;
	public static JTextField txtMtKhu;
	public static JTextField txtNhpLiMt;
	private JLabel lblNewLabel_2;
	public static ViewRegister frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewRegister();
					frame.setTitle("JChat");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewRegister() {
		ControllerRegister ct = new ControllerRegister();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 226, 299);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 122, 26);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhanh chóng và dễ dàng.");
		lblNewLabel_1.setForeground(new Color(96, 103, 112));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 40, 154, 16);
		panel.add(lblNewLabel_1);

		txtTiKhon = new JTextField();

		txtTiKhon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTiKhon.setText("");
				txtTiKhon.setForeground(new Color(0, 0, 0));
			}
		});

		txtTiKhon.setForeground(new Color(221, 223, 226));
		txtTiKhon.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtTiKhon.setText("Tài khoản");
		txtTiKhon.setBounds(10, 79, 207, 26);
		panel.add(txtTiKhon);
		txtTiKhon.setColumns(10);

		txtEmail = new JTextField();

		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmail.setText("");
				txtEmail.setForeground(new Color(0, 0, 0));
			}
		});

		txtEmail.setText("Email");
		txtEmail.setForeground(new Color(221, 223, 226));
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 115, 207, 26);
		panel.add(txtEmail);

		txtMtKhu = new JTextField();

		txtMtKhu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMtKhu.setText("");
				txtMtKhu.setForeground(new Color(0, 0, 0));
			}
		});

		txtMtKhu.setText("Mật khẩu");
		txtMtKhu.setForeground(new Color(221, 223, 226));
		txtMtKhu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtMtKhu.setColumns(10);
		txtMtKhu.setBounds(10, 151, 207, 26);
		panel.add(txtMtKhu);

		txtNhpLiMt = new JTextField();

		txtNhpLiMt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNhpLiMt.setText("");
				txtNhpLiMt.setForeground(new Color(0, 0, 0));
			}
		});

		txtNhpLiMt.setText("Nhập lại mật khẩu");
		txtNhpLiMt.setForeground(new Color(221, 223, 226));
		txtNhpLiMt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNhpLiMt.setColumns(10);
		txtNhpLiMt.setBounds(10, 187, 207, 26);
		panel.add(txtNhpLiMt);

		JButton btnNewButton = new JButton("Đăng ký");

		btnNewButton.addActionListener(ct);

		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(66, 183, 42));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(57, 239, 117, 32);
		panel.add(btnNewButton);

		lblNewLabel_2 = new JLabel(
				"_________________________________________________________________________________________________________");
		lblNewLabel_2.setForeground(new Color(221, 223, 226));
		lblNewLabel_2.setBounds(-39, 56, 320, 13);
		panel.add(lblNewLabel_2);
	}
}
