package ui;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.event.ActionEvent;
public class RegisterController {


    @FXML
    private Button Back1;
    
    @FXML
    private TextField itemid;

    @FXML
    private TextField itemname;

    @FXML
    private Button regButton;

    @FXML
    private TextField itemprice;
    @FXML
    private Label info;
    
    @FXML
    void Add(ActionEvent event) {
    	Main m=new Main();
    	if(itemid.getText().isEmpty() || itemname.getText().isEmpty()||itemprice.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		int roll=Integer.parseInt(itemid.getText());
    		double pr= Double.parseDouble(itemprice.getText());
    		m.getBLController().Add(roll, itemname.getText(), pr);
    		info.setText("Item Added");
    //		m.changeScene("HomeScreen.fxml");
    	}
    }
    

    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("HomeScreen.fxml");

    } 
}
