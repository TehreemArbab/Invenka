package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
import businesslogic.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewSupplierController {

    @FXML
    private TableView<Supplier> Itemtable;

    @FXML
    private TableColumn<Supplier, String> addresscol;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Supplier, String> contactcol;

    @FXML
    private TableColumn<Supplier, Integer> idcol;

    @FXML
    private Label info;

    @FXML
    private TableColumn<Supplier, String> namecol;

    @FXML
    private Button viewButton;

    @FXML
    void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("SupplierCRUDhomeScreen.fxml");		//this was missing in Harmain's version
    }

    @FXML
    void ViewSuppliers(ActionEvent event) {
    	Main m = new Main();
		ArrayList<Supplier> stu = m.getBLController().ViewSupplier();

		if (stu.isEmpty()) {
			info.setText("No suppliers registered");
		}

		else {
			final ObservableList<Supplier> data = FXCollections.observableArrayList(stu);
			
			
			
			idcol.setCellValueFactory(new PropertyValueFactory<Supplier, Integer>("suppliertID"));
			namecol.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
			contactcol.setCellValueFactory(new PropertyValueFactory<Supplier, String>("contactNo"));
			addresscol.setCellValueFactory(new PropertyValueFactory<Supplier, String>("address"));
			


			Itemtable.setItems(data);
		}

	}
    

}
