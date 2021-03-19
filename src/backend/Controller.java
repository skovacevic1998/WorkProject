package backend;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
	Login login = new Login();
	HashingPassword hashingPassword = new HashingPassword();
	List<Users> ListOfUser = new ArrayList<>();
	List<String> StringListaUsera = new ArrayList<String>();
	Jdbc db = new Jdbc();


	@FXML
	public Label timeLabel = new Label();
	@FXML
	public Label userInfoLabel = new Label();
	@FXML
	public TextField usernameField;
	@FXML
	public PasswordField passwordField;
	@FXML
	public Label statusLabel;

	@FXML
	private void handleRegisterButtonAction(ActionEvent event) throws IOException {

		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Register.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Register");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleLoginButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Login.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Login");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleEvidencijaButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Evidencija.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Evidencija");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleMenuButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Menu.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleProfileButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Profil.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleKontaktiButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Kontakti.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void handleZaposleniciButtonAction(ActionEvent event) throws IOException {
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Zaposlenici.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle("Zaposlenici");
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void registerValidation(ActionEvent event) throws IOException {
		event.consume();
		Jdbc db = new Jdbc();
	}

	@FXML
	private void loginValidation(ActionEvent event) throws IOException, NoSuchAlgorithmException{
		event.consume();
		Jdbc db = new Jdbc();

		login.username = usernameField.getText();
		login.password = hashingPassword.toHexString(hashingPassword.getSHA(passwordField.getText()));
		db.sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";
		int count = db.getCount(login.username, login.password);

		if (count == 1) {
			FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Menu.fxml"));
			Parent registerPane = pageLoader.load();
			Scene secondScene = new Scene(registerPane, 800, 500);

			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			primaryStage.setResizable(false);
			primaryStage.setTitle("Menu");
			primaryStage.setScene(secondScene);
			primaryStage.show();
		} else {
			statusLabel.setVisible(true);
		}
	}

	@FXML
	public void initialize() {
		localTime();
	}

	@FXML
	public void localTime(){
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			timeLabel.setText(LocalDateTime.now().format(formatter));
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	@FXML
	private void exitButtonAction() {
		Platform.exit();
	}
}
