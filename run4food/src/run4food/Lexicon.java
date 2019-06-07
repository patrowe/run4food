package run4food;

import java.util.Hashtable;

public class Lexicon {
	
	Hashtable<String, Double> activity2calory = new Hashtable<String, Double>();
	Hashtable<String, Double> food2calory = new Hashtable<String, Double>();
	
	public Lexicon() {
		//Quelle www.sportunterricht.ch
				activity2calory.put("Schwimmen", 7.5);
				activity2calory.put("Radfahren 15-25 km/h", 7.5);
				activity2calory.put("Radfahren 25-30 km/h", 9.5);
				activity2calory.put("Radfahren 30-35 km/h", 11.5);
				activity2calory.put("Radfahren 40 km/h", 17.5);
				activity2calory.put("Laufen 7-9 km/h", 11.5);
				activity2calory.put("Laufen 13-14 km/h", 13.5);
				activity2calory.put("Laufen 15-17 km/h", 11.5);
				activity2calory.put("Tischtennis", 5.3);
				activity2calory.put("Fussball", 12.0);
				activity2calory.put("Kraftsport", 7.0);
				activity2calory.put("Badminton", 11.5);
				activity2calory.put("Volleyball", 7.3);
				activity2calory.put("Basketball", 16.2);
				activity2calory.put("Handball", 14.0);
				activity2calory.put("Eishockey", 14.0);
				activity2calory.put("Judo", 14.0);
				activity2calory.put("Turnen", 14.0);
				activity2calory.put("Fechten", 7.5);
				activity2calory.put("Boxen/Ring", 14.0);
				activity2calory.put("Boxen/Sparring", 20.5);
				activity2calory.put("Gymnastik", 3.5);
				
				// pro Gramm Quelle www.kalorientabelle.net
				//wird noch erweitert
				food2calory.put("Apfeltasche", 0.263);
				food2calory.put("Bagel", 0.189); 
				food2calory.put("Baguette", 0.248);
				food2calory.put("Bauernschnitte", 0.212);
				food2calory.put("Brezel", 0.217);
				food2calory.put("Buttertoast", 0.262);
				food2calory.put("Ciabatta", 0.333);
				food2calory.put("Croissant", 0.393);
				food2calory.put("Donut", 0.388);
				food2calory.put("Fladenbrot / Wraps", 0.291);
				food2calory.put("Kaffeekränze", 0.483);
				food2calory.put("Knäckebrot", 0.313);
				food2calory.put("Knusperstange", 0.276);
				food2calory.put("Laugenstange", 0.320);
				food2calory.put("Mandelhörnchen", 0.366);
				food2calory.put("Mehrkornbrot", 0.232);
				food2calory.put("Nussecken", 0.561);
				food2calory.put("Pide",0.235);
				food2calory.put("Pumpernickel", 0.181);
				food2calory.put("Quarktasche", 0.346);
				food2calory.put("Reiswaffeln", 0.367 );
				food2calory.put("Rosinenbrötchen/-stuten", 0.315);
				food2calory.put("Sandwich", 0.257);
				food2calory.put("Schinken Käse Croissant", 0.462);
				food2calory.put("Schokocroissant", 0.396);
				food2calory.put("Schwarzbrot", 0.199);
				food2calory.put("Sesamring", 0.210);
				food2calory.put("Vanillekipferl", 0.483);
				food2calory.put("Vollkornbrot", 0.300);
				food2calory.put("Vollkornknäckebrot", 0.350);
				food2calory.put("Vollkorntoast", 0.244);
				food2calory.put("Zimtschnecke", 0.384);
				food2calory.put("Zwieback", 0.385);
				
				
		
	}
	
	
	public Hashtable<String, Double> getActivity2calory(){
		return activity2calory;
	}

	public Hashtable<String, Double> getFood2calory(){
		return food2calory;
	}
	
}
