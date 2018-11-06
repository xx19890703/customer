package com.xx.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xx.modal.Cardinfo;
import com.xx.modal.Customer;
import com.xx.modal.Recharge;
import com.xx.publics.util.Check;
import com.xx.publics.util.Constants;
import com.xx.publics.util.DateUtil;
import com.xx.service.CardinfoService;
import com.xx.service.CustomerService;
import com.xx.service.RechargeService;

public class Cardinfo_Add extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField sMoney;
	private JTextField eMoney;
	private JTextField eCount;
	private JComboBox sYear;
	private JComboBox sMonth;
	private JComboBox sDay;
	private JComboBox eYear;
	private JComboBox eMonth;
	private JComboBox eDay;
	private JLabel userName;
	private JButton button_1;
	private JButton button_4;
	private Main main;
	/**
	 * Create the panel.
	 */
	public Cardinfo_Add(Main main,String ids,String name) {
		this.main=main;
		//setLayout(null);
		
		JButton button = new JButton("查询");
		button.addActionListener(this);
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(502, 68, 95, 31);
		add(button);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(136, 67, 191, 32);
		add(id);
		
		JLabel label = new JLabel("会员编号：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(51, 68, 75, 31);
		add(label);
		
		sYear = new JComboBox();
		sYear.setModel(new DefaultComboBoxModel(new String[] {"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		sYear.setFont(new Font("宋体", Font.PLAIN, 15));
		sYear.setBounds(136, 136, 89, 31);
		add(sYear);
		sYear.setSelectedItem(DateUtil.getYear());
		
		sMonth = new JComboBox();
		sMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		sMonth.setFont(new Font("宋体", Font.PLAIN, 15));
		sMonth.setBounds(276, 136, 60, 31);
		add(sMonth);
		sMonth.setSelectedItem(DateUtil.getMonth());
		
		sDay = new JComboBox();
		sDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		sDay.setFont(new Font("宋体", Font.PLAIN, 15));
		sDay.setBounds(376, 136, 60, 31);
		add(sDay);
		sDay.setSelectedItem(DateUtil.getDay());
		
		
		eYear = new JComboBox();
		eYear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		eYear.setFont(new Font("宋体", Font.PLAIN, 15));
		eYear.setBounds(136, 198, 89, 31);
		add(eYear);
		eYear.setSelectedItem("2018");
		
		eMonth = new JComboBox();
		eMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		eMonth.setFont(new Font("宋体", Font.PLAIN, 15));
		eMonth.setBounds(276, 198, 60, 31);
		add(eMonth);
		eMonth.setSelectedItem("12");
		
		eDay = new JComboBox();
		eDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		eDay.setFont(new Font("宋体", Font.PLAIN, 15));
		eDay.setBounds(376, 198, 60, 31);
		add(eDay);
		eDay.setSelectedItem("31");
		
		sMoney = new JTextField();
		sMoney.setFont(new Font("宋体", Font.PLAIN, 15));
		sMoney.setColumns(10);
		sMoney.setBounds(136, 264, 119, 32);
		add(sMoney);
		
		eMoney = new JTextField();
		eMoney.setEditable(false);
		eMoney.setFont(new Font("宋体", Font.PLAIN, 15));
		eMoney.setColumns(10);
		eMoney.setBounds(361, 264, 119, 32);
		add(eMoney);
		
		eCount = new JTextField();
		eCount.setEditable(false);
		eCount.setFont(new Font("宋体", Font.PLAIN, 15));
		eCount.setColumns(10);
		eCount.setBounds(136, 337, 119, 32);
		add(eCount);
		
		JLabel label_1 = new JLabel("开卡日期：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(51, 136, 75, 31);
		add(label_1);
		
		JLabel label_2 = new JLabel("截止日期：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(51, 198, 75, 31);
		add(label_2);
		
		JLabel label_3 = new JLabel("开卡金额：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(51, 264, 75, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("剩余金额：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(276, 264, 75, 31);
		add(label_4);
		
		JLabel label_6 = new JLabel("消费次数：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(51, 338, 75, 31);
		add(label_6);
		
		JLabel lblNewLabel = new JLabel("年");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(240, 139, 15, 25);
		add(lblNewLabel);
		
		JLabel label_7 = new JLabel("年");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(240, 198, 15, 25);
		add(label_7);
		
		JLabel label_8 = new JLabel("月");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(351, 139, 15, 25);
		add(label_8);
		
		JLabel label_9 = new JLabel("月");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(351, 201, 15, 25);
		add(label_9);
		
		JLabel label_10 = new JLabel("日");
		label_10.setFont(new Font("宋体", Font.PLAIN, 15));
		label_10.setBounds(446, 139, 15, 25);
		add(label_10);
		
		JLabel label_11 = new JLabel("日");
		label_11.setFont(new Font("宋体", Font.PLAIN, 15));
		label_11.setBounds(446, 201, 15, 25);
		add(label_11);
		
		button_1 = new JButton("保存");
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(136, 438, 95, 31);
		button_1.addActionListener(this);
		add(button_1);
		
		JButton button_2 = new JButton("清空");
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(271, 438, 95, 31);
		button_2.addActionListener(this);
		add(button_2);
		
		userName = new JLabel("");
		userName.setFont(new Font("宋体", Font.PLAIN, 15));
		userName.setBounds(349, 68, 111, 31);
		add(userName);
		
		JButton button_3 = new JButton("会员信息");
		button_3.setFont(new Font("宋体", Font.PLAIN, 15));
		button_3.setBounds(624, 68, 95, 31);
		button_3.addActionListener(this);
		add(button_3);
		
		button_4 = new JButton("充值");
		button_4.setFont(new Font("宋体", Font.PLAIN, 15));
		button_4.setBounds(502, 265, 95, 31);
		button_4.addActionListener(this);
		add(button_4);
		button_4.setEnabled(false);
		
		if(!ids.equals("")&&ids!=null){
			id.setText(ids);
			userName.setText(name);
			select();
		}else{
			if(!Constants.id.equals("")){
				id.setText(Constants.id);
				select();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("保存")) {
			String ids = id.getText();
			String syear = sYear.getSelectedItem().toString();
			String smonth = sMonth.getSelectedItem().toString();
			String sday = sDay.getSelectedItem().toString();
			String eyear = eYear.getSelectedItem().toString();
			String emonth = eMonth.getSelectedItem().toString();
			String eday = eDay.getSelectedItem().toString();
			String smoney = sMoney.getText();
			
			//**********校验
			if(!Check.checkNull(new String[]{"会员编号","开卡金额"}, new String[]{ids,smoney})){
				return ;
			}
			if(!Check.checkNum(new String[]{"开卡金额"}, new String[]{smoney})){
				return ;
			}
			
			
			
			CustomerService cs = new CustomerService();
			CardinfoService cis = new CardinfoService();
			Cardinfo card = cis.getCardinfoByCustomer(ids);
			if(card!=null){
				JOptionPane.showMessageDialog(null, "该会员已经存在账户，不能再次添加", "提示", JOptionPane.INFORMATION_MESSAGE);
				return ;
			}
			Customer c = cs.getCustomer(ids);
			Cardinfo ci = new Cardinfo();
			ci.setCustomer(c);
			ci.setStartDate(syear+"-"+smonth+"-"+sday);
			ci.setEndDate(eyear+"-"+emonth+"-"+eday);
			ci.setStartAmount(new BigDecimal(smoney));
			ci.setAmount(new BigDecimal(0));
			ci.setStartCount(0);
			ci.setCount(0);
			cis.save(ci);
			Recharge r = new Recharge();
			r.setCard(ci);
			r.setMoney(new BigDecimal(smoney));
			r.setTime(DateUtil.getSystemTime());
			RechargeService rs = new RechargeService();
			rs.save(r);
			JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			select();
		} else if (e.getActionCommand().equals("清空")) {
			id.setText("");
			sMoney.setText("");
			eMoney.setText("");
			eCount.setText("");
			userName.setText("");
			sYear.setSelectedIndex(0);
			sMonth.setSelectedIndex(0);
			sDay.setSelectedIndex(0);
			eYear.setSelectedIndex(0);
			eMonth.setSelectedIndex(0);
			eDay.setSelectedIndex(0);
			button_1.setEnabled(true);
			button_4.setEnabled(false);
			Constants.id="";
		} else if (e.getActionCommand().equals("查询")) {
			select();
		} else if (e.getActionCommand().equals("充值")) {
//			Recharge_Add dialog = new Recharge_Add();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
			String ids = id.getText();
			Recharge_Add frame = new Recharge_Add(Cardinfo_Add.this,ids);
			frame.setVisible(true);
		} else if (e.getActionCommand().equals("会员信息")) {
			main.change(new Customer_Add(this.main,id.getText()));
		} 
	}
	
	public void select(){
		String ids = id.getText();
		if(ids.equals("")){
			JOptionPane.showMessageDialog(null, "请输入会员编号！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		CustomerService cs = new CustomerService();
		Customer c = cs.getCustomer(ids);
		userName.setText(c.getUsername());
		CardinfoService cis = new CardinfoService();
		Cardinfo card = cis.getCardinfoByCustomer(ids);
		if(card==null){
			return ;
		}
		sMoney.setText(card.getStartAmount().toString());
		eMoney.setText(card.getAmount().toString());
		eCount.setText(""+card.getCount());
		sYear.setSelectedItem(card.getStartDate().split("-")[0]);
		sMonth.setSelectedItem(card.getStartDate().split("-")[1]);
		sDay.setSelectedItem(card.getStartDate().split("-")[2]);
		eYear.setSelectedItem(card.getEndDate().split("-")[0]);
		eMonth.setSelectedItem(card.getEndDate().split("-")[1]);
		eDay.setSelectedItem(card.getEndDate().split("-")[2]);
		button_1.setEnabled(false);
		button_4.setEnabled(true);
		Constants.id=ids;
	}
}
