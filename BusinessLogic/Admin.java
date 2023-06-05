package businesslogic;

import java.util.*;

import db.DBHandler;
public class Admin {

	private int adminID; 
	private String adminPassword;
	ArrayList<Item> itemsArray = new ArrayList<Item>();
	ArrayList<Order> ordersArray= new ArrayList<Order>();
	ArrayList<OrderTracking> trackorderArray= new ArrayList<OrderTracking>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	public int rate=0;
	
	//to control CRUD Functions;
	private DBHandler db;

	public Admin() {
		db = new DBHandler();
	}
   //order functionality 
	public void MakeOrder(int supplierid, int itemid, String Itemname, int quantity, double price, String OrderDate, String Location) {
		Order o = new Order(supplierid, itemid, Itemname, quantity, price,OrderDate, Location);
		db.MakeOrder(o);
	}

	public void EnterOrderInformation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	public void Add(int id, String name, double price) {
		Item i = new Item(id, name, price);
		
		db.AddItem(i);
	}
	public void AddToSupplier(int id, String Suppliername, String Contact, String Address, String pass) {
		Supplier s= new Supplier (id, Suppliername, Contact, Address, pass);
		db.AddSupplier(s);
	}
	public boolean Update(int id, String newname, double newPrice) {
		return db.updateItem(id, newname,newPrice);
	}
	public boolean UpdateSupplier(int id, String name, String contact, String address, String password) {
		// TODO Auto-generated method stub
		return db.updateSupplier(id, name,contact, address, password);
	}
	
	public boolean Delete(int id) {
		return db.deleteItem(id);
	}

	public boolean DeleteSupplier(int id) {
		return db.deleteSupplierFromDB(id);
	}
	
	public boolean LoginAdmin(int id, String passwrd) {
		boolean temp;
		temp = db.AdminLoginFn(id,passwrd);
		if (temp==true) {
			this.setAdminID(id);
			this.setAdminPassword(passwrd);
		}
		else
			if (temp == false) {
			}
		return temp; 
		
	}
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
			
	public ArrayList<Item> ViewItems() {
	
		return db.readItems();

	}
	
	public ArrayList<Rate> ViewRates() {
		
		return db.readRates();

	}
	
	public ArrayList<Supplier> ViewSupplier() {
		
		return db.readSupplier();
	}
	
	public ArrayList<Order> ViewOrder() {
	
		return db.readOrders();

	}
	public ArrayList<OrderTracking> OrderTracking(int id) {
		return db.TrackOrder(id);
	
	}
	public ArrayList<Order> RecentOrder(String date) {
		return db.RecentOrders(date);
	
	}
	public void AddNewItem() {

	}

	public void UpdateItem() {
	}

	public void DeleteItem() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void RetrieveItem() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void SearchItem() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void EnterItemID() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void ManageReturns() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	

	public int CheckConsumptionRate(int id, String startDate, String endDate) {
		
		rate=db.CheckConsumptionRate(id, startDate, endDate);
		return rate;
	}
	
	public double EstimatedBudget(int id) {
		// begin-user-code
		// TODO Auto-generated method stub
		return db.EstimatedBudget(id, rate);
		// end-user-code
	}

	public void GenerateInventoryReport() {
		// begin-user-code
		// TODO Auto-generated method stub
		db.GenerateInventoryReport();
		// end-user-code
	}

	public void AddNewSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void UpdateSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void DeleteSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void RetrieveSupplier() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	


	public void ShowRecentOrders() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}



	public void ControlStorage() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void CheckDueOrders() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void ForecastInventory() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	
}