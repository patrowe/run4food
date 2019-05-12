package run4food;


import java.util.Date;
import java.util.Hashtable;

public class DailyRoutine {
	// Version 1.1 under construction, not tested ;-)
	
	User activeUser;
	Hashtable<Date, Double[]> activeDiary;
	
	Calculator calc = new Calculator();
	
	double earnedCalory, consumedCalory, freeCalory;
	private Date today;
	public Double[] diaryEntry;
	
			
	DailyRoutine(User user){
		activeUser = user;
		activeDiary = user.getDiary();
		today = new Date();
		diaryEntry = new Double[5];
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateSteps(int steps) {
	
		earnedCalory+=calc.steps2calory(steps);
		
	}

	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateActivity(String activity, double duration) {

		earnedCalory+=calc.activity2calory(activity, duration, activeUser.getWeight());
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	public void calculateConsumption(String food, double quantaty) {
		
		consumedCalory+=calc.food2calory(food, quantaty);
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	public void setFreeCalory() {
		
		freeCalory = activeUser.getBasalMetabolism() + earnedCalory - consumedCalory;
	
	}
	
	public double basalMetabolism(int age, double weight, double height, String gender) {
		
		return calc.basalMetabolism(age, weight, height, gender);
		
	}
	
	public void updateDiary() {
		
		diaryEntry[0]=earnedCalory;
		diaryEntry[1]=consumedCalory;
		diaryEntry[2]=freeCalory;
		diaryEntry[3]=activeUser.getWeight();
		diaryEntry[4]=activeUser.getBasalMetabolism();
		
		// hier kann noch eine Abfrage kommen, ob für "heute" schon ein Eintrag besteht
		activeUser.setDiary(today, diaryEntry);
		
	}
	
	
}
