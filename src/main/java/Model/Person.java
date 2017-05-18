package main.java.Model;

public class Person extends BasicModel {
	
	
	private String firstName;
	private String lastName;	
	private int age;

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

}