package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OrderRelevantFnController {

    @FXML
    private Button MakeOrder;

    @FXML
    private Button back;

    @FXML
    private Button showorder;
    
    @FXML
    private Button checkrecent;

    @FXML
    private Button logout;

    @FXML
    private Button trackorder;

    @FXML
    void LogOutFunction(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }

    @FXML
    void SendBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("AdminAllFunctionsPage.fxml");
    }

    @FXML
    void SendToCheckRecent(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("RecentOrders.fxml");
    }
	//gotta separate these;ShowOrders

    @FXML
    void SendToShowOrder(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("ShowOrders.fxml");
    }
    
    @FXML
    void SendToMakeOrder(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("MakeOrder.fxml");
    }

    @FXML
    void SendToTrackOrder(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("OrderTracking.fxml");
    }
}
