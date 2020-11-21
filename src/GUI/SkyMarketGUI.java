package GUI;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import Exceptions.PasswordNotEqualsException;
import Model.SkyMarket;
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
    public void login(ActionEvent event) {
    	
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
    public void addUserBuyer(ActionEvent event) {
    	try {
    		String name = txtNameRegister.getText();
        	String lastName = txtLastNameRegister.getText();
        	String identification = txtIdentificationRegister.getText();
        	String email = txtEmailRegister.getText();
        	String password = txtPasswordRegister.getText();
        	String passwordVerify = txtPasswordVerificationRegister.getText();
        	skymarket.verificationPasswords(password, passwordVerify);
        	String username = txtUsernameRegister.getText();
        	String pathPicture = txtPathPictureRegister.getText();
        	LocalDate birthday = dpBirthday.getValue();
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 0);
    	}catch(PasswordNotEqualsException pnee) {
    		incorrectPassword();
    	}
    }
    
    @FXML
    public void addUserSeller(ActionEvent event) {
    	try {
    		String name = txtNameRegister.getText();
        	String lastName = txtLastNameRegister.getText();
        	String identification = txtIdentificationRegister.getText();
        	String email = txtEmailRegister.getText();
        	String password = txtPasswordRegister.getText();
        	String passwordVerify = txtPasswordVerificationRegister.getText();
        	skymarket.verificationPasswords(password, passwordVerify);
        	String username = txtUsernameRegister.getText();
        	String pathPicture = txtPathPictureRegister.getText();
        	LocalDate birthday = dpBirthday.getValue();
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 1);
    	}catch(PasswordNotEqualsException pnee) {
    		incorrectPassword();
    	}
    }
    
    public void incorrectPassword() {
    	txtNameRegister.setText("");
    	txtLastNameRegister.setText("");
    	txtIdentificationRegister.setText("");
    	txtEmailRegister.setText("");
    	txtPasswordRegister.setText("");
    	txtPasswordVerificationRegister.setText("");
    	txtUsernameRegister.setText("");
    	txtPathPictureRegister.setText("");
    	dpBirthday.setValue(null);
    	
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Contraseñas incorrectas");
    	alert.setContentText("Las contraseñas que ingreson no son iguales");
    	alert.showAndWait();
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
}
