package run4food;



import java.io.Serializable;

public class Dishes implements Serializable {
	private String name;
	private Boolean lactose,vegetarian,gluten;
	private int cal;
	private double price;
	
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

	protected void setGluten(Boolean glut) {
		this.gluten = glut;
	}

	protected Boolean getGluten() {
		return this.gluten;
	}

	protected void setPrice(double preis) {
		this.price = preis;
	}
	protected double getPrice() {
		 return this.price;
	}

}
