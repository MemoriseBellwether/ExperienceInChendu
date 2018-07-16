package oop.JDBC;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.mysqla.io.Buffer;
public class jdbc {
	    private Connection getConnection(){
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dbURl="jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC";
//				System.out.println("���������ɹ���");
				try {
					Connection connection=DriverManager.getConnection(dbURl, "root", "SQLMM0724");
					return connection;
//					System.out.println("�������ӳɹ���");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					System.out.println("����ʧ��");
					e.printStackTrace();
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
//				System.out.println("��������ʧ�ܣ�");
				e.printStackTrace();
			}
				return null;
	    }
	    private void close(Connection cont,Statement stat,ResultSet result){
	    
				try {
					if(result!=null){
					result.close();
				} 
					if(stat!=null){
						stat.close();
					}
					if(cont!=null){
						cont.close();
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				}
	    private void testInsertDate(String name,String password){
//	    	1.�������ݿ�����
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//					try {
//							Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
						connection=getConnection();
			
	    	
//	    	2.����������ݵ�SQL���
	    	String sql="insert into account (name,password) values ('"+name+"','"+password+"')";
	    	
//	    	3.ִ��SQL���.
	    	statement =connection.createStatement();
	    	
//	    	4.�õ�ִ�к�Ľ����ȷ���Ƿ���ӳɹ�
	    	int rows=statement.executeUpdate(sql);
	    	if(rows>=1){
	    	System.out.println("��ӳɹ�!"); 
	    	}  	
			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
	    	finally{
	    		this.close(connection,statement,resultSet);
			}
			
		}
//	    } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	    	}
	    private void testDeleteDate(int id){
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
	    	
//	    	1.�������ݿ�����
	    	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql//localhost:3306/class11?serverTimezone=GMT%2B8&amp;useSSL=false","root","SQLMM0724");
					connection=getConnection();
//					2.����ɾ�����ݵ�sql���
					String sql="delete from account where id="+id;					
//			    	3.ִ�����
					statement=connection.createStatement();
					
//			    	4.�õ�ִ�н����ȷ����ӳɹ�
					int rows=statement.executeUpdate(sql);
					if(rows>=1){
				    	System.out.println("ɾ���ɹ�!"); 
				    	}  	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.close(connection,statement,resultSet);
				}
	    	
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	    }
	    private void testUpdateDate(int id,String name,String password){
//	    	1.�������ݿ�����
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
					connection=getConnection();
					//			    	2.����update sql���
					String sql="update account set name='"+name+"',password='"+password+"' where id=" + id;
					//			    	3.ִ�����
					statement=connection.createStatement();
//			    	4�鿴������Ƿ�ɹ�
					int rows=statement.executeUpdate(sql);
					if(rows>=1){
				    	System.out.println("�ɹ�!"); 
				    	}  	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	finally{
	    			this.close(connection,statement,resultSet);
				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    }
	    private String[][] bestFindAllDate(){
	    	//������ά����
	    	String[][] datas=new String[100][3];
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
//	    	1.��ȡ���ݿ�����
	    	connection=getConnection();
	    	
//	    	2.����sql���
	    	String sql="select * from account";
	    
//	    	3.ִ��sql���
			try {
				statement=connection.createStatement();
				resultSet =statement.executeQuery(sql);
//		    	4.�������
				int index=0;
				while(resultSet.next()){
					int id=resultSet.getInt("id");
					String name=resultSet.getString("name");
					String password =resultSet.getString("password");
					datas[index][0]=String.valueOf(id);
					datas[index][1]=name;
					datas[index][2]=password;
					index ++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close(connection,statement,resultSet);
			}
	    	return datas;
	    }
	    private void showfindAllDatasOutput(){
	    	String[][] datas=bestFindAllDate();
//	    	�������
	    	StringBuffer buff= new StringBuffer();
			buff.append("=================================================================="+System.lineSeparator());
			buff.append("          id          |        name        |         password     "+System.lineSeparator());	
			buff.append("=================================================================="+System.lineSeparator());
			for(int i=0;i<datas.length;i++){
				String values[]=datas[i];
				if(values[0]!=null){
					buff.append(String.format("          %s          |       %s        |         %s     ",values[0],values[1],values[2]));
					buff.append(System.lineSeparator());
				}
			}
			System.out.println(buff.toString());
	    }
	    
	    
	    
//	    private  void findAllData(){
//	    	Connection connection=null;
//	    	Statement statement=null;
//	    	ResultSet resultSet=null;
////	    	1.��ȡ���ݿ�����
//	    	connection=getConnection();
//	    	
////	    	2.����sql���
//	    	String sql="select * from account";
//	    
////	    	3.ִ��sql���
//			try {
//				statement=connection.createStatement();
//				resultSet =statement.executeQuery(sql);
////		    	4.�������
//				StringBuffer buff= new StringBuffer();
//				buff.append("=================================================================="+System.lineSeparator());
//				buff.append("          id          |        name        |         password     "+System.lineSeparator());
//
//				buff.append("=================================================================="+System.lineSeparator());
//				while(resultSet.next()){
//					
//					int id=resultSet.getInt("id");
//					String name=resultSet.getString("name");
//					String password =resultSet.getString("password");
//					buff.append("\t|"+id+"\t|\t"+name+" \t|\t  "+password+System.lineSeparator());
//				}
//				System.out.println(buff);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally{
//				this.close(connection,statement,resultSet);
//			}
//	    }
	    private String[] findAccountDataById(int id){
	    	String[] datas= new String[100];
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
//	    	1.�������ݿ�����
	    	connection=getConnection();
//	    	2.����sql���
	    	String sql="select * from account where id="+id;
//	    	3.ִ�����
	    	try {
				statement=connection.createStatement();
				resultSet =statement.executeQuery(sql);
//			4.�������
				int index=0;
				while(resultSet.next()){
					int id1=resultSet.getInt("id");
					String name=resultSet.getString("name");
					String password =resultSet.getString("password");
					datas[index]="\t  "+String.valueOf(id1)+"\t\t|\t"+name+"\t|\t  "+password+"\t|";
					index ++;
						}
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close(connection,statement,resultSet);
			}
	    	return datas;
	    }
	    private void findAccountDataByIdFmatOutput(int id){
	    		
		    	String[] datas=findAccountDataById(id);
//		    	�������
		    	StringBuffer buff= new StringBuffer();
				buff.append("=================================================================="+System.lineSeparator());
				buff.append("          id          |        name        |         password     "+System.lineSeparator());	
				buff.append("=================================================================="+System.lineSeparator());
				for(int i=0;i<datas.length;i++){
					String[] values=datas;
					if(values[i]!=null){
						buff.append(String.format("      %s     ",values[i]));
						buff.append(System.lineSeparator());
					}
				}
				System.out.println(buff.toString());
		    }
	    	
	    private String[][] findAccountDateLikeKeyWord(String KeyWord){
	    	String[][] datas=new String[100][3];
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
//	    	1.�������ݿ�����
	    	connection=getConnection();
//	    	2.����sql���
	    	String sql="select * from account where name like '%"+KeyWord+"%' or password like '%"+KeyWord+"' or id like '%"+KeyWord+"%'";
//	    	3.ִ��SQL���
	    	
			try {
				statement = connection.createStatement();
				resultSet =statement.executeQuery(sql);
//			4.�������
				int index=0;
				while(resultSet.next()){
					int id=resultSet.getInt("id");
					String name=resultSet.getString("name");
					String password =resultSet.getString("password");
					datas[index][0]=String.valueOf(id);
					datas[index][1]=name;
					datas[index][2]=password;
					index++;
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close(connection,statement,resultSet);
			}
			return datas;
	    }
	    private void findDatasLikeKeyWordFmatOutput(String KeyWord){
	    	String[][] datas=findAccountDateLikeKeyWord(KeyWord);
	    	StringBuffer buffer= new StringBuffer();
	    	buffer.append("=================================================================="+System.lineSeparator());
			buffer.append("          id          |        name        |         password     "+System.lineSeparator());	
			buffer.append("=================================================================="+System.lineSeparator());
			
			for(int i=0;i<datas.length;i++){
				String[] values=datas[i];
				if(values[0]!=null&&values[1]!=null&values[2]!=null){
					buffer.append(String.format("         %s          |       %s        |         %s    ",values[0],values[1],values[2]));
					buffer.append(System.lineSeparator());
				}
				
			}
	    	System.out.println(buffer.toString());
	    	
	    }	    
	public  static  void main(String[] args){
		 jdbc jdbc=new jdbc();
		while(true){
	      Scanner scanner=new Scanner(System.in);
	      System.out.println("============================��ӭ����༶����ϵͳ===================================");
	      System.out.println("+---------------------------------------------------------------------------+");
	      System.out.println("|       1.�������                 2.ɾ������                 3.�޸�����                  4.��ѯ����                    -1.�˳�                 |");
	      System.out.println("+---------------------------------------------------------------------------+");
	      System.out.println("==============================�����������======================================");
	      int select;
	      int reselect;
	      select= scanner.nextInt();
	      while((select>5||select<1)&&select!=-1){
	    	  System.out.println("�����������������������");
	    	  select=scanner.nextInt();
	      }
	      String value=null;
	      
	      if(select == 1){//���
	    	  System.out.println("������Ҫ��ӵ��˺ź����룬�ö��ŷָ�����������ƽ,123456");
	    	  value=scanner.next(); 
		      String[] values=value.split(",",2);
		      jdbc.testInsertDate(values[0],values[1]);
	      }
	      else if(select==2){//ɾ��
	    	  int id=0;
	    	  System.out.println("������Ҫɾ���ļ�¼id��");
	    	  id=scanner.nextInt();
	    	  jdbc.testDeleteDate(id);
	      }
	      else if(select == 3){//�޸�����  update
	    	  System.out.println("������Ҫ�޸ĵļ�¼id��");
	    	  value=scanner.next();
	    	  String[] values=value.split(",");
	    	  jdbc.testUpdateDate(Integer.parseInt((values[0])),values[1],values[2]);
	      }
	      else if(select==4){
	    	  
	    	  System.out.println("�������ѯ��ʽ��1.��ѯ���� 2.��id��ѯ 3.���ؼ��ֲ�ѯ");
	    	  reselect=scanner.nextInt();
	    	  if(reselect==1){
	    		  System.out.println("====================��ѯ�������=====================");
	    		  jdbc.showfindAllDatasOutput();
	    		  
	    	  }
	    	  else if(reselect==2){
	    		  System.out.println("������Ҫ��ѯ��id��");
	    		  value=scanner.next();
	    		  System.out.println("====================��ѯ�������=====================");
	    		  jdbc.findAccountDataByIdFmatOutput(Integer.parseInt(value));
	    	  }
	    	  else if(reselect==3){
	    		  System.out.println("������ؼ��֣�");
	    		  value=scanner.next();
	    		  System.out.println("====================��ѯ�������=====================");
	    		  jdbc.findDatasLikeKeyWordFmatOutput(value);
	    	  }
	      }
	      if(select==5){//����ͨ��
	    	  System.out.println("�����룺");
	    	  value=scanner.next();
	    	  System.out.println("����ͨ�����޲�����Ŀ���밴�����������");
	    	  value=scanner.next();
	    	 
	    	  
	      }
		 if(select== -1){
			 System.out.println("�ϰ����ߣ��´�����~");
			 System.exit(-1);
		 }

		}
	}
	
	}
