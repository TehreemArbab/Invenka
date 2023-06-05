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

public class CheckWeeklyConsumptionRateController {

	  @FXML
	    private Button CalculateButton;

	    @FXML
	    private TextField EndDateField;

	    @FXML
	    private TableView<?> Itemtable;

	    @FXML
	    private TextField StartDatefield;

	    @FXML
	    private Label answer;

	    @FXML
	    private Button backButton;

	    @FXML
	    private Label incaseerror;

	    @FXML
	    private TableColumn<?, ?> idcol;

	    @FXML
	    private Label info;

	    @FXML
	    private TextField itemID;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("ConsumptionRate.fxml");
    }

    @FXML
     void Calculate(ActionEvent event)throws IOException {
		Main m = new Main();
		if (itemID.getText().isEmpty())

		{
			incaseerror.setText("Enter Data in all fields");
		} 
		else if (StartDatefield.getText().isEmpty())

		{
			incaseerror.setText("Enter Data in all fields");
		} 
		else if (EndDateField.getText().isEmpty())
		{
			incaseerror.setText("Enter Data in all fields");
		} 				
		else {
			int id = Integer.parseInt(itemID.getText());
			String startdate = StartDatefield.getText();
			String enddate = EndDateField.getText();			
			int rate = m.getBLController().CheckConsumptionRate(id, startdate, enddate);
			String str = Integer.toString(rate);
			/*
			final ObservableList<Integer> data = FXCollections.observableArrayList(rate);
			idcol.setCellValueFactory(new PropertyValueFactory<>("rate"));
			//idcol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));

			Itemtable.setItems(data);
			Itemtable.set*/
			answer.setText(str);
		}     }
}
