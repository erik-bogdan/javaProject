package main.java.Model;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Database
{
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public Database()
	{
		this.driver = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/java_app";
		this.username = "root";
		this.password = "";
		
		this.connectToDb();
	}
	
	public Connection connectToDb()
    {
    	try {
    		Class.forName(this.driver);
    		
    		Connection conn = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
    		
    		return conn;
    	} catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
}