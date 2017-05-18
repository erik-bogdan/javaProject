package main.java.Model;

import java.sql.DriverManager;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.mysql.jdbc.Connection;

public class Database
{
	//private String driver;
	//private String url;
	private String username;
	private String password;
	private String databaseUrl;
	
	public Database()
	{
		this.databaseUrl = "jdbc:mysql://localhost:3306/java_app";
		//this.driver = "com.mysql.jdbc.Driver";
		//this.url = "jdbc:mysql://localhost:3306/java_app";
		this.username = "root";
		this.password = "";
		
		this.connectToDb();
	}
	
	public ConnectionSource connectToDb()
    {
    	try {
    		// create a connection source to our database
            ConnectionSource connectionSource =
                new JdbcConnectionSource(this.databaseUrl, this.username, this.password);
    		
            // instantiate the dao
           // Dao<Person, String> accountDao =
            //    DaoManager.createDao(connectionSource, Person.class);
    		return connectionSource;
    	} catch (Exception e) {
    		return null;
    	}
    }
}