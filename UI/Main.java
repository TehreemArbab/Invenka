package ui;

import java.io.IOException;

import businesslogic.Admin;
import businesslogic.Supplier;
import businesslogic.BusinessOwner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;

public class Main extends Application {
	private static Stage stg;
	
	private static Admin ai= new Admin(); //bl contoller
	private static Supplier si= new Supplier();
	private static BusinessOwner ow= new BusinessOwner();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("StartOfProgram.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("Manage Items");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Supplier getBLController1() {
		return si;
		
	}
	
	public BusinessOwner getBLController2() {
		return ow;
		
	}
	public Admin getBLController() {
		return ai;
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
