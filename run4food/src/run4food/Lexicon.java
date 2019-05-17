package run4food;

import java.util.Hashtable;

public class Lexicon {
	
	Hashtable<String, Double> activity2calorie = new Hashtable<String, Double>();
	Hashtable<String, Double> food2calorie = new Hashtable<String, Double>();
	
	public Lexicon() {
		//Quelle www.sportunterricht.ch
				activity2calorie.put("Schwimmen", 7.5);
				activity2calorie.put("Radfahren 15-25 km/h", 7.5);
				activity2calorie.put("Radfahren 25-30 km/h", 9.5);
				activity2calorie.put("Radfahren 30-35 km/h", 11.5);
				activity2calorie.put("Radfahren 40 km/h", 17.5);
				activity2calorie.put("Laufen 7-9 km/h", 11.5);
				activity2calorie.put("Laufen 13-14 km/h", 13.5);
				activity2calorie.put("Laufen 15-17 km/h", 11.5);
				activity2calorie.put("Tischtennis", 5.3);
				activity2calorie.put("Fussball", 12.0);
				activity2calorie.put("Kraftsport", 7.0);
				activity2calorie.put("Badminton", 11.5);
				activity2calorie.put("Volleyball", 7.3);
				activity2calorie.put("Basketball", 16.2);
				activity2calorie.put("Handball", 14.0);
				activity2calorie.put("Eishockey", 14.0);
				activity2calorie.put("Judo", 14.0);
				activity2calorie.put("Turnen", 14.0);
				activity2calorie.put("Fechten", 7.5);
				activity2calorie.put("Boxen/Ring", 14.0);
				activity2calorie.put("Boxen/Sparring", 20.5);
				activity2calorie.put("Gymnastik", 3.5);
				
				// pro Gramm Quelle www.kalorientabelle.net
				//wird noch erweitert
				food2calorie.put("Apfeltasche", 0.263);
				food2calorie.put("Bagel", 0.189); 
				food2calorie.put("Baguette", 0.248);
				food2calorie.put("Bauernschnitte", 0.212);
				food2calorie.put("Brezel", 0.217);
				food2calorie.put("Buttertoast", 0.262);
				food2calorie.put("Ciabatta", 0.333);
				food2calorie.put("Croissant", 0.393);
				food2calorie.put("Donut", 0.388);
				food2calorie.put("Fladenbrot / Wraps", 0.291);
				food2calorie.put("Kaffeekränze", 0.483);
				food2calorie.put("Knäckebrot", 0.313);
				food2calorie.put("Knusperstange", 0.276);
				food2calorie.put("Laugenstange", 0.320);
				food2calorie.put("Mandelhörnchen", 0.366);
				food2calorie.put("Mehrkornbrot", 0.232);
				food2calorie.put("Nussecken", 0.561);
				food2calorie.put("Pide",0.235);
				food2calorie.put("Pumpernickel", 0.181);
				food2calorie.put("Quarktasche", 0.346);
				food2calorie.put("Reiswaffeln", 0.367 );
				food2calorie.put("Rosinenbrötchen/-stuten", 0.315);
				food2calorie.put("Sandwich", 0.257);
				food2calorie.put("Schinken Käse Croissant", 0.462);
				food2calorie.put("Schokocroissant", 0.396);
				food2calorie.put("Schwarzbrot", 0.199);
				food2calorie.put("Sesamring", 0.210);
				food2calorie.put("Vanillekipferl", 0.483);
				food2calorie.put("Vollkornbrot", 0.300);
				food2calorie.put("Vollkornknäckebrot", 0.350);
				food2calorie.put("Vollkorntoast", 0.244);
				food2calorie.put("Zimtschnecke", 0.384);
				food2calorie.put("Zwieback", 0.385);
				
				
		
	}
	
	
	public Hashtable<String, Double> getActivity2calorie(){
		return activity2calorie;
	}

	public Hashtable<String, Double> getFood2calorie(){
		return activity2calorie;
	}
	
}
