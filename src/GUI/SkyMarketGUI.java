package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

import Exceptions.EmptyFieldException;
import Exceptions.PasswordNotEqualsException;
import Model.Article;
import Model.SkyMarket;
import Model.Technology;
import Model.User;
import Model.UserBuyer;
import Model.UserSeller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

public class SkyMarketGUI {
	
	private final static String PATH_PICTURE_PEOPLE = "data/picturesPeople/";
	
	private Article currentArticle;

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
    
    //Attributes personalDataScreen
    
    @FXML
    private ImageView ivPictureUserPD;

    @FXML
    private Label lblNamePD;

    @FXML
    private Label lblLastNamePD;

    @FXML
    private Label lblIdentificationPD;

    @FXML
    private Label lblEmailPD;

    @FXML
    private Label lblUsernamePD;

    @FXML
    private Label lblBirthdayPD;
    
    //Attributes screenAddNewArticle
    
    @FXML
    private TextField txtNameArticleNA;

    @FXML
    private TextField txtPriceArticleNA;

    @FXML
    private TextArea txtaDescriptionArticleNA;

    @FXML
    private TextField txtPictureArticleNA;

    @FXML
    private TextField txtQuantityArticleNA;

    @FXML
    private ChoiceBox<String> cbTypeArticleNA;
    
    //Attributes screenAddNewTechnology
    
    @FXML
    private TextField txtBatteryWatsNT;

    @FXML
    private TextField txtScreenSizeNT;

    @FXML
    private TextField txtProcessorNT;

    @FXML
    private ChoiceBox<String> cbTypeTechnologyNT;

    @FXML
    private TextField txtRamNT;

    //Attributes screenAddNewHomeAppliances
    
    @FXML
    private TextField txtWeightNH;

    @FXML
    private TextField txtCapacityNH;

    @FXML
    private TextField txtHeightNH;

    @FXML
    private TextField txtWattsConsumNH;

    @FXML
    private TextField txtWidthNH;

    @FXML
    private ChoiceBox<String> cbTypeHomeAppliancesNH;
    
	//Constructor
	public SkyMarketGUI(SkyMarket sk){
		skymarket = sk;
		serializeData();
	}
	
