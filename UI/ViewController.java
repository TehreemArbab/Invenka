package ui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewController {
	@FXML
	private Button backButton;
	@FXML
	private Button viewButton;

	@FXML
    private TableColumn<Item, Integer> idcol;

    @FXML
    private Label info;

    @FXML
    private TableColumn<Item, String> namecol;

    @FXML
    private TableColumn<Item, Double> pricecol;

  

	@FXML
	private TableView<Item> Itemtable;

	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("HomeScreen.fxml");
	}
	@FXML
	void View(ActionEvent event) {
		Main m = new Main();
		ArrayList<Item> stu = m.getBLController().ViewItems();

		if (stu.isEmpty()) {
			info.setText("No items registered");
		}

		else {
			final ObservableList<Item> data = FXCollections.observableArrayList(stu);

			
			idcol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
			namecol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
			pricecol.setCellValueFactory(new PropertyValueFactory<Item, Double>("itemPrice"));

			Itemtable.setItems(data);
		}

	}

}
