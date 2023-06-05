package businesslogic;

import db.DBHandler;

public class BusinessOwner {

	private int ownerIDint;
	private String ownerPassword;
	private DBHandler db;
		
	public int getOwnerIDint() {
		return ownerIDint;
	}
	public void setOwnerIDint(int ownerIDint) {
		this.ownerIDint = ownerIDint;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	public BusinessOwner() {
		db = new DBHandler();
	}
	
	public boolean LoginOwner(int id, String passwrd) {
		boolean temp;
		temp = db.OwnerLoginFn(id,passwrd);
		if (temp==true) {
			this.setOwnerIDint(id);
			this.setOwnerPassword(passwrd);
		}
		else
			if (temp == false) {
			}
		return temp; 
		
	}
}


