package oop.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {
	public  MyFrame(){
		
		
		this.setVisible(true);
		this.setTitle("有梦想的半咸鱼_晓平");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		FlowLayout flowlayout=new FlowLayout();
		GridLayout gridlayout =new GridLayout(3,2);
//		this.setLayout(flowlayout);
		this.setLayout(gridlayout);
		JButton btnEast = new JButton("东方");
		JButton btnWest = new JButton("西方");
		JButton btnNorth = new JButton("北方");
		JButton btnSouth = new JButton("南方");
		JButton btnCenter = new JButton("中部");
		
		//监听按钮事件
			btnCenter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//实现事件
					btnCenter.setText("Memorise羚头羊");
				}
			});
			
		
			this.add(btnEast,BorderLayout.EAST);
			this.add(btnWest,BorderLayout.WEST);
			this.add(btnNorth,BorderLayout.NORTH);
			this.add(btnSouth,BorderLayout.SOUTH);
			this.add(btnCenter,BorderLayout.CENTER);
		
	}
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
		
	}
	
}
