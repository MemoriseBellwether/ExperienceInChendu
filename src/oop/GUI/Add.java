package oop.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Add extends JFrame{
	private JTextField txtSearch=new JTextField();
	private JButton btnSearch=new JButton("Search");
	private JButton btnEnter=new JButton("Enter");
	private JButton btnCaner=new JButton("Cancer");
	private JPanel panlSearch=new JPanel();
	private JPanel panlOperate=new JPanel();
	private JPanel panlMian=new JPanel();
	private JLabel title=new JLabel("Title");
	private JTextField Atitle=new JTextField();
	private JLabel username=new JLabel("UserName");
	private JTextField Ausername=new JTextField();
	private JLabel password=new JLabel("PassWord");
	private JTextField Apassword=new JTextField();
	private JLabel remark=new JLabel("Remark");
	private JTextField Aremark=new JTextField();
	
	private Ui713 ui = null;

	public Add(Ui713 ui){
		this.ui = ui;
		this.setVisible(true);
		this.setTitle("添加纪录");
		this.setSize(1000, 700);
		this.setLocation(500, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//布局设置
		this.setLayout(new BorderLayout());
		panlSearch.setLayout(new BorderLayout());
		panlMian.setLayout(new GridLayout(4,2));
		
		//将组件添加到面板
		panlSearch.add(txtSearch);
		panlSearch.add(btnSearch,BorderLayout.EAST);
		panlOperate.add(btnEnter);
		panlOperate.add(btnCaner);
		panlMian.add(title);
		panlMian.add(Atitle);
		panlMian.add(username);
		panlMian.add(Ausername);
		panlMian.add(password);
		panlMian.add(Apassword);
		panlMian.add(remark);
		panlMian.add(Aremark);
		
//		设置command
		btnCaner.setActionCommand("Cancer");
		btnEnter.setActionCommand("Enter");
		
		//监听按钮
		ActionListener actionlistener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String command=e.getActionCommand();
				JButton button=(JButton) e.getSource();
//				调用类
				if(command.equals("Cancer")){
					Add.this.dispose();
					Add.this.ui.setVisible(true);
				}
				if(command.equals("Enter")){
					JOptionPane.showMessageDialog(Add.this, "Have been save successfully!");
					Add.this.dispose();
					Add.this.ui.setVisible(true);
				}
				
			}
		};
		btnCaner.addActionListener(actionlistener);
		btnEnter.addActionListener(actionlistener);
		
		this.add(panlSearch,BorderLayout.NORTH);
		this.add(panlMian);
		this.add(panlOperate,BorderLayout.SOUTH);
	}

	protected static void setDefaultLookAndFeelDecorated(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
}
