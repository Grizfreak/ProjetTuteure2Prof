package application;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static Parent actualRoot;
	public static Parent rootmain;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/application/Prof.fxml"));
			actualRoot = root;
			rootmain = actualRoot;
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
			primaryStage.centerOnScreen();
			primaryStage.setFullScreen(true);
			primaryStage.show();
			primaryStage.setTitle("Application Anglais");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
