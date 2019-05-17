package run4food;

import java.io.Serializable;

public class Dishes implements Serializable {
	private String name;
	private Boolean lactose,vegetarian;
	private int cal;
	private float price;
	
	protected void setName(String name) {
		this.name = name;
	}

	protected String getName() {
		return this.name;
	}

	protected void setCal(int cal) {
		this.cal = cal;
	}

	protected int getCal() {
		return this.cal;
	}

	protected void setLactose(Boolean lac) {
		this.lactose = lac;
	}

	protected Boolean getLactose() {
		return this.lactose;
	}

	protected void setVegetarian(Boolean veg) {
		this.vegetarian = veg;
	}

	protected Boolean getVegetarian() {
		return this.vegetarian;
	}
	
	protected void setPrice(float preis) {
		this.price = preis;
	}
	protected float getPrice() {
		 return this.price;
	}

}
