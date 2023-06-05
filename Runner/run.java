package Runner;
import java.util.ArrayList;

import businesslogic.*;
import db.*;
public class run {

	public static void main(String[] args) {
		DBHandler db = new DBHandler();
ArrayList<Item> studentdata = db.readItems();
		
		for(Item std: studentdata) {
			System.out.println(std.toString());
		}

	}

}
