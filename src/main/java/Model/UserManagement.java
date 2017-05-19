package main.java.Model;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import main.java.Model.Database;

public class UserManagement
{
	private int userId;
	public static Database database;
	public static ConnectionSource dbConn;
	public static Dao<Person, String> personDao;
	public static List<Person> loggedPerson;
	
	public UserManagement(ConnectionSource dbConnection)
	{
		dbConn = dbConnection;
	}
	
	public static void login() throws SQLException
	{
    	Scanner scanInput = new Scanner(System.in);

		personDao = DaoManager.createDao(dbConn, Person.class);
		while(true) {
		   System.out.println("Please enter your email address:");
 	       String emailAddress = scanInput.nextLine();
 	       
 	       System.out.println("Please enter your password:");
	       String password = scanInput.nextLine();
	       
		loggedPerson =
    			personDao.queryBuilder()
    			.where()
    			.eq(Person.EMAIL_FIELD_NAME, emailAddress)
    			.and()
    			.eq(Person.PASSWORD_FIELD_NAME, password)
    			.query();
		System.out.println(loggedPerson);
		if (!loggedPerson.isEmpty()) {
			break;
		}
		
		}
	}
}