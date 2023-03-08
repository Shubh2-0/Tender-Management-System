package com.masai.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

public static final String url;
public static final String username;
public static final String password;

   static {

	   ResourceBundle budle = ResourceBundle.getBundle("DB_Details");
	   
	   url = budle.getString("url");
	   username = budle.getString("username");
	   password = budle.getString("password");
	   
   }
   
   
   static {
	   
	   try {
		   
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		
	}
	   
   }
   
   
   public static Connection getConnection() {
	
	Connection con = null;
	
	
	try {
		
		con = DriverManager.getConnection(url,username,password);
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}
	
	   
	return con;   
	   
   }
   
   public static void closeConnection(Connection con) throws SQLException{
	   
	  if(con!=null)
		  con.close();
	   
   }
   
   
   
   
   
   
   
 
   
   
   
   
   
   
   

	
	

}
