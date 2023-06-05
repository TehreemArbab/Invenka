package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Order;
import businesslogic.OrderTracking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecentOrdersController {

    @FXML
    private TableView<Order> RecentOrders;

    @FXML
    private TableColumn<Order, String> arrivalcol;

    @FXML
    private Button backButton;

    @FXML
    private Label info;

    @FXML
    private TextField month;

    @FXML
    private TableColumn<Order, String> namecol;

    @FXML
    private TableColumn<Order, Integer> ordercol;

    @FXML
    private TableColumn<Order, Integer> quantitycol;

    @FXML
    private Button recentButton;

    @FXML
    private TableColumn<Order, String> statuscol;

    @FXML
    void Back(ActionEvent event) throws IOException {
     	Main m = new Main();
    	m.changeScene("OrderRelevantFn.fxml");
    	//was going to AdminHome.fxml
    }

    @FXML
    void RecentOrders(ActionEvent event) {
    	Main m = new Main();
    	String recent =month.getText();
    	
		ArrayList<Order> stu = m.getBLController().RecentOrder(recent);

		if (stu.isEmpty()) {
			info.setText("No Recent orders in this month");
		}

		else {
			final ObservableList<Order> data = FXCollections.observableArrayList(stu);

			
			ordercol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderID"));
			namecol.setCellValueFactory(new PropertyValueFactory<Order, String>("OrderName"));
			quantitycol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
			arrivalcol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDates"));
		    statuscol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderStatus"));
			

			RecentOrders.setItems(data);
		}
    }
    }

