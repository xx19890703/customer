package com.xx.frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xx.modal.Customer;
import com.xx.service.CustomerService;

public class Main extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Main frame = new Main();
			frame.setVisible(true);

			CustomerService cs = new CustomerService();
			Customer c = new Customer();
			c.setId("2");
			c.setUsername("谢谢");
			cs.save(c);
			//cs.delete(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		this.setTitle("客户管理系统");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("系统");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("退出");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		JMenu menu_1 = new JMenu("客户管理");
		menuBar.add(menu_1);

		JMenuItem menuItem_1 = new JMenuItem("新增客户");
		menuItem_1.addActionListener(this);
		menu_1.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("查询客户");
		menuItem_2.addActionListener(this);
		menu_1.add(menuItem_2);

		JMenu menu_2 = new JMenu("消费管理");
		menuBar.add(menu_2);

		JMenu menu_3 = new JMenu("统计");
		menuBar.add(menu_3);
		contentPane = new JPanel(){
            @Override  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("D://34.jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
            }  
        };  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("新增客户")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Customer_Add());// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("查询客户")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Customer_Sel());// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("退出")) {
			Main.this.dispose();
		}
	}
}
