package backend;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
	Login login = new Login();
	HashingPassword hashingPassword = new HashingPassword();
	Register reg = new Register();
	public static String windowName = "WorkProject";
	UserSession session = new UserSession();
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
	public Label errorLoginLabel;
	@FXML
	public TextField enterUsername;
	@FXML
	public TextField enterPassword;
	@FXML
	public TextField reEnterPassword;
	@FXML
	public TextField enterEmail;
	@FXML
	public Label usernameErrorLabel;
	@FXML
	public Label passwordErrorLabel;
	@FXML
	public Label emailErrorLabel;
	@FXML
	public Label validRegisterLabel;
	@FXML
	public Label emptyUsernameLabel;
	@FXML
	public Label emptyPasswordLabel;
	@FXML
	public Label emptyEmailLabel;
	@FXML
	public Label requiredEmailCharacterLabel;
	@FXML
	public Button logoutButton;

	@FXML
	private void handleRegisterButtonAction(ActionEvent event) throws IOException {

		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Register.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
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
		primaryStage.setTitle(windowName);
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	private void registerValidation(ActionEvent event) throws IOException, NoSuchAlgorithmException {
		event.consume();
		Jdbc db = new Jdbc();

		reg.enterUsername = enterUsername.getText();
		reg.enterPassword = hashingPassword.toHexString(hashingPassword.getSHA(enterPassword.getText()));
		reg.reEnterPassword = hashingPassword.toHexString(hashingPassword.getSHA(reEnterPassword.getText()));
		reg.enterEmail = enterEmail.getText();

		Users.username = reg.enterUsername;
		Users.password = reg.enterPassword;
		Users.email = reg.enterEmail;

		int usernameExistence = db.checkUsernameExistence(Users.username);
		int emailExistence = db.checkEmailExistence(Users.email);
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(enterEmail.getText());


		if(enterUsername.getText().isEmpty()){
			emptyUsernameLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					emptyUsernameLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(usernameExistence >= 1){
			usernameErrorLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					usernameErrorLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterPassword.getText().isEmpty() && reEnterPassword.getText().isEmpty()) {
			emptyPasswordLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					emptyPasswordLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(!(enterPassword.getText().equals(reEnterPassword.getText()))){
			passwordErrorLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					passwordErrorLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterEmail.getText().isEmpty()) {
			emptyEmailLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					emptyEmailLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(matcher.matches() == false){
			requiredEmailCharacterLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					requiredEmailCharacterLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(emailExistence >= 1){
			emailErrorLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					emailErrorLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);
		}else if(usernameExistence == 0 && emailExistence == 0 && enterPassword.getText().equals(reEnterPassword.getText())) {
				int successRegister = db.addUserRegister(Users.username, Users.password, Users.email, Users.ime, Users.prezime, Users.drzava,
						Users.grad, Users.brojMobitela, Users.pozicija, Users.placaProslogMjeseca, Users.putniTroskovi, Users.bodovi,
						Users.satiMjesecno, Users.ukupnoStecenihRadnihSati,Users.preostaliDaniGodisnjegOdmora, Users.roleId);

				if(successRegister >= 1){
					validRegisterLabel.setVisible(true);
					TimerTask task = new TimerTask() {
						public void run() {
							validRegisterLabel.setVisible(false);
						}
					};
					Timer timer = new Timer("Timer");

					long delay = 3000L;
					timer.schedule(task, delay);

					enterEmail.clear();
					enterPassword.clear();
					reEnterPassword.clear();
					enterUsername.clear();
			}
		}
	}

	@FXML
	private void loginValidation(ActionEvent event) throws IOException, NoSuchAlgorithmException{
		event.consume();
		Jdbc db = new Jdbc();

		login.username = usernameField.getText();
		login.password = hashingPassword.toHexString(hashingPassword.getSHA(passwordField.getText()));
		int count = db.dbLogin(login.username, login.password);

		if (count == 1){
			UserSession.userId = db.dbGetUserId(login.username);
			UserSession.username = login.username;
			Role.roleId = db.dbGetRoleId(UserSession.username);
			Role.roleName = db.dbGetRoleName(Role.roleId);

			FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Menu.fxml"));
			Parent registerPane = pageLoader.load();
			Scene secondScene = new Scene(registerPane, 800, 500);

			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			primaryStage.setResizable(false);
			primaryStage.setTitle(windowName);
			primaryStage.setScene(secondScene);
			primaryStage.show();
		} else {
			errorLoginLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					errorLoginLabel.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

			usernameField.clear();
			passwordField.clear();
		}
	}

	@FXML
	public void logout(ActionEvent event) throws IOException {
		session.clearSession();
		FXMLLoader pageLoader = new FXMLLoader(getClass().getResource("/frontend/Login.fxml"));
		Parent registerPane = pageLoader.load();
		Scene secondScene = new Scene(registerPane, 800, 500);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		primaryStage.setResizable(false);
		primaryStage.setTitle(windowName);
		primaryStage.setScene(secondScene);
		primaryStage.show();
	}

	@FXML
	public void initialize() {
		userInfoLabel.setText(UserSession.username);
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
