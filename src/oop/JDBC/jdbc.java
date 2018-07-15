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
//				System.out.println("创建驱动成功！");
				try {
					Connection connection=DriverManager.getConnection(dbURl, "root", "SQLMM0724");
					return connection;
//					System.out.println("创建链接成功！");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					System.out.println("链接失败");
					e.printStackTrace();
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
//				System.out.println("驱动链接失败！");
				e.printStackTrace();
			}
				return null;
	    }
	    private void testInsertDate(String name,String password){
//	    	1.创建数据库连接
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//					try {
//							Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
						Connection connection=getConnection();
			
	    	
//	    	2.构建添加数据的SQL语句
	    	String sql="insert into account (name,password) values ('"+name+"','"+password+"')";
	    	
//	    	3.执行SQL语句.
	    	Statement statement =connection.createStatement();
	    	
//	    	4.得到执行后的结果，确定是否添加成功
	    	int rows=statement.executeUpdate(sql);
	    	System.out.println("有"+rows+"添加成功");   	
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
	    	
//	    	1.创建数据库连接
	    	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql//localhost:3306/class11?serverTimezone=GMT%2B8&amp;useSSL=false","root","SQLMM0724");
					Connection connection=getConnection();
//					2.构建删除数据的sql语句
					String sql="delete from account where id="+id;					
//			    	3.执行语句
					Statement statement=connection.createStatement();
					
//			    	4.得到执行结果，确定添加成功
					int rows=statement.executeUpdate(sql);
					System.out.println("有"+rows+"行被删除");
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
//	    	1.创建数据库连接
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
					Connection connection=getConnection();
					//			    	2.创建update sql语句
					String sql="update account set name='"+name+"',password='"+password+"' where id=" + id;
					//			    	3.执行语句
					Statement statement=connection.createStatement();
//			    	4查看结果，是否成功
					int rows=statement.executeUpdate(sql);
					System.out.println("有"+rows+"行更新成功");
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
	      System.out.println("|=======*****=============欢迎使用班级管理系统==================*****==========|");
	      System.out.println("|===1.添加数据	2.删除数据	3.修改数据	4.查询数据	-1.退出 =====|");
	      System.out.println("============================================================================");
	      System.out.println("=============================请输入操作：======================================");
	      int select;
	      select= scanner.nextInt();
	      while((select>4||select<1)&&select!=-1){
	    	  System.out.println("操作有误，请重新输入操作：");
	    	  select=scanner.nextInt();
	      }
	      jdbc jdbc=new jdbc();
	      String value=null;
	      
	      if(select == 1){//添加
	    	  System.out.println("请输入要添加的账号和密码，用逗号分隔，举例：晓平,123456");
	    	  value=scanner.next(); 
		      String[] values=value.split(",",2);
		      jdbc.testInsertDate(values[0],values[1]);
	      }
	      else if(select==2){//删除
	    	  int id=0;
	    	  System.out.println("请输入要删除的记录id：");
	    	  id=scanner.nextInt();
	    	  jdbc.testDeleteDate(id);
	      }
	      else if(select == 3){//修改数据  update
	    	  System.out.println("请输入要修改的记录id：");
	    	  value=scanner.next();
	    	  String[] values=value.split(",");
	    	  jdbc.testUpdateDate(Integer.parseInt((values[0])),values[1],values[2]);
	      }
	      else if(select==4){
	  
	      }
	      else if(select== -1){
	    
	      }
		 if(select== -1){
			 System.out.println("老板慢走，下次再来~");
			 System.exit(-1);
		 }

		}
	}
	
	}
