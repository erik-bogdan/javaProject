package main.java.Controller;

import main.java.Model.Person;
import main.java.Model.Database;
import main.java.Model.Match;
import main.java.Controller.BaseController;

import main.java.Gui;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.mysql.fabric.xmlrpc.base.Data;


public class PersonController extends BaseController {
	
	public PersonController() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	//public static Database database;
	//public static ConnectionSource dbConn;
	public static List<Person> peopleList;
	public static List<Person> likedPerson;
	public static List<Person> dislikedPerson;
	public static Dao<Person, String> personDao;
	public static Dao<Match, String> matchDao;
	
    public static void person() throws Exception {

    	personDao = DaoManager.createDao(dbConn, Person.class);
    	matchDao = DaoManager.createDao(dbConn, Match.class);
    	//System.out.println(loggedPerson);
    	//createPerson();
    	
    	
    	//QueryBuilder<Person, String> personQb = personDao.queryBuilder();
    	//QueryBuilder<Match, String> matchQb = matchDao.queryBuilder();
    	
    	//personQb.join(matchQb);
    	
    	List<Person> peopleList =
    			personDao.queryBuilder()
    			.where()
    			.ne(Person.EMAIL_FIELD_NAME, loggedPerson.get(0).getEmail())
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
    			   createMatch(loggedPerson.get(0).getId(), person.getId(), 1);
    	            break;
    	        } else if(question.equals("no")) {
    	        	dislikedPerson.add(person);
     			   createMatch(loggedPerson.get(0).getId(), person.getId(), 0);
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

    	// persist the person object to the database
    	personDao.create(person);
    }
    
    public static void createMatch(int firstPersonId, int secondPersonId, int status) throws SQLException 
    {
    	System.out.println("works match");
    	QueryBuilder<Match, String> queryBuilder = matchDao.queryBuilder();
    	Where<Match, String> where = queryBuilder.where();

    	//where.and(where.eq(Account.NAME_FIELD_NAME, "foo"),
    	 //         where.eq(Account.PASSWORD_FIELD_NAME, "_secret"));
    	where.or(
    		    where.eq(Match.FIRST_PERSON_ID_FIELD_NAME, firstPersonId)
    		    .and()
    		    .eq(Match.SECOND_PERSON_ID_FIELD_NAME, secondPersonId),
    		    where.eq(Match.FIRST_PERSON_ID_FIELD_NAME, secondPersonId)
    		    .and()
    		    .eq(Match.SECOND_PERSON_ID_FIELD_NAME, firstPersonId)
    		);
    	
    	List<Match> existMatch = queryBuilder.query();

    	//System.out.println(existMatch);

    	if (existMatch.size() == 0) {
	    	
	        // create an instance of Account
	    	Match match = new Match();
	    	match.setFirstPersonId(firstPersonId);
	    	match.setSecondPersonId(secondPersonId);
	    	match.setStatus(1);
	
	    	// persist the match object to the database
	    	matchDao.create(match);
    	} else {
    		if (existMatch.get(0).getSecondPersonId() == loggedPerson.get(0).getId()) {
    			if (existMatch.get(0).getStatus() == Match.STATUS_LIKED)
    			{
    				//0 = disliked; 1 = liked
    				if (status == 0) {
    					existMatch.get(0).setStatus(Match.STATUS_DECLINED);
    				} else if (status == 1) {
    					existMatch.get(0).setStatus(Match.STATUS_MATCHED);	
    				}
    			} else if (existMatch.get(0).getStatus() == Match.STATUS_DISLIKED) {
    				existMatch.get(0).setStatus(Match.STATUS_DECLINED);
    			}
    			System.out.println("Én vagyok a második");
				matchDao.update(existMatch.get(0));
    		}
    	}
    }
}
