package main.java;

import main.java.Model.Person;
import main.java.Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class HelloWorld {
	
	public static Database database;
	public static Connection dbConn;
	public static List<Person> peopleList;
	
    public static void main(String[] args) throws Exception {
    	database = new Database();
    	
    	dbConn = database.connectToDb();
    	
    	Statement statement = (Statement) dbConn.createStatement();
    	
    	ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
    
    	peopleList = generatePeople(resultSet);
    	
    	//System.out.println(peopleList.get(1));
    	
    	for (int i = 0; i < peopleList.size(); i++) {
    	    Person person = peopleList.get(i);
    	    System.out.println(person.getFirstName());
    	}
    }
    
    public static List<Person> generatePeople(ResultSet resultSet) throws SQLException
    {
    	List<Person> personList = new ArrayList<Person>();

    	while (resultSet.next()) {
    		Person person = new Person();
    		person.setId(resultSet.getInt(1));
    		person.setFirstName(resultSet.getString(2));
    		person.setLastName(resultSet.getString(3));
    		person.setAge(resultSet.getInt(4));	
    		personList.add(person);
    	}
    	
    	return personList;
    }
}
