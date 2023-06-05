package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
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

public class OrderTrackingController {

    @FXML
    private TableView<OrderTracking> Orderstatus;

    @FXML
    private TableColumn<OrderTracking, String> arrivalcol;

    @FXML
    private Button backButton;
    
   // @FXML
   // private TableColumn<OrderTracking, Integer> inclusivecol;

    @FXML
    private TableColumn<OrderTracking, Integer> delivery;

    @FXML
    private TableColumn<OrderTracking, String> deptcol;

    @FXML
    private Label info;

    @FXML
    private TableColumn<OrderTracking, Integer> ordercol;

    @FXML
    private TextField orderid;

    @FXML
    private Button trackButton;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("OrderRelevantFn.fxml");
		//was going to AdminHome.fxml
    }

    @FXML
    void TrackOrder(ActionEvent event) {
    	Main m = new Main();
    	int id = Integer.parseInt(orderid.getText());
		ArrayList<OrderTracking> stu = m.getBLController().OrderTracking(id);

		if (stu.isEmpty()) {
			info.setText("No orders");
		}

		else {
			final ObservableList<OrderTracking> data = FXCollections.observableArrayList(stu);

			
			ordercol.setCellValueFactory(new PropertyValueFactory<OrderTracking, Integer>("id"));
			deptcol.setCellValueFactory(new PropertyValueFactory<OrderTracking, String>("departure"));
			arrivalcol.setCellValueFactory(new PropertyValueFactory<OrderTracking, String>("Arrival"));
			delivery.setCellValueFactory(new PropertyValueFactory<OrderTracking, Integer>("TotalDays"));
		//	inclusivecol.setCellValueFactory(new PropertyValueFactory<OrderTracking, Integer>("inc"));
			

			Orderstatus.setItems(data);
		}
    }

}
