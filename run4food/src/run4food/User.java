package run4food;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String surname;
	private String firstname;
	
	private int age;
	private int weight; //oder double?
	private int height;
	private String gender;
	private int basalMetabolism;
	
	
	private String street;
    private int streetNumber;
    private int postCode;
    private String city;
    private int phone;
	private String preferedFood;
	private ArrayList<String> incompatibilities;
	
   
    
    
	
	public User(String surname, String firstname, String street, int postcode, String city,int phone, int age, String gender,  int height, int weight, String preferedFood,  ArrayList<String> incompatibilities) {
        this.surname = surname;
        this.firstname = firstname;
        
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
	public void setStreet (String street){
		this.street = street;
	}	

	public String getStreet (){
		return street;
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
