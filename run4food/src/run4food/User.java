package run4food;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String surname;
	private String firstname;
	
	private int age;
	private int weight; 
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
        this.street = street;
        this.postCode = postcode;
        this.city = city;
        this.phone = phone;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.preferedFood = preferedFood;
        this.incompatibilities = incompatibilities;
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
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBasalMetabolism(int bm) {
		this.basalMetabolism = bm;
	}
	
	public int getBasalMetabolism() {
		
		return basalMetabolism;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPreferedFood() {
		return preferedFood;
	}

	public void setPreferedFood(String preferedFood) {
		this.preferedFood = preferedFood;
	}

	public ArrayList<String> getIncompatibilities() {
		return incompatibilities;
	}

	public void setIncompatibilities(ArrayList<String> incompatibilities) {
		this.incompatibilities = incompatibilities;
	}

	
	

}
