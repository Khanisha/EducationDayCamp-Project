package EducationDayCamp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JInternalFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.border.LineBorder;


import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Arial", Font.BOLD, 17));
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\uum logo.png"));
		setTitle("EDC UUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					if(textFieldUsername.getText().equals("Khanisha") && textFieldPassword.getText().equals("1234")) {
						//JOptionPane.showMessageDialog(null, "Login Successful");
						
						//AdminHome frame //calling another frame/window
							AdminHome frame = new AdminHome();
							frame.setModalExclusionType(null);
				            frame.setVisible(true);
				            dispose(); //login frame will disappear
					}else
						JOptionPane.showMessageDialog(null, "Invalid Username/Password ! Please enter the valid Username/Password.");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Username/Password ! Please enter the valid Username/Password.");
				}
			}
		});
		btnLogin.setBackground(SystemColor.scrollbar);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBounds(472, 463, 160, 49);
		panel.add(btnLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Segoe UI Semilight", Font.BOLD, 22));
		lblUsername.setBounds(319, 223, 151, 69);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Segoe UI Semilight", Font.BOLD, 22));
		lblPassword.setBounds(319, 309, 151, 69);
		panel.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = "Khanisha";
				textFieldUsername.setText(userName);
			}
		});
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setLabelFor(textFieldUsername);
		textFieldUsername.setBounds(495, 240, 285, 33);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userPswd = "1234";
				textFieldPassword.setText(userPswd);
			}
		});
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setLabelFor(textFieldPassword);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(495, 332, 285, 33);
		panel.add(textFieldPassword);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUsername.setText("");
				textFieldPassword.setText("");
			}
		});
		btnReset.setBackground(SystemColor.scrollbar);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReset.setBounds(287, 463, 160, 49);
		panel.add(btnReset);
		
		JLabel lbluum = new JLabel("");
		lbluum.setIcon(new ImageIcon("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\EducationDayCamp\\image\\lbluum(Home,Login).png"));
		lbluum.setBounds(-14, 0, 233, 274);
		panel.add(lbluum);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Home page //calling another frame/window
				Home frame = new Home();
				frame.setModalExclusionType(null);
	            frame.setVisible(true);
	            dispose(); //login frame will disappear
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBackground(SystemColor.scrollbar);
		btnBack.setBounds(654, 463, 160, 49);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(75, 0, 130), 5));
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(264, 195, 577, 364);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(153, 50, 204), 5));
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(209, 37, 768, 124);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTitle = new JLabel("EDUCATION DAY CAMP UUM");
		lblTitle.setBounds(24, 36, 733, 65);
		panel_2.add(lblTitle);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 50));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\EducationDayCamp\\image\\lblBackground(Home,Login,Register).jpg"));
		lblBackground.setBounds(-61, -24, 1062, 653);
		panel.add(lblBackground);
	}
}
