package com.xx.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.xx.modal.Customer;
import com.xx.publics.util.Constants;
import com.xx.service.CustomerService;

public class Customer_Sel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	String[] headers = { "序号", "编号", "姓名", "性别", "电话", "年龄", "生日", "地址" };
	Object[][] cellData = null;
	private Main mains;
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
	public Customer_Sel(Main main) {
		this.mains = main;
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
		table.getColumn(headers[1]).setPreferredWidth(120);
		table.getColumn(headers[2]).setPreferredWidth(90);
		table.getColumn(headers[3]).setPreferredWidth(40);
		table.getColumn(headers[4]).setPreferredWidth(140);
		table.getColumn(headers[5]).setPreferredWidth(80);
		table.getColumn(headers[6]).setPreferredWidth(80);
		table.getColumn(headers[7]).setPreferredWidth(140);

		// 表格事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowI = table.rowAtPoint(e.getPoint());// 得到table的行号
					if (rowI > -1) {
						Object id =	((DefaultTableModel) table.getModel()).getValueAt(rowI, 1);
						Constants.id = id.toString();
						mains.change(new Customer_Add(mains,id.toString()));
					}
				}
			}

		});

		scrollPane.setViewportView(table);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (model.getRowCount() > 0) {
			model.removeRow(model.getRowCount() - 1);
		}
		CustomerService cs = new CustomerService();
		String ids = textField.getText();
		List<Customer> list = cs.findAll(ids);
		for (Customer c : list) {
			String[] dd = { "" + (model.getRowCount() + 1), c.getId(),
					c.getUsername(), c.getSex(), c.getTel(), "" + c.getAge(),
					c.getBrithday(), c.getAddress() };
			model.addRow(dd);
		}
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		}
	}
}
