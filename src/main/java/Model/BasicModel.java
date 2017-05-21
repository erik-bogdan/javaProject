package main.java.Model;

import java.sql.Date;
import com.j256.ormlite.field.DatabaseField;

public class BasicModel implements BasicInterface {
	
	@DatabaseField(generatedId = true)
	private int id;

	  
	public void setId(int id) {
        this.id = id;
    }
	
	public int getId() {
        return this.id;
    }


}