package main.java.Controller;


import main.java.Model.Person;
import main.java.Model.Database;
import main.java.Model.UserManagement;
import main.java.Gui;

import java.sql.SQLException;
import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;


public class BaseController {
	
	public static Database database;
	public static ConnectionSource dbConn;
	
	public BaseController() throws SQLException {
		makeConnection();
		UserManagement userManagement = new UserManagement(dbConn);
		userManagement.login();
	}
	
	public static void makeConnection() {
		database = new Database();
    	dbConn = database.connectToDb();
	}
	
}