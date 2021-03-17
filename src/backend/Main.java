package backend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("/frontend/Login.fxml"));
		Parent firstPane = firstPaneLoader.load();

		Scene firstScene = new Scene(firstPane, 800, 500);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Login");
		primaryStage.setScene(firstScene);
		primaryStage.show();
	}
}
