package com.xx.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.xx.modal.Customer;
import com.xx.service.CustomerService;

public class Customer_Add extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField name;
	private JLabel label_1;
	private JTextField age;
	private JTextField tell;
	private JTextField address;
	private JTextArea memo;
	private JComboBox month;
	private JComboBox day;
	private JComboBox sex;
	/**
	 * Create the panel.
	 */
	public Customer_Add() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("会员编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 40, 75, 31);
		add(lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.PLAIN, 15));
		id.setBounds(151, 39, 191, 32);
		add(id);
		id.setColumns(10);
		
		JLabel label = new JLabel("姓   名：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(46, 110, 75, 31);
		add(label);
		
		name = new JTextField();
		name.setFont(new Font("宋体", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(151, 110, 119, 32);
		add(name);
		
		label_1 = new JLabel("生   日：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(355, 102, 75, 31);
		add(label_1);
		
		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month.setFont(new Font("宋体", Font.PLAIN, 15));
		month.setBounds(440, 102, 60, 31);
		add(month);
		
		JLabel label_2 = new JLabel("月");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(505, 102, 24, 31);
		add(label_2);
		
		day = new JComboBox();
		day.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day.setFont(new Font("宋体", Font.PLAIN, 15));
		day.setBounds(530, 102, 60, 31);
		add(day);
		
		JLabel label_3 = new JLabel("日");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(600, 102, 24, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("年   龄：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(46, 180, 75, 31);
		add(label_4);
		
		age = new JTextField();
		age.setFont(new Font("宋体", Font.PLAIN, 15));
		age.setColumns(10);
		age.setBounds(151, 180, 119, 32);
		add(age);
		
		JLabel label_5 = new JLabel("性   别：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(355, 179, 75, 31);
		add(label_5);
		
		sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));
		sex.setFont(new Font("宋体", Font.PLAIN, 15));
		sex.setBounds(440, 179, 60, 31);
		add(sex);
		
		JLabel label_6 = new JLabel("电   话：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(46, 250, 75, 31);
		add(label_6);
		
		tell = new JTextField();
		tell.setFont(new Font("宋体", Font.PLAIN, 15));
		tell.setColumns(10);
		tell.setBounds(151, 250, 119, 32);
		add(tell);
		
		JLabel label_7 = new JLabel("地   址：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(355, 250, 75, 31);
		add(label_7);
		
		address = new JTextField();
		address.setFont(new Font("宋体", Font.PLAIN, 15));
		address.setColumns(10);
		address.setBounds(440, 250, 225, 32);
		add(address);
		
		JLabel label_8 = new JLabel("备   注：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(46, 320, 75, 31);
		add(label_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 332, 514, 128);
		add(scrollPane);
		
		memo = new JTextArea();
		scrollPane.setViewportView(memo);
		
		JButton btnNewButton = new JButton("保存");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(151, 487, 95, 31);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		
		JButton button = new JButton("清空");
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(281, 487, 95, 31);
		button.addActionListener(this);
		add(button);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("保存")) {
			String ids = id.getText();
			String names = name.getText();
			String ages = age.getText();
			String tells = tell.getText();
			String adds = address.getText();
			String memos = memo.getText();
			String sexs = sex.getSelectedItem().toString();
			String months = month.getSelectedItem().toString();
			String days = day.getSelectedItem().toString();
			Customer cus = new Customer();
			cus.setId(ids);
			cus.setUsername(names);
			cus.setAge(Integer.parseInt(ages));
			cus.setTel(tells);
			cus.setAddress(adds);
			cus.setRemarks(memos);
			cus.setSex(sexs);
			cus.setBrithday(months+"."+days);
			cus.setStatus("0");
			CustomerService cs=new CustomerService();
			cs.save(cus);
			JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			reset();
		} else if (e.getActionCommand().equals("清空")) {
			reset();
		} else if (e.getActionCommand().equals("退出")) {
		}
	}
	
	private void reset(){
		sex.setSelectedIndex(0);
		month.setSelectedIndex(0);
		day.setSelectedIndex(0);
		id.setText("");
		name.setText("");
		age.setText("");
		tell.setText("");
		address.setText("");
		memo.setText("");
	}
}
