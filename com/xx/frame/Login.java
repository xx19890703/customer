package com.xx.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.xx.modal.Userinfo;
import com.xx.publics.util.Constants;
import com.xx.service.UserinfoService;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					UserinfoService us = new UserinfoService();
					us.getUserinfo("asd");
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
		setTitle("系统登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(81, 49, 87, 32);
		contentPane.add(label);

		JLabel label_1 = new JLabel("密  码：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		label_1.setBounds(81, 126, 87, 32);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 17));
		textField.setBounds(188, 48, 165, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 17));
		passwordField.setBounds(188, 125, 165, 37);
		passwordField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e){
				 int k = e.getKeyCode();
				 if(k == KeyEvent.VK_ENTER){
					 log();
				 }
			 }
		});
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("登陆");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(107, 188, 81, 32);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		JButton button = new JButton("取消");
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(231, 188, 81, 32);
		button.addActionListener(this);
		contentPane.add(button);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("登陆")) {
			log();
		} else if (e.getActionCommand().equals("取消")) {
			Login.this.dispose();
		}
	}

	public void log(){
		String name = textField.getText();
		char[] passwords = passwordField.getPassword();
		String password = String.valueOf(passwords);
		UserinfoService us = new UserinfoService();
		Userinfo u = us.getUserinfo(name);
		if(u!=null){
			if(u.getPassword().equals(password)){
				Constants.user = u;
				Login.this.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main frame = new Main();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}else{
				JOptionPane.showMessageDialog(null, "密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
				return ;
			}
		}else{
			JOptionPane.showMessageDialog(null, "用户名不存在!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
	}
}
