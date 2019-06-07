
package run4food;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuCard {
	private File f = new File("MenuKarte.bin");
	int auswahl = 1;
	static final long serialVersionUID = 42L;
	ArrayList<Dishes> menu_list = new ArrayList<Dishes>();
	ObjectOutputStream oos;

	public void saveDish(Dishes dish) throws Exception {
		/*
		 * try { this.menu_list =this.loadCard(); } catch(Exception e) {
		 * System.out.println("Liste leer"); }
		 */
		this.menu_list.add(dish);
		this.writeFile(menu_list);
	}

	protected void writeFile(ArrayList<Dishes> dishlist) throws Exception {
		// File wird geschrieben
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bus = new BufferedOutputStream(fos);
		this.oos = new ObjectOutputStream(bus);
		this.oos.writeObject(dishlist);
		this.oos.reset();
		this.oos.close();
	}

	protected void deleteDish(String name) throws Exception {
		// liste wird geladen, index zum loeschen ermittelt, geloescht und erneut in
		// File geschrieben
		this.menu_list = this.loadCard();
		for (int a = 0; a < this.menu_list.size(); a++) {
			if (this.menu_list.get(a).getName().equals(name))
				this.menu_list.remove(a); // gesuchtes Profil wird aus arraylist gel�scht

		}

		this.writeFile(this.menu_list);
	}

	public ArrayList<Dishes> loadCard() throws Exception {

		try {
			// ObjectInputStream wird geoeffnet und in ArrayList<Dishes> gespeichert
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
			// ArrayList<Dishes> userRead = new ArrayList<Dishes>();
			this.menu_list = (ArrayList<Dishes>) objectInputStream.readObject(); // type safety: vielleicht instanceof
																					// testen
			objectInputStream.close();
			System.out.println("Liste gelesen!");
			return this.menu_list;

		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Profilliste!");
			return null;
		}

	}

	public ArrayList<Dishes> filterCard(ArrayList<Integer> arr) throws Exception { // wenn 1 lactose,2 vegetarisch, 3
																					// Gluten
		this.menu_list = this.loadCard();
		ArrayList<Dishes> userRead = this.menu_list;
		for (int a : arr) {
			if (a == 1) {
				for (Iterator<Dishes> it = userRead.iterator(); it.hasNext();) {
					if (it.next().getLactose()) {

						it.remove();
					}
				}
			}

			if (a == 2) {
				for (Iterator<Dishes> it = userRead.iterator(); it.hasNext();) {
					if (!it.next().getVegetarian()) {

						it.remove();
					}
				}
			}
			if (a == 3) {
				for (Iterator<Dishes> it = userRead.iterator(); it.hasNext();) {
					if (it.next().getGluten()) {

						it.remove();
					}
				}
			}
			if (a == 4) {
				for (Iterator<Dishes> it = userRead.iterator(); it.hasNext();) {
					if (!it.next().getVegan()) {

						it.remove();
					}
				}
			}
			if (a == 5) {
				for (Iterator<Dishes> it = userRead.iterator(); it.hasNext();) {
					if (it.next().getWeizen()) {

						it.remove();
					}
				}
			}
		}

		return userRead;
	}

	public ArrayList<Dishes> sortCard(ArrayList<Dishes> list, int sortby) throws Exception {
		this.auswahl = sortby;
		divide(0, list.size() - 1);
		this.menu_list = list;

		return list;

	}

	/*
	 * public void sortGivenArray(){ divide(0, this.inputArray.size()-1); }
	 */

	public void divide(int startIndex, int endIndex) {

		// Bis auf ein Element runterbrechen
		if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
			int mid = (endIndex + startIndex) / 2;
			divide(startIndex, mid);
			divide(mid + 1, endIndex);

			// zusammenf�gen in ein Array
			merge(startIndex, mid, endIndex);
		}

	}

	public void merge(int startIndex, int midIndex, int endIndex) {

		// Below is the mergedarray that will be sorted array Array[i-midIndex] ,
		// Array[(midIndex+1)-endIndex]
		ArrayList<Dishes> mergedSortedArray = new ArrayList<Dishes>();

		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
			if (this.auswahl == 1) {
				if (menu_list.get(leftIndex).getPrice() <= menu_list.get(rightIndex).getPrice()) {
					mergedSortedArray.add(menu_list.get(leftIndex));
					leftIndex++;
				} else {
					mergedSortedArray.add(menu_list.get(rightIndex));
					rightIndex++;
				}
			}
			if (this.auswahl == 2) {
				if (menu_list.get(leftIndex).getCal() <= menu_list.get(rightIndex).getCal()) {
					mergedSortedArray.add(menu_list.get(leftIndex));
					leftIndex++;
				} else {
					mergedSortedArray.add(menu_list.get(rightIndex));
					rightIndex++;
				}
			}

			if (this.auswahl == 3) {
				if (menu_list.get(leftIndex).getName().compareTo(menu_list.get(rightIndex).getName()) < 0) {
					mergedSortedArray.add(menu_list.get(leftIndex));
					leftIndex++;
				} else {
					mergedSortedArray.add(menu_list.get(rightIndex));
					rightIndex++;
				}
			}
		}

		// Either of below while loop will execute
		while (leftIndex <= midIndex) {
			mergedSortedArray.add(menu_list.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex <= endIndex) {
			mergedSortedArray.add(menu_list.get(rightIndex));
			rightIndex++;
		}

		int i = 0;
		int j = startIndex;
		// Setting sorted array to original one
		while (i < mergedSortedArray.size()) {
			menu_list.set(j, mergedSortedArray.get(i++));
			j++;
		}
	}

}
