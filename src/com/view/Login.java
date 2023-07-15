package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Credential;
import com.service.StudentService;
import com.service.StudentServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JTextField usernametxt;
	private JButton login;
	private JButton signup;
	private JPasswordField passwordtxt;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getUsernametxt());
		contentPane.add(getLogin());
		contentPane.add(getSignup());
		contentPane.add(getPasswordtxt());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("D:\\Java Workspace\\SwingProject\\src\\com\\photo\\icon.png"));
			lblNewLabel.setBounds(0, 0, 268, 415);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("LOGIN");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(383, 11, 177, 34);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("UserName");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(319, 83, 103, 22);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("PassWord");
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_2_1.setBounds(319, 138, 103, 22);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("Create Account:");
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_2_2.setBounds(334, 284, 131, 22);
		}
		return lblNewLabel_2_2;
	}
	private JTextField getUsernametxt() {
		if (usernametxt == null) {
			usernametxt = new JTextField();
			usernametxt.setBounds(408, 79, 152, 34);
			usernametxt.setColumns(10);
		}
		return usernametxt;
	}
	private JButton getLogin() {
		if (login == null) {
			login = new JButton("Login");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Credential c = new Credential();
					c.setUsername(usernametxt.getText());
					c.setPassword(passwordtxt.getText());
					
					StudentService ss = new StudentServiceImpl();
					boolean res = ss.login(c);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Login Success");
						new SignupForm().setVisible(true);
						dispose();	
					}else {
						JOptionPane.showMessageDialog(null, "LoginFailure");
					}
					
									
				}
			});
			login.setFont(new Font("Tahoma", Font.PLAIN, 14));
			login.setBounds(471, 198, 89, 34);
		}
		return login;
	}
	private JButton getSignup() {
		if (signup == null) {
			signup = new JButton("Sign-Up");
			signup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				 
					new signup().setVisible(true);
					dispose();
					
				}
			});
			signup.setFont(new Font("Tahoma", Font.PLAIN, 14));
			signup.setBounds(475, 278, 109, 34);
		}
		return signup;
	}
	private JPasswordField getPasswordtxt() {
		if (passwordtxt == null) {
			passwordtxt = new JPasswordField();
			passwordtxt.setBounds(408, 134, 152, 34);
		}
		return passwordtxt;
	}
}
