package com.xx.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.xx.modal.Recharge;
import com.xx.publics.util.Constants;
import com.xx.service.RechargeService;

public class Recharge_Sel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	String[] headers = { "序号", "编号", "姓名", "充值金额（元）", "时间"};
	Object[][] cellData = null;
	
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
	public Recharge_Sel() {
		JLabel lblNewLabel = new JLabel("用户编号：");
		lblNewLabel.setBounds(29, 28, 87, 24);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));

		textField = new JTextField();
		textField.setBounds(112, 26, 111, 28);
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(247, 28, 62, 25);
		btnNewButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 100, 734, 430);

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
		table.getColumn(headers[1]).setPreferredWidth(160);
		table.getColumn(headers[2]).setPreferredWidth(140);
		table.getColumn(headers[3]).setPreferredWidth(120);
		table.getColumn(headers[4]).setPreferredWidth(220);

		scrollPane.setViewportView(table);

		textField.setText(Constants.id);
		setLayout(null);
		add(lblNewLabel);
		add(textField);
		add(btnNewButton);
		add(scrollPane);
		if(!"".equals(Constants.id)){
			actionPerformed(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (model.getRowCount() > 0) {
			model.removeRow(model.getRowCount() - 1);
		}
		RechargeService cs = new RechargeService();
		String ids = textField.getText();
		List<Recharge> list = cs.findRechargesByCusId(ids);
		for (Recharge c : list) {
			String[] dd = { "" + (model.getRowCount() + 1),
					c.getCard().getCustomer().getId(), c.getCard().getCustomer().getUsername(),
					c.getMoney().toString(),c.getTime()};
			model.addRow(dd);
		}
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		}
	}

}
