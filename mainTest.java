package Profil;

import java.util.ArrayList;

public class mainTest {

	public static void main(String[] args) throws Exception {
		UserManagement usrManage = new UserManagement();
		RegisteredUser person = new RegisteredUser(); 
		RegisteredUser person2 = new RegisteredUser(); 
		RegisteredUser person3 = new RegisteredUser(); 
		
		person.setForename("Dieter");
		person.setSurname("Doedel");
		person.setuserid(01);

		person.setHeight(155);
		usrManage.saveUser(person);
		
		person2.setForename("Karl");
		person2.setSurname("Klumpen");
		person2.setuserid(02);

		person2.setHeight(175);
		usrManage.saveUser(person2);
		
		person3.setForename("Peter");
		person3.setSurname("Pansen");
		person3.setuserid(044);

		person3.setHeight(205);
		usrManage.saveUser(person3);

		
		
		RegisteredUser user = usrManage.loadUser("Pansen");
		System.out.println("Vorname:" + user.getForename() +"Groesse: " + user.getHeight());
	/*
		usrManage.deleteUser("Pansen");
	
		//usrManage.deleteUser("Doedel");
		ArrayList<RegisteredUser> testliste = 	usrManage.loadListe();
		System.out.println(testliste.size());
		if(testliste.size()!= 0)
		{
		//System.out.println("Vorname: " + testliste.get(0).getForename() + " Nachname: "
			//	+ testliste.get(0).getSurname() + " UserId: " + testliste.get(0).getUserId()+  "  nach loeschen");
		//System.out.println("Vorname: " + testliste.get(1).getForename() + " Nachname: "
		//		+ testliste.get(1).getSurname() + " UserId: " + testliste.get(1).getUserId()+  "  nach loeschen");
	for (int i = 0 ; i < testliste.size();i++)
		{
			System.out.println("Vorname: " + testliste.get(i).getForename() + " Nachname: "
					+ testliste.get(i).getSurname() + " UserId: " + testliste.get(i).getUserId()+  "  nach loeschen");

		}
		} */
	}

}
