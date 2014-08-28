package com.xx.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Customer_Add extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	
	/**
	 * Create the panel.
	 */
	public Customer_Add() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("会员编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 40, 75, 31);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setBounds(151, 39, 191, 32);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("姓   名：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(46, 110, 75, 31);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(151, 110, 119, 32);
		add(textField_1);
		
		label_1 = new JLabel("生   日：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(355, 102, 75, 31);
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setBounds(440, 102, 60, 31);
		add(comboBox);
		
		JLabel label_2 = new JLabel("月");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(505, 102, 24, 31);
		add(label_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_1.setBounds(530, 102, 60, 31);
		add(comboBox_1);
		
		JLabel label_3 = new JLabel("日");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(600, 102, 24, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("年   龄：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(46, 180, 75, 31);
		add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(151, 180, 119, 32);
		add(textField_2);
		
		JLabel label_5 = new JLabel("性   别：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(355, 179, 75, 31);
		add(label_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_2.setBounds(440, 179, 60, 31);
		add(comboBox_2);
		
		JLabel label_6 = new JLabel("电   话：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(46, 250, 75, 31);
		add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(151, 250, 119, 32);
		add(textField_3);
		
		JLabel label_7 = new JLabel("地   址：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(355, 250, 75, 31);
		add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(440, 250, 225, 32);
		add(textField_4);
		
		JLabel label_8 = new JLabel("备   注：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(46, 320, 75, 31);
		add(label_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 332, 514, 128);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
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
			
		} else if (e.getActionCommand().equals("清空")) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textArea.setText("");
		} else if (e.getActionCommand().equals("退出")) {
		}
	}
}
