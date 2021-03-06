package run4food;
import java.util.Hashtable;


public class Calculator {
	// Version 1.0, die Listen activity2calory, food2calory müssen noch erweitert werden
	// die Formel für den Grundumsatz funktioniert nicht für "divers" wie sollen wir den Fall behandeln?

	private Hashtable<String, Double> activity2calorie;
	private Hashtable<String, Double> food2calorie;
	private Lexicon lexicon = new Lexicon();

	public Calculator(){
		activity2calorie = lexicon.getActivity2calory();
		food2calorie = lexicon.getFood2calory();
	}

	public int basalMetabolism(int age, int weight, int height, String gender) {

		int s=0;

		if (gender.equals("female")) s=-161;
		if (gender.equals("male")) s= 5;

		//Mifflin St. Jeor-Formel
		return (int) Math.round(10.0 * weight + 6.25 * height - 5.0 * age + s);
	}


	int steps2calory(int steps) {
		// habe diese "Faustformel" gefunden. Kennt jemand eine besssere?
		return (int) Math.round(steps* 0.04);
	}


	int activity2calory(String activity, double duration, int weight) {
		// Dauer in Stunden, Gewicht des Users in ganzen Kilogramm
	System.out.println("activity2calory");
		return (int) Math.round(duration*weight* activity2calorie.get(activity));

	}

	int food2calory(String food, double quantity) {
		// Menge in gramm

		return (int) Math.round(quantity/100 * food2calorie.get(food));

	}

}