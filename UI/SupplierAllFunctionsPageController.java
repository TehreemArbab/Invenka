package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SupplierAllFunctionsPageController {

    @FXML
    private Button ShowDueOrders;

    @FXML
    private Button logout;

    @FXML
    void DisplayShowDueOrders(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("ShowDueOrdersSupplier.fxml");
    }

    @FXML
    void LogOutFunction(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }

}