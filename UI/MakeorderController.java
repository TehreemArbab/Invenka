package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class MakeorderController {

    @FXML
    private TextField Location;

    @FXML
    private TextField OrderDate;

    @FXML
    private TextField itemid;

    @FXML
    private TextField itemname;

    @FXML
    private TextField itemprice;

    @FXML
    private TextField itemquantity;

    @FXML
    private Button makeorderbtn;

    @FXML
    private Button showOrderbtn;


    @FXML
    private TextField supplierid;
    
    @FXML
    private Label info;
    
    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("OrderRelevantFn.fxml");
		
	
    }

    @FXML
    void MakeOrder(ActionEvent event) {
    	Main m=new Main();
    	if(supplierid.getText().isEmpty() || itemid.getText().isEmpty()|| itemname.getText().isEmpty() || 
    		itemquantity.getText().isEmpty() || itemprice.getText().isEmpty() || Location.getText().isEmpty() ||
    		OrderDate.getText().isEmpty() )

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		int sID=Integer.parseInt(supplierid.getText());
    		int ItID= Integer.parseInt(itemid.getText());
    		int qtn= Integer.parseInt(itemquantity.getText());
    		double pr= Double.parseDouble(itemprice.getText());
    		m.getBLController().MakeOrder(sID, ItID, itemname.getText(), qtn, pr, OrderDate.getText(), Location.getText());
    		try {
				m.changeScene("AdminHome.fxml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    }



