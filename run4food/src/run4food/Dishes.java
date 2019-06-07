package run4food;

import java.io.Serializable;

public class Dishes implements Serializable {
	private String name;
	private Boolean lactose,vegetarian,gluten,vegan,weizen;
	private int cal;
	private double price;
	static final long serialVersionUID= 42L; 
	
	protected void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	protected void setCal(int cal) {
		this.cal = cal;
	}

	public int getCal() {
		return this.cal;
	}

	protected void setVegan(boolean b) {
		this.vegan = b;
	}

	public boolean getVegan() {
		return this.vegan;
	}

	protected void setWeizen(boolean b) {
		this.weizen = b;
	}

	public boolean getWeizen() {
		return this.weizen;
	}
	
	protected void setLactose(Boolean lac) {
		this.lactose = lac;
	}

	public Boolean getLactose() {
		return this.lactose;
	}

	protected void setVegetarian(Boolean veg) {
		this.vegetarian = veg;
	}

	public Boolean getVegetarian() {
		return this.vegetarian;
	}

	protected void setGluten(Boolean glut) {
		this.gluten = glut;
	}

	public Boolean getGluten() {
		return this.gluten;
	}

	protected void setPrice(double preis) {
		this.price = preis;
	}
	public double getPrice() {
		 return this.price;
	}

}
