package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Order;
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

public class ShowDueOrderSuppliersController {

    @FXML
    private TableView<Order> Itemtable;

    @FXML
    private TableColumn<Order, Integer> Quantitycol;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Order, String> datecol;

    @FXML
    private Label info;

    @FXML
    private TableColumn<Order, String> namecol;

    @FXML
    private Button viewButton;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("SupplierAllFunctionsPage.fxml");
    }

    @FXML
    void ViewDueOrders(ActionEvent event) {
    	Main m = new Main();
		ArrayList<Order> stu = m.getBLController1().ViewDueOrders();

		if (stu.isEmpty()) {
			info.setText("No suppliers registered");
		}

		else {
			final ObservableList<Order> data = FXCollections.observableArrayList(stu);
			
			
			
		
			namecol.setCellValueFactory(new PropertyValueFactory<Order, String>("OrderName"));
			datecol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDates"));
			Quantitycol.setCellValueFactory(new PropertyValueFactory<Order,Integer>("quantity"));
			


			Itemtable.setItems(data);
		}

    }

}
