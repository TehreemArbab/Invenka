package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateSupplierController {

    @FXML
    private TextField address;

    @FXML
    private Button backButton;

    @FXML
    private TextField contact;

    @FXML
    private TextField id;

    @FXML
    private Label info;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private Button updateButton;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("SupplierCRUDhomeScreen.fxml");
    }

    @FXML
    void UpdateSupplier(ActionEvent event) {
Main m = new Main();
		
		if (id.getText().isEmpty() || name.getText().isEmpty() || contact.getText().isEmpty()
				|| address.getText().isEmpty() || password.getText().isEmpty())

		{
			info.setText("Enter Data in all fields");
		} else {
			int Id = Integer.parseInt(id.getText());
			
			boolean res = m.getBLController().UpdateSupplier(Id, name.getText(), contact.getText(), address.getText(),
					password.getText());
			if (res) {
				info.setText("Item updated successfully");
			} else {
				info.setText("Item not updated");

			}
		}
    }

}
