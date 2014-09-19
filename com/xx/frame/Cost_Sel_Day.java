package com.xx.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.xx.modal.Costinfo;
import com.xx.publics.util.DateUtil;
import com.xx.service.CostinfoService;
import com.xx.service.ExcelUtil;

public class Cost_Sel_Day extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTable table;
	DefaultTableModel model;
	String[] headers = { "序号", "编号", "姓名", "消费项目", "花费", "时间", "操作人" };
	Object[][] cellData = null;
	private JComboBox syear;
	private JComboBox smonth;
	private JComboBox sday;
	private JComboBox eyear;
	private JComboBox emonth;
	private JComboBox eday;
	private BigDecimal money;
	private int count;
	private JLabel totalMoney;
	private JLabel totalCount;

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
	public Cost_Sel_Day() {
		JLabel lblNewLabel = new JLabel("开始时间：");
		lblNewLabel.setBounds(29, 28, 87, 24);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(373, 28, 62, 25);
		btnNewButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 116, 734, 393);

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
		table.getColumn(headers[1]).setPreferredWidth(120);
		table.getColumn(headers[2]).setPreferredWidth(90);
		table.getColumn(headers[3]).setPreferredWidth(180);
		table.getColumn(headers[4]).setPreferredWidth(100);
		table.getColumn(headers[5]).setPreferredWidth(130);
		table.getColumn(headers[6]).setPreferredWidth(90);

		scrollPane.setViewportView(table);
		setLayout(null);
		add(lblNewLabel);
		add(btnNewButton);
		add(scrollPane);
		
		syear = new JComboBox();
		syear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		syear.setFont(new Font("宋体", Font.PLAIN, 15));
		syear.setBounds(111, 28, 62, 24);
		add(syear);
		syear.setSelectedItem(DateUtil.getYear());
		
		smonth = new JComboBox();
		smonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		smonth.setFont(new Font("宋体", Font.PLAIN, 15));
		smonth.setBounds(200, 28, 46, 24);
		add(smonth);
		smonth.setSelectedItem(DateUtil.getMonth());
		
		sday = new JComboBox();
		sday.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		sday.setFont(new Font("宋体", Font.PLAIN, 15));
		sday.setBounds(274, 28, 46, 24);
		add(sday);
		sday.setSelectedItem(DateUtil.getDay());
		
		JLabel label = new JLabel("年");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(179, 28, 21, 24);
		add(label);
		
		JLabel label_1 = new JLabel("月");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(253, 28, 21, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("日");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(325, 28, 21, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("结束时间：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(29, 65, 87, 24);
		add(label_3);
		
		eyear = new JComboBox();
		eyear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		eyear.setFont(new Font("宋体", Font.PLAIN, 15));
		eyear.setBounds(111, 66, 62, 24);
		add(eyear);
		eyear.setSelectedItem(DateUtil.getYear());
		
		emonth = new JComboBox();
		emonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		emonth.setFont(new Font("宋体", Font.PLAIN, 15));
		emonth.setBounds(200, 66, 46, 24);
		add(emonth);
		emonth.setSelectedItem(DateUtil.getMonth());
		
		eday = new JComboBox();
		eday.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		eday.setFont(new Font("宋体", Font.PLAIN, 15));
		eday.setBounds(274, 66, 46, 24);
		add(eday);
		eday.setSelectedItem(DateUtil.getDay());
		
		JLabel label_4 = new JLabel("年");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(179, 65, 21, 24);
		add(label_4);
		
		JLabel label_5 = new JLabel("月");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(253, 65, 21, 24);
		add(label_5);
		
		JLabel label_6 = new JLabel("日");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(325, 65, 21, 24);
		add(label_6);
		
		JLabel lblNewLabel_1 = new JLabel("总消费次数：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(560, 28, 106, 25);
		add(lblNewLabel_1);
		
		JLabel label_9 = new JLabel("总消费金额：");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(560, 65, 106, 25);
		add(label_9);
		
		totalCount = new JLabel("0   次");
		totalCount.setFont(new Font("宋体", Font.PLAIN, 15));
		totalCount.setBounds(676, 28, 87, 25);
		add(totalCount);
		
		totalMoney = new JLabel("0.00 元");
		totalMoney.setFont(new Font("宋体", Font.PLAIN, 15));
		totalMoney.setBounds(666, 65, 114, 25);
		add(totalMoney);
		
		JButton button = new JButton("导出");
		button.setBounds(373, 65, 62, 25);
		button.addActionListener(this);
		add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")){
			while (model.getRowCount() > 0) {
				model.removeRow(model.getRowCount() - 1);
			}
			totalCount.setText("0  次");
			totalMoney.setText("0.00  元");
			money = new BigDecimal(0);
			count = 0;
			CostinfoService cs = new CostinfoService();
			
			String sy = syear.getSelectedItem().toString();
			String sm = smonth.getSelectedItem().toString();
			String sd = sday.getSelectedItem().toString();
			String ey = eyear.getSelectedItem().toString();
			String em = emonth.getSelectedItem().toString();
			String ed = eday.getSelectedItem().toString();
			String sdate = sy+"-"+sm+"-"+sd;
			String edate = ey+"-"+em+"-"+ed;
			List<Costinfo> list = cs.findCostinfosByTimes(sdate,edate);
			for (Costinfo c : list) {
				String[] dd = { "" + (model.getRowCount() + 1),
						c.getCustomer().getId(), c.getCustomer().getUsername(),
						c.getProjectName(), c.getCost().toString(), c.getTime(),
						c.getOperator() };
				model.addRow(dd);
				money = money.add(c.getCost());
				count++;
			}
			
			totalCount.setText(""+count+"    次");
			totalMoney.setText(""+money+" 元");
			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			}
		}else if(e.getActionCommand().equals("导出")){
			if(money==null){
				JOptionPane.showMessageDialog(null, "请先查询后再导出！", "提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			CostinfoService cs = new CostinfoService();
			
			String sy = syear.getSelectedItem().toString();
			String sm = smonth.getSelectedItem().toString();
			String sd = sday.getSelectedItem().toString();
			String ey = eyear.getSelectedItem().toString();
			String em = emonth.getSelectedItem().toString();
			String ed = eday.getSelectedItem().toString();
			String sdate = sy+"-"+sm+"-"+sd;
			String edate = ey+"-"+em+"-"+ed;
			List<Costinfo> list = cs.findCostinfosByTimes(sdate,edate);
			String[][] lists = new String[list.size()+1][6];
			for (int i = 0; i < list.size(); i++) {
				Costinfo c = list.get(i);
				lists[i][0] = c.getCustomer().getId();
				lists[i][1] = c.getCustomer().getUsername();
				lists[i][2] = c.getProjectName();
				lists[i][3] = c.getCost().toString();
				lists[i][4] = c.getTime();
				lists[i][5] = c.getOperator() ;
			}
			lists[list.size()][1] = "时间：";
			lists[list.size()][2] = sdate+"至"+edate;
			lists[list.size()][4] = "总额：";
			lists[list.size()][5] = ""+money;
			
			try {
				if(list!=null&&0!=list.size()){
					ExcelUtil eu = new ExcelUtil();
					eu.exportExcel("消费信息", new String[]{"编号", "姓名", "消费项目", "花费", "时间", "操作人"}, new Integer[]{5000,5000,5000,5000,5000,5000},lists);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//FitTableColumns(table);
	}

	public void FitTableColumns(JTable myTable) {
		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();

		TableColumn column = table.getColumn(headers[3]);
		int col = header.getColumnModel()
				.getColumnIndex(column.getIdentifier());
		int width = (int) myTable
				.getTableHeader()
				.getDefaultRenderer()
				.getTableCellRendererComponent(myTable, column.getIdentifier(),
						false, false, -1, col).getPreferredSize().getWidth();
		for (int row = 0; row < rowCount; row++) {
			int preferedWidth = (int) myTable
					.getCellRenderer(row, col)
					.getTableCellRendererComponent(myTable,
							myTable.getValueAt(row, col), false, false, row,
							col).getPreferredSize().getWidth();
			width = Math.max(width, preferedWidth);
		}
		header.setResizingColumn(column); // 此行很重要
		column.setWidth(width + myTable.getIntercellSpacing().width);
	}
}
