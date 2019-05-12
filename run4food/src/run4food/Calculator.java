package run4food;
import java.util.Hashtable;


public class Calculator {
	// Version 1.0, die Listen activity2calory, food2calory müssen noch erweitert werden
	// die Formel für den Grundumsatz funktioniert nicht für "divers" wie sollen wir den Fall behandeln?

	Hashtable<String, Double> activity2calory = new Hashtable<String, Double>();
	Hashtable<String, Double> food2calory = new Hashtable<String, Double>();
	
	Calculator(){
		//Quelle www.sportunterricht.ch
		activity2calory.put("Schwimmen", 7.0);
		activity2calory.put("Radfahren 15 km/h", 7.5);
		activity2calory.put("Laufen 14 km/h", 11.5);
		activity2calory.put("Tischtennis", 5.3);
		activity2calory.put("Fussball", 12.0);
		// pro Gramm Quelle www.kalorientabelle.net
		//wird noch erweitert
		food2calory.put("Apfel", 0.52);
		food2calory.put("Birne", 0.58);
		food2calory.put("Käckebrot", 0.313);
		food2calory.put("Toastbrot", 0.238);
		food2calory.put("Vollkornbrot", 0.212);


		
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
