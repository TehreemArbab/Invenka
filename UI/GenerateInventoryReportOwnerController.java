
package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
import businesslogic.Order;
import businesslogic.Rate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class GenerateInventoryReportOwnerController {


    @FXML
    private TableView<Order> Itemtable;

    @FXML
    private TableView<Item> Itemtable1;

    @FXML
    private TableView<Rate> Itemtable2;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Rate, Integer> idConsumption;

    @FXML
    private TableColumn<Order, Integer> idSold;

    @FXML
    private TableColumn<Item, Integer> idcol1;

    @FXML
    private TableColumn<Order, String>  nameSold;

    @FXML
    private TableColumn<Item, String>  namecol1;

    @FXML
    private TableColumn<Item, Double>  pricecol1;

    @FXML
    private TableColumn<Rate, Integer> ratecol;

    @FXML
    private Button viewButton;


	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("OwnerAllFunctionsPage.fxml");
	}
	@FXML
	void View(ActionEvent event) {
		Main m = new Main();
		ArrayList<Item> stu = m.getBLController().ViewItems();
		ArrayList<Order> fdv = m.getBLController().ViewOrder();
		ArrayList<Rate> rat = m.getBLController().ViewRates();
		
		if (stu.isEmpty()) {
			//info.setText("No items registered");
		}

		else {
			final ObservableList<Item> data = FXCollections.observableArrayList(stu);

			
			idcol1.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
			namecol1.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
			pricecol1.setCellValueFactory(new PropertyValueFactory<Item, Double>("itemPrice"));

			Itemtable1.setItems(data);
		}

		if (fdv.isEmpty()) {
			//info.setText("No orders registered");
		}

		else {
			final ObservableList<Order> data2 = FXCollections.observableArrayList(fdv);

			
			idSold.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderID"));
			
			nameSold.setCellValueFactory(new PropertyValueFactory<Order, String>("OrderName"));
			Itemtable.setItems(data2);
		}
		
		if (rat.isEmpty()) {
			//info.setText("No items registered");
		}

		else {
			final ObservableList<Rate> data3 = FXCollections.observableArrayList(rat);

			
			idConsumption.setCellValueFactory(new PropertyValueFactory<Rate, Integer>("itemID"));
			ratecol.setCellValueFactory(new PropertyValueFactory<Rate, Integer>("rate"));

			Itemtable2.setItems(data3);
		}
	}

}
