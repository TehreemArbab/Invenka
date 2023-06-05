package ui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class AdminHomeController {

		    @FXML
		    private Button duebtn;

		    @FXML
		    private Button makeOrderButton;

		    @FXML
		    private Button recentbutton;

		    @FXML
		    private Button trackbtn;

		    @FXML
		    void MakeOrder(ActionEvent event) throws IOException {
		    	Main m=new Main();
		    	m.changeScene("MakeOrder.fxml");
		    }

		    @FXML
		    void ShowRecentOrders(ActionEvent event) throws IOException {
		    	Main m=new Main();
		    	m.changeScene("RecentOrders.fxml");
		    }

		    @FXML
		    void orderTracking(ActionEvent event) throws IOException {
		    	Main m=new Main();
		    	m.changeScene("OrderTracking.fxml");
		    }

		    @FXML
		    void showDueOrders(ActionEvent event) {

		    }


}
