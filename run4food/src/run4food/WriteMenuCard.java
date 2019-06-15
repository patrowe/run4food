package run4food;

import java.util.ArrayList;

public class WriteMenuCard {

	public static void main(String[] args) {
		
		Dishes pizza1, pizza2, pizza3, pizza4, pizza5, salat1, salat2, salat3, salat4, salat5, pasta1, pasta2, pasta3, pasta4, pasta5;
		
		pizza1 = new Dishes();
		pizza1.setName("Pizza Margherita");
		pizza1.setLactose(true);
		pizza1.setVegetarian(true);
		pizza1.setGluten(true);
		pizza1.setVegan(false);
		pizza1.setWeizen(true);
		pizza1.setCal(833);
		pizza1.setPrice(4.5);
		
		pizza2 = new Dishes();
		pizza2.setName("Pizza Salami");
		pizza2.setLactose(true);
		pizza2.setVegetarian(false);
		pizza2.setGluten(true);
		pizza2.setVegan(false);
		pizza2.setWeizen(true);
		pizza2.setCal(945);
		pizza2.setPrice(6.0);
		
		pizza3 = new Dishes();
		pizza3.setName("Pizza Capricciose");
		pizza3.setLactose(true);
		pizza3.setVegetarian(false);
		pizza3.setGluten(true);
		pizza3.setVegan(false);
		pizza3.setWeizen(true);
		pizza3.setCal(1098);
		pizza3.setPrice(7.5);
	
		pizza4 = new Dishes();
		pizza4.setName("Pizza Gourmet");
		pizza4.setLactose(true);
		pizza4.setVegetarian(false);
		pizza4.setGluten(true);
		pizza4.setVegan(false);
		pizza4.setWeizen(true);
		pizza4.setCal(1131);
		pizza4.setPrice(7.5);	
		
		pizza5 = new Dishes();
		pizza5.setName("Pizza Salami, glutenfrei");
		pizza5.setLactose(true);
		pizza5.setVegetarian(false);
		pizza5.setGluten(false);
		pizza5.setVegan(false);
		pizza5.setWeizen(false);
		pizza5.setCal(912);
		pizza5.setPrice(8.0);
		
		salat1 = new Dishes();
		salat1.setName("Insalata mit Joghurtdressing");
		salat1.setLactose(true);
		salat1.setVegetarian(true);
		salat1.setGluten(false);
		salat1.setVegan(false);
		salat1.setWeizen(false);
		salat1.setCal(346);
		salat1.setPrice(4.5);
		
		salat2 = new Dishes();
		salat2.setName("Insalata mit Essig und Oel");
		salat2.setLactose(false);
		salat2.setVegetarian(true);
		salat2.setGluten(false);
		salat2.setVegan(true);
		salat2.setWeizen(false);
		salat2.setCal(230);
		salat2.setPrice(4.5);
		
		salat3 = new Dishes();
		salat3.setName("Chef-Salat");
		salat3.setLactose(true);
		salat3.setVegetarian(false);
		salat3.setGluten(false);
		salat3.setVegan(false);
		salat3.setWeizen(false);
		salat3.setCal(589);
		salat3.setPrice(7.5);
		
		salat4 = new Dishes();
		salat4.setName("Insalata Contadina");
		salat4.setLactose(true);
		salat4.setVegetarian(true);
		salat4.setGluten(false);
		salat4.setVegan(false);
		salat4.setWeizen(false);
		salat4.setCal(384);
		salat4.setPrice(7.5);
		
		salat5 = new Dishes();
		salat5.setName("Tomaten mit Mozzarella und Balsamico");
		salat5.setLactose(true);
		salat5.setVegetarian(true);
		salat5.setGluten(false);
		salat5.setVegan(false);
		salat5.setWeizen(false);
		salat5.setCal(405);
		salat5.setPrice(5.5);
		
		pasta1 = new Dishes();
		pasta1.setName("Spaghetti Bolognese");
		pasta1.setLactose(false);
		pasta1.setVegetarian(false);
		pasta1.setGluten(true);
		pasta1.setVegan(false);
		pasta1.setWeizen(true);
		pasta1.setCal(691);
		pasta1.setPrice(5.0);
	
		pasta2 = new Dishes();
		pasta2.setName("Tortellini alla Panna");
		pasta2.setLactose(true);
		pasta2.setVegetarian(false);
		pasta2.setGluten(true);
		pasta2.setVegan(false);
		pasta2.setWeizen(true);
		pasta2.setCal(798);
		pasta2.setPrice(6.5);
		
		pasta3 = new Dishes();
		pasta3.setName("Lasagne al Forno");
		pasta3.setLactose(true);
		pasta3.setVegetarian(false);
		pasta3.setGluten(true);
		pasta3.setVegan(false);
		pasta3.setWeizen(true);
		pasta3.setCal(841);
		pasta3.setPrice(6.5);
		
		pasta4 = new Dishes();
		pasta4.setName("Penne (glutenfrei) mit Tomatensauce");
		pasta4.setLactose(false);
		pasta4.setVegetarian(true);
		pasta4.setGluten(false);
		pasta4.setVegan(true);
		pasta4.setWeizen(false);
		pasta4.setCal(475);
		pasta4.setPrice(6.0);	
		
		pasta5 = new Dishes();
		pasta5.setName("Lasagne Vegetaria");
		pasta5.setLactose(true);
		pasta5.setVegetarian(true);
		pasta5.setGluten(true);
		pasta5.setVegan(false);
		pasta5.setWeizen(true);
		pasta5.setCal(744);
		pasta5.setPrice(7.0);
		
		MenuCardItalian myCard = new MenuCardItalian();
		
		try {
			myCard.saveDish(pizza1);
			myCard.saveDish(pizza2);
			myCard.saveDish(pizza3);
			myCard.saveDish(pizza4);
			myCard.saveDish(pizza5);
			myCard.saveDish(salat1);
			myCard.saveDish(salat2);
			myCard.saveDish(salat3);
			myCard.saveDish(salat4);
			myCard.saveDish(salat5);
			myCard.saveDish(pasta1);
			myCard.saveDish(pasta2);
			myCard.saveDish(pasta3);
			myCard.saveDish(pasta4);
			myCard.saveDish(pasta5);
			
			ArrayList<Dishes> menuCard = myCard.getMenuCard();
			
			myCard.writeFile(menuCard);
			
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
