package run4food;
import java.util.Hashtable;


public class Calculator {
	// Version 1.0, die Listen activity2calory, food2calory müssen noch erweitert werden
	// die Formel für den Grundumsatz funktioniert nicht für "divers" wie sollen wir den Fall behandeln?

	private Hashtable<String, Double> activity2calory;
	private Hashtable<String, Double> food2calory;
	private Lexicon lexicon = new Lexicon();
	
	Calculator(){
		activity2calory = lexicon.getActivity2calory();
		food2calory = lexicon.getFood2calory();
	}
	
	double basalMetabolism(int age, double weight, double height, String gender) {
		
		int s=0;
		
		if (gender.equals("female")) s=-161;
		if (gender.equals("male")) s= 5;
		
		//Mifflin St. Jeor-Formel
		return 10.0 * weight + 6.25 * height - 5.0 * age + s;
	}
	
	
	double steps2calory(int steps) {
	// habe diese "Faustformel" gefunden. Kennt jemand eine besssere?
		return steps* 0.04;
	}
	
	
	double activity2calory(String activity, double duration, double weight) {
		// Dauer in Stunden, Gewicht des Users in Kilogramm
		
		return duration*weight* activity2calory.get(activity);
		
	}
	
	double food2calory(String food, double quantity) {
		// Menge in gramm
		
		return quantity * food2calory.get(food);
		
	}
	
}
