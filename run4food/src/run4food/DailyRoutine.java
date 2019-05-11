package run4food;


import java.util.Date;

public class DailyRoutine {
	
	User activeUser;
	Diary activeDiary;
	
	Calculator calc = new Calculator();
	
	double earnedCalory, consumedCalory, freeCalory;
	private Date today;
	
	
			
	DailyRoutine(User user){
		activeUser = user;
		activeDiary = user.getDiary();
		today = new Date();
	}
	
	//hier müssen die Nutzereingaben übergeben werden.
	void calculateSteps(int steps) {
	
		earnedCalory+=calc.steps2calory(steps);
		
	}

	//hier müssen die Nutzereingaben übergeben werden.
	void calculateActivity(String activity, double duration) {

		earnedCalory+=calc.activity2calory(activity, duration, activeUser.getWeight());
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	void calculateConsumption(String food, double quantaty) {
		
		consumedCalory+=calc.food2calory(food, quantaty);
		
	}
	//hier müssen die Nutzereingaben übergeben werden.
	void setFreeCalory() {
		freeCalory = activeUser.getBasalMetabolism() + earnedCalory - consumedCalory;
	}
	
	void updateDiary() {
		
		
	}
	
	
}
