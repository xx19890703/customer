package com.xx.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.xx.modal.Cardinfo;
import com.xx.service.CardinfoService;
import com.xx.service.ExcelUtil;

public class Account_Sel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	String[] headers = { "序号", "编号", "姓名", "电话", "余额(元)","消费次数" };
	Object[][] cellData = null;
	private JLabel count;
	private BigDecimal counts;
	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (row % 2 == 0) {
				setBackground(Color.white); // 设置奇数行底色
			} else if (row % 2 == 1) {
				setBackground(new Color(206, 231, 255)); // 设置偶数行底色
			}
			this.setHorizontalAlignment(SwingConstants.CENTER);
			return super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
		}
	};
	
	/**
	 * Create the panel.
	 */
	public Account_Sel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("用户编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 28, 88, 24);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setBounds(111, 26, 142, 29);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(288, 26, 80, 30);
		add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 100, 734, 430);
		add(scrollPane);

		model = new DefaultTableModel(cellData, headers);

		table = new JTable(model) {
			private static final long serialVersionUID = 6656802629898126354L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// 大小 字体
		table.setFont(new Font("Dialog", 0, 19));
		table.setRowHeight(25);

		// 表格列宽
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn(headers[0]).setPreferredWidth(40);
		table.getColumn(headers[1]).setPreferredWidth(150);
		table.getColumn(headers[2]).setPreferredWidth(120);
		table.getColumn(headers[3]).setPreferredWidth(170);
		table.getColumn(headers[4]).setPreferredWidth(140);
		table.getColumn(headers[5]).setPreferredWidth(80);


		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("余额总数（元）：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(493, 28, 142, 24);
		add(lblNewLabel_1);
		
		count = new JLabel("");
		count.setFont(new Font("宋体", Font.PLAIN, 15));
		count.setBounds(630, 28, 133, 24);
		add(count);
		
		JButton button = new JButton("导出");
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(386, 26, 80, 30);
		button.addActionListener(this);
		add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")){
			counts = new BigDecimal(0);
			while (model.getRowCount() > 0) {
				model.removeRow(model.getRowCount() - 1);
			}
			CardinfoService cs = new CardinfoService();
			String ids = textField.getText();
			List<Cardinfo> list = cs.findAll(ids);
			for (Cardinfo c : list) {
				String[] dd = { "" + (model.getRowCount() + 1), c.getCustomer().getId(),
						c.getCustomer().getUsername(), c.getCustomer().getTel(), "" + c.getAmount(),
						""+c.getCount()};
				model.addRow(dd);
				counts = counts.add(c.getAmount());
			}
			
			count.setText(""+counts);
			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			}
		}else if(e.getActionCommand().equals("导出")){
			if(counts==null){
				JOptionPane.showMessageDialog(null, "请先查询后再导出！", "提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			CardinfoService cs = new CardinfoService();
			String ids = textField.getText();
			List<Cardinfo> list = cs.findAll(ids);
			ExcelUtil eu = new ExcelUtil();
			String[][] lists = new String[list.size()+1][5];
			for (int i = 0; i < list.size(); i++) {
				Cardinfo c = list.get(i);
				lists[i][0] = c.getCustomer().getId();
				lists[i][1] = c.getCustomer().getUsername();
				lists[i][2] = c.getCustomer().getTel();
				lists[i][3] = "" + c.getAmount();
				lists[i][4] = ""+c.getCount();
			}
			lists[list.size()][1] = "总额：";
			lists[list.size()][3] = ""+counts;
			try {
				if(list!=null&&0!=list.size()){
					eu.exportExcel("账户信息", new String[]{"编号", "姓名", "电话", "余额(元)","消费次数" }, new Integer[]{5000,5000,5000,5000,5000},lists);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
