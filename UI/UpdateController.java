package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateController {
	@FXML
	private Label info;

	@FXML
	private TextField id;
	@FXML
	private TextField name;

	@FXML
	private TextField price;

	@FXML
	private Button updateButton;
    @FXML
    private Button backButton;

	@FXML
	void Update(ActionEvent event) {
		Main m = new Main();
		
		if (id.getText().isEmpty() || name.getText().isEmpty() || price.getText().isEmpty())

		{
			info.setText("Enter Data in all fields");
		} else {
			int Id = Integer.parseInt(id.getText());
			double pr = Double.parseDouble(price.getText());
			boolean res = m.getBLController().Update(Id, name.getText(), pr);
			if (res) {
				info.setText("Item updated successfully");
			} else {
				info.setText("Item not updated");

			}
		}
	}

	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("HomeScreen.fxml");
	}

}
