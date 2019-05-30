package run4food;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class DailyRoutine {
	// Version 1.2 under construction, not tested ;-)
	
	User user;
	RegisteredUser regUser;
	Hashtable<String, Integer[]> activeDiary;
	
	Calculator calc = new Calculator();
	
	double earnedCalorie, consumedCalorie, freeCalorie;
	private String today;
	public Integer[] diaryEntry;
	
			
	DailyRoutine(RegisteredUser regUser){
		
		this.regUser = regUser;
		
		activeDiary = regUser.getDiary();
		 
		Calendar calendar = Calendar.getInstance();
	    Date date = calendar.getTime();
	    today = DateFormat.getDateInstance().format(date);
		diaryEntry = new Integer[5];
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateSteps(int steps) {
	
		earnedCalorie+=calc.steps2calorie(steps);
		
	}

	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateActivity(String activity, double durationHouers, double durationMinitues) {
		
		double duration= durationHouers + (durationMinitues/60);
		
		earnedCalorie+=calc.activity2calorie(activity, duration, regUser.getWeight());
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateConsumption(String food, double quantaty) {
		
		consumedCalorie+=calc.food2calorie(food, quantaty);
		
	}
	//hier werden die noch freien Kalorien für die Bestellung berechnet
	public void setFreeCalorie() {
		
		freeCalorie = regUser.getBasalMetabolism() + earnedCalorie - consumedCalorie;
	
	}
	
	public double basalMetabolism(int age, double weight, double height, String gender) {
		
		return calc.basalMetabolism(age, weight, height, gender);
		
	}
	
	public void updateDiary() {
		//Tagebucheintrag in der Reihenfolge earnedCalorie/consumedCalorie/freeCalorie/Weight/BasalMetabolsim
		diaryEntry[0]=(int)earnedCalorie;
		diaryEntry[1]=(int)consumedCalorie;
		diaryEntry[2]=(int)freeCalorie;
		diaryEntry[3]=(int)regUser.getWeight();
		diaryEntry[4]=(int)regUser.getBasalMetabolism();
		
		// hier kann noch eine Abfrage kommen, ob für "heute" schon ein Eintrag besteht
		regUser.setDiary(today, diaryEntry);
		
	}
	
	
}
