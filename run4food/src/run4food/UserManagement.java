package run4food;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Dennis Liebelt
 * 		  	Die Klasse UserManagement ermoeglicht die Verwaltung der Profile. Dies beeinhaltet das Erstellen eines neuen Benutzers,
 * 			das Verändern eines Profils, das Laden und das Löschen.
 */


public class UserManagement {

    private File f = new File("AldProf.bin"); // Dateiname wo die Profile gespeichert werden
    ArrayList<RegisteredUser> profile_list = new ArrayList<RegisteredUser>();
    ObjectOutputStream oos;


    /**
     * @author Dennis Liebelt
     * @param user - Profil vom Typ RegisteredUser
     */
    public void saveUser(RegisteredUser user) throws Exception {

        // neuer Benutzer wird Liste hinzugefügt und in Datei geschrieben
        ArrayList<RegisteredUser> userRead = new ArrayList<RegisteredUser>();;
        try {
            //ObjectInputStream wird geoeffnet und in ArrayList<RegisteredUser> gespeichert
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
            userRead = (ArrayList<RegisteredUser>) objectInputStream.readObject(); //type safety: vielleicht instanceof testen
            objectInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fehler/Ende beim lesen der Profilliste!");
        }
        userRead.add(user);
        this.writeFile(userRead);

    }

    /**
     * @author Dennis Liebelt
     * @return Arraylist<RegisteredUser> - enthaelt alle Profile
     */
    public ArrayList<RegisteredUser> loadListe() throws Exception {

        try {
            //ObjectInputStream wird geoeffnet und in ArrayList<RegisteredUser> gespeichert
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
            ArrayList<RegisteredUser> userRead = new ArrayList<RegisteredUser>();
            userRead = (ArrayList<RegisteredUser>) objectInputStream.readObject(); //type safety: vielleicht instanceof testen
            objectInputStream.close();
            return userRead;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fehler/Ende beim lesen der Profilliste!");
            return null;
        }

    }

    /**
     * @author Dennis Liebelt
     * @param String name - UserId des gesuchten Profiles
     */

    public void deleteUser(String name) throws Exception {
        //liste wird geladen, index zum loeschen ermittelt, geloescht und erneut in File geschrieben
        this.profile_list = this.loadListe();
        for (int a = 0; a < this.profile_list.size(); a++) {
            if (this.profile_list.get(a).getUserId().equals(name))
                this.profile_list.remove(a); // gesuchtes Profil wird aus arraylist gelöscht

        }

        this.writeFile(this.profile_list);
    }

    /**
     * @author Dennis Liebelt
     * @param RegisteredUser user - geaendertes Profil
     */

    protected void updateUser(RegisteredUser user) throws Exception {
        //liste wird geladen, gesuchtes Profil zum updaten ermittelt, altes Profil rausgenommen und neues reingeschrieben
        this.profile_list  = this.loadListe();
        for (int i = 0; i < this.profile_list.size(); i++) {
            if (this.profile_list.get(i).getUserId().equals(user.getUserId())) {
                this.profile_list.remove(i);
                this.profile_list.add(user);
            }
        }

        this.writeFile(this.profile_list);
    }

    /**
     * @author Dennis Liebelt
     * @param ArrayList<RegisteredUser> profile - Profilliste die als File geschrieben werden soll
     */
    protected void writeFile(ArrayList<RegisteredUser> profile) throws Exception {
        //File wird geschrieben
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bus = new BufferedOutputStream(fos);
        this.oos = new ObjectOutputStream(bus);
        this.oos.writeObject(profile);
        this.oos.reset();
        this.oos.close();
    }
}