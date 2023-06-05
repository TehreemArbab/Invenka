package businesslogic;

import java.util.*;

public class Order {
	
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public OrderTracking getOrderTracking() {
		return OrderTracking;
	}

	public void setOrderTracking(OrderTracking orderTracking) {
		OrderTracking = orderTracking;
	}

	public void setPrice(double price) {
		Price = price;
	}

	//DefectiveOrder D_order = new DefectiveOrder();
	private int orderID;
	private String orderStatus;
	private String orderDates;
	private String OrderName;
	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	private int quantity;
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private double Price;
	private String loc;
	Item itemOrdered = new Item();
	private int SupplierOrderedFromID;
	private Set<Item> Item;
	public OrderTracking OrderTracking;
	
	public Order(int supplierid, int itemid, String itemname, int quantity, double price, String orderDate,
			String location) {
		this.SupplierOrderedFromID = supplierid;
		this.orderID = itemid;
		this.OrderName= itemname;
		this.quantity= quantity;
		this.Price= price;
		this.orderDates= orderDate;
		this.loc= location;
		
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return Price;
	}

	public String getDate() {
		return orderDates;
	}
	public String getItemName() {
		return OrderName;
	}
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDates() {
		return orderDates;
	}

	public void setOrderDates(String orderDates) {
		this.orderDates = orderDates;
	}

	public Item getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(Item itemOrdered) {
		this.itemOrdered = itemOrdered;
	}

	public int getSupplierOrderedFromID() {
		return SupplierOrderedFromID;
	}

	public void setSupplierOrderedFromID(int supplierOrderedFromID) {
		SupplierOrderedFromID = supplierOrderedFromID;
	}

	public Set<Item> getItem() {
		return Item;
	}

	public void setItem(Set<Item> item) {
		Item = item;
	}



	

	

	public void RecordOrder() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void ShowRecentOrders() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	
}