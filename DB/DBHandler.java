package db;

import java.util.ArrayList;

import businesslogic.*;
import ui.Connection;
import ui.ResultSet;
import ui.SQLException;
import ui.Statement;

import java.sql.*;

public class DBHandler {
	private String username = "root";
	private String pass = "raheimeen";
	Connection con; // connection object
	Integer consumprate[]= {0,0,0,0,0,0,0,0,0,0};
	
	public DBHandler() { // default constructor

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Invenka", username, pass);
			System.out.println("Connection made to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

	}

	public ArrayList<Item> readItems() {

		ArrayList<Item> items = new ArrayList<Item>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT *FROM Item";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Item i = new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				items.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	public ArrayList<Rate> readRates() {

		ArrayList<Rate> rates = new ArrayList<Rate>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT *FROM rate";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Rate i = new Rate(rs.getInt(1), rs.getInt(2));
				rates.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rates;
	}	
	
	
	public ArrayList<Supplier> readSupplier() {
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT *FROM Supplier";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Supplier s = new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				suppliers.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suppliers;
	}
	public ArrayList<Order> ViewDueOrders() {
		ArrayList<Order> orderstack = new ArrayList<Order>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT itemOrders.itemName, itemOrders.orderDate, itemOrders.quantity "
					+ "FROM itemOrders INNER JOIN Supplier ON itemOrders.SupplierID = Supplier.ID"
					+ " INNER JOIN OrderStatus ON itemOrders.itemID = OrderStatus.OrderID "
					+ "WHERE OrderStatus.OrderStatus = 'Not Arrived'";
			
			
			
			ResultSet rs = stm.executeQuery(query);
			
			
			while (rs.next()) {
				Order o = new Order();
				o.setOrderName(rs.getString(1));
				o.setOrderDates(rs.getString(2));
				o.setQuantity(rs.getInt(3));
				orderstack.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderstack;
	}

	
	/*public void saveItem(Item i) {
		try {
			String query = "INSERT INTO student (idstudent, firstname,lastname) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, i.getItemID());
			stmt.setString(2, i.getItemName());
			stmt.setDouble(3, i.getItemPrice());

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("An Item was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
	public void MakeOrder(Order o) {
		try {
			String query = "INSERT INTO itemOrders (SupplierID,itemID,itemName,quantity,price, orderDate,location) "
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, o.getSupplierOrderedFromID());
			stmt.setInt(2, o.getOrderID());
			stmt.setString(3, o.getItemName());
			stmt.setInt(4, o.getQuantity());
			stmt.setDouble(5, o.getPrice());
			stmt.setString(6, o.getDate());
			stmt.setString(7, o.getLoc());
			

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("An Order was Placed.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Order> readOrders() {

		ArrayList<Order> orders = new ArrayList<Order>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT *FROM itemOrders";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Order o = new Order(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDouble(5), 
						rs.getString(6),  rs.getString(7));
				orders.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}	
	
	public ArrayList<OrderTracking> TrackOrder(int id) {
		
		ArrayList<OrderTracking> orderstrack = new ArrayList<OrderTracking>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT OrderID,Departure,Arrival,DATEDIFF(arrival, departure)  "
					+ "FROM OrderStatus WHERE OrderID = " + id; 
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				OrderTracking ot = new OrderTracking(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4));
				orderstrack.add(ot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderstrack;
	}
	
	public ArrayList<Order> RecentOrders(String date) {
		
		ArrayList<Order> orderstack = new ArrayList<Order>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT distinct OrderStatus.OrderID, itemOrders.itemName, itemOrders.quantity, itemOrders.orderDate, OrderStatus.OrderStatus FROM itemOrders INNER JOIN OrderStatus ON "
					+ "itemOrders.orderDate = OrderStatus.Departure And itemOrders.itemID = OrderStatus.OrderID "
					+ "WHERE itemOrders.orderDate  > '" + date +"'";
			
			
			
			ResultSet rs = stm.executeQuery(query);
			
			
			while (rs.next()) {
				Order o = new Order();
				o.setOrderID(rs.getInt(1));
				o.setOrderName(rs.getString(2));
				o.setQuantity(rs.getInt(3));
				o.setOrderDates(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				orderstack.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderstack;
	}	
		
	
	public void AddItem(Item i) {
		try {
			String query = "INSERT INTO Item (ID, Name,Price) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, i.getItemID());
			stmt.setString(2, i.getItemName());
			stmt.setDouble(3, i.getItemPrice());

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("An Item was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void AddSupplier(Supplier s) {
		try {
			String query = "INSERT INTO Supplier (ID, Name,Contact, Address, Password) VALUES (?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, s.getSuppliertID());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getContactNo());
			stmt.setString(4, s.getAddress());
			stmt.setString(5, s.getSupplierPassword());

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("A Supplier was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	
	public boolean updateItem(int id, String fname, double Price) {
		String query = "UPDATE Item SET Name=?, Price=? WHERE ID=?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setDouble(2, Price);
			ps.setInt(3, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("An Item was updated...");
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public boolean updateSupplier(int id, String name, String contact, String address, String password) {
		String query = "UPDATE Supplier SET Name=?, Contact=?, Address=?, Password=? WHERE ID=?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setString(3, address);

			ps.setString(4, password);
			ps.setInt(5, id);


			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Supplier was updated...");
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean deleteItem(int id) {
		String query = "DELETE FROM Item WHERE ID=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("An item was deleted..");
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//it is giving error because PK is used as FK in other Tables
	public boolean deleteSupplierFromDB(int id) {
		String query = "DELETE FROM Supplier WHERE ID=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("A Supplier was deleted..");
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int CheckConsumptionRate(int id, String startDate, String endDate) {
		ResultSet startqty;
		ResultSet endqty;
		int quantityof1=0;
		int quantityof2=0;
		int rate = 0;
		
		try {
			String query = "SELECT Quantity FROM Weeks WHERE ID= ? AND weekdate= ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, startDate);

			startqty = stmt.executeQuery();
			
			while(startqty.next()) {
				String quantity1 = startqty.getString(1);
				quantityof1= Integer.parseInt(quantity1);
			}
			
			String query2 = "SELECT Quantity FROM Weeks WHERE ID= ? AND weekdate= ?";
			PreparedStatement stmt2 = con.prepareStatement(query2);
			stmt2.setInt(1, id);
			stmt2.setString(2, endDate);

			endqty = stmt2.executeQuery();
			
			while(endqty.next()) {
				String quantity2 = endqty.getString(1);
				quantityof2= Integer.parseInt(quantity2);
			}
			rate = (quantityof1 - quantityof2);
			consumprate[id]=rate;
			System.out.println("Consumption Rate= " + (quantityof1-quantityof2) );
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			String query = "INSERT INTO rate (ID, Rate) VALUES (?,?)";
			PreparedStatement stmt;
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setInt(2, rate);
			
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("rate updated...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rate;
	}
	
	public double EstimatedBudget(int id, int rate) {
		double budget=0;
		double quantityof1=0;
		
		try {
		String query = "SELECT Price FROM Item WHERE ID= ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet startqty = stmt.executeQuery();
		
			while(startqty.next()) {
				String quantity1 = startqty.getString(1);
				quantityof1= Double.parseDouble(quantity1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		budget= (rate*quantityof1);
		System.out.println("Budget for itemid= " + id + " is: " + budget );
		return budget;
	}
	
	public void GenerateInventoryReport() {
	/*	//view all items [view items];check
	 	//take join of 3 table make 1 query and run it 
		//calls consumption rate for all items [checkconsumptionrate make array and update prev function:estimate budget wala]
		//sold items from orders placed [order tracking]
		ArrayList<Item> items = new ArrayList<Item>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT *FROM Item";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Item i = new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				items.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Item> tempitem = new ArrayList<Item>(); 
		for (int x = 1; x < 10; x++) {
			
			tempitem.c_rate = consumprate[x];
		}*/
			
	}

	public boolean AdminLoginFn(int id,String passwrd) {
		int adminid;
		String adminpswrd;
		String temp;
		boolean giveback = false;
		
		Statement stm;
		try {
			stm = con.createStatement();


			String query = "SELECT *FROM Admin";
			ResultSet ret = stm.executeQuery(query);
				//	ResultSet ret=stm.executeQuery("SELECT * FROM Admin");
					
				
					while(ret.next()) {

						temp = ret.getString(1);
						adminid	=Integer.parseInt(temp);	//do parse to int thing
						adminpswrd=ret.getString(2);
						//AUTHENTICATION
						if((adminid== id)&&(adminpswrd.equals(passwrd))) {
							giveback= true;
						}
						else {
							giveback= false;
						}
						}
					}
		catch (Exception e) {
			System.out.println(e);
		}
		return giveback;
	}
	
	public boolean OwnerLoginFn(int id,String passwrd) {
		int ownerid;
		String ownerpswrd;
		String temp;
		boolean giveback = false;
		
		Statement stm;
		try {
			stm = con.createStatement();


			String query = "SELECT *FROM Owner";
			ResultSet ret = stm.executeQuery(query);
					
					
					while(ret.next()) {

						temp = ret.getString(1);
						ownerid	=Integer.parseInt(temp);	//do parse to int thing
						ownerpswrd=ret.getString(2);
						//AUTHENTICATION
						if((ownerid== id)&&(ownerpswrd.equals(passwrd))) {
							giveback= true;
						}
						else {
							giveback= false;
						}
						}
					}
		catch (Exception e) {
			System.out.println(e);
		}
		return giveback;
	}	
			//authenticates supplier--login supplier
	public boolean authenticate(int id, String username, String password) {
        boolean isCredentialsCorrect = false;
	Statement stm;
	
	try {
		stm = con.createStatement();
		String query = "SELECT ID FROM Supplier WHERE ID = "+id+" AND "
				+ " Name = '"+username+"' AND Password = '" + password +"' ";
		
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()) {
			isCredentialsCorrect = true;
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return isCredentialsCorrect;
	
}		
	
	public void closeConnection() {
		try {

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	
	
	

	
}
