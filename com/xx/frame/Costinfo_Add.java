package com.xx.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.xx.modal.Cardinfo;
import com.xx.modal.Costinfo;
import com.xx.modal.Customer;
import com.xx.publics.util.Check;
import com.xx.publics.util.Constants;
import com.xx.publics.util.DateUtil;
import com.xx.service.CardinfoService;
import com.xx.service.CostinfoService;
import com.xx.service.CustomerService;

public class Costinfo_Add extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField username;
	private JTextField amount;
	private JTextField projectName;
	private JTextField cost;
	private JTextField time;
	private JTextField operator;
	private JTextArea costName ;

	/**
	 * Create the panel.
	 */
	public Costinfo_Add() {
		setLayout(null);
		
		JLabel label = new JLabel("会员编号：");
		label.setBounds(33, 60, 75, 18);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		add(label);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(120, 53, 191, 32);
		add(id);
		
		JButton button = new JButton("查询");
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(370, 54, 95, 31);
		button.addActionListener(this);
		add(button);
		
		JLabel label_1 = new JLabel("会员名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(33, 120, 75, 18);
		add(label_1);
		
		username = new JTextField();
		username.setEditable(false);
		username.setFont(new Font("宋体", Font.PLAIN, 15));
		username.setColumns(10);
		username.setBounds(120, 113, 191, 32);
		add(username);
		
		JLabel label_2 = new JLabel("账户余额：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(370, 120, 75, 18);
		add(label_2);
		
		amount = new JTextField();
		amount.setEditable(false);
		amount.setFont(new Font("宋体", Font.PLAIN, 15));
		amount.setColumns(10);
		amount.setBounds(469, 113, 191, 32);
		add(amount);
		
		projectName = new JTextField();
		projectName.setFont(new Font("宋体", Font.PLAIN, 15));
		projectName.setColumns(10);
		projectName.setBounds(120, 173, 191, 32);
		add(projectName);
		
		cost = new JTextField();
		cost.setFont(new Font("宋体", Font.PLAIN, 15));
		cost.setColumns(10);
		cost.setBounds(469, 173, 191, 32);
		add(cost);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 293, 540, 185);
		add(scrollPane);
		
		costName = new JTextArea();
		scrollPane.setViewportView(costName);
		
		JLabel label_3 = new JLabel("消费项目：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(33, 180, 75, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("消费金额：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(370, 180, 75, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("消费时间：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(370, 240, 75, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("消费内容：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(33, 379, 75, 18);
		add(label_6);
		
		time = new JTextField();
		time.setFont(new Font("宋体", Font.PLAIN, 15));
		time.setEditable(false);
		time.setColumns(10);
		time.setBounds(469, 233, 191, 32);
		add(time);
		
		operator = new JTextField();
		operator.setFont(new Font("宋体", Font.PLAIN, 15));
		operator.setColumns(10);
		operator.setBounds(120, 233, 191, 32);
		add(operator);
		
		JLabel label_7 = new JLabel("操作员：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(33, 240, 75, 18);
		add(label_7);
		
		JButton button_1 = new JButton("保存");
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(120, 499, 95, 31);
		button_1.addActionListener(this);
		add(button_1);
		
		JButton button_2 = new JButton("清空");
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(253, 499, 95, 31);
		button_2.addActionListener(this);
		add(button_2);

		time.setText(DateUtil.getSystemTime());
		if(!Constants.id.equals("")){
			id.setText(Constants.id);
			select();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("清空")) {
			resetAll();
		} else if (e.getActionCommand().equals("查询")) {
			select();
		} else if (e.getActionCommand().equals("保存")) {
			String ids = id.getText();
			CustomerService cs=new CustomerService();
			Customer cus = cs.getCustomer(ids);
			String pros = projectName.getText();
			String costs = cost.getText();
			String times = time.getText();
			String cnames = costName.getText();
			String operas = operator.getText();
			//**********校验
			if(!Check.checkNull(new String[]{"会员编号","消费项目","消费金额","消费内容","操作人"}, new String[]{ids,pros,costs,cnames,operas})){
				return ;
			}
			if(!Check.checkNum(new String[]{"消费金额"}, new String[]{costs})){
				return ;
			}
			
			
			BigDecimal cos = new BigDecimal(costs);
			Costinfo c = new Costinfo();
			c.setCost(cos);
			c.setCostName(cnames);
			c.setCustomer(cus);
			c.setOperator(operas);
			c.setProjectName(pros);
			c.setTime(times);
			CostinfoService costser = new CostinfoService();
			
			CardinfoService cis = new CardinfoService();
			Cardinfo ci = cis.getCardinfoByCustomer(ids);
			BigDecimal am = ci.getAmount();
			if(am.subtract(cos).compareTo(new BigDecimal(0))<0){
				JOptionPane.showMessageDialog(null, "余额不足，请充值！", "提示", JOptionPane.INFORMATION_MESSAGE);
				return ;
			}else{
				costser.save(c);
				ci.setAmount(am.subtract(cos));
				ci.setCount(ci.getCount()+1);
				cis.save(ci);
				JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				reset();
			}
		} 
	}
	
	/**
	 * 查询
	 */
	private void select(){
		String ids = id.getText();
		if(ids.equals("")){
			JOptionPane.showMessageDialog(null, "请输入会员编号！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		CustomerService cs=new CustomerService();
		Customer cus = cs.getCustomer(ids);
		CardinfoService cis = new CardinfoService();
		Cardinfo ci = cis.getCardinfoByCustomer(ids);
		username.setText(cus.getUsername());
		amount.setText(ci.getAmount().toString());
		time.setText(DateUtil.getSystemTime());
		Constants.id=ids;
	}
	
	/**
	 * 清空消费情况
	 */
	private void reset(){
		projectName.setText("");
		cost.setText("");
		time.setText(DateUtil.getSystemTime());
		costName.setText("");
		operator.setText("");
		select();
	}
	
	/**
	 * 清空所有信息
	 */
	private void resetAll(){
		projectName.setText("");
		cost.setText("");
		time.setText(DateUtil.getSystemTime());
		costName.setText("");
		operator.setText("");
		id.setText("");
		amount.setText("");
		username.setText("");
		Constants.id="";
	}
}
