package run4food;

import java.util.Hashtable;

public class RegisteredUser extends User{
	
	public String userId;
	private Hashtable<String, Integer[]> diary;
	
	public void setUserId (String id){
		this.userId = id;
	}	

	public String getUserId (){
		return userId;
	}
	
	public RegisteredUser(String surname, String firstname, String address, int age, int weight, int height, String gender, String userId){
		super(surname, firstname, address, age, weight, height, gender);
	}
	
	
	public void setDiary(String date, Integer[] value) {
		diary.put(date, value);
	}
	
	public Hashtable<String, Integer[]> getDiary(){
		return diary;
	}
}
