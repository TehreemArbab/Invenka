package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteSupplierController {

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label info;

    @FXML
    private TextField supplierid;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("SupplierCRUDhomeScreen.fxml");
    }

    @FXML
    void DeleteSupplier(ActionEvent event) {
    	Main m = new Main();
    	if (supplierid.getText().isEmpty())

		{
			info.setText("Enter Data in all fields");
		} else {
			int id = Integer.parseInt(supplierid.getText());
			boolean res = m.getBLController().DeleteSupplier(id);
			if (res) {
				info.setText("item deleted successfully");
			} else {
				info.setText("item not found");

			}
		}
    }
    }


