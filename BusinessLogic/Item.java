
package businesslogic;
import java.util.*;

import com.mysql.cj.conf.StringProperty;

public class Item {
			//Variables
		private int itemID;
		private String itemName;
		private double itemPrice;
		//Integer c_rate[]= {0,0,0,0,0,0,0,0,0,0};
		//int c_rate=0;
		
		
		public Item(int item, String name, double price) {
			
			this.itemID= item;
			this.itemName= name;
			this.itemPrice= price;
		}
		public Item() {
			// TODO Auto-generated constructor stub
		}
		
	
		
		public String getItemName() {
			return itemName;
		}
		public double getItemPrice() {
			return itemPrice;
		}
		public int getItemID() {
			return itemID;
		}
		public void setItemName(String name) {
			this.itemName= name;
		}
		public void setItemID(int ID) {
			this.itemID=ID;
		}
		public void setItemPrice(double price) {
			this.itemPrice= price;
	}
		//*********************NOTE: it isn't necessary that any of these functions have to be void; you should change that in accordance to your
		// requirement; thankments!
		public String toString() {
			return "Item [ItemID=" + itemID + ",ItemName=" + itemName  + ", ItemPrice=" + itemPrice + "]";
		}
		
		public void EnterItemInformation() {

		}

		public void EnterUpdatedInfo() {
		}

		public void RecordItem() {
		}

		public void RemoveItem() {

		}

		public void SearchItem() {

		}


		public void UpdateItem() {
		}

		public void CalculateConsumptionRate() {
		}


		public void RetrieveAvailableItems() {
		}


		public void RetrieveItemsSold() {
		}

		
		public void LogOrder() {
		}


		public void CalculateBudgetAndQuantity() {
		}

		
		public void ForecastInventory() {
		}
		
	}

