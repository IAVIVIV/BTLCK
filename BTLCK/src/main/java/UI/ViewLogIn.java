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

public class ViewLogIn extends JFrame {

	public static String username;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtTiKhon;
	public static JTextField txtMtKhu;
	public static ViewLogIn frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewLogIn();
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
	public ViewLogIn() {
		ControllerLogIn ct = new ControllerLogIn();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 242, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("JChat");
		lblNewLabel.setForeground(new Color(66, 135, 245));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel.setBounds(25, 10, 75, 55);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(177, 27, 249, 226);
		contentPane.add(panel);
		panel.setLayout(null);

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
		txtTiKhon.setToolTipText("");
		txtTiKhon.setBounds(10, 10, 229, 34);
		panel.add(txtTiKhon);
		txtTiKhon.setColumns(10);

		txtMtKhu = new JTextField();

		txtMtKhu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMtKhu.setText("");
				txtMtKhu.setForeground(new Color(0, 0, 0));
			}
		});

		txtMtKhu.setForeground(new Color(221, 223, 226));
		txtMtKhu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtMtKhu.setText("Mật khẩu");
		txtMtKhu.setColumns(10);
		txtMtKhu.setBounds(10, 56, 229, 34);
		panel.add(txtMtKhu);

		JButton btnNewButton = new JButton("Đăng nhập");

		btnNewButton.addActionListener(ct);

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(66, 135, 245));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton.setBounds(10, 100, 229, 34);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Quên mật khẩu?");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(86, 146, 99, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("________________________________________");
		lblNewLabel_2.setForeground(new Color(221, 223, 226));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 169, 269, 13);
		panel.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Tạo tài khoản mới");

		btnNewButton_1.addActionListener(ct);

		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(66, 183, 42));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 192, 229, 24);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("Kết nối bạn bè, chia sẻ niềm vui.");
		lblNewLabel_3.setForeground(new Color(28, 30, 33));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(177, 261, 249, 35);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Đăng nhập để kết nối");
		lblNewLabel_4.setForeground(new Color(28, 30, 33));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(25, 85, 119, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Đăng nhập");
		lblNewLabel_5.setForeground(new Color(51, 51, 51));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_5.setBounds(24, 51, 120, 35);
		contentPane.add(lblNewLabel_5);
	}
}
