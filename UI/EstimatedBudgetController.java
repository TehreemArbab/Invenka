
package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;

public class EstimatedBudgetController {

	 @FXML
	    private Button CalculateButton;

	    @FXML
	    private Label answer;

	    @FXML
	    private Button backButton;
	    
	    @FXML
	    private Label dollar;

	    @FXML
	    private Label incaseerror;

	    @FXML
	    private TextField itemID;


    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("AdminAllFunctionsPage.fxml");
    }

    @FXML
     void Calculate(ActionEvent event)throws IOException {
		Main m = new Main();
		if (itemID.getText().isEmpty())

		{
			incaseerror.setText("Enter Data in all fields");
		} 			
		else {
			int id = Integer.parseInt(itemID.getText());		
			double budget = m.getBLController().EstimatedBudget(id);
			String str = Double.toString(budget);
			/*
			final ObservableList<Integer> data = FXCollections.observableArrayList(rate);
			idcol.setCellValueFactory(new PropertyValueFactory<>("rate"));
			//idcol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));

			Itemtable.setItems(data);
			Itemtable.set*/
			answer.setText(str);
			dollar.setText("dollars");
		}     }
}
