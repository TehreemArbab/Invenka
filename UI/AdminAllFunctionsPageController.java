package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminAllFunctionsPageController {

    @FXML
    private Button Manageitem1;

    @FXML
    private Button consumptionrate;

    @FXML
    private Button estimatebudget;
   
    @FXML
    private Button logout;
    
    @FXML
    private Button generateinventoryreport;

    @FXML
    private Button managesupplier1;

    @FXML
    private Button orderfunctions;

    @FXML
    void SendToCheckConsumptionRate(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("ConsumptionRate.fxml");
    }

    @FXML
    void SendToEstimateItemBudget(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("EstimatedBudget.fxml");
    }

    @FXML
    void SendToGIR(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("GenerateInventoryReport.fxml");
    }

    @FXML
    void SendToManageItems(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("HomeScreen.fxml");
    }

    @FXML
    void SendToManageSupplier(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("SupplierCRUDhomeScreen.fxml");
    }

    @FXML
    void SendToOrderFunctions(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("OrderRelevantFn.fxml");
    }

    @FXML
    void LogOutFunction(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StartOfProgram.fxml");
    }
}