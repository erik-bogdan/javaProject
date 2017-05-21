package main.java.Model;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "matches")
public class Match extends BasicModel {
	public static final String FIRST_PERSON_ID_FIELD_NAME = "first_person_id"; 
	public static final String SECOND_PERSON_ID_FIELD_NAME = "second_person_id";
	
	public static final int STATUS_NOONE = 0;
	public static final int STATUS_LIKED = 1;
	public static final int STATUS_DISLIKED = 2;
	public static final int STATUS_MATCHED = 3;
	public static final int STATUS_DECLINED = 4;

	
	@DatabaseField(columnName = FIRST_PERSON_ID_FIELD_NAME)
	private int firstPersonId;
	@DatabaseField(columnName = SECOND_PERSON_ID_FIELD_NAME)
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