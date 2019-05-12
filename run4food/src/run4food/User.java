package run4food;

import java.util.Date;
import java.util.Hashtable;

public class User {
	// Dummy Klasse für meine bisherige Programmierung. 
	// enthält meinen Vorschlag, wie wir das Diary umsetzen können.
	
	private Hashtable<Date, Double[]> diary;
	
	
	
	//dummy
	public double getWeight() {
		return 70.0;
	}
	//dummy
	public double getBasalMetabolism() {
		return 1500;
	}
	
	
	
	public Hashtable<Date, Double[]>  getDiary() {
		return diary;
	}
	
	public void setDiary(Date d, Double[] value) {
		diary.put(d, value);
	}
	
	
	
}
