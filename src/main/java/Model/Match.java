package main.java.Model;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "matches")
public class Match extends BasicModel {
	//public static final String PASSWORD_FIELD_NAME = "password"; 
	//public static final String EMAIL_FIELD_NAME = "email";
	
	@DatabaseField(columnName = "first_person_id")
	private int firstPersonId;
	@DatabaseField(columnName = "second_person_id")
	private int secondPersonId;
	@DatabaseField
	private int status;
	@DatabaseField
	private Date date;
	
	public void setFirstPersonId(int firstPersonId) {
        this.firstPersonId = firstPersonId;
    }
	
	public int getFirstPersonId() {
        return this.firstPersonId;
    }	

	public void setSecondPersonId(int secondPersonId) {
        this.secondPersonId = secondPersonId;
    }
	
	public int getSecondPersonId() {
        return this.secondPersonId;
    }	
	
	public void setStatus(int status) {
        this.status = status;
    }
	
	public int getStatus() {
        return this.status;
    }
	

	public void setDate(Date date) {
        this.date = date;
    }
	
	public Date getDate() {
        return this.date;
    }
	
	public String toString() { 
	    return "Name: " + this.getFirstPersonId() + " " + this.getSecondPersonId();
	} 
}