package oop.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
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
	    private void testInsertDate(String name,String password){
//	    	1.�������ݿ�����
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//					try {
//							Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
						Connection connection=getConnection();
			
	    	
//	    	2.����������ݵ�SQL���
	    	String sql="insert into account (name,password) values ('"+name+"','"+password+"')";
	    	
//	    	3.ִ��SQL���.
	    	Statement statement =connection.createStatement();
	    	
//	    	4.�õ�ִ�к�Ľ����ȷ���Ƿ���ӳɹ�
	    	int rows=statement.executeUpdate(sql);
	    	System.out.println("��"+rows+"��ӳɹ�");   	
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
//	    } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	    	}
	    }
	    private void testDeleteDate(int id){
	    	
//	    	1.�������ݿ�����
	    	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql//localhost:3306/class11?serverTimezone=GMT%2B8&amp;useSSL=false","root","SQLMM0724");
					Connection connection=getConnection();
//					2.����ɾ�����ݵ�sql���
					String sql="delete from account where id="+id;					
//			    	3.ִ�����
					Statement statement=connection.createStatement();
					
//			    	4.�õ�ִ�н����ȷ����ӳɹ�
					int rows=statement.executeUpdate(sql);
					System.out.println("��"+rows+"�б�ɾ��");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	    }
	    private void testUpdateDate(int id,String name,String password){
//	    	1.�������ݿ�����
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
					Connection connection=getConnection();
					//			    	2.����update sql���
					String sql="update account set name='"+name+"',password='"+password+"' where id=" + id;
					//			    	3.ִ�����
					Statement statement=connection.createStatement();
//			    	4�鿴������Ƿ�ɹ�
					int rows=statement.executeUpdate(sql);
					System.out.println("��"+rows+"�и��³ɹ�");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    }
	    
	public  static  void main(String[] args){
		while(true){
	      Scanner scanner=new Scanner(System.in);
	      System.out.println("============================================================================");
	      System.out.println("|=======*****=============��ӭʹ�ð༶����ϵͳ==================*****==========|");
	      System.out.println("|===1.�������	2.ɾ������	3.�޸�����	4.��ѯ����	-1.�˳� =====|");
	      System.out.println("============================================================================");
	      System.out.println("=============================�����������======================================");
	      int select;
	      select= scanner.nextInt();
	      while((select>4||select<1)&&select!=-1){
	    	  System.out.println("�����������������������");
	    	  select=scanner.nextInt();
	      }
	      jdbc jdbc=new jdbc();
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
	  
	      }
	      else if(select== -1){
	    
	      }
		 if(select== -1){
			 System.out.println("�ϰ����ߣ��´�����~");
			 System.exit(-1);
		 }

		}
	}
	
	}
