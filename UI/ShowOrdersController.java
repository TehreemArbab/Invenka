package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
import businesslogic.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowOrdersController {

    @FXML
    private TableView<Order> ordertable;

    @FXML
    private Button ShowButton;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Order, String> datecol;

    @FXML
    private Label info;

    @FXML
    private TableColumn<Order, Integer> itemcol;

    @FXML
    private TableColumn<Order, String> loccol;

    @FXML
    private TableColumn<Order, String> namecol;

    @FXML
    private TableColumn<Order, Double> pricecol;

    @FXML
    private TableColumn<Order, Integer> quantitycol;

    @FXML
    private TableColumn<Order, Integer> s_col;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("OrderRelevantFn.fxml");
    }

    @FXML
    void ShowOrder(ActionEvent event) {
    	Main m = new Main();
		ArrayList<Order> stu = m.getBLController().ViewOrder();

		if (stu.isEmpty()) {
			info.setText("No orders registered");
		}

		else {
			final ObservableList<Order> data = FXCollections.observableArrayList(stu);

			
			s_col.setCellValueFactory(new PropertyValueFactory<Order, Integer>("SupplierOrderedFromID"));
			itemcol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderID"));
			
			namecol.setCellValueFactory(new PropertyValueFactory<Order, String>("OrderName"));
			quantitycol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
			
			pricecol.setCellValueFactory(new PropertyValueFactory<Order, Double>("Price"));
			datecol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDates"));
			
			loccol.setCellValueFactory(new PropertyValueFactory<Order, String>("loc"));

			ordertable.setItems(data);
		}
    }

}

