package oop.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import homework.ActionListenerImpl;

public class Ui713 extends JFrame{
	private JPanel panelSearch=new JPanel();
	private JPanel panelProcess=new JPanel();
	private JPanel panelmain=new JPanel();
	
	private JButton btnSearch=new JButton("Search");
	private JTextField txtSearch=new JTextField();
	private JButton btnAdd=new JButton("Add");
	private JButton btnDel=new JButton("Delete");
	private JButton btnCancer=new JButton("Modify");
	private JLabel labtitle=new JLabel("名称：");
	private JLabel labaccount=new JLabel("账号：");
	private JLabel labpassword=new JLabel("密码：");
	private JLabel labremark=new JLabel("备注：");
	private JTextField txtmiantitle=new JTextField();
	private JTextField txtmianaccount=new JTextField();
	private JTextField txtmianpassword=new JTextField();
	private JTextField txtmianremark=new JTextField();
	private int m=1;//控制循环变量
	public Ui713(){
		//=========初始化组件======
		panelmain.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加面板到窗体
		this.add(panelSearch,BorderLayout.NORTH);
		this.add(panelmain);
		this.add(panelProcess,BorderLayout.SOUTH);
		
		
		//更改布局方式
		panelSearch.setLayout(new BorderLayout());
		panelProcess.setLayout(new FlowLayout());
		panelmain.setLayout(new GridLayout(4,2));
//		添加到面板
		panelSearch.add(txtSearch);
		panelSearch.add(btnSearch,BorderLayout.EAST);
		panelProcess.add(btnDel);
		panelProcess.add(btnAdd);
		panelProcess.add(btnCancer);
		panelmain.add(labtitle);
		panelmain.add(txtmiantitle);
		panelmain.add(labaccount);
		panelmain.add(txtmianaccount);
		panelmain.add(labpassword);
		panelmain.add(txtmianpassword);
		panelmain.add(labremark);
		panelmain.add(txtmianremark);
		//====设定窗体相关属性=====errrrrterrrrrrrrrrrrrrrrrr55rerf
		this.setTitle("有梦想的半咸鱼_晓平");
		this.setVisible(true);
		this.setSize(800, 500);
		btnSearch.setActionCommand("Search");
		btnAdd.setActionCommand("Add");
		ActionListener actionlistener =new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String command=e.getActionCommand();
				JButton Button=new JButton();
				if(command.equals("Search")){
					
						if(m%2==1){
							panelmain.setVisible(true);
							m++;
						}
						else if(m%2==0){
							panelmain.setVisible(false);
							m++;}
						
						
				}
				if(command.equals("Add")){
					Ui713.this.setVisible(false);
					Add add=new Add(Ui713.this);
					

				}
			}
		};
		btnAdd.addActionListener(actionlistener);
		btnSearch.addActionListener(actionlistener);
		btnCancer.addActionListener(actionlistener);
		btnDel.addActionListener(actionlistener);
		
	}
	public static void main(String[] args) {
		Ui713 ui=new Ui713();
	}

}
