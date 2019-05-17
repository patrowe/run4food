package run4food;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuCard {
	private File f = new File("MenuList.bin");
	ArrayList<Dishes> menu_list = new ArrayList<Dishes>();
	ObjectOutputStream oos;

	public void saveDish(Dishes dish) throws Exception {
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
				this.menu_list.remove(a); // gesuchtes Profil wird aus arraylist gelöscht

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
			return this.menu_list;

		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Profilliste!");
			return null;
		}

	}

	public ArrayList<Dishes> sortCard(int a) throws Exception { // wenn 1 lactose,2 vegetarisch
		this.menu_list = this.loadCard();
		ArrayList<Dishes> userRead = new ArrayList<Dishes>();
		if (a == 1) {
			for (int i = 0; i < this.menu_list.size(); i++)
				if (this.menu_list.get(i).getLactose() == true)
					userRead.add(this.menu_list.get(i));
		}
		else if (a==2){
			for (int i = 0; i < this.menu_list.size(); i++)
				if (this.menu_list.get(i).getVegetarian() == true)
					userRead.add(this.menu_list.get(i));
		}
	
		return userRead;
	}

}
