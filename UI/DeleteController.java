package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DeleteController {
	 @FXML
	    private Button backButton;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Label info;

	    @FXML
	    private TextField itemid;

	    @FXML
	    void Back(ActionEvent event) throws IOException {
	    	Main m = new Main();
			m.changeScene("HomeScreen.fxml");
	    }

	    @FXML
	    void Delete(ActionEvent event) {
	    	Main m = new Main();
	    	if (itemid.getText().isEmpty())

			{
				info.setText("Enter Data in all fields");
			} else {
				int id = Integer.parseInt(itemid.getText());
				boolean res = m.getBLController().Delete(id);
				if (res) {
					info.setText("item deleted successfully");
				} else {
					info.setText("item not found");

				}
			}
	    }
}
