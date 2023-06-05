package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddSupplierController {

    @FXML
    private Button addButton;

    @FXML
    private TextField address;

    @FXML
    private TextField contact;

    @FXML
    private Label info;

    @FXML
    private Button Back;
        
    @FXML
    private TextField itemid;

    @FXML
    private TextField pass;
    
    @FXML
    private TextField suppliername;

    @FXML
    void AddSupplier(ActionEvent event) {
    	Main m=new Main();
    	if(itemid.getText().isEmpty() || suppliername.getText().isEmpty()||contact.getText().isEmpty()
    		|| address.getText().isEmpty()	|| pass.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		int roll=Integer.parseInt(itemid.getText());
    		
    		m.getBLController().AddToSupplier(roll, suppliername.getText(), contact.getText(), address.getText(), pass.getText());
    		//m.changeScene("SupplierCRUDhomeScreen.fxml");
    		info.setText("Supplier Added");
    	}
    }
    
    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("SupplierCRUDhomeScreen.fxml");
    
    	}
    }
    
  


