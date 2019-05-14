package run4food;

import java.util.Date;
import java.util.Hashtable;

public class User {
	private String surname;
	private String firstname;
	private String address;
	private int age;
	private int weight; //oder double?
	private int height;
	private String gender;
	private int basalMetabolism;
	
	
	public User(String surname, String firstname, String address, int age, int weight, int height, String gender) {
        this.surname = surname;
        this.firstname = firstname;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }
	
	public void setSurname (String surname){
		this.surname = surname;
	}	

	public String getSurname (){
		return surname;
	}

	public void setFirstname (String firstname){
		this.firstname = firstname;
	}	

	public String getFirstname (){
		return firstname;
	}
	public void setAddress (String address){
		this.address = address;
	}	

	public String getAddress (){
		return address;
	}
	
	public void setWeight (int weight){
		this.weight = weight;
	}	

	public int getWeight (){
		return weight;
	}
	
	public void setHeight (int height){
		this.height = height;
	}	

	public int getHeight (){
		return height;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setgender (String gender){
		this.gender = gender;
	}	

	public String getGender (){
		return gender;
	}
	
	
	public void setBasalMetabolism(int bm) {
		this.basalMetabolism = bm;
	}
	public int getBasalMetabolism() {
		
		return basalMetabolism;
	}
	
	

}
