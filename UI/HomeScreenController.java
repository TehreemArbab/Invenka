package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HomeScreenController {

    @FXML
    private Button deleteButton;

    @FXML
    private Button Back;

    @FXML
    private Label info;

    @FXML
    private Button updateButton;

    @FXML
    private Button viewButton;
    @FXML
    private Button AddButton;

    @FXML
    void Delete(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Delete.fxml");
    }

    @FXML
    void Update(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Update.fxml");
    }
    
    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("AdminAllFunctionsPage.fxml");
    }

    @FXML
    void View(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("View.fxml");
    }
    @FXML
    void Add(ActionEvent event) throws IOException {
    	Main m= new Main();
    	m.changeScene("Register.fxml");
    }
}
