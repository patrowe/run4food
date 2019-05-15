package Profil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserManagement implements Serializable {
	private File f = new File("alles.bin"); // Dateiname wo die Profile gespeichert werden
	private File t = new File("l12.bin");
	ObjectOutputStream oos;
	AppendingObjectOutputStream aoos;
	RegisteredUser test = new RegisteredUser();

	public UserManagement() {
		try {
			if (f.exists()) // wenn Datei schon existiert wird der Header nicht überschrieben ->
							// AppendingObjectOutputStream
				this.aoos = new AppendingObjectOutputStream(new FileOutputStream(f, true));
			else // Datei existiert noch nicht -> neu anlegen
				this.oos = new ObjectOutputStream(new FileOutputStream(f, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveUser(RegisteredUser user) throws Exception {

		System.out.println(user.getForename());
		// neuer Benutzer wird in Datei geschrieben

		FileOutputStream fos = new FileOutputStream(f, true);
		BufferedOutputStream bus = new BufferedOutputStream(fos);
		AppendingObjectOutputStream aoos = new AppendingObjectOutputStream(bus);
		aoos.writeObject(user);
		aoos.reset();
		aoos.close();

	}

	protected RegisteredUser loadUser(String name) throws Exception { // momentan werden einfach alle Profile als
																		// Objekte eingelesen undin Arraylist
																		// gespeichert
		int zaehl = 0;
		// declaring ArrayList
		ArrayList<RegisteredUser> profil_liste = new ArrayList<RegisteredUser>();
		boolean list_check = true;
		// declaring ObjectInputStream
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
			while (list_check) {
				RegisteredUser userRead = (RegisteredUser) objectInputStream.readObject();
				if (userRead != null)
					profil_liste.add(userRead);
				else
					list_check = false;
			}
		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Profilliste!");
		}

		for (int i = 0; i < profil_liste.size(); i++) { // Ausgabe der Arraylist zur Überprüfung
			System.out.println("Vorname: " + profil_liste.get(i).getForename() + " Nachname: "
					+ profil_liste.get(i).getSurname() + " UserId: " + profil_liste.get(i).getUserId());
			if (profil_liste.get(i).getSurname() == name)
				return profil_liste.get(i);
		}

		/*while (!profil_liste.get(zaehl).getSurname().equals(name)) { // index für gesuchten Nutzer wird in der
																		// Arrayliste ermittelt
			zaehl++;
		} */
		return profil_liste.get(0);

	}

	protected ArrayList<RegisteredUser> loadListe() throws Exception { // komplette Liste aller Nutzer, vielleicht nötig
																		// aber nicht im Klasendiagramm
		// benutzt um user zu löschen

// declaring ArrayList
		ArrayList<RegisteredUser> profil_liste = new ArrayList<RegisteredUser>();
		boolean list_check = true;
// declaring ObjectInputStream
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
			while (list_check) {
				RegisteredUser userRead = (RegisteredUser) objectInputStream.readObject();
				if (userRead != null)
					profil_liste.add(userRead);
				else
					list_check = false;
			}
		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Profilliste!");
		}
		return profil_liste;
	}

	protected void deleteUser(String name) throws Exception {
		int i = 0;
		ArrayList<RegisteredUser> profile = this.loadListe();
		for (int a = 0; a < profile.size(); a++) 
		{
			if (profile.get(a).getSurname() == name)
				i=a;
		}
		/*	while (!profile.get(i).getSurname().equals(name)) { // index für gesuchten Nutzer wird in der
			// Arrayliste ermittelt
			i++;
		}*/
		
		System.out.println("Gesuchter Index zum löschen" +i);
		
		profile.remove(i); // gesuchtes Profil wird aus arraylist gelöscht
		
		
		FileOutputStream fos = new FileOutputStream(f);
		for(int y = 0; y< profile.size();y++)
		{
			System.out.println("del User "+ profile.get(y).getForename());
			
			BufferedOutputStream bus = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bus);
			oos.writeObject(profile.get(y));
			oos.reset();
			oos.close();
			fos = new FileOutputStream(f,true);
		}
		fos.close();
		//oos.reset();
		//oos.close();

	}

}
