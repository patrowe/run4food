package run4food;

public class User {
	
	Diary myDiary;
	
	User(){
		myDiary = new Diary();
	}
	
	
	double getWeight() {
		return 70.0;
	}
	
	double getBasalMetabolism() {
		return 1500;
	}
	
	Diary getDiary() {
		return myDiary;
	}
	
}
