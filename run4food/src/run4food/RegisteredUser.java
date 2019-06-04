package run4food;


import java.util.ArrayList;
import java.util.Hashtable;

public class RegisteredUser extends User{
	
	public String userId;
	private Hashtable<String, Integer[]> diary;
	
	
	public RegisteredUser(String userId, String surname, String firstname, String street, int streetnumber, int postcode, String city, int phone, int age, String gender, int height, int weight, String preferedFood, ArrayList<String> incompatibilities ){
		
		super(surname, firstname, street, streetnumber, postcode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
		this.userId = userId;
		diary = new Hashtable<String, Integer[]>();
	}
	
	public void setUserId (String id){
		this.userId = id;
	}	

	public String getUserId (){
		return userId;
	}
	
	public void setDiary(String date, Integer[] value) {
		diary.put(date, value);
	}
	
	public Hashtable<String, Integer[]> getDiary(){
		return diary;
	}
}
