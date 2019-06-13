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

		// pro 100 Gramm Quelle www.kalorientabelle.net
		//wird noch erweitert
		food2calory.put("Apfeltasche", 263.0);
		food2calory.put("Bagel", 189.0); 
		food2calory.put("Baguette", 248.0);
		food2calory.put("Bauernschnitte", 212.0);
		food2calory.put("Brezel", 217.0);
		food2calory.put("Buttertoast", 262.0);
		food2calory.put("Ciabatta", 333.0);
		food2calory.put("Croissant", 393.0);
		food2calory.put("Donut", 388.0);
		food2calory.put("Fladenbrot / Wraps", 291.0);
		food2calory.put("Kaffeekränze", 483.0);
		food2calory.put("Knäckebrot", 313.0);
		food2calory.put("Knusperstange", 276.0);
		food2calory.put("Laugenstange", 320.0);
		food2calory.put("Mandelhörnchen", 366.0);
		food2calory.put("Mehrkornbrot", 232.0);
		food2calory.put("Nussecken", 561.0);
		food2calory.put("Pide", 235.0);
		food2calory.put("Pumpernickel", 181.0);
		food2calory.put("Quarktasche", 346.0);
		food2calory.put("Reiswaffeln", 367.0);
		food2calory.put("Rosinenbrötchen/-stuten", 315.0);
		food2calory.put("Sandwich", 257.0);
		food2calory.put("Schinken Käse Croissant", 462.0);
		food2calory.put("Schokocroissant", 396.0);
		food2calory.put("Schwarzbrot", 199.0);
		food2calory.put("Sesamring", 210.0);
		food2calory.put("Vanillekipferl", 483.0);
		food2calory.put("Vollkornbrot", 300.0);
		food2calory.put("Vollkornknäckebrot", 350.0);
		food2calory.put("Vollkorntoast", 244.0);
		food2calory.put("Zimtschnecke", 384.0);
		food2calory.put("Zwieback", 385.0);
		food2calory.put("Ananas" , 50.0); 
		food2calory.put("Apfel", 52.0);
		food2calory.put("Aprikose", 48.0) ;
		food2calory.put("Avocado", 160.0) ;
		food2calory.put("Banane",89.0);
		food2calory.put("Birne",  58.0);
		food2calory.put("Datteln", 282.0);
		food2calory.put("Erdbeeren", 32.0);
		food2calory.put("Feigen", 74.0);
		food2calory.put("Grapefruit", 32.0);
		food2calory.put("Himbeeren", 52.0);
		food2calory.put("Kirschen", 63.00);
		food2calory.put("Kiwi", 61.0);
		food2calory.put("Mandarine", 53.0);
		food2calory.put("Mango", 65.0);
		food2calory.put("Nektarine", 44.0);
		food2calory.put("Obstsalat", 53.0);
		food2calory.put("Orange", 47.0);
		food2calory.put("Pfirsich", 39.0);
		food2calory.put("Pflaume", 46.0);
		food2calory.put("Rhabarber",20.0);
		food2calory.put("Wassermelone", 30.0);
		food2calory.put("Weintrauben", 69.0);
		food2calory.put("Zitrone", 29.0);
		food2calory.put("Bircher Müsli",361.0);
		food2calory.put("Cini-Minis",424.0) ;
		food2calory.put("Cornflakes",353.0);
		food2calory.put("Froot Loops",391.0);
		food2calory.put("Früchte Müsli",355.0);
		food2calory.put("Haferflocken",366.0);
		food2calory.put("Kelloggs Frosties",378.0);
		food2calory.put("Kelloggs Special K",379.0);
		food2calory.put("Knusper-Schoko Müsli",445.0);
		food2calory.put("Lion Cereals",411.0);
		food2calory.put("Mymuesli Müsli",403.0);
		food2calory.put("Müsli mit Nüssen",375.0);
		food2calory.put("Porridge / Haferbrei",106.0);
		food2calory.put("Seitenbacher Müsli",332.0);
		food2calory.put("Smacks / Honigpops",386.0);
		food2calory.put("Vollkornmüsli",404.0);
		food2calory.put("Butter", 752.0);
		food2calory.put("Ei", 161.0);
		food2calory.put("Erdbeermarmelade", 251.0);
		food2calory.put("Erdnussbutter", 625.0);
		food2calory.put("Frischkäse 60,0", 342.0);
		food2calory.put("Halbfettmargarine", 360.0);
		food2calory.put("Honig", 287.0);
		food2calory.put("Ketchup", 97.0);
		food2calory.put("Kräuterbutter", 661.0);
		food2calory.put("Leberwurst", 358.0);
		food2calory.put("Margarine", 720.0);
		food2calory.put("Mayonnaise", 721.0);
		food2calory.put("Nuss-Nougat-Creme", 532.0);
		food2calory.put("Pommersche", 276.0);
		food2calory.put("Schmalz", 930.0);
		food2calory.put("Schmelzkäse", 296.0);
		food2calory.put("Senf", 88.0); 
		food2calory.put("Bacon & Egg McMuffin",228.0); 
		food2calory.put("BBQ Rib",174.0);  
		food2calory.put("Bean Burrito",204.0); 
		food2calory.put("Big Bacon & Eggs",190.0); 
		food2calory.put("Big King",277.0); 
		food2calory.put("Big Mac",225.0); 
		food2calory.put("Big Tasty Bacon",259.0);  
		food2calory.put("Bratwurst",291.0); 
		food2calory.put("Cheeseburger",250.0);  
		food2calory.put("Chicken McNuggets",236.0); 
		food2calory.put("Chili Cheese Nuggets",305.0); 
		food2calory.put("Crispy Chicken",269.0);  
		food2calory.put("Curly Fries",260.0); 
		food2calory.put("Currywurst",288.0); 
		food2calory.put("Doppel Cheeseburger",254.0); 
		food2calory.put("Doppel Hamburger",241.0); 
		food2calory.put("Döner",215.0); 
		food2calory.put("Egg McMuffin",228.0); 
		food2calory.put("Falafel",350.0); 
		food2calory.put("Frikandel",167.0); 
		food2calory.put("Grilled Chicken Wrap",152.0); 
		food2calory.put("Hamburger",241.0); 
		food2calory.put("Hamburger Royal TS",217.0); 
		food2calory.put("Hotdog",212.0); 
		food2calory.put("Long Chicken",280.0); 
		food2calory.put("McChicken",226.0);  
		food2calory.put("McDouble",248.0); 
		food2calory.put("McRib",235.0); 
		food2calory.put("Nachos mit Käse",306.0); 
		food2calory.put("Onion Rings",367.0); 
		food2calory.put("Pommes",291.0); 
		food2calory.put("Vegetarischer Döner",107.0);  
		food2calory.put("Veggieburger",240.0);  
		food2calory.put("Whopper",231.0);  
		food2calory.put("Apfelschorle",34.0);
		food2calory.put("Bionade",22.0);
		food2calory.put("Capri-Sonne Orange", 29.0);
		food2calory.put("Coca Cola", 37.0);
		food2calory.put("Eistee", 29.0);
		food2calory.put("Fanta", 38.0);
		food2calory.put("Fassbrause",24.0);
		food2calory.put("Fritz Kola",42.0);
		food2calory.put("Ginger Ale", 34.0);
		food2calory.put("Mezzo Mix", 43.0);
		food2calory.put("Red Bull", 45.0);
		food2calory.put("Spezi", 44.0);
		food2calory.put("Sprite", 37.0);
		food2calory.put("Bier (4,9 Vol.-%)",42.0);
		food2calory.put("Gin (47,0 Vol.-%)",262.0); 
		food2calory.put("Glühwein (7,0 Vol.-%)",87.0); 
		food2calory.put("Jägermeister (35,0 Vol.-%)",250.0); 
		food2calory.put("Likör (20,0 Vol.-%)",194.0); 
		food2calory.put("Ramazzotti (30,0 Vol.-%)",275.0); 
		food2calory.put("Rosé (11,5 Vol.-%)",71.0); 
		food2calory.put("Rotwein (12,0 Vol.-%)",65.0); 
		food2calory.put("Vodka / Wodka (43,0 Vol.-%)",234.0); 
		food2calory.put("Weißwein (12,0 Vol.-%)",69.0); 
		food2calory.put("Whisky / Scotch (43,0 Vol.-%)",246.0); 

	}


	public Hashtable<String, Double> getActivity2calory(){
		return activity2calory;
	}

	public Hashtable<String, Double> getFood2calory(){
		return food2calory;
	}

}
