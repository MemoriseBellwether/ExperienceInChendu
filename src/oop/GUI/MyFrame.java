package oop.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {
	public  MyFrame(){
		
		
		this.setVisible(true);
		this.setTitle("������İ�����_��ƽ");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		FlowLayout flowlayout=new FlowLayout();
		GridLayout gridlayout =new GridLayout(3,2);
//		this.setLayout(flowlayout);
		this.setLayout(gridlayout);
		JButton btnEast = new JButton("����");
		JButton btnWest = new JButton("����");
		JButton btnNorth = new JButton("����");
		JButton btnSouth = new JButton("�Ϸ�");
		JButton btnCenter = new JButton("�в�");
		
		//������ť�¼�
			btnCenter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//ʵ���¼�
					btnCenter.setText("Memorise��ͷ��");
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
