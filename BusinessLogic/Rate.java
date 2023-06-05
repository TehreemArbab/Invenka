package businesslogic;

public class Rate {
	private int itemID;
	private int rate;
	
	public Rate(int itemid, int r) {
		this.itemID= itemid;
		this.rate= r;
	}
	
	public Rate() {
		// TODO Auto-generated constructor stub
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
