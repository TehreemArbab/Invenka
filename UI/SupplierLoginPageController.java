package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class SupplierLoginPageController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField SupplierName;

    @FXML
    private PasswordField SupplierPassword;

    @FXML
    private TextField Supplierid;

    @FXML
    private Button backButton;

    @FXML
    private Label info;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }


    @FXML
    void CheckSupplierPassword(ActionEvent event) throws IOException {
        	Main m = new Main();
        	if(Supplierid.getText().isEmpty() || SupplierPassword.getText().isEmpty() || 
        			SupplierName.getText().isEmpty())

        	{
        		info.setText("Enter Data in all fields");
        	}
        	else {
        		int Id = Integer.parseInt(Supplierid.getText());
        		if(m.getBLController1().EnterIDAndPassword(Id, SupplierName.getText(), SupplierPassword.getText())) {
        			//if supplier verifies we will go to this page so change it accordingly
        			m.changeScene("SupplierAllFunctionsPage.fxml");
        			
        		} else {
            		info.setText("Wrong credentials entered!");
        			
        		}
        		
        	
        	}
        	
        }
    }

