package run4food;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;




/**
 * @author pamela
 *
 *Implementierung des Interfaces Menu für ein italienisches Restaurant
 *
 *der genutze Sortieralgorithmus ist Quicksort
 */
public class MenuCardItalian implements Menu {
	
	private File menuFile = new File("Italiano.bin");
	private ArrayList<Dishes> menuCard = new ArrayList<Dishes>();
	private ObjectOutputStream oos;
	
	

	public ArrayList<Dishes> getMenuCard(){
		return menuCard;
	}
	
	
	/**
	 *Mit dieser Methode werden Gerichte der Speisekarte zugefügt. 
	 *Keine Funktion für einen StandardUser
	 */
	@Override
	public void saveDish(Dishes dish) throws Exception {	
		
		menuCard.add(dish);

	}

	/**
	 *Mit dieser Methode wird ein Gericht von der Speisekarte genommen
	 *dient nur zur Verwaltung der Speisekarte, keine Funktion für einen StandardUser
	 */
	@Override
	public void deleteDish(String name) throws Exception {
		menuCard = this.loadCard();
		for (int a = 0; a < menuCard.size(); a++) {
			if (menuCard.get(a).getName().equals(name))
				menuCard.remove(a);
		}

		this.writeFile(menuCard);

	}

	/**
	 *Mit dieser Methode wird die Speisekarte als Datei gespeichert
	 *keine Methode für einen StandardUser
	 */
	@Override
	public void writeFile(ArrayList<Dishes> list) throws Exception {
		FileOutputStream fos = new FileOutputStream(menuFile);
		BufferedOutputStream bus = new BufferedOutputStream(fos);
		oos = new ObjectOutputStream(bus);
		oos.writeObject(list);
		oos.reset();
		oos.close();

	}

	/**
	 *Mit dieser Methode wird die gespeicherte Speisekarte geladen.
	 */
	@Override
	public ArrayList<Dishes> loadCard() throws Exception {
		try {
			// ObjectInputStream wird geoeffnet und in ArrayList<Dishes> gespeichert
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(menuFile));
			// ArrayList<Dishes> userRead = new ArrayList<Dishes>();
			menuCard = ((ArrayList<Dishes>) objectInputStream.readObject()); // type safety: vielleicht instanceof
																					// testen
			objectInputStream.close();
			System.out.println("Liste gelesen!");
			return menuCard;

		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Italienischen Liste!");
			return null;
		}

	}

	/**
	 *filterCard, sortiert Gerichte mit bekannten Unverträglichekeiten heraus
	 */
	@Override
	public ArrayList<Dishes> filterCard(ArrayList<Integer> incompabilities) throws Exception {
		menuCard = this.loadCard();
		ArrayList<Dishes> filteredList = menuCard;
		for (int a : incompabilities) {
			if (a == 1) {
				for (Iterator<Dishes> it = filteredList.iterator(); it.hasNext();) {
					if (it.next().getLactose()) {

						it.remove();
					}
				}
			}

			if (a == 2) {
				for (Iterator<Dishes> it = filteredList.iterator(); it.hasNext();) {
					if (!it.next().getVegetarian()) {

						it.remove();
					}
				}
			}
			if (a == 3) {
				for (Iterator<Dishes> it = filteredList.iterator(); it.hasNext();) {
					if (it.next().getGluten()) {

						it.remove();
					}
				}
			}
			if (a == 4) {
				for (Iterator<Dishes> it = filteredList.iterator(); it.hasNext();) {
					if (!it.next().getVegan()) {

						it.remove();
					}
				}
			}
			if (a == 5) {
				for (Iterator<Dishes> it = filteredList.iterator(); it.hasNext();) {
					if (it.next().getWeizen()) {

						it.remove();
					}
				}
			}
		}

		return filteredList;
	}

	/**
	 *Die übergebene Speisekarte wird aufsteigend sortiert zurück gegeben.
	 *Quicksort wird verwendet.
	 *
	 * @param ArrayList<Dishes> list -  die liste die Sortiert werden soll
	 * @param int sortby - 1 sortieren nach Preis, 2 sortieren nach Kalorien, 3 sortieren nach Namen
	 */
	@Override
	public ArrayList<Dishes> sortCard(ArrayList<Dishes> list, int sortby) throws Exception {
		switch (sortby) {
		case 1: //sortieren nach Preis
			return sortByPrice(list, 0, list.size()-1);
		case 2: //sortieren nach Kalorien
			return sortByCalorie(list, 0, list.size()-1);
		case 3: //sortieren nach Namen	
			return sortByName(list, 0, list.size()-1);

		}
		return null;
	}
	
	
	private ArrayList<Dishes> sortByPrice(ArrayList<Dishes> list, int left, int right){
		//Sortieren mit Quicksort
		
		int up = left; //linker Zeiger
		int down = right; //rechter Zeiger
		final double pivot = list.get((left+right)/2).getPrice(); //Pivotelement aus der Mitte
		
		
		do {
			
			while(list.get(up).getPrice() < pivot) up++; //suche von links, bis du ein grösseres Element als Pivot findest
			while(pivot < list.get(down).getPrice()) down--; //suche von rechts bis du ein kleineres Element als Pivot findest
			
			if(up<=down) { //falls gefunden, und die Indices nicht aneinander vorbeigelaufen, führe Tausch durch
	
				Dishes temp = list.get(up);
				list.set(up, list.get(down));
				list.set(down, temp);
				up++;//setze Suche fort
				down--;
			} 

		}while (up <= down);
		
		if(left < down) sortByPrice(list, left, down); //linke Hälfte
		if(up < right)  sortByPrice(list, up, right); //rechte Hälfte
		
		return list;
	}
		
	
	private ArrayList<Dishes> sortByCalorie(ArrayList<Dishes> list, int left, int right){
		
		int up = left; //linker Zeiger
		int down = right; //rechter Zeiger
		final int pivot = list.get((left+right)/2).getCal(); //Pivotelement aus der Mitte
		
		do {
			
			while(list.get(up).getCal() < pivot) up++; //suche von links bis du ein grösseres Element findest
			while(pivot < list.get(down).getCal()) down--; //suche von rechts bis du ein kleineres Element findest
			
			if(up<=down) { //falls gefunden, führe Tausch durch
				Dishes temp = list.get(up);
				list.set(up, list.get(down));
				list.set(down, temp);
				up++;
				down--;
			} 
		}while (up <= down);
		
		if(left < down) sortByCalorie(list, left, down); //linke Hälfte
		if(up < right)  sortByCalorie(list, up, right); //rechte Hälfte
		
		return list;
	}
	
	private ArrayList<Dishes> sortByName(ArrayList<Dishes> list, int left, int right){
		
		int up = left; //linker Zeiger
		int down = right; //rechter Zeiger
		final String pivot = list.get((left+right)/2).getName(); //Pivotelement aus der Mitte
		
		do {
			
			while(list.get(up).getName().compareTo(pivot)<0) up++; //suche von links bis du ein grösseres Element findest
			while(pivot.compareTo(list.get(down).getName())<0) down--; //suche von rechts bis du ein kleineres Element findest
			
			if(up<=down) { //falls gefunden, führe Tausch durch
				Dishes temp = list.get(up);
				list.set(up, list.get(down));
				list.set(down, temp);
				up++;
				down--;
			} //sonst rufe Sortieren mit kleineren Hälften auf
			
			
		
		}while (up <= down);
		
		if(left < down) sortByName(list, left, down); //linke Hälfte
		if(up < right)  sortByName(list, up, right); //rechte Hälfte
		
		return list;
	}
}
