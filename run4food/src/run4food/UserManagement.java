package run4food;

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
import java.util.List;

public class UserManagement implements Serializable {
	private File f = new File("AldProf.bin"); // Dateiname wo die Profile gespeichert werden

	ArrayList<RegisteredUser> profile_list = new ArrayList<RegisteredUser>();
	public List<RegisteredUser> p_list;
	Object test = new Object();
	
	ObjectOutputStream oos;
	
	// AppendingObjectOutputStream aoos;
	// RegisteredUser test = new RegisteredUser();

	public UserManagement() {
		try {
			this.oos = new ObjectOutputStream(new FileOutputStream(f, true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveUser(RegisteredUser user) throws Exception {

		System.out.println(user.getFirstname());
		// neuer Benutzer wird in Datei geschrieben

		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bus = new BufferedOutputStream(fos);
		this.oos = new ObjectOutputStream(bus);
		this.profile_list.add(user);
		this.oos.writeObject(profile_list);
		this.oos.writeObject(p_list);
		this.oos.reset();
		this.oos.close();

	}

	
	public ArrayList<RegisteredUser> loadListe() throws Exception { // komplette Liste aller Nutzer, vielleicht nötig
		
		try {
			
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
			ArrayList<RegisteredUser> userRead = new	ArrayList<RegisteredUser>();
			userRead = (ArrayList<RegisteredUser>) objectInputStream.readObject();
			objectInputStream.close(); 
				return userRead;
			
		} catch (Exception e) {
			System.out.println("Fehler/Ende beim lesen der Profilliste!");
			return null;
		}
		
	}

	protected void deleteUser(String name) throws Exception {
		int i = 0;
		ArrayList<RegisteredUser> profile = this.loadListe();
		System.out.println("sdfsdfsdfsdf" +profile.size());
		System.out.println("i  " + i);
		for (int a = 0; a < profile.size(); a++) {
			System.out.println("a  " + a);
			if (profile.get(a).getSurname().equals(name))
				i = a;
		}
		System.out.println("i  " + i);
		/*
		 * while (!profile.get(i).getSurname().equals(name)) { // index für gesuchten
		 * Nutzer wird in der // Arrayliste ermittelt i++; }
		 */

		System.out.println("Gesuchter Index zum löschen" + i);

		profile.remove(i); // gesuchtes Profil wird aus arraylist gelöscht
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bus = new BufferedOutputStream(fos);
		this.oos = new ObjectOutputStream(bus);
		
		this.oos.writeObject(profile);
		this.oos.reset();
		this.oos.close();
	}

}
