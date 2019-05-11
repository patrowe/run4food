package run4food;

import java.util.Date;
import java.util.Hashtable;

public class Diary {
	


	Hashtable<Date, Integer> stepDiary = new Hashtable<Date,Integer>();
	Hashtable<Date, Double> earnedDiary = new Hashtable<Date,Double>();
	Hashtable<Date, Double> consumedDiary = new Hashtable<Date,Double>();
	Hashtable<Date, Double> weightDiary = new Hashtable<Date,Double>();
	
	void setStep(Date d, int step){
		stepDiary.put(d,step);
	}
	
}
