package main.java;

import main.java.Model.Person;
import main.java.Model.Database;

import java.sql.SQLException;

import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class HelloWorld {
	
	public static Database database;
	public static ConnectionSource dbConn;
	public static List<Person> peopleList;
	public static List<Person> likedPerson;
	public static List<Person> dislikedPerson;
	public static Dao<Person, String> personDao;
	
    public static void main(String[] args) throws Exception {
    	database = new Database();
    	
    	dbConn = database.connectToDb();
    	personDao = DaoManager.createDao(dbConn, Person.class);
    	//createPerson();
    	
    	List<Person> peopleList =
    			personDao.queryBuilder()
    			.query();
    	likedPerson = new ArrayList<Person>();
    	dislikedPerson = new ArrayList<Person>();

    	Scanner scanInput = new Scanner(System.in);

    	for (int i = 0; i < peopleList.size(); i++) {
    	    Person person = peopleList.get(i);
    	    System.out.println(person.getFirstName() + " " + person.getLastName() + "(" + person.getAge() + ")");
    	   while(true) {
    		   System.out.println("Do you like him/her? Type yes/no:");
    	       String question = scanInput.nextLine();
    		   if(question.equals("yes")) {
    			   likedPerson.add(person);
    	            break;
    	        } else if(question.equals("no")) {
    	        	dislikedPerson.add(person);
    	        	break;
    	        }
    	   }
    	}
    	
    	System.out.println("Liked Person:" + likedPerson);
    	System.out.println("Disliked Person:" + dislikedPerson);

    }
    
    public static void createPerson() throws SQLException 
    {
    	
        // create an instance of Account
    	Person person = new Person();
    	person.setFirstName("Joooozsi");
    	person.setLastName("Molnar");
    	person.setAge(11);

    	// persist the account object to the database
    	personDao.create(person);
    }
}
