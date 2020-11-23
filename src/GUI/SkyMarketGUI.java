package GUI;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import Exceptions.EmptyFieldException;
import Exceptions.PasswordNotEqualsException;
import Model.SkyMarket;
import Model.User;
import Model.UserBuyer;
import Model.UserSeller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

public class SkyMarketGUI {

	private SkyMarket skymarket;
	
	//attributes main-panel
	@FXML
    private BorderPane mainPanel;
	
	//attributes login
	@FXML
	private TextField txtUsername;

	@FXML
    private PasswordField txtPassword;
	
	//attributesRegister
    @FXML
    private TextField txtNameRegister;

    @FXML
    private TextField txtLastNameRegister;

    @FXML
    private TextField txtIdentificationRegister;

    @FXML
    private TextField txtEmailRegister;

    @FXML
    private PasswordField txtPasswordRegister;
    
    @FXML
    private PasswordField txtPasswordVerificationRegister;

    @FXML
    private TextField txtUsernameRegister;

    @FXML
    private TextField txtPathPictureRegister;

    @FXML
    private DatePicker dpBirthday;
    
	//Constructor
	public SkyMarketGUI(SkyMarket sk) {
		skymarket = sk;
	}
	
	public void loadLogin() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent loginPane = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
    	mainPanel.setCenter(loginPane);
	}
	
	//methods mainPanel
	 @FXML
	 public void showAbout(ActionEvent event) {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setHeaderText("Credits");
		 alert.setContentText("Juan Camilo Zorrilla\nJuan Pablo Sanin\nGiovanni Mosquera\nAlgorithms II");
		 
		 alert.showAndWait();
	 }
	
	//methods login
    @FXML
    public void login(ActionEvent event) throws IOException {
    	User userToLogin = skymarket.binarySearchUser(txtUsername.getText());
    	if(userToLogin!=null) {
    		if(userToLogin.getPassword().equals(txtPassword.getText())) {
    			loginManagement(userToLogin);
    		}else {
    			userPasswordIncorrectAlert();
    		}
    	}else {
    		userDoesNotExistAlert();
    	}
    }
    
    public void loginManagement(User userToLogin) throws IOException {
    	if(userToLogin instanceof UserBuyer) {
    		loadUserBuyerScreen();
    		skymarket.setCurrentUser(userToLogin);
    	}else if(userToLogin instanceof UserSeller) {
    		loadUserSellerScreen();
    		skymarket.setCurrentUser(userToLogin);
    	}else {
    		loadAdministraitorScreen();
    		skymarket.setCurrentUser(userToLogin);
    	}
    }
    
    public void userDoesNotExistAlert(){
    	cleanFieldsLogin();
    	
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Cliente no existente");
    	alert.setContentText("El cliente no se encuentra en nuestros datos, por favor verifique su nombre de usuario");
    	alert.showAndWait();
    }
    
    public void userPasswordIncorrectAlert(){
    	cleanFieldsLogin();
    	
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Contraseña incorrecta");
    	alert.setContentText("La contraseña que usted ingreso no es la correcta");
    	alert.showAndWait();
    }
    
    public void loadUserBuyerScreen() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreenUserBuyer.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent userBuyerScreenPane = fxmlLoader.load(); 
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(userBuyerScreenPane);
    }
    
    public void loadUserSellerScreen() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreenUserSeller.fxml"));
    	
    	fxmlLoader.setController(this);

    	Parent userSellerScreenPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(userSellerScreenPane);
    }

	public void loadAdministraitorScreen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreenAdministrator.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent administraitorScreenPane = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setCenter(administraitorScreenPane);
	}
    
    public void cleanFieldsLogin() {
    	txtUsername.setText("");
    	txtPassword.setText("");
    }

    @FXML
    public void register(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent registerPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(registerPane);
    }
    
    //methods register
    @FXML
    public void addUserBuyer(ActionEvent event) throws IOException {
    	try {
    		String name = txtNameRegister.getText();
        	String lastName = txtLastNameRegister.getText();
        	String identification = txtIdentificationRegister.getText();
        	String email = txtEmailRegister.getText();
        	String password = txtPasswordRegister.getText();
        	String passwordVerify = txtPasswordVerificationRegister.getText();
        	String username = txtUsernameRegister.getText();
        	String pathPicture = txtPathPictureRegister.getText();
        	LocalDate birthday = dpBirthday.getValue();
        	skymarket.verificationFieldsRegister(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday);
        	skymarket.verificationPasswords(password, passwordVerify);
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 0);
        	cleanFieldsRegister();
        	clientAddedAlert(username, 0);
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		incorrectPasswordAlert();
    	}
    }
    
    @FXML
    public void addUserSeller(ActionEvent event) throws IOException {
    	try {
    		String name = txtNameRegister.getText();
        	String lastName = txtLastNameRegister.getText();
        	String identification = txtIdentificationRegister.getText();
        	String email = txtEmailRegister.getText();
        	String password = txtPasswordRegister.getText();
        	String passwordVerify = txtPasswordVerificationRegister.getText();
        	String username = txtUsernameRegister.getText();
        	String pathPicture = txtPathPictureRegister.getText();
        	LocalDate birthday = dpBirthday.getValue();
        	skymarket.verificationFieldsRegister(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday);
        	skymarket.verificationPasswords(password, passwordVerify);
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 1);
        	cleanFieldsRegister();
        	clientAddedAlert(username, 1);
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		incorrectPasswordAlert();
    	}
    }
    
    public void incorrectPasswordAlert() {
    	cleanFieldsRegister();
    	
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Contraseñas incorrectas");
    	alert.setContentText("Las contraseñas que ingreson no son iguales");
    	alert.showAndWait();
    }
    
    public void fieldEmptyAlert() {
    	cleanFieldsRegister();
    	
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Campo vacío");
    	alert.setContentText("Todos los campos tienen que tener un dato ingresado");
    	alert.showAndWait();
    }
    
    public void clientAddedAlert(String username, int type) {
    	cleanFieldsRegister();
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("Cliente agregado correctamente");
    	if(type == 0) {
    		alert.setContentText("El cliente se ha guardado como comprador con el nombre de usuario: " + username);
    	}else {
    		alert.setContentText("El cliente se ha guardado como vendedor con el nombre de usuario: " + username);
    	}
    	alert.showAndWait();
    }
    
    public void cleanFieldsRegister() {
    	txtNameRegister.setText("");
    	txtLastNameRegister.setText("");
    	txtIdentificationRegister.setText("");
    	txtEmailRegister.setText("");
    	txtPasswordRegister.setText("");
    	txtPasswordVerificationRegister.setText("");
    	txtUsernameRegister.setText("");
    	txtPathPictureRegister.setText("");
    	dpBirthday.setValue(null);
    }

    
    //pendiente
    @FXML
    public void browsePathPicture(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Buscar imagen");
 
    	File theDirectory = new File("data/picturesPeople");
    	
    	fileChooser.setInitialDirectory(theDirectory);
    	try {
    		txtPathPictureRegister.setText(fileChooser.showOpenDialog(null).getPath());
    	}catch(NullPointerException npe) {
    		txtPathPictureRegister.setText("data/picturesApp/people");
    	}
    }

    @FXML
    public void exitRegister(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent loginPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(loginPane);
    }
    
    //methods mainScreenUserBuyer
    
    @FXML
    void historyShopping(ActionEvent event) {

    }

    @FXML
    void viewBasket(ActionEvent event) {

    }

    @FXML
    void viewListArticleForSale(ActionEvent event) {

    }
    
    //methods mainScreenUserSeller
    
    @FXML
    void addArticleToSell(ActionEvent event) {

    }

    @FXML
    void historySales(ActionEvent event) {

    }

    @FXML
    void viewListArticlesToSell(ActionEvent event) {

    }
    
    //methods mainScreenAdministraitor
    
    @FXML
    void ViewAllArticles(ActionEvent event) {

    }

    @FXML
    void banUser(ActionEvent event) {

    }

    @FXML
    void importData(ActionEvent event) {

    }

    @FXML
    void viewAllUsers(ActionEvent event) {

    }
    //methods share mainScreenUserSeller, mainScreenuserBuyer and mainScreenAdministrator
    
    @FXML
    void logout(ActionEvent event) throws IOException {
    	loadLogin();
    	skymarket.setCurrentUser(null);
    }
}
