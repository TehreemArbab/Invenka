package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ConsumptionRateOwnerController {

	@FXML
    private Button Back;

    @FXML
    private Button MonthlyButton;

    @FXML
    private Button WeeklyButton;
    
    @FXML
    private Label title;

    @FXML	
    void CheckWeekly(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("CheckWeeklyConsumptionRateOwner.fxml");
    }

    @FXML	
    void CheckMonthly(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("CheckMonthlyConsumptionRateOwner.fxml");
    }
    
    @FXML	
    void GoBack(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("OwnerAllFunctionsPage.fxml");
    }
}
