package businesslogic;

import java.util.ArrayList;

import db.DBHandler;

public class Supplier {

	private int suppliertID;

	private String supplierPassword;

	private String name;

	private String address;

	private String contactNo;
	ArrayList<Order> ordersArray= new ArrayList<Order>();
	
	public Supplier(int suppliertID,String name,String contactNo, String address,String supplierPassword) {
		super();
		this.suppliertID = suppliertID;
		this.supplierPassword = supplierPassword;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
	}
	private DBHandler db;

	public Supplier() {
		db = new DBHandler();
	}
public ArrayList<Order> ViewDueOrders() {
		
		return db.ViewDueOrders();
	}
	public int getSuppliertID() {
		return suppliertID;
	}
	public void setSuppliertID(int suppliertID) {
		this.suppliertID = suppliertID;
	}
	public String getSupplierPassword() {
		return supplierPassword;
	}
	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public boolean EnterIDAndPassword(int id, String Name, String pass) {
		// TODO Auto-generated method stub
		return db.authenticate(id, Name, pass);
	}

    public int getsupplierID() {
    	return suppliertID;
    }
	public void ProcesOrder() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void EnterSupplierInformation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void RecordSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void UpdateSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void SearchSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void RemoveSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void EnterOrderInformation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	
}