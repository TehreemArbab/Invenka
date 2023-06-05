package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class OwnerLoginPageController {

    @FXML
    private Button BackButton;

    @FXML
    private Button Login;

    @FXML
    private TextField idtext;

    @FXML
    private Label incaseerror;

    @FXML
    private PasswordField passwordtext;


    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }

    @FXML
    void LoginOwner(ActionEvent event) throws IOException {

    	Main m=new Main();
    	if(idtext.getText().isEmpty() || passwordtext.getText().isEmpty()) {
    		incaseerror.setText("Enter Data in all fields");
    	}
     		  	
    	else {	//if all is well
			int id = Integer.parseInt(idtext.getText());
			String password = passwordtext.getText();
			boolean answer = m.getBLController2().LoginOwner(id, password);
				if (answer == true) {
			    	m.changeScene("OwnerAllFunctionsPage.fxml");
					//incaseerror.setText("Owner Is Okay");
				}
				else if (answer == false) {
					incaseerror.setText("Owner Does Not Match Records");
				}    	
    	}
    }
}