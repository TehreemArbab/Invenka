package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartOfProgramController {

    @FXML
    private Button Admin1;

    @FXML
    private Button Owner1;

    @FXML
    private Button Supplier1;

    @FXML
    void LoginAdmin(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("AdminLoginPage.fxml");
    }


    @FXML
    void LoginOwner(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("OwnerLoginPage.fxml");
    }


    @FXML
    void LoginSupplier(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("SupplierLoginPage.fxml");
    }

    
}
