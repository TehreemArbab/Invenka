package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OwnerAllFunctionsPageController {

    @FXML
    private Button consumptionrate;

    @FXML
    private Button estimatebudget;

    @FXML
    private Button generateinventoryreport;

    @FXML
    private Button logout;

    @FXML
    void SendToCheckConsumptionRate(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("ConsumptionRateOwner.fxml");
    }

    @FXML
    void SendToEstimateItemBudget(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("EstimateBudgetOwner.fxml");
    }

    @FXML
    void SendToGIR(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("GenerateInventoryReportOwner.fxml");
    }

    @FXML
    void LogOutFunction(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }
}