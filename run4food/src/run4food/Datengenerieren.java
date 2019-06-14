package run4food;

import java.util.ArrayList;
import java.util.TreeMap;

public class Datengenerieren {
	
	
	public static void main(String[] args) {
		UserManagement uManagement = new UserManagement();
		Calculator calc = new Calculator();
		
		ArrayList<String> a=new ArrayList<>();
		a.add("Weizen");
		RegisteredUser regUser = new RegisteredUser("T800", "Arnold", "Schwarzenegger", "Sesamstrasse", 1, 12345, "LosAngeles", 999, 34, "male", 189, 94, "Vegan", a);
		int b = calc.basalMetabolism(34, 94, 189, "male");
		regUser.setBasalMetabolism(b);
		
		//Tagebucheintrag in der Reihenfolge earnedCalorie/consumedCalorie/freeCalorie/Weight/BasalMetabolsim
		
		Integer[] entry1 = {600,400,b+600-400,94,b};
		Integer[] entry2 = {700,450,b+700-450,94,b};
		Integer[] entry3 = {500,480,b+500-480,94,b};
		Integer[] entry4 = {100,700,b+100-700,94,b};
		Integer[] entry5 = {800,600,b+800-600,94,b};
		Integer[] entry6 = {300,800,b+300-800,94,b};
		Integer[] entry7 = {500,900,b+500-900,94,b};
		Integer[] entry8 = {600,500,b+600-500,94,b};
		
		regUser.setDiary("05.06.2019", entry1);
		regUser.setDiary("06.06.2019", entry2);
		regUser.setDiary("07.06.2019", entry3);
		regUser.setDiary("08.06.2019", entry4);
		regUser.setDiary("09.06.2019", entry5);
		regUser.setDiary("10.06.2019", entry6);
		regUser.setDiary("11.06.2019", entry7);
		regUser.setDiary("12.06.2019", entry8);
		
		try {
			uManagement.saveUser(regUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
