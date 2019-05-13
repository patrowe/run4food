package Profil;

import java.io.Serializable;

abstract class User implements Serializable {
	private String surname;
	private String forename;
	private int height;
	
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}

	
	public void setSurname(String sname) {
		this.surname = sname;
	}
	
	public String getSurname() {
		return this.surname;
	}


	public void setForename(String vname) {
		this.forename = vname;
	}
	
	public String getForename() {
		return this.forename;
	}
	
	
}
