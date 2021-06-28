package backend;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
	long diffHours = 0;
	long diffMinutes = 0;

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
	public Label passwordErrorMinimumCharactersLabel;
	@FXML
	public Label usernameErrorMinimumCharactersLabel;
	@FXML
	public Label username_lbl = new Label();
	@FXML
	public Label ime_lbl = new Label();
	@FXML
	public Label prezime_lbl = new Label();
	@FXML
	public Label email_lbl = new Label();
	@FXML
	public Label drzava_lbl = new Label();
	@FXML
	public Label grad_lbl = new Label();
	@FXML
	public Label brojMobitela_lbl = new Label();
	@FXML
	public Label pozicija_lbl = new Label();
	@FXML
	public Label placaProslogMjeseca_lbl = new Label();
	@FXML
	public Label putniTroskovi_lbl = new Label();
	@FXML
	public Label bodovi_lbl = new Label();
	@FXML
	public Label radniSatiMjesecno_lbl = new Label();
	@FXML
	public Label ukupniRadniSati_lbl = new Label();
	@FXML
	public Label daniGodisnjegOdmora_lbl = new Label();
	@FXML
	public Label lblPromjeneImena = new Label();
	@FXML
	public Label lblPromjenePrezimena = new Label();
	@FXML
	public Label lblPromjeneEmaila = new Label();
	@FXML
	public Label lblPromjeneDrzave = new Label();
	@FXML
	public Label lblPromjeneGrada = new Label();
	@FXML
	public Label lblPromjeneBrojaMobitela = new Label();
	@FXML
	public TextField editIme_txtField;
	@FXML
	public TextField editPrezime_txtField;
	@FXML
	public TextField editEmail_txtField;
	@FXML
	public TextField editDrzava_txtField;
	@FXML
	public TextField editGrad_txtField;
	@FXML
	public TextField editBrojMobitela_txtField;
	@FXML
	public Button editIme_btn;
	@FXML
	public Button editPrezime_btn;
	@FXML
	public Button editEmail_btn;
	@FXML
	public Button editDrzava_btn;
	@FXML
	public Button editGrad_btn;
	@FXML
	public Button editBrojMobitela_btn;
	@FXML
	public Button saveIme_btn;
	@FXML
	public Button savePrezime_btn;
	@FXML
	public Button saveEmail_btn;
	@FXML
	public Button saveDrzava_btn;
	@FXML
	public Button saveGrad_btn;
	@FXML
	public Button saveBrojMobitela_btn;
	@FXML
	public Label emailEmptyError_lbl = new Label();
	@FXML
	public Label emailExistsError_lbl = new Label();
	@FXML
	public Label emailFormatError_lbl = new Label();
	@FXML
	public TableView<Evidencija> tableContent;
	@FXML
	public TableColumn<Evidencija, Integer> col_br = new TableColumn<>();
	@FXML
	public TableColumn<Evidencija, Integer> col_vrOd = new TableColumn<>();
	@FXML
	public TableColumn<Evidencija, Integer> col_vrDo = new TableColumn<>();
	@FXML
	public TableColumn<Evidencija, Integer> col_dat = new TableColumn<>();
	@FXML
	public TableColumn<Evidencija, Integer> col_opis = new TableColumn<>();
	@FXML
	public TableColumn<Evidencija, Integer> col_brSati = new TableColumn<>();
	@FXML
	public DatePicker datePickerForSearch;
	@FXML
	public TextArea tableInfo_textArea;
	@FXML
	public TextField addOpisPosla_textField;
	@FXML
	public TextField vrijemeOdlaska_textField;
	@FXML
	public TextField vrijemeDolaska_textField;
	@FXML
	public Label existsError_lbl;
	@FXML
	public Label success_lbl;




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

		db.oblist.removeAll();

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
	private void registerValidation(ActionEvent event) throws NoSuchAlgorithmException {
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
			enterUsername.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					emptyUsernameLabel.setVisible(false);
					enterUsername.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterUsername.getLength() < 4){
			enterUsername.setStyle("-fx-border-color: red;");
			usernameErrorMinimumCharactersLabel.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					usernameErrorMinimumCharactersLabel.setVisible(false);
					enterUsername.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(usernameExistence >= 1){
			usernameErrorLabel.setVisible(true);
			enterUsername.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					usernameErrorLabel.setVisible(false);
					enterUsername.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterPassword.getText().isEmpty() && reEnterPassword.getText().isEmpty()) {
			emptyPasswordLabel.setVisible(true);
			enterPassword.setStyle("-fx-border-color: red;");
			reEnterPassword.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					emptyPasswordLabel.setVisible(false);
					enterPassword.setStyle("-fx-border-color: none;");
					reEnterPassword.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(!(enterPassword.getText().equals(reEnterPassword.getText()))){
			passwordErrorLabel.setVisible(true);
			enterPassword.setStyle("-fx-border-color: red;");
			reEnterPassword.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					passwordErrorLabel.setVisible(false);
					enterPassword.setStyle("-fx-border-color: none;");
					reEnterPassword.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterPassword.getLength() < 8 && reEnterPassword.getLength() < 8){
			passwordErrorMinimumCharactersLabel.setVisible(true);
			enterPassword.setStyle("-fx-border-color: red;");
			reEnterPassword.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					passwordErrorMinimumCharactersLabel.setVisible(false);
					enterPassword.setStyle("-fx-border-color: none;");
					reEnterPassword.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(enterEmail.getText().isEmpty()) {
			emptyEmailLabel.setVisible(true);
			enterEmail.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					emptyEmailLabel.setVisible(false);
					enterEmail.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(matcher.matches() == false){
			requiredEmailCharacterLabel.setVisible(true);
			enterEmail.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					requiredEmailCharacterLabel.setVisible(false);
					enterEmail.setStyle("-fx-border-color: none;");
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else if(emailExistence >= 1){
			emailErrorLabel.setVisible(true);
			enterEmail.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					emailErrorLabel.setVisible(false);
					enterEmail.setStyle("-fx-border-color: none;");
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
			usernameField.setStyle("-fx-border-color: red;");
			passwordField.setStyle("-fx-border-color: red;");
			TimerTask task = new TimerTask() {
				public void run() {
					errorLoginLabel.setVisible(false);
					usernameField.setStyle("-fx-border-color: none;");
					passwordField.setStyle("-fx-border-color: none;");
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
	public void editAction(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
		String id = source.getId();

		if(id == editIme_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			saveIme_btn.setVisible(true);
			editIme_txtField.setVisible(true);
		}

		if(id == editPrezime_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			savePrezime_btn.setVisible(true);
			editPrezime_txtField.setVisible(true);
		}

		if(id == editEmail_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			saveEmail_btn.setVisible(true);
			editEmail_txtField.setVisible(true);
		}

		if(id == editDrzava_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			saveDrzava_btn.setVisible(true);
			editDrzava_txtField.setVisible(true);
		}

		if(id == editGrad_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			saveGrad_btn.setVisible(true);
			editGrad_txtField.setVisible(true);
		}

		if(id == editBrojMobitela_btn.getId()){
			editIme_btn.setVisible(false);
			editPrezime_btn.setVisible(false);
			editEmail_btn.setVisible(false);
			editDrzava_btn.setVisible(false);
			editGrad_btn.setVisible(false);
			editBrojMobitela_btn.setVisible(false);

			saveBrojMobitela_btn.setVisible(true);
			editBrojMobitela_txtField.setVisible(true);
		}
		//----------------------------------------------------------

		if (id == saveIme_btn.getId()){
			String content = editIme_txtField.getText();
			db.updateIme(UserSession.username,content);

			editIme_btn.setVisible(true);
			editPrezime_btn.setVisible(true);
			editEmail_btn.setVisible(true);
			editDrzava_btn.setVisible(true);
			editGrad_btn.setVisible(true);
			editBrojMobitela_btn.setVisible(true);

			saveIme_btn.setVisible(false);
			editIme_txtField.setVisible(false);
		}

		if (id == savePrezime_btn.getId()){
			String content = editPrezime_txtField.getText();
			db.updatePrezime(UserSession.username,content);

			editIme_btn.setVisible(true);
			editPrezime_btn.setVisible(true);
			editEmail_btn.setVisible(true);
			editDrzava_btn.setVisible(true);
			editGrad_btn.setVisible(true);
			editBrojMobitela_btn.setVisible(true);

			savePrezime_btn.setVisible(false);
			editPrezime_txtField.setVisible(false);
		}

		if (id == saveEmail_btn.getId()){
			String content = editEmail_txtField.getText();
			int emailExistence = db.checkEmailExistence(content);
			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(content);

			if(content.isEmpty()) {
				editEmail_txtField.setStyle("-fx-border-color: red;");
				emailEmptyError_lbl.setVisible(true);
				TimerTask task = new TimerTask() {
					public void run() {
						emailEmptyError_lbl.setVisible(false);
						editEmail_txtField.setStyle("-fx-border-color: none;");
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);

			}else if(matcher.matches() == false){
				emailFormatError_lbl.setVisible(true);
				editEmail_txtField.setStyle("-fx-border-color: red;");
				TimerTask task = new TimerTask() {
					public void run() {
						emailFormatError_lbl.setVisible(false);
						editEmail_txtField.setStyle("-fx-border-color: none;");
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);

			}else if(emailExistence >= 1){
				emailExistsError_lbl.setVisible(true);
				editEmail_txtField.setStyle("-fx-border-color: red;");
				TimerTask task = new TimerTask() {
					public void run() {
						emailExistsError_lbl.setVisible(false);
						editEmail_txtField.setStyle("-fx-border-color: none;");
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);
			}else{
				db.updateEmail(UserSession.username,content);

				editIme_btn.setVisible(true);
				editPrezime_btn.setVisible(true);
				editEmail_btn.setVisible(true);
				editDrzava_btn.setVisible(true);
				editGrad_btn.setVisible(true);
				editBrojMobitela_btn.setVisible(true);

				saveEmail_btn.setVisible(false);
				editEmail_txtField.setVisible(false);
			}
		}

		if (id == saveDrzava_btn.getId()){
			String content = editDrzava_txtField.getText();
			db.updateDrzava(UserSession.username,content);

			editIme_btn.setVisible(true);
			editPrezime_btn.setVisible(true);
			editEmail_btn.setVisible(true);
			editDrzava_btn.setVisible(true);
			editGrad_btn.setVisible(true);
			editBrojMobitela_btn.setVisible(true);

			saveDrzava_btn.setVisible(false);
			editDrzava_txtField.setVisible(false);
		}

		if (id == saveGrad_btn.getId()){
			String content = editGrad_txtField.getText();
			db.updateGrad(UserSession.username,content);

			editIme_btn.setVisible(true);
			editPrezime_btn.setVisible(true);
			editEmail_btn.setVisible(true);
			editDrzava_btn.setVisible(true);
			editGrad_btn.setVisible(true);
			editBrojMobitela_btn.setVisible(true);

			saveGrad_btn.setVisible(false);
			editGrad_txtField.setVisible(false);
		}

		if (id == saveBrojMobitela_btn.getId()){
			String content = editBrojMobitela_txtField.getText();
			db.updateBrojMobitela(UserSession.username,content);

			editIme_btn.setVisible(true);
			editPrezime_btn.setVisible(true);
			editEmail_btn.setVisible(true);
			editDrzava_btn.setVisible(true);
			editGrad_btn.setVisible(true);
			editBrojMobitela_btn.setVisible(true);

			saveBrojMobitela_btn.setVisible(false);
			editBrojMobitela_txtField.setVisible(false);

		}
		initialize();
	}

	@FXML
	public void searchTable(ActionEvent event){
		db.oblist.removeAll();
		tableContent.getItems().clear();
		db.tableData();

		col_br.setCellValueFactory(new PropertyValueFactory<>("br"));
		col_vrOd.setCellValueFactory(new PropertyValueFactory<>("vrijemeDolaska"));
		col_vrDo.setCellValueFactory(new PropertyValueFactory<>("vrijemeOdlaska"));
		col_dat.setCellValueFactory(new PropertyValueFactory<>("datumRada"));
		col_opis.setCellValueFactory(new PropertyValueFactory<>("opisPosla"));
		col_brSati.setCellValueFactory(new PropertyValueFactory<>("ukupnoSatiRadnogDana"));

		getTableInfo();
		tableContent.setItems(db.oblist);
	}

	@FXML
	public void searchByDate(){
		db.oblist.removeAll();
		tableContent.getItems().clear();
		if(datePickerForSearch.getValue()!=null){
			java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datePickerForSearch.getValue());

			db.tableDataByDate(gettedDatePickerDate.toString());

			col_br.setCellValueFactory(new PropertyValueFactory<>("br"));
			col_vrOd.setCellValueFactory(new PropertyValueFactory<>("vrijemeDolaska"));
			col_vrDo.setCellValueFactory(new PropertyValueFactory<>("vrijemeOdlaska"));
			col_dat.setCellValueFactory(new PropertyValueFactory<>("datumRada"));
			col_opis.setCellValueFactory(new PropertyValueFactory<>("opisRada"));
			col_brSati.setCellValueFactory(new PropertyValueFactory<>("ukupnoSatiRadnogDana"));

			getTableInfo();
			tableContent.setItems(db.oblist);
		}
	}

	@FXML
	public void getTableInfo(){
		tableContent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
				if(tableContent.getSelectionModel().getSelectedItem() != null)
				{
					TableView.TableViewSelectionModel selectionModel = tableContent.getSelectionModel();
					ObservableList selectedCells = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCells.get(0);
					Object opisPoslaValue = tablePosition.getTableColumn().getCellData(newValue);
					tableInfo_textArea.setText(opisPoslaValue.toString());
				}
			}
		});
	}

	@FXML
	public void addToTableInfo() throws ParseException {
		String opisPosla = addOpisPosla_textField.getText();
		String vrijemeDolaska = vrijemeDolaska_textField.getText();
		String vrijemeOdlaska = vrijemeOdlaska_textField.getText();
		String timeFormat = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
		long userHours = Long.valueOf(db.getUserTotalWorkingHours(UserSession.username));

		vrijemeDolaska_textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
				if (vrijemeDolaska_textField.getText().length() > 5) {
					String s = vrijemeDolaska_textField.getText().substring(0, 5);
					vrijemeDolaska_textField.setText(s);
				}
			}
		});

		vrijemeOdlaska_textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
				if (vrijemeOdlaska_textField.getText().length() > 5) {
					String s = vrijemeOdlaska_textField.getText().substring(0, 5);
					vrijemeOdlaska_textField.setText(s);
				}
			}
		});

		String nowDate = db.checkDate();
		if(nowDate.equals(LocalDate.now().toString())){
			existsError_lbl.setVisible(true);
			TimerTask task = new TimerTask() {
				public void run() {
					existsError_lbl.setVisible(false);
				}
			};
			Timer timer = new Timer("Timer");

			long delay = 3000L;
			timer.schedule(task, delay);

		}else {
			if (vrijemeDolaska_textField.getText().matches(timeFormat) &&
					vrijemeOdlaska_textField.getText().matches(timeFormat)) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				Date date1 = format.parse(vrijemeDolaska);
				Date date2 = format.parse(vrijemeOdlaska);
				long difference = date2.getTime() - date1.getTime();
				long diffSeconds = difference / 1000 % 60;
				diffMinutes = difference / (60 * 1000) % 60;
				diffHours = difference / (60 * 60 * 1000) % 24;
				long diffDays = difference / (24 * 60 * 60 * 1000);
				String ukupnoSati = String.valueOf(diffHours)+":"+ String.valueOf(diffMinutes);
				String ukupnoSatiUsera = String.valueOf(userHours + diffHours);

				db.updateUkupnoSatiUsera(ukupnoSatiUsera, UserSession.username);
				db.addEvidencija(LocalDate.now().toString(), vrijemeDolaska, vrijemeOdlaska, opisPosla, ukupnoSati, UserSession.username);

				success_lbl.setVisible(true);
				TimerTask task = new TimerTask() {
					public void run() {
						success_lbl.setVisible(false);
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);
			} else if (!vrijemeDolaska_textField.getText().matches(timeFormat) || vrijemeDolaska_textField.getText().isEmpty()) {
				vrijemeDolaska_textField.setStyle("-fx-border-color: red;");
				TimerTask task = new TimerTask() {
					public void run() {
						vrijemeDolaska_textField.setStyle("-fx-border-color: none;");
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);
			}else if (!vrijemeOdlaska_textField.getText().matches(timeFormat) || vrijemeOdlaska_textField.getText().isEmpty()) {
				vrijemeOdlaska_textField.setStyle("-fx-border-color: red;");
				TimerTask task = new TimerTask() {
					public void run() {
						vrijemeOdlaska_textField.setStyle("-fx-border-color: none;");
					}
				};
				Timer timer = new Timer("Timer");

				long delay = 3000L;
				timer.schedule(task, delay);
			}
		}
	}

	@FXML
	public void validateDatePickerSearch(){
		datePickerForSearch.setDayCellFactory(param -> new DateCell() {
			private LocalDate now = LocalDate.now();
			private LocalDate twoMonthsLater = LocalDate.now().plusMonths(2);

			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date != null && !empty) {
					setDisable(date.compareTo(now) > 0 || date.compareTo(twoMonthsLater) > 0);
				}
			}
		});
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
		username_lbl.setText(UserSession.username);
		userInfoLabel.setText(UserSession.username);
		ime_lbl.setText(db.getUserName(UserSession.username));
		prezime_lbl.setText(db.getUserSurname(UserSession.username));
		email_lbl.setText(db.getUserEmail(UserSession.username));
		drzava_lbl.setText(db.getUserState(UserSession.username));
		grad_lbl.setText(db.getUserCity(UserSession.username));
		brojMobitela_lbl.setText(db.getUserNumber(UserSession.username));
		pozicija_lbl.setText(db.getUserPosition(UserSession.username));
		placaProslogMjeseca_lbl.setText(db.getUserLastMonthPayment(UserSession.username));
		putniTroskovi_lbl.setText(db.getUserTravelExpenses(UserSession.username));
		bodovi_lbl.setText(db.getUserPoints(UserSession.username));
		radniSatiMjesecno_lbl.setText(db.getUserWorkedHoursMonthly(UserSession.username));
		ukupniRadniSati_lbl.setText(db.getUserTotalWorkingHours(UserSession.username));
		daniGodisnjegOdmora_lbl.setText(db.getUserFreeDays(UserSession.username));
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