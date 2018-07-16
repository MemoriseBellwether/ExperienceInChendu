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
//	    	1.创建数据库连接
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//					try {
//							Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
						connection=getConnection();
			
	    	
//	    	2.构建添加数据的SQL语句
	    	String sql="insert into account (name,password) values ('"+name+"','"+password+"')";
	    	
//	    	3.执行SQL语句.
	    	statement =connection.createStatement();
	    	
//	    	4.得到执行后的结果，确定是否添加成功
	    	int rows=statement.executeUpdate(sql);
	    	if(rows>=1){
	    	System.out.println("添加成功!"); 
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
	    	
//	    	1.创建数据库连接
	    	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql//localhost:3306/class11?serverTimezone=GMT%2B8&amp;useSSL=false","root","SQLMM0724");
					connection=getConnection();
//					2.构建删除数据的sql语句
					String sql="delete from account where id="+id;					
//			    	3.执行语句
					statement=connection.createStatement();
					
//			    	4.得到执行结果，确定添加成功
					int rows=statement.executeUpdate(sql);
					if(rows>=1){
				    	System.out.println("删除成功!"); 
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
//	    	1.创建数据库连接
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
	    	try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Class?useSSL=false&serverTimezone=UTC","root","SQLMM0724");
					connection=getConnection();
					//			    	2.创建update sql语句
					String sql="update account set name='"+name+"',password='"+password+"' where id=" + id;
					//			    	3.执行语句
					statement=connection.createStatement();
//			    	4查看结果，是否成功
					int rows=statement.executeUpdate(sql);
					if(rows>=1){
				    	System.out.println("成功!"); 
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
	    	//声明二维数组
	    	String[][] datas=new String[100][3];
	    	Connection connection=null;
	    	Statement statement=null;
	    	ResultSet resultSet=null;
//	    	1.获取数据库连接
	    	connection=getConnection();
	    	
//	    	2.构建sql语句
	    	String sql="select * from account";
	    
//	    	3.执行sql语句
			try {
				statement=connection.createStatement();
				resultSet =statement.executeQuery(sql);
//		    	4.遍历结果
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
//	    	遍历结果
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
////	    	1.获取数据库连接
//	    	connection=getConnection();
//	    	
////	    	2.构建sql语句
//	    	String sql="select * from account";
//	    
////	    	3.执行sql语句
//			try {
//				statement=connection.createStatement();
//				resultSet =statement.executeQuery(sql);
////		    	4.遍历结果
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
//	    	1.建立数据库连接
	    	connection=getConnection();
//	    	2.构建sql语句
	    	String sql="select * from account where id="+id;
//	    	3.执行语句
	    	try {
				statement=connection.createStatement();
				resultSet =statement.executeQuery(sql);
//			4.遍历结果
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
//		    	遍历结果
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
//	    	1.创建数据库连接
	    	connection=getConnection();
//	    	2.构建sql语句
	    	String sql="select * from account where name like '%"+KeyWord+"%' or password like '%"+KeyWord+"' or id like '%"+KeyWord+"%'";
//	    	3.执行SQL语句
	    	
			try {
				statement = connection.createStatement();
				resultSet =statement.executeQuery(sql);
//			4.遍历结果
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
	      System.out.println("============================欢迎进入班级管理系统===================================");
	      System.out.println("+---------------------------------------------------------------------------+");
	      System.out.println("|       1.添加数据                 2.删除数据                 3.修改数据                  4.查询数据                    -1.退出                 |");
	      System.out.println("+---------------------------------------------------------------------------+");
	      System.out.println("==============================请输入操作：======================================");
	      int select;
	      int reselect;
	      select= scanner.nextInt();
	      while((select>5||select<1)&&select!=-1){
	    	  System.out.println("操作有误，请重新输入操作：");
	    	  select=scanner.nextInt();
	      }
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
	    	  
	    	  System.out.println("请输入查询方式：1.查询所有 2.按id查询 3.按关键字查询");
	    	  reselect=scanner.nextInt();
	    	  if(reselect==1){
	    		  System.out.println("====================查询结果如下=====================");
	    		  jdbc.showfindAllDatasOutput();
	    		  
	    	  }
	    	  else if(reselect==2){
	    		  System.out.println("请输入要查询的id：");
	    		  value=scanner.next();
	    		  System.out.println("====================查询结果如下=====================");
	    		  jdbc.findAccountDataByIdFmatOutput(Integer.parseInt(value));
	    	  }
	    	  else if(reselect==3){
	    		  System.out.println("请输入关键字：");
	    		  value=scanner.next();
	    		  System.out.println("====================查询结果如下=====================");
	    		  jdbc.findDatasLikeKeyWordFmatOutput(value);
	    	  }
	      }
	      if(select==5){//测试通道
	    	  System.out.println("请输入：");
	    	  value=scanner.next();
	    	  System.out.println("测试通道暂无测试项目，请按任意键继续：");
	    	  value=scanner.next();
	    	 
	    	  
	      }
		 if(select== -1){
			 System.out.println("老板慢走，下次再来~");
			 System.exit(-1);
		 }

		}
	}
	
	}
