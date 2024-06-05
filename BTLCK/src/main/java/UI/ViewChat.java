package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewChat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JList<String> jList;
	public static JTextField txtT;
	public static JTextField txtNhpEmail;
	public static JTextField txtNhpIp;
	public static JTextArea txtrSdgd;
	public static DefaultListModel<String> listModel;
	public static ViewChat frame;

	public static String selectUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewChat();
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
	public ViewChat() {
		ControllerChat ct = new ControllerChat();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(172, 72, 572, 396);
		contentPane.add(panel);
		panel.setLayout(null);

		txtT = new JTextField();
		txtT.setBackground(new Color(221, 223, 226));
		txtT.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtT.setBounds(0, 360, 458, 36);
		panel.add(txtT);
		txtT.setColumns(10);

		JButton btnNewButton = new JButton("Send");

		btnNewButton.addActionListener(ct);

		btnNewButton.setForeground(new Color(75, 79, 86));
		btnNewButton.setBackground(new Color(245, 246, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setBounds(455, 360, 117, 36);
		panel.add(btnNewButton);

		txtrSdgd = new JTextArea();
		txtrSdgd.setBackground(new Color(246, 247, 255));
		txtrSdgd.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtrSdgd.setEditable(false);
		txtrSdgd.setBounds(0, 0, 572, 360);
		panel.add(txtrSdgd);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 242, 245));
		panel_1.setBounds(0, 72, 174, 396);
		panel_1.setLayout(new BorderLayout());
		contentPane.add(panel_1);

		listModel = new DefaultListModel<>();
		jList = new JList<>(listModel);

		JScrollPane scrollPane = new JScrollPane(jList);
		panel_1.add(scrollPane, BorderLayout.CENTER);

//		jList.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1) {
//					System.out.println("Chaof ngay moi vui ve");
//					int index = jList.locationToIndex(e.getPoint());
//					if (index >= 0) {
//						txtrSdgd.setText("");
//						String sender = ViewLogIn.username;
//						String receiver = jList.getModel().getElementAt(index);
//						ViewChat.selectUser = receiver;
//						Service s = new Service();
//						try {
//							List<String> content = s.reloadMessage(sender, receiver);
//							for (String string : content) {
//								txtrSdgd.setText(ViewChat.txtrSdgd.getText() + string + "\n");
//							}
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//				}
//			}
//		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(314, 0, 457, 72);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtNhpEmail = new JTextField();

//		txtNhpEmail.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				txtNhpEmail.setText("");
//				txtNhpEmail.setForeground(new Color(0, 0, 0));
//			}
//		});

		txtNhpEmail.setBackground(new Color(255, 255, 255));
		txtNhpEmail.setForeground(new Color(221, 223, 226));
		txtNhpEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNhpEmail.setText("Nhập email để kết bạn");
		txtNhpEmail.setBounds(0, 0, 305, 36);
		panel_2.add(txtNhpEmail);
		txtNhpEmail.setColumns(10);

		txtNhpIp = new JTextField();

//		txtNhpIp.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				txtNhpIp.setText("");
//				txtNhpIp.setForeground(new Color(0, 0, 0));
//			}
//		});

		txtNhpIp.setForeground(new Color(221, 223, 226));
		txtNhpIp.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNhpIp.setText("Nhập địa chỉ để gửi");
		txtNhpIp.setColumns(10);
		txtNhpIp.setBounds(0, 36, 305, 36);
		panel_2.add(txtNhpIp);

		JButton btnNewButton_1 = new JButton("accept_e");

		btnNewButton_1.addActionListener(ct);

		btnNewButton_1.setForeground(new Color(75, 79, 86));
		btnNewButton_1.setBackground(new Color(245, 246, 247));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(304, 0, 128, 36);
		panel_2.add(btnNewButton_1);
	}
}
