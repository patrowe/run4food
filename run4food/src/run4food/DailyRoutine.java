package run4food;


import java.util.Date;
import java.util.Hashtable;

public class DailyRoutine {
	// Version 1.2 under construction, not tested ;-)
	
	User user;
	RegisteredUser regUser;
	Hashtable<Date, Integer[]> activeDiary;
	
	Calculator calc = new Calculator();
	
	double earnedCalory, consumedCalory, freeCalory;
	private Date today;
	public Integer[] diaryEntry;
	
			
	DailyRoutine(RegisteredUser regUser, Date date){
		this.regUser = regUser;
		activeDiary = regUser.getDiary();
		today = date;
		diaryEntry = new Integer[5];
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateSteps(int steps) {
	
		earnedCalory+=calc.steps2calory(steps);
		
	}

	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateActivity(String activity, double duration) {

		earnedCalory+=calc.activity2calory(activity, duration, regUser.getWeight());
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateConsumption(String food, double quantaty) {
		
		consumedCalory+=calc.food2calory(food, quantaty);
		
	}
	//hier werden die noch freien Kalorien für die Bestellung berechnet
	public void setFreeCalory() {
		
		freeCalory = regUser.getBasalMetabolism() + earnedCalory - consumedCalory;
	
	}
	
	public double basalMetabolism(int age, double weight, double height, String gender) {
		
		return calc.basalMetabolism(age, weight, height, gender);
		
	}
	
	public void updateDiary() {
		//Tagebucheintrag in der Reihenfolge earnedCalry/consumedCalory/freeCalory/Weight/BasalMetabolsim
		diaryEntry[0]=(int)earnedCalory;
		diaryEntry[1]=(int)consumedCalory;
		diaryEntry[2]=(int)freeCalory;
		diaryEntry[3]=(int)regUser.getWeight();
		diaryEntry[4]=(int)regUser.getBasalMetabolism();
		
		// hier kann noch eine Abfrage kommen, ob für "heute" schon ein Eintrag besteht
		regUser.setDiary(today, diaryEntry);
		
	}
	
	
}
