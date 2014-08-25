package com.xx.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Customer_Sel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	String[] headers = {"编号", "表头一", "表头二", "表头三" };
	Object[][] cellData = null;

	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  
		  
        public Component getTableCellRendererComponent(JTable table,  
                Object value, boolean isSelected, boolean hasFocus,  
                int row, int column) {  
            if (row % 2 == 0) {  
                setBackground(Color.white); //设置奇数行底色  
            } else if (row % 2 == 1) {  
                setBackground(new Color(206, 231, 255)); //设置偶数行底色  
            }  
            return super.getTableCellRendererComponent(table, value,  
                    isSelected, hasFocus, row, column);  
        }  
    }; 
	/**
	 * Create the panel.
	 */
	public Customer_Sel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("用户编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 28, 71, 24);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(110, 30, 90, 21);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TableColumnModel columnModel = table.getColumnModel();
				String[] dd = {""+(model.getRowCount()+1), "一啊是大三的", "二七台河还给我", "三好多钱合肥市你好" };
				model.addRow(dd);
				for (int i = 0; i < table.getColumnCount(); i++) {  
		            table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);  
		        }
			}
		});
		btnNewButton.setBounds(218, 28, 62, 25);
		add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 100, 734, 430);
		add(scrollPane);

		model = new DefaultTableModel(cellData, headers);

		table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setFont(new Font("Dialog", 0, 19));
		table.setRowHeight(22);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);  
		scrollPane.setViewportView(table);

	}
	
}
