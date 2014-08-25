package com.xx.frame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Customer_Add extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Customer_Add() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(27, 10, 54, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 7, 66, 21);
		add(textField);
		textField.setColumns(10);

	}
}
