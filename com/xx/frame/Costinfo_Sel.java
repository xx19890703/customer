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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.xx.modal.Costinfo;
import com.xx.publics.util.Constants;
import com.xx.service.CostinfoService;

public class Costinfo_Sel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	String[] headers = { "序号", "编号", "姓名", "消费项目", "花费", "时间", "操作人" };
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
	public Costinfo_Sel() {

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
		table.getColumn(headers[1]).setPreferredWidth(120);
		table.getColumn(headers[2]).setPreferredWidth(90);
		table.getColumn(headers[3]).setPreferredWidth(120);
		table.getColumn(headers[4]).setPreferredWidth(100);
		table.getColumn(headers[5]).setPreferredWidth(210);
		table.getColumn(headers[6]).setPreferredWidth(90);

		scrollPane.setViewportView(table);

		textField.setText(Constants.id);
		setLayout(null);
		add(lblNewLabel);
		add(textField);
		add(btnNewButton);
		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (model.getRowCount() > 0) {
			model.removeRow(model.getRowCount() - 1);
		}
		CostinfoService cs = new CostinfoService();
		String ids = textField.getText();
		List<Costinfo> list = cs.findCostinfosByCusId(ids);
		for (Costinfo c : list) {
			String[] dd = { "" + (model.getRowCount() + 1),
					c.getCustomer().getId(), c.getCustomer().getUsername(),
					c.getProjectName(), c.getCost().toString(), c.getTime(),
					c.getOperator() };
			model.addRow(dd);
		}
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		}

		FitTableColumns(table);
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
