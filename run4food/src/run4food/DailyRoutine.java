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
	
	private int earnedCalorie, consumedCalorie, freeCalorie;
	private String today;
	public Integer[] diaryEntry;
	
			
	DailyRoutine(RegisteredUser regUser){
		// hier muss noch unterschieden werden, ob es ein RegisteredUser ist oder ein User/Gast
		
		this.regUser = regUser;
		
		Calendar calendar = Calendar.getInstance();
	    Date date = calendar.getTime();
	    today = DateFormat.getDateInstance().format(date);
		activeDiary = regUser.getDiary();
		
		diaryEntry = new Integer[5];
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateSteps(int steps) {
	
		earnedCalorie+=calc.steps2calory(steps);
		
	}

	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateActivity(String activity, double duration) {

		earnedCalorie+=calc.activity2calory(activity, duration, regUser.getWeight());
		
	}
	
	public int getEarnedCalorie() {
		
		return earnedCalorie;
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateConsumption(String food, double quantaty) {
		
		consumedCalorie+=calc.food2calory(food, quantaty);
		
	}
	
	public int getConsumedCalorie() {
		return consumedCalorie;
	}
	
	//hier werden die noch freien Kalorien für die Bestellung berechnet
	public void calculateFreeCalorie() {
		
		freeCalorie = regUser.getBasalMetabolism() + earnedCalorie - consumedCalorie;
	
	}
	
	public int getFreeCalorie() {
		return freeCalorie;
	}
	
	
	
	public int basalMetabolism(int age, int weight, int height, String gender) {
		
		return calc.basalMetabolism(age, weight, height, gender);
		
	}
	
	public void updateDiary() {
		
		//Tagebucheintrag in der Reihenfolge earnedCalry/consumedCalory/freeCalory/Weight/BasalMetabolsim
		diaryEntry[0]=(int)earnedCalorie;
		diaryEntry[1]=(int)consumedCalorie;
		diaryEntry[2]=(int)freeCalorie;
		diaryEntry[3]=(int)regUser.getWeight();
		diaryEntry[4]=(int)regUser.getBasalMetabolism();
		
		// hier kann noch eine Abfrage kommen, ob für "heute" schon ein Eintrag besteht
		
		regUser.setDiary(today, diaryEntry);
	}
	
	
}
