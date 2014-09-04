package com.xx.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Main() {
//		this.setUndecorated(true);
//		this.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
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

		JMenuItem menuItem_1 = new JMenuItem("客户编辑");
		menuItem_1.addActionListener(this);
		menu_1.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("客户查询");
		menuItem_2.addActionListener(this);
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("会员卡信息");
		menuItem_3.addActionListener(this);
		menu_1.add(menuItem_3);

		JMenu menu_2 = new JMenu("消费管理");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("添加消费");
		menuItem_4.addActionListener(this);
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("消费历史");
		menuItem_5.addActionListener(this);
		menu_2.add(menuItem_5);

		JMenu menu_3 = new JMenu("统计");
		menuBar.add(menu_3);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override  
            protected void paintComponent(Graphics g) {  
//                ImageIcon icon = new ImageIcon("D://34.jpg");  
//                Image img = icon.getImage();  
//                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
            }  
        };  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("客户编辑")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Customer_Add(Main.this,""));// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("客户查询")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Customer_Sel());// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("会员卡信息")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Cardinfo_Add(Main.this,"",""));// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("添加消费")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Costinfo_Add());// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("消费历史")) {
			Main.this.getContentPane().removeAll();
			Main.this.getContentPane().add(new Costinfo_Sel());// JPanel换成自己的panel
			Main.this.getContentPane().validate();
			Main.this.getContentPane().repaint();
		} else if (e.getActionCommand().equals("退出")) {
			Main.this.dispose();
		}
	}
	
	public void change(Component o){
		Main.this.getContentPane().removeAll();
		Main.this.getContentPane().add(o);// JPanel换成自己的panel
		Main.this.getContentPane().validate();
		Main.this.getContentPane().repaint();
	}
}
