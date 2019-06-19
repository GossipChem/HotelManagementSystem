package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
private String dbUrl="jdbc:mysql://localhost:3306/manager?useSSL=false&serverTimezone=UTC";
private String dbUserName="root";
private String dbPassword="1234";
private String JdbcName="com.mysql.cj.jdbc.Driver";

public Connection getCon()throws Exception {
	
	Class.forName(JdbcName);
	Connection con=DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
	return con;
}

public void close(Connection con)throws Exception{
	
	if(con!=null) {
	con.close();
	}
	
}


public static void main(String[] args) {
	Dbutil dbutil=new Dbutil();
	try {
		
		
		
	dbutil.getCon();
	System.out.println("数据库连接成功");
	
	
	
}catch(Exception e) {e.printStackTrace();
System.out.println("数据库连接失败");}
}
}