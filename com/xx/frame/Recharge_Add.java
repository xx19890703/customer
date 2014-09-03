package com.xx.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.xx.modal.Cardinfo;
import com.xx.publics.util.Check;
import com.xx.publics.util.DateUtil;
import com.xx.service.CardinfoService;
import com.xx.service.RechargeService;

public class Recharge_Add extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Cardinfo_Add cpanel;
	private String cusId;

	/**
	 * Create the frame.
	 */
	public Recharge_Add(Cardinfo_Add panel,String cusId) {
		cpanel = panel;
		this.cusId = cusId;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("会员卡充值");
		setAlwaysOnTop(true);
		setBounds(100, 100, 409, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("充值");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(80, 108, 95, 34);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("取消");
		button.addActionListener(this);
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(206, 108, 95, 34);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 17));
		textField.setBounds(161, 47, 158, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("充值金额：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(68, 53, 83, 23);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("充值")) {
			String ms = textField.getText();
			if(!Check.checkNull(new String[]{"充值金额"}, new String[]{ms})){
				return ;
			}
			if(!Check.checkNum(new String[]{"充值金额"}, new String[]{ms})){
				return ;
			}
			BigDecimal money = new BigDecimal(ms);
			CardinfoService cis = new CardinfoService();
			Cardinfo card = cis.getCardinfoByCustomer(cusId);
			com.xx.modal.Recharge r = new com.xx.modal.Recharge();
			r.setCard(card);
			r.setMoney(money);
			r.setTime(DateUtil.getSystemTime());
			RechargeService rs = new RechargeService();
			rs.save(r);
			cpanel.select();
			Recharge_Add.this.dispose();
			JOptionPane.showMessageDialog(null, "充值成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("取消")) {
			Recharge_Add.this.dispose();
		} 
	}
}