	public void serializeData(){
		try {
			skymarket.loadDataClients();
		}catch(IOException | ClassNotFoundException iocnfe) {
			serializableAlert();
		}
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
    	alert.setHeaderText("Contrase�a incorrecta");
    	alert.setContentText("La contrase�a que usted ingreso no es la correcta");
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
        	skymarket.saveDataRestaurants();
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		cleanFieldsRegister();
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		cleanFieldsRegister();
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
        	skymarket.saveDataRestaurants();
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		cleanFieldsRegister();
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		cleanFieldsRegister();
    		incorrectPasswordAlert();
    	}
    }
    
    public void incorrectPasswordAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Contrase�as incorrectas");
    	alert.setContentText("Las contrase�as que ingreson no son iguales");
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

    @FXML
    public void browsePathPictureProfile(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Buscar imagen");
 
    	File theDirectory = new File("data/picturesPeople");
    	
    	fileChooser.setInitialDirectory(theDirectory);
    	try {
    		txtPathPictureRegister.setText(fileChooser.showOpenDialog(null).getName());
    	}catch(NullPointerException npe) {
    		txtPathPictureRegister.setText("data/picturesApp/people.PNG");
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
    void addArticleToSell(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewArticle.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewArticlePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewArticlePane);
    	cbTypeArticleNA.getItems().add("Tecnologia");
    	cbTypeArticleNA.getItems().add("Electrodomestico");
    }

    @FXML
    void historySales(ActionEvent event) {

    }

    @FXML
    void viewListArticlesToSell(ActionEvent event) {

    }

    @FXML
    void modifyShipping(ActionEvent event) {

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
    
    //methods screenAddNewArticle
    
    @FXML
    public void browsePathPictureArticle(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Buscar imagen articulo");
    	
    	File pathPictureArticle = new File("data/picturesArticles");
    	
    	fileChooser.setInitialDirectory(pathPictureArticle);
    	try {
    		txtPictureArticleNA.setText(fileChooser.showOpenDialog(null).getName());
    	}catch(NullPointerException npe) {
    		txtPictureArticleNA.setText("data/picturesApp/Producto.JPG");
    	}
    }

    @FXML
    public void continueToTypeArticle(ActionEvent event) {
    	try {
    		String nameArticle = txtNameArticleNA.getText();
    		String code = skymarket.generateRandomNumber();
    		Double priceArticle = Double.parseDouble(txtPriceArticleNA.getText());
    		String description = txtaDescriptionArticleNA.getText();
    		String pathImageArticle = txtIdentificationRegister.getText();
    		int quantity = Integer.parseInt(txtQuantityArticleNA.getText());
    		String type = cbTypeArticleNA.getValue();
    		
    		skymarket.verificationFieldsAddArticle(nameArticle, code, priceArticle, description, pathImageArticle, quantity,type);    		
    		managementAddArticle(type);
    	}catch(EmptyFieldException efe) {
    		clearFieldsAddArticle();
    		fieldEmptyAlert();
    	} catch(NumberFormatException nfe) {
    		nfe.getStackTrace();
    		FormatAlert();
    	}
    }
    
    public void clearFieldsAddArticle() {
    	txtNameArticleNA.setText("");
    	txtPriceArticleNA.setText("");
    	txtaDescriptionArticleNA.setText("");
    	txtIdentificationRegister.setText("");
    	txtQuantityArticleNA.setText("");
    }
    
    public void managementAddArticle(String type) {
	    try {
    		if(type.equals("Tecnologia")) {
	    		loadScreenTechnology();
	    	}else if(type.equals("Electrodomestico")){
	    		loadScreenHomeAppliances();
	    	}
	    }catch(IOException ioe) {
	    	fxmlNotFound();
	    } 
    }
    
    public void loadScreenTechnology() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewTechnology.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewTechnologyPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewTechnologyPane);
    	
    	cbTypeTechnologyNT.getItems().add("Celular");
    	cbTypeTechnologyNT.getItems().add("Computador");
    }
    
    public void loadScreenHomeAppliances() throws IOException {
    	FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("screenAddNewHomeAppliances.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddHomeAppliancesPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddHomeAppliancesPane);
    	
    	cbTypeHomeAppliancesNH.getItems().add("Nevera");
    	cbTypeHomeAppliancesNH.getItems().add("Estufa");
    }
    
    //methods screenAddNewTechnology
    
    @FXML
    void continueToTypeTechnology(ActionEvent event) {
    	
    }
    
    //methods screenAddNewHomeAppliances
    
    @FXML
    void continueToTypeHomeAppliances(ActionEvent event) {

    }
    
    //methods share mainScreenUserSeller, mainScreenuserBuyer and mainScreenAdministrator
    
    @FXML
    public void personalDataScreen(ActionEvent event) throws IOException {
		String currentName = skymarket.getCurrentUser().getName();
		String currentLastName = skymarket.getCurrentUser().getLastName();
		String currentIdentification = skymarket.getCurrentUser().getIdentification();
		String currentEmail = skymarket.getCurrentUser().getEmail();
		String currentUsername = skymarket.getCurrentUser().getUsername();
		String currentBirthday = skymarket.getCurrentUser().getBirthday().toString();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("personalDataScreen.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent personalDataPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(personalDataPane);
    	
    	lblNamePD.setText(currentName);
    	lblLastNamePD.setText(currentLastName);
    	lblIdentificationPD.setText(currentIdentification);
    	lblEmailPD.setText(currentEmail);
    	lblUsernamePD.setText(currentUsername);
    	lblBirthdayPD.setText(currentBirthday);
    	
    	String path = PATH_PICTURE_PEOPLE + skymarket.getCurrentUser().getPicture();
    	
    	Image newImage = new Image( new FileInputStream(path));
    	
    	ivPictureUserPD.setImage(newImage);
    }
    
    @FXML
    public void exit(ActionEvent event) throws IOException {
    	loginManagement(skymarket.getCurrentUser());
    }
    
    @FXML
    public void logout(ActionEvent event) throws IOException {
    	loadLogin();
    	skymarket.setCurrentUser(null);
    }
    
    //Alerts
    
    public void fieldEmptyAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Campo vac�o");
    	alert.setContentText("Todos los campos tienen que tener un dato ingresado");
    	alert.showAndWait();
    }
    
    public void fxmlNotFound() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Archivo no encontrado");
    	alert.setContentText("El archivo no se pudo cargar");
    	alert.showAndWait();
    }
    
    public void FormatAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Ingresar formato adecuado");
    	alert.setContentText("Porfavor ingrese los tipo de datos pertinentes\nEjemplo: precio = numeros");
    	alert.showAndWait();
    }
    
    public void serializableAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("Imposible serializar la informacion");
    	alert.setContentText("Este error puede ocurrir debido a que no existe un archivo para serializar");
    	alert.showAndWait();
    }
}
