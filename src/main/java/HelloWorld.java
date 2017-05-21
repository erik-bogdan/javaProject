package main.java;

import main.java.Model.Person;
import main.java.Model.Database;
import main.java.Controller.BaseController;
import main.java.Controller.PersonController;
import main.java.Gui;

import java.sql.SQLException;
import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;


public class HelloWorld {
	
    public static void main(String[] args) throws Exception {
    	PersonController personController = new PersonController();
    	personController.person();

    }
   
}
