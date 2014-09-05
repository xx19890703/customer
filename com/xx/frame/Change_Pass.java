package com.xx.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.xx.modal.Userinfo;
import com.xx.publics.util.Check;
import com.xx.publics.util.Constants;
import com.xx.service.UserinfoService;

public class Change_Pass extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Change_Pass dialog = new Change_Pass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Change_Pass() {
		setBounds(400, 200, 373, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("旧  密  码：");
			lblNewLabel.setBounds(32, 13, 73, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(135, 10, 143, 21);
			contentPanel.add(passwordField);
		}
		{
			JLabel label = new JLabel("新  密  码：");
			label.setBounds(32, 53, 73, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("确认新密码：");
			label.setBounds(32, 95, 93, 15);
			contentPanel.add(label);
		}
		{
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(135, 50, 143, 21);
			contentPanel.add(passwordField_1);
		}
		{
			passwordField_2 = new JPasswordField();
			passwordField_2.setBounds(135, 92, 143, 21);
			contentPanel.add(passwordField_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Userinfo luser = Constants.user;
						String olds = String.valueOf(passwordField.getPassword());
						String news1 = String.valueOf(passwordField_1.getPassword());
						String news2 = String.valueOf(passwordField_2.getPassword());
						if(!Check.checkNull(new String[]{"旧密码","新密码","确认新密码"}, new String[]{olds,news1,news2})){
							return ;
						}
						if(news1.equals(news2)){
							if(luser!=null){
								String opd = luser.getPassword();
								if(opd.equals(olds)){
									UserinfoService us = new UserinfoService();
									luser.setPassword(news1);
									us.save(luser);
									Constants.user = luser;
									JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
									Change_Pass.this.dispose();
									return ;
								}else{
									JOptionPane.showMessageDialog(null, "旧密码错误！请重新输入！", "提示", JOptionPane.INFORMATION_MESSAGE);
									passwordField.setText("");
									passwordField_1.setText("");
									passwordField_2.setText("");
									return ;
								}
							}else{
								JOptionPane.showMessageDialog(null, "系统未登录，请重新登陆", "提示", JOptionPane.INFORMATION_MESSAGE);
								Change_Pass.this.dispose();
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
						}else{
							JOptionPane.showMessageDialog(null, "2次新密码不同，请重新输入！", "提示", JOptionPane.INFORMATION_MESSAGE);
							passwordField_1.setText("");
							passwordField_2.setText("");
							return ;
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Change_Pass.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
