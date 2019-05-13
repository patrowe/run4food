package Profil;

import java.io.Serializable;

public class RegisteredUser extends User implements Serializable {
	
	private int userid;
	
	public void setuserid(int id) {
		this.userid = id;
	}
	
	public int getUserId() {
		return this.userid;
	}

}
