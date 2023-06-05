package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SupplierCRUDController {

    @FXML
    private Button AddButton;

    @FXML
    private Label additem;

    @FXML
    private Button deleteButton;

    @FXML
    private Label info;

    @FXML
    private Button updateButton;

    @FXML
    private Button viewButton;

    @FXML
    void AddSupplier(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("AddSupplier.fxml");
    }

    @FXML
    
    void DeleteSupplier(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("DeleteSupplier.fxml");
    }

    @FXML
    void UpdateSupplier(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("UpdateSupplier.fxml");
    }

    @FXML
    void ViewSupplier(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("ViewSupplier.fxml");
    }

}
