package homework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home712 extends JFrame{
	public Home712(){
		this.setTitle("������İ����㡪��ƽ");
		this.setBounds(400, 150, 800, 600);
		this.setVisible(true);
		this.setResizable(false);//���ô��ڲ��ɵ���
		GridLayout gridlayout=new GridLayout(3,1);
		this.setLayout(gridlayout);
		
		
		JPanel paltop=new JPanel();
		JPanel palmid=new JPanel();
		palmid.setLayout(null);//���ò��ַ�ʽ
		JPanel palbot=new JPanel();
		
		
		
//		������
		JTextField Searchfield=new JTextField(50);
		JButton btnSearch=new JButton("Search");
		
//		ʵ�����������
		JLabel title=new JLabel("Title");
		title.setBounds(0, 0, 100, 30);
		JTextArea Atitle=new JTextArea();
		Atitle.setBounds(150, 0, 650, 30);
		JLabel username=new JLabel("UserName");
		username.setBounds(0, 50, 100, 30);
		JTextArea Ausername=new JTextArea();
		Ausername.setBounds(150, 50, 650, 30);
		
		JLabel password=new JLabel("PassWord");
		password.setBounds(0, 100, 100, 30);
		JTextArea Apassword=new JTextArea();
		Apassword.setBounds(150, 100, 650, 30);
		
		JLabel remark=new JLabel("Remark");
		remark.setBounds(0,150, 100, 30);
		JTextArea Aremark=new JTextArea();
		Aremark.setBounds(150, 150, 650, 30);
		String text=Atitle.getText().toString();
//		ʵ�����·����󡪡���ť
		JButton btnSubmit=new JButton("Submit");
		JButton btnCancer=new JButton("Cancer");
		JButton btnCopy=new JButton("Appear");
		palbot.setLayout(null);
		btnCopy.setBounds(200, 90, 120, 40);
		btnSubmit.setBounds(350, 90, 120, 40);
		btnCancer.setBounds(500,90, 120, 40);
		btnCopy.setActionCommand("Appear");
		btnSubmit.setActionCommand("Submit");
		btnCancer.setActionCommand("Cancer");
		
//		��ӵ��������
		paltop.add(Searchfield);
		paltop.add(btnSearch);
		
		palmid.add(title);
		palmid.add(Atitle);
		palmid.add(username);
		palmid.add(Ausername);
		palmid.add(password);
		palmid.add(Apassword);
		palmid.add(remark);
		palmid.add(Aremark);
		palbot.add(btnCopy);
		palbot.add(btnSubmit);
		palbot.add(btnCancer);
		
		ActionListener actionlistener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String command = e.getActionCommand();
               JButton button = (JButton) e.getSource();
               if(command.equals("Appear")) {
              
                   JOptionPane.showMessageDialog(Home712.this,Atitle.getText()+Ausername.getText()
                   +Apassword.getText()+Aremark.getText());
			
               	}
               if(command.equals("Submit")){
            	   if(Atitle.getText().equals("") ||Apassword.getText().equals("") 
            			   ||Ausername.getText().equals("") )
            	   { JOptionPane.showMessageDialog(Home712.this,"���⡢�û�����������δ���룡");}
            	   else
            	   {
            		   JOptionPane.showMessageDialog(Home712.this,"���ύ��");
            	   }
               }
               if(command.equals("Cancer")){
            	   Atitle.setText(null);
            	   Ausername.setText(null);
            	   Apassword.setText(null);
            	   Aremark.setText(null);
            	   JOptionPane.showMessageDialog(Home712.this,"��ȡ����");
               }
               
				}
			};
			btnCopy.addActionListener(actionlistener);
			btnSubmit.addActionListener(actionlistener);
			btnCancer.addActionListener(actionlistener);
		
		
//		��ӵ�����
		
		this.add(paltop);
		this.add(palmid);
		this.add(palbot);
	}
	public static void main(String[] args) {
		Home712 home=new Home712();
	}
}
