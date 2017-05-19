package main.java.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class Person extends BasicModel {
	public static final String PASSWORD_FIELD_NAME = "password"; 
	public static final String EMAIL_FIELD_NAME = "email";
	
	@DatabaseField(id = true, columnName = "first_name")
	private String firstName;
	@DatabaseField(columnName = "last_name")
	private String lastName;
	@DatabaseField
	private int age;
	@DatabaseField
	private int gender;
	@DatabaseField(columnName = EMAIL_FIELD_NAME)
	private String email;
	@DatabaseField(columnName = PASSWORD_FIELD_NAME)
	private String password;

	
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
	public String getFirstName() {
        return this.firstName;
    }	

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	
	public String getLastName() {
        return this.lastName;
    }
	
	public void setAge(int age) {
        this.age = age;
    }
	
	public int getAge() {
        return this.age;
    }
	
	public void setGender(int gender) {
        this.gender = gender;
    }
	
	public int getGender() {
        return this.gender;
    }

	public void setEmail(String email) {
        this.email = email;
    }
	
	public String getEmail() {
        return this.email;
    }

	public void setPassword(String password) {
        this.password = password;
    }
	
	public String getPassword() {
        return this.password;
    }
	
	public String toString() { 
	    return "Name: " + this.getFirstName() + " " + this.getLastName();
	} 
}