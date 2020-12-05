package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import Exceptions.CartQuantityException;
import Exceptions.EmptyFieldException;
import Exceptions.IdentificationRepeatException;
import Exceptions.PasswordNotEqualsException;
import Exceptions.RepeatArticleCodeException;
import Exceptions.UsernameRepeatException;
import Model.Article;
import Model.CartItem;
import Model.CellPhone;
import Model.Computer;
import Model.Fridge;
import Model.HomeAppliances;
import Model.ProgressBar;
import Model.SkyMarket;
import Model.Stove;
import Model.Technology;
import Model.User;
import Model.UserBuyer;
import Model.UserSeller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Thread.ExportThread;
import Thread.ImportThread;
import Thread.ProgressBarThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class SkyMarketGUI {
	
	/**
	 * Route of the pictures of people
	 */
	private final static String PATH_PICTURE_PEOPLE = "data/picturesPeople/";
	
	
	/**
	 * Route of the pictures of products
	 */
	private final static String PATH_PICTURE_ARTICLES_CELLPHONE= "data/picturesArticles/Celulares/";
	
	private final static String PATH_PICTURE_ARTICLES_COMPUTERS= "data/picturesArticles/Computadores/";
	
	private final static String PATH_PICTURE_ARTICLES_FRIDGE= "data/picturesArticles/Neveras/";
	
	private final static String PATH_PICTURE_ARTICLES_STOVE= "data/picturesArticles/Estufas/";
	
	/**
	 * Temp article to help in the process to add
	 */
	private Article currentArticle;

	/**
	 * Variable to manage the program
	 */
	private SkyMarket skymarket;
	
	/**
	 * ProgressBar with thread at the end
	 */
	private ProgressBar pb;
	
	//Rectangle ProgressBar
    @FXML
    private Rectangle progressBar;
    
    @FXML
    private Label txtPercent;
	
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
    
    //Attributes screenAddCellphone
    
    @FXML
    private TextField txtNumberSimsNC;

    @FXML
    private TextField txtNumberCameraNC;
    
    //Attributes screenAddNewFridge
    
    @FXML
    private ToggleGroup tgSmart;

    @FXML
    private ToggleGroup tgFrost;
    
    
    // Attributes screenAddNewComputer
    @FXML
    private TextField txtNumberPortsPC;

    @FXML
    private ToggleGroup tgTouch;
    
    //Attributes screenAddNewStove
    
    @FXML
    private TextField txtNumberNozzlesNS;

    @FXML
    private ChoiceBox<String> cbTypeStoveNS;
    
    //Attributes banUserScreen
    
    @FXML
    private TextField txtUsernameToBan;

    @FXML
    private TableView<UserSeller> tvUserSellerListB;

    @FXML
    private TableColumn<UserSeller, String> tcUsernameB;

    @FXML
    private TableColumn<UserSeller, String> tcIdentificationB;

    @FXML
    private TableColumn<UserSeller, String> tcNameB;

    @FXML
    private TableColumn<UserSeller, String> tcLastNameB;

    @FXML
    private TableColumn<UserSeller, Double> tcCalificationB;
    
    @FXML
    private TableColumn<UserSeller, Boolean> tcBanB;
    

    //Attributes screenToBuyArticles
    
    @FXML
    private TableView<Article> tvArticlesTSUB;

    @FXML
    private TableColumn<Article, String> tcNameTSUB;

    @FXML
    private TableColumn<Article, String> tcCodeTSUB;

    @FXML
    private TableColumn<Article, Double> tcPriceTSUB;

    @FXML
    private TableColumn<Article, String> tcDescriptionTSUB;

    @FXML
    private TableColumn<Article, Integer> tcQuantityTSUB;

    @FXML
    private TableView<Article> tvArticlesOnSale;
    
    @FXML
    private TableColumn<Article, String> tcPictureOnSale;

    @FXML
    private TableColumn<Article, String> tcNameOnSale;

    @FXML
    private TableColumn<Article, Double> tcPriceOnSale;

    @FXML
    private TableColumn<Article, String> tcCodeOnSale;

    @FXML
    private TableColumn<Article, Button> tcActionOnSale;

    //Attributes showFiltredUsers
    
    @FXML
    private TableView<User> tvFiltedUsers;

    @FXML
    private TableColumn<User, String> tcNameFiltredTv;

    @FXML
    private TableColumn<User, String> tcLastnameFiltredTv;

    @FXML
    private TableColumn<User, String> tcIdentificationFiltredTv;

    @FXML
    private TableColumn<User, String> tcEmailFiltredTv;

    @FXML
    private TableColumn<User, String> tcUsernameFiltredTv;
    
    //Attrinutes ArticleCellphoneBuy
    
    @FXML
    private Label lbArticleCode;

    @FXML
    private ImageView imgProductImage;

    @FXML
    private Label lbArticleName;

    @FXML
    private Label lbArticleDescription;

    @FXML
    private Label lbArticlePrice;

    @FXML
    private Label lbArticleQuantity;

    @FXML
    private Label lbArticleBattery;

    @FXML
    private Label lbArticleScreenSize;

    @FXML
    private Label lbArticleRam;

    @FXML
    private Label lbArticleProcessor;

    @FXML
    private Label lbArticleNumberSims;

    @FXML
    private Label lbArticleNumberCameras;
    
    @FXML
    private Label lbArticleNumberOfPorts;

    @FXML
    private Label lbArticleTouch;
    
    
    //Home appliances 
    @FXML
    private Label lbArticleWeight;

    @FXML
    private Label lbArticleCapacity;

    @FXML
    private Label lbArticleWattsConsumption;

    @FXML
    private Label lbArticleHeight;

    @FXML
    private Label lbArticleWidth;
    
    //Fridge

    @FXML
    private Label lbArticleSmart;

    @FXML
    private Label lbArticleFrost;
    
    //Stove
    @FXML
    private Label lbArticleNumberNozzles;

    @FXML
    private Label lbArticleStoveType;

    
    @FXML
    private TableView<Article> tvSortedArticles;

    @FXML
    private TableColumn<Article, String> tcNameSortedArticles;

    @FXML
    private TableColumn<Article, String> tcCodeSortedArticles;

    @FXML
    private TableColumn<Article, Double> tcPriceSortedArticles;

    @FXML
    private TableColumn<Article, String> tcDescriptionSortedArticles;

    @FXML
    private TableColumn<Article, Integer> tcQuantitySortedArticles;
    

    @FXML
    private TableView<Article> tvArticlesSeller;

    @FXML
    private TableColumn<Article, String>tcNameArticleSeller;

    @FXML
    private TableColumn<Article, String> tcCodeArticleSeller;

    @FXML
    private TableColumn<Article, Double> tcPriceArticleSeller;

    @FXML
    private TableColumn<Article, String> tcDescriptionArticleSeller;

    @FXML
    private TableColumn<Article, Integer> tcQuantityArticleSeller;
    
    @FXML
    private Label lbTitle;
    
    // Attributes directPurchase
    
    @FXML
    private Spinner<Integer> sQuantityBuy;

    @FXML
    private Label lbPriceToShopping;
    
    @FXML
    private TableView<UserSeller> tvUserSellerListBinary;

    @FXML
    private TableColumn<UserSeller, String> tcUsernameBinary;

    @FXML
    private TableColumn<UserSeller, String> tcIdentificationBinary;

    @FXML
    private TableColumn<UserSeller, String> tcNameBinary;

    @FXML
    private TableColumn<UserSeller, String> tcLastNameBinary;

    @FXML
    private TableColumn<UserSeller, Double> tcCalificationBinary;

    @FXML
    private TableColumn<UserSeller, Boolean> tcBanBinary;
    
    
    @FXML
    private TableView<CartItem> tvCart;

    @FXML
    private TableColumn<CartItem,String> tcNameArticleCart;

    @FXML
    private TableColumn<CartItem, String> tcCodeArticleCart;

    @FXML
    private TableColumn<CartItem, Double> tcPriceArticleCart;

    @FXML
    private TableColumn<CartItem, String> tcDescriptionArticleCart;

    @FXML
    private TableColumn<CartItem, Integer> tcQuantityArticleCart;
    
    
    private Stage modalStage;
    
    private Stage modalStageCart;
    
    
	/**
	 * Constructor of SkyMarketGUI
	 * <br><b>Pre:<b><br>
	 * <br><b>Post:<b>Initializate boot variables to start the program<br>
	 * @param sk SkyMarket principal class to manage the Program
	 */
	public SkyMarketGUI(SkyMarket sk){
		skymarket = sk;
		pb= new ProgressBar();
		serializeData();
	}
	
	/**
	 * Method to serialize the saved Data
	 * <br><b>Pre:<b>SkyMarket variable must be initializated<br>
	 * <br><b>Post:<b>Data serializated and loaded<br>
	 */
	public void serializeData(){
		try {
			skymarket.loadDataClients();
		}catch(IOException | ClassNotFoundException iocnfe) {
			serializableAlert();
		}
		
		try {
			skymarket.loadDataArticles();
		}catch(IOException | ClassNotFoundException iocnfe) {
			serializableAlert();
		}
	}
	
	/**
	 * Method to load the screen login
	 * <br><b>Pre:<b>Principal panel loaded<br>
	 * <br><b>Post:<b>A new scene in the main screen<br>
	 * @throws IOException Excepto in case fxml don't exists
	 */
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
	 
	 @FXML
	 void onEnter(ActionEvent event) throws IOException {
		 login(event);
	 }
	
	 /**
	  * Method to load progress bar at the end
	  * <br><b>Pre:<b>Main screen loaded<br>
	  * <br><b>Post:<b>ProgressBar scene loaded and show<br>
	  * @throws IOException Exception in case of fxml dont exists
	  */
	 public void loadProgressBar() throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("progress-bar.fxml"));
			
			fxmlLoader.setController(this);
			
			Parent progressPane = fxmlLoader.load();
			
			mainPanel.getChildren().clear();
	    	mainPanel.setCenter(progressPane); 	
	    	 pb.setActive(true);
			 new ProgressBarThread(pb,this).start();
			 
			 
		}
	 
	 /**
	  * Method to update the progress bar
	  * <br><b>Pre:<b>Progress bar initializated and thread<br>
	  * <br><b>Post:<b><br> ProgressBar updated status
	  */
	 public void updateBar() {
		 txtPercent.setText((pb.getProgressLevel()/3)+"%");
		 progressBar.setWidth(pb.getProgressLevel());
		 if(pb.isActive()==false) {
			 try {
				loadLogin();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
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
    
    /**
     * Method to manage the attempt of login
     * <br><b>Pre:<b>SkyMarket variable must initializated<br>
	 * <br><b>Post:<b>CurrentUser setted, Ban verified<br>
     * @param userToLogin User trying to login
     * @throws IOException Exception in case of fxml don't exists
     */
    public void loginManagement(User userToLogin) throws IOException {
    	if(userToLogin instanceof UserBuyer) {
    		loadUserBuyerScreen();
    		skymarket.setCurrentUser(userToLogin);
    	}else if(userToLogin instanceof UserSeller) {
    		if(((UserSeller) userToLogin).isBan()) {
    			userSellerBan();
    		}else {
    			loadUserSellerScreen();
        		skymarket.setCurrentUser(userToLogin);
    		}
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
        	skymarket.verifyIdentificationNotRepeat(identification);
        	skymarket.verifyUsernameNotRepeat(username);
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 0);
        	cleanFieldsRegister();
        	clientAddedAlert(username, 0);
        	skymarket.saveDataClients();
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		cleanFieldsRegister();
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		cleanFieldsRegister();
    		incorrectPasswordAlert();
    	}catch(IdentificationRepeatException ire) {
    		cleanFieldsRegister();
    		identificationRepeatAlert();
    	}catch(UsernameRepeatException unre) {
    		cleanFieldsRegister();
    		usernameRepeatAlert();
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
        	skymarket.verifyIdentificationNotRepeat(identification);
        	skymarket.verifyUsernameNotRepeat(username);
        	skymarket.newUser(name, lastName, identification, email, passwordVerify, username, pathPicture, birthday, 1);
        	cleanFieldsRegister();
        	clientAddedAlert(username, 1);
        	skymarket.saveDataClients();
        	loadLogin();
    	}catch(EmptyFieldException efe) {
    		cleanFieldsRegister();
    		fieldEmptyAlert();
    	}catch(PasswordNotEqualsException pnee) {
    		cleanFieldsRegister();
    		incorrectPasswordAlert();
    	}catch(IdentificationRepeatException ire) {
    		cleanFieldsRegister();
    		identificationRepeatAlert();
    	}catch(UsernameRepeatException unre) {
    		cleanFieldsRegister();
    		usernameRepeatAlert();
    	}
    }
    
    public void incorrectPasswordAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Contraseñas incorrectas");
    	alert.setContentText("Las contraseñas que ingreson no son iguales");
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
    void historyShopping(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showArticlesSeller.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent showArticlesPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showArticlesPane);
    	initializeTableHistoryShoppings();
    }
    
    public void initializeTableHistoryShoppings() {
    	ObservableList<Article> observableList;
    	observableList = FXCollections.observableList(skymarket.getArticlesPurchased());
    	
    	tvArticlesSeller.setItems(observableList);
    	tcNameArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Name"));
    	tcCodeArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
    	tcPriceArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Double>("Price"));
    	tcDescriptionArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Description"));
    	tcQuantityArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Integer>("Quantity"));
    	if(skymarket.getArticlesPurchased().isEmpty()) {
    		historyArticlePurchasedEmpty();
    	}
    }

    
    @FXML
    void viewListArticleForSale(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenToBuyArticles.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenToBuyArticlePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenToBuyArticlePane);
    	initializeTableBuyArticles();
    }


    public void initializeTableBuyArticles() {
    	ObservableList<Article> observableList;
    	observableList = FXCollections.observableList(skymarket.getArticles());
    	
    	tvArticlesTSUB.setItems(observableList);
    	tcNameTSUB.setCellValueFactory(new PropertyValueFactory<Article, String>("Name"));
    	tcCodeTSUB.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
    	tcPriceTSUB.setCellValueFactory(new PropertyValueFactory<Article, Double>("Price"));
    	tcDescriptionTSUB.setCellValueFactory(new PropertyValueFactory<Article, String>("Description"));
    	tcQuantityTSUB.setCellValueFactory(new PropertyValueFactory<Article, Integer>("Quantity"));
    	
    	tvArticlesTSUB.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
            	if(tvArticlesTSUB.getSelectionModel().getSelectedItem().getQuantity()==0) {
            		outOfStockAlert();
            	}else {
            		 managementArticleToBuy(tvArticlesTSUB.getSelectionModel().getSelectedItem());
            	}
              
            }
        });
        
    }
    
    

	public void managementArticleToBuy(Article article) {
    	try {
    		if(article instanceof CellPhone) {
        		CellPhone articleC = (CellPhone)(article);
    			loadCellPhoneInfoToBuy(articleC);
        	}else if(article instanceof Computer) {
        		Computer articleC = (Computer)(article);
    			loadComputerInfoToBuy(articleC);
        	}else if(article instanceof Fridge) {
        		Fridge articleC = (Fridge)(article);
    			loadFridgeInfoToBuy(articleC);
        	}else if(article instanceof Stove) {
        		Stove articleC = (Stove)(article);
    			loadStoveInfoToBuy(articleC);
        	}
    		
    		
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    public void loadStoveInfoToBuy(Stove article) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("articleStoveBuy.fxml"));

    	fxmlLoader.setController(this);

    	Parent articleStoveBuyPane = fxmlLoader.load();

    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(articleStoveBuyPane);
    	lbArticleName.setText(article.getName());
    	lbArticleDescription.setText(article.getDescription());
    	lbArticleCode.setText(article.getCode());
    	lbArticlePrice.setText(String.valueOf(article.getPrice()));
    	lbArticleQuantity.setText(String.valueOf(article.getQuantity()));
    	lbArticleWeight.setText(String.valueOf(article.getWeight()));
    	lbArticleCapacity.setText(String.valueOf(article.getCapacity()));
    	lbArticleWattsConsumption.setText(String.valueOf(article.getWattsConsum()));
    	lbArticleHeight.setText(String.valueOf(article.getHeight()));
    	lbArticleWidth.setText(String.valueOf(article.getWidth()));
    	lbArticleNumberNozzles.setText(String.valueOf(article.getNumberOfNozzles()));
    	lbArticleStoveType.setText(String.valueOf(article.getTypeStove()));
    	
    	String path = PATH_PICTURE_ARTICLES_STOVE + article.getPicture();
    	
    	System.out.println(path);
    	
    	Image newImage = new Image( new FileInputStream(path));
    
    	imgProductImage.setImage(newImage);
		
	}

	public void loadFridgeInfoToBuy(Fridge article) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("articleFridgeBuy.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent articleFridgeBuyPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(articleFridgeBuyPane);
    	lbArticleName.setText(article.getName());
    	lbArticleDescription.setText(article.getDescription());
    	lbArticleCode.setText(article.getCode());
    	lbArticlePrice.setText(String.valueOf(article.getPrice()));
    	lbArticleQuantity.setText(String.valueOf(article.getQuantity()));
    	
    	lbArticleWeight.setText(String.valueOf(article.getWeight()));
    	lbArticleCapacity.setText(String.valueOf(article.getCapacity()));
    	lbArticleWattsConsumption.setText(String.valueOf(article.getWattsConsum()));
    	lbArticleHeight.setText(String.valueOf(article.getHeight()));
    	lbArticleWidth.setText(String.valueOf(article.getWidth()));
    	lbArticleSmart.setText(String.valueOf(article.isSmartString()));
    	lbArticleFrost.setText(String.valueOf(article.isFrostString()));
    
    	
    	String path = PATH_PICTURE_ARTICLES_FRIDGE + article.getPicture();
    	
    	Image newImage = new Image( new FileInputStream(path));
    
    	imgProductImage.setImage(newImage);
		
	}

	public void loadComputerInfoToBuy(Computer article) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("articleComputerBuy.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent articleComputerBuyPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(articleComputerBuyPane);
    	lbArticleName.setText(article.getName());
    	lbArticleDescription.setText(article.getDescription());
    	lbArticleCode.setText(article.getCode());
    	lbArticlePrice.setText(String.valueOf(article.getPrice()));
    	lbArticleQuantity.setText(String.valueOf(article.getQuantity()));
    	lbArticleBattery.setText(String.valueOf(article.getBatteryWatts()));
    	lbArticleScreenSize.setText(String.valueOf(article.getScreenSize()));
    	lbArticleRam.setText(String.valueOf(article.getRam()));
    	lbArticleProcessor.setText(article.getProcessor());
    	lbArticleNumberOfPorts.setText(String.valueOf(article.getNumberOfPorts()));
    	lbArticleTouch.setText(String.valueOf(article.isTouchString()));
    	
    	String path = PATH_PICTURE_ARTICLES_COMPUTERS + article.getPicture();
    	
    	Image newImage = new Image( new FileInputStream(path));
    
    	imgProductImage.setImage(newImage);
		
	}

	public void loadCellPhoneInfoToBuy(CellPhone article) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("articleCellphoneBuy.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent articleCellphoneBuyPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(articleCellphoneBuyPane);
    	lbArticleName.setText(article.getName());
    	lbArticleDescription.setText(article.getDescription());
    	lbArticleCode.setText(article.getCode());
    	lbArticlePrice.setText(String.valueOf(article.getPrice()));
    	lbArticleQuantity.setText(String.valueOf(article.getQuantity()));
    	lbArticleBattery.setText(String.valueOf(article.getBatteryWatts()));
    	lbArticleScreenSize.setText(String.valueOf(article.getScreenSize()));
    	lbArticleRam.setText(String.valueOf(article.getRam()));
    	lbArticleProcessor.setText(article.getProcessor());
    	lbArticleNumberSims.setText(String.valueOf(article.getNumberOfSims()));
    	lbArticleNumberCameras.setText(String.valueOf(article.getNumberOfCameras()));
    	
    	String path = PATH_PICTURE_ARTICLES_CELLPHONE + article.getPicture();
    	
    	
    	Image newImage = new Image( new FileInputStream(path));
    
    	imgProductImage.setImage(newImage);
    }

    
   //methods mainScreenAdministraitor
    
    @FXML
    void ViewAllArticles(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("optionsShowArticles.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent optionShowArticlesPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(optionShowArticlesPane);
    }
    
    public void initializeTableBanUser() {
    	ObservableList <UserSeller> observableList;
    	observableList = FXCollections.observableList(skymarket.getListUsersSellers());
    	
    	tvUserSellerListB.setItems(observableList);
    	tcUsernameB.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Username"));
    	tcIdentificationB.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Identification"));
    	tcNameB.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Name"));
    	tcLastNameB.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("LastName"));
    	tcCalificationB.setCellValueFactory(new PropertyValueFactory<UserSeller, Double>("Calification"));
    	tcBanB.setCellValueFactory(new PropertyValueFactory<UserSeller,Boolean>("ban"));
    }

    @FXML
    void banUser(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("banUserScreen.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent banUserScreen = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(banUserScreen);
    	initializeTableBanUser();
    }

    @FXML
    void importData(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuImports.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent menuImportsPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(menuImportsPane);
    }

    @FXML
    public void viewAllUsers(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("optionsShowUser.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent optionsShowUserPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(optionsShowUserPane);
    }
    
    @FXML
    void exportData(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuExports.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent menuExportsPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(menuExportsPane);
    }
    
    //methods optionsShowUser
    
    @FXML
    public void showUsersByNameFromHighestToLowest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showFiltredUsers.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredUsersPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredUsersPane);
    	initializateTableFiltredUsers(1);
    }
    
    private void initializateTableFiltredUsers(int fil) {
    	ObservableList <User> observableList = null;
    	switch(fil) {
    		case 1:
    	    	observableList = FXCollections.observableList(skymarket.getListUsersFiltredNameInsertion());
    			break;
    		case 2:
    			observableList = FXCollections.observableList(skymarket.getListUsersFiltredNameSelection());
    			break;
    		case 3:
    			observableList = FXCollections.observableList(skymarket.getListUsersFiltredIdentificationBubble());
    			break;
    	}
    	tvFiltedUsers.setItems(observableList);
    	tcNameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
    	tcLastnameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("LastName"));
    	tcIdentificationFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Identification"));
    	tcEmailFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
    	tcUsernameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
    }

    @FXML
    public void showUsersByNameFromLowestToHighest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showFiltredUsers.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredUsersPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredUsersPane);
    	initializateTableFiltredUsers(2);
    }

    @FXML
    public void showUsersByNumberIdentification(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showFiltredUsers.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredUsersPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredUsersPane);
    	initializateTableFiltredUsers(3);
    }
    
    //methods optionsShowArticles
    
    @FXML
    void showArticlesByNameFromHighestToLowest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showSortedArticles.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredArticlesAZ = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredArticlesAZ);
    	initializateTableShowArticlesSorted(1);
    }
    
    public void initializateTableShowArticlesSorted(int fil) {
    	ObservableList <Article> observableList = null;
    	switch(fil) {
    		case 1:
    	    	observableList = FXCollections.observableList(skymarket.getArticlesAZ(1));
    			break;
    		case 2:
    			observableList = FXCollections.observableList(skymarket.getArticlesAZ(2));
    			break;
    		case 3:
    			observableList = FXCollections.observableList(skymarket.getArticlesPricesComparator(1));
    			break;
    		case 4:
    			observableList = FXCollections.observableList(skymarket.getArticlesPricesComparator(2));
    			break;
    	}
    	tvSortedArticles.setItems(observableList);
    	tcNameSortedArticles.setCellValueFactory(new PropertyValueFactory<Article, String>("Name"));
    	tcCodeSortedArticles.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
    	tcPriceSortedArticles.setCellValueFactory(new PropertyValueFactory<Article, Double>("Price"));
    	tcDescriptionSortedArticles.setCellValueFactory(new PropertyValueFactory<Article, String>("Description"));
    	tcQuantitySortedArticles.setCellValueFactory(new PropertyValueFactory<Article, Integer>("Quantity"));
    }

    @FXML
    void showArticlesByNameFromLowestToHighest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showSortedArticles.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredArticlesAZ = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredArticlesAZ);
    	initializateTableShowArticlesSorted(2);
    }

    @FXML
    void showArticlesByPriceFromLowestToHighest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showSortedArticles.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredArticlesAZ = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredArticlesAZ);
    	initializateTableShowArticlesSorted(4);
    }

    @FXML
    void showArticlesByPricepriceFromHighestToLowest(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showSortedArticles.fxml"));
    	fxmlLoader.setController(this);
    	Parent showFiltredArticlesAZ = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showFiltredArticlesAZ);
    	initializateTableShowArticlesSorted(3);
    }
    
    //methods banUserScreen
    
    @FXML
    public void ban(ActionEvent event) {
    	if(txtUsernameToBan != null) { 
    		if(skymarket.searchUserByIdentification(txtUsernameToBan.getText()) != null) {
    			UserSeller search = (UserSeller)(skymarket.binarySearchUser(txtUsernameToBan.getText()));
    			if(search.isBan()) {
    				search.setBan(false);
    				banConfirmationAlert(1);
    			}else {
    				search.setBan(true);
    				banConfirmationAlert(0);
    			}
    			try {
    				skymarket.saveDataClients();
    			}catch(IOException ioe) {
    				serializableAlert();
    			}
    		}else {
    			clientIdentificationAlert();
    		}
    	}else {
    		fieldEmptyAlert();
    	}
    }
    
    //methods menuImports
    
    @FXML
    void importArticles(ActionEvent event)  {
    	ArrayList<Integer> listNum  = new ArrayList<>();
    	try {
    		listNum = skymarket.importDataArticles();
    		importedSuccessfullyAlert();
    	}catch(IOException ioe) {
    		fileImportAlert();
    	}
    	if(!listNum.isEmpty()) {
    		importArticlesRepeatAlert(listNum);
    	}
    }

    @FXML
    void importUsers(ActionEvent event) {
    	ArrayList<Integer> listNum  = new ArrayList<>();
    	try {
    		listNum = skymarket.importDataClient();
    		importedSuccessfullyAlert();
    	}catch(IOException ioe) {
    		fileImportAlert();
    	}
    	if(!listNum.isEmpty()) {
    		importClientsRepeatAlert(listNum);
    	}
    }

    @FXML
    void importUsersAndArticles(ActionEvent event) {
    	ArrayList<Integer> listNum  = new ArrayList<>();
    	try {
    		listNum = skymarket.importDataClient();
    		importedSuccessfullyAlert();
    	}catch(IOException ioe) {
    		fileImportAlert();
    	}
    	if(!listNum.isEmpty()) {
    		importClientsRepeatAlert(listNum);
    	}
    	new ImportThread(skymarket).start();
    }
    
    //methods menuExports
    
    @FXML
    void exportArticles(ActionEvent event) {
    	try {
    		skymarket.exportDataArticles();
    	}catch(FileNotFoundException fnfe) {
    		fileExportAlert();
    	}
    }

    @FXML
    void exportUsers(ActionEvent event) throws FileNotFoundException  {
    	try {
    		skymarket.exportDataClients();
    	}catch(FileNotFoundException fnfe) {
    		fileExportAlert();
    	}
    }

    @FXML
    void exportUsersAndArticles(ActionEvent event) {
    	try {
    		skymarket.exportDataClients();
    	}catch(FileNotFoundException fnfe) {
    		fileExportAlert();
    	}
    	new ExportThread(skymarket).start();
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
    void historySales(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showArticlesSeller.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenSellerArticlesPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenSellerArticlesPane);
    	lbTitle.setText("Productos vendidos");
    	initializeTableSoldArticles();
    }
    
    public void initializeTableSoldArticles() {
    	ObservableList<Article> observableList;
    	observableList = FXCollections.observableList(skymarket.getArticlesSolds());
    	
    	tvArticlesSeller.setItems(observableList);
    	tcNameArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Name"));
    	tcCodeArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
    	tcPriceArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Double>("Price"));
    	tcDescriptionArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Description"));
    	tcQuantityArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Integer>("Quantity"));
    	if(skymarket.getArticlesSolds().isEmpty()) {
    		historyArticleSoldEmpty();
    	}
    }

    @FXML
    void viewListArticlesToSell(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showArticlesSeller.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenSellerArticlesPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenSellerArticlesPane);
    	lbTitle.setText("Mis productos en venta");
    	initializeTableSellerArticles();
    }

    public void initializeTableSellerArticles() {
    	ObservableList<Article> observableList;
    	observableList = FXCollections.observableList(skymarket.getArticlesSeller());
    	
    	tvArticlesSeller.setItems(observableList);
    	tcNameArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Name"));
    	tcCodeArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
    	tcPriceArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Double>("Price"));
    	tcDescriptionArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, String>("Description"));
    	tcQuantityArticleSeller.setCellValueFactory(new PropertyValueFactory<Article, Integer>("Quantity"));
	}

	@FXML
    void modifyShipping(ActionEvent event) {
    	
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
    		String pathImageArticle = txtPictureArticleNA.getText();
    		int quantity = Integer.parseInt(txtQuantityArticleNA.getText());
    		String type = cbTypeArticleNA.getValue();
    		skymarket.verificationFieldsAddArticle(nameArticle, code, priceArticle, description, pathImageArticle, quantity,type);    		
    		currentArticle = new Article(nameArticle,code,priceArticle,description,pathImageArticle,quantity);
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
    public void continueToTypeTechnology(ActionEvent event) {
    	double batteryWatts = Double.parseDouble(txtBatteryWatsNT.getText());
    	double screenSize = Double.parseDouble(txtScreenSizeNT.getText());
    	int ram = Integer.parseInt(txtRamNT.getText());
    	String processor = txtProcessorNT.getText();
    	String type = cbTypeTechnologyNT.getValue();
    	
    	currentArticle = new Technology(currentArticle.getName(),currentArticle.getCode(),currentArticle.getPrice(),currentArticle.getDescription(),currentArticle.getPicture(),currentArticle.getQuantity(),batteryWatts,screenSize,ram,processor);
    	managementAddTechnology(type);
    }
    
    public void managementAddTechnology(String type) {
     try {
    		if(type.equals("Celular")) {
        		loadScreenAddNewCellphone();
        	}else if(type.equals("Computador")) {
        		loadScreenAddNewComputer();
        	}
     	}catch(IOException ioe) {
     		fxmlNotFound();
     	}
    		
    }
    
    public void loadScreenAddNewComputer() throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewComputer.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewComputerPane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewComputerPane);
		
	}

	public void loadScreenAddNewCellphone() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewCellphone.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewCellphonePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewCellphonePane);
    }
    
    //methods screenAddNewHomeAppliances
    
    @FXML
    public void continueToTypeHomeAppliances(ActionEvent event) {
    	Double weight = Double .parseDouble(txtWeightNH.getText());
    	Double capacity = Double.parseDouble(txtCapacityNH.getText());
    	Double wattsConsum = Double.parseDouble(txtWattsConsumNH.getText());
    	Double height = Double.parseDouble(txtHeightNH.getText());
    	Double widht = Double.parseDouble(txtWidthNH.getText());
    	String type = cbTypeHomeAppliancesNH.getValue();
    	
    	currentArticle = new HomeAppliances(currentArticle.getName(),currentArticle.getCode(),currentArticle.getPrice(),currentArticle.getDescription(),currentArticle.getPicture(),currentArticle.getQuantity(),weight,capacity,wattsConsum,height,widht);
    	managementAddHomeAppliances(type);
    }
    
    public void managementAddHomeAppliances(String type) {
    	try {
    		if(type.equals("Nevera")) {
        		loadScreenAddNewFridge();
        	}else if(type.equals("Estufa")){
        		loadScreenAddNewStove();
        	}
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
  
    public void loadScreenAddNewFridge() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewFridge.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewFridgePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewFridgePane);
    }
    
    public void loadScreenAddNewStove() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewStove.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewStovePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewStovePane);
    	cbTypeStoveNS.getItems().add("ELECTRICA");
    	cbTypeStoveNS.getItems().add("GAS");
    	cbTypeStoveNS.getItems().add("ELECTRICA Y GAS");
    }
    
    //Methods screenAddNewComputer
    
    @FXML
    void addNewArticleComputer(ActionEvent event) {
    	int numberOfPorts = Integer.parseInt(txtNumberPortsPC.getText());
    	Toggle toggleTouch = tgTouch.getSelectedToggle();
    	String touchString = toggleTouch.toString();
    	boolean touch = (touchString.equals("Si"))?true:false;
    	
    	
    	Technology currentArticleT = (Technology)currentArticle;
    	Computer newComputer = new Computer(currentArticleT.getName(), currentArticleT.getCode(), currentArticleT.getPrice(), currentArticleT.getDescription(), currentArticleT.getPicture(), currentArticleT.getQuantity(), currentArticleT.getBatteryWatts(), currentArticleT.getScreenSize(), currentArticleT.getRam(), currentArticleT.getProcessor(),numberOfPorts,touch);
    	
    	String username = skymarket.getCurrentUser().getUsername();
    	newComputer.setNameSeller(username);
    	
    	addNewArticle(newComputer);
    	
    	try {
    		loginManagement(skymarket.getCurrentUser());
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    //methods screenAddNewCellphone
    
    @FXML
    public void addNewArticleCellphone(ActionEvent event) {
    	int numberSims = Integer.parseInt(txtNumberSimsNC.getText());
    	int numberCameras = Integer.parseInt(txtNumberCameraNC.getText());
    	
    	Technology currentArticleT = (Technology)currentArticle;
    	CellPhone newCellphone = new CellPhone(currentArticleT.getName(), currentArticleT.getCode(), currentArticleT.getPrice(), currentArticleT.getDescription(), currentArticleT.getPicture(), currentArticleT.getQuantity(), currentArticleT.getBatteryWatts(), currentArticleT.getScreenSize(), currentArticleT.getRam(), currentArticleT.getProcessor(), numberSims, numberCameras);
    	
    	String username = skymarket.getCurrentUser().getUsername();
    	newCellphone.setNameSeller(username);
    	
    	addNewArticle(newCellphone);
    	
    	try {
    		loginManagement(skymarket.getCurrentUser());
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    //methods screenAddNewFridge
    
    @FXML
    public void addNewArticleFridge(ActionEvent event) {
    	Toggle toggleSmart = tgSmart.getSelectedToggle();
    	String smartString = toggleSmart.toString();
    	boolean smart = (smartString.equals("Si"))?true:false;
    	Toggle toggleFrost = tgFrost.getSelectedToggle();
    	String frostString = toggleFrost.toString();
    	boolean frost = (frostString.equals("Si"))?true:false;
    	
    	HomeAppliances currentArticleH = (HomeAppliances) currentArticle;
    	Fridge newFridge = new Fridge(currentArticleH.getName(), currentArticleH.getCode(), currentArticleH.getPrice(), currentArticleH.getDescription(), currentArticleH.getPicture(), currentArticleH.getQuantity(), currentArticleH.getWeight(), currentArticleH.getCapacity(), currentArticleH.getWattsConsum(), currentArticleH.getHeight(), currentArticleH.getWidth(), smart, frost);
    	
    	String username = skymarket.getCurrentUser().getUsername();
    	newFridge.setNameSeller(username);
    	
    	addNewArticle(newFridge);
    	
    	try {
    		loginManagement(skymarket.getCurrentUser());
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    //methods screenAddNewStove
    
    @FXML
    public void addNewArticleStove(ActionEvent event) {
    	int numberOfNozzles = Integer.parseInt(txtNumberNozzlesNS.getText());
    	String typeStove = cbTypeStoveNS.getValue();
    	
    	HomeAppliances currentArticleH = (HomeAppliances) currentArticle;
    	Stove newStove = new Stove(currentArticleH.getName(), currentArticleH.getCode(), currentArticleH.getPrice(), currentArticleH.getDescription(), currentArticleH.getPicture(), currentArticleH.getQuantity(), currentArticleH.getWeight(), currentArticleH.getCapacity(), currentArticleH.getWattsConsum(), currentArticleH.getHeight(), currentArticleH.getWidth(), numberOfNozzles , typeStove);
    	
    	String username = skymarket.getCurrentUser().getUsername();
    	newStove.setNameSeller(username);
    	
    	addNewArticle(newStove);
    	
    	try {
    		loginManagement(skymarket.getCurrentUser());
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    //methods articleCellphoneBuy
    
    @FXML
    void btnBuyButton(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("directPurchase.fxml")); 
    	
    	fxmlLoader.setController(this);
    	
    	Parent directPurchasePane = fxmlLoader.load();
    	
    	modalStage = new Stage();
    	modalStage.setScene(new Scene(directPurchasePane));
    	modalStage.setTitle("Compra");
    	modalStage.initModality(Modality.WINDOW_MODAL);
    	
    	modalStage.show();
    	SpinnerValueFactory<Integer> s = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.parseInt(lbArticleQuantity.getText()));
    	sQuantityBuy.setValueFactory(s);
    	lbPriceToShopping.setText(lbArticlePrice.getText());
    }
    
    @FXML
    void createBinaryTreeBtn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showSellersByCalification.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent showUsersByCalificationScreen = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(showUsersByCalificationScreen);
    	initializateTableUsersBinaryTree();
    }
    
    private void initializateTableUsersBinaryTree() {
    	ObservableList <UserSeller> observableList;
    	observableList = FXCollections.observableList(skymarket.getBinaryList());
    	
    	tvUserSellerListBinary.setItems(observableList);
    	tcUsernameBinary.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Username"));
    	tcIdentificationBinary.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Identification"));
    	tcNameBinary.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("Name"));
    	tcLastNameBinary.setCellValueFactory(new PropertyValueFactory<UserSeller, String>("LastName"));
    	tcCalificationBinary.setCellValueFactory(new PropertyValueFactory<UserSeller, Double>("Calification"));
    	tcBanBinary.setCellValueFactory(new PropertyValueFactory<UserSeller,Boolean>("Ban"));
    }
    
    @FXML
    void testClic(MouseEvent event) {
    	double temp = Double.parseDouble(lbArticlePrice.getText());
    	Long newPrice = sQuantityBuy.getValue()*Math.round(temp);
    	lbPriceToShopping.setText(String.valueOf(newPrice));
    }
    
    
    //Cart Methods

    @FXML
    void btnBuyFromCart(ActionEvent event) {

    }
    

    @FXML
    void viewCart(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cartViewBuyer.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent cartView = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(cartView);
    	initializateTableCartBinaryTree();
    }
    
    
    public void initializateTableCartBinaryTree() {
    	ObservableList<CartItem> observableList;
    	observableList = FXCollections.observableList(skymarket.getBinaryListCart());
    	
    	tvCart.setItems(observableList);
    	tcNameArticleCart.setCellValueFactory(new PropertyValueFactory<CartItem, String>("Name"));
    	tcCodeArticleCart.setCellValueFactory(new PropertyValueFactory<CartItem, String>("Code"));
    	tcPriceArticleCart.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("Price"));
    	tcDescriptionArticleCart.setCellValueFactory(new PropertyValueFactory<CartItem, String>("Description"));
    	tcQuantityArticleCart.setCellValueFactory(new PropertyValueFactory<CartItem, Integer>("Quantity"));
		
	}

	@FXML
    void btnAddToCartModal(ActionEvent event) throws IOException {
    	addToCartAlert();
    }
    
   

	public void cartAdder() throws IOException {
    	Article articleToBuy = skymarket.searchArticleByCode(lbArticleCode.getText());
    	int quantity=sQuantityBuy.getValue();
    	CartItem ci= new CartItem(articleToBuy,quantity);
    	try {
			skymarket.addCartItemTree(ci,articleToBuy.getQuantity());
			cartSuccessfulAlert();
		} catch (CartQuantityException e) {
			cartQuantityAlert();
		}
    }
    
    
    @FXML
    void btnAddToCart(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addToCartModal.fxml")); 
    	
    	fxmlLoader.setController(this);
    	
    	Parent addToCartPane = fxmlLoader.load();
    	
    	modalStageCart = new Stage();
    	modalStageCart.setScene(new Scene(addToCartPane));
    	modalStageCart.setTitle("Agregar al Carrito");
    	modalStageCart.initModality(Modality.WINDOW_MODAL);
    	
    	modalStageCart.show();
    	SpinnerValueFactory<Integer> s = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.parseInt(lbArticleQuantity.getText()));
    	sQuantityBuy.setValueFactory(s);
    	lbPriceToShopping.setText(lbArticlePrice.getText());
    }
    
    public void buyArticleAdder(int calification) throws CloneNotSupportedException {
    	Article articleToBuy = skymarket.searchArticleByCode(lbArticleCode.getText());
    	articleToBuy.setQuantity(articleToBuy.getQuantity()-sQuantityBuy.getValue());
    	
    	Article newArticleBuy = articleToBuy.clone();
    	Article newArticleBuy2 = articleToBuy.clone();
    	newArticleBuy.setQuantity(sQuantityBuy.getValue());
    	newArticleBuy.setNextArticle(null);
    	newArticleBuy2.setQuantity(sQuantityBuy.getValue());
    	newArticleBuy2.setNextArticle(null);
    	skymarket.addArticleSoldToSeller(articleToBuy.getNameSeller(), newArticleBuy2);
    	skymarket.addArticleBuyToBuyer(newArticleBuy);
    	UserSeller u = skymarket.searchUserByIdentification(articleToBuy.getNameSeller());
    	u.changeCalification(calification);
    }
    
    //methods directPurchase
    
    @FXML
    void buyArticleDirect(ActionEvent event) throws CloneNotSupportedException, IOException {
    	buyArticleAlert();
    }
    
    //methods share screenAddNewCellphone, screenAddNewFridge, screenAddNewStove
    
    public void addNewArticle(Article newArticle) {
    	try {
    		skymarket.addNewArticleToArticles(newArticle);
    		skymarket.addNewArticleToUserSeller(skymarket.getCurrentUser().getUsername(), newArticle);
    		skymarket.saveDataClients();
    		skymarket.saveDataArticles();
    	}catch(RepeatArticleCodeException race) {
    		newArticle.setCode(skymarket.generateRandomNumber());
    		addNewArticle(newArticle);
    	}catch(IOException ioe) {
    		
    	}
    }
    
    
    /*
     *  :::::::::::::/”\:::::::::::::::::
		::::::::::::|\:/|::::::::::::::::
		::::::::::::|:::|::::::::::::::::
		::::::::::::|:~:|::::::::::::::::
		::::::::::::|:::|::::::::::::::::
		:::::::::/’\|:::|/’\:::::::::::::
		:::::/”\|:::|:::|:::|:\::::::::::
		::::|::::[@]:::|:::|::::\:::::::::
		::::|:::|:::|:::|:::|:::\::::::::
		::::|:~:~::~::~:|:::::::)::::::::
		::::|:::::::::::::::::::/::::::::
		:::::\:::::::::::::::::/:::::::::
		::::::\:::::::::::::::/::::::::::
		:::::::\::::_______::/:::::::::::::
		::::::::|__–//”`\–::|:::::::::::::
		::::::::|  ((:+=))::|:::::::::::::
		::::::::|:–-\_|_//–:|:::::::::::::
     */
    
    
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
    	skymarket.resetCart();
    }
    
    //Alerts
    
    public void fieldEmptyAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Campo vacío");
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

    public void clientIdentificationAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("No se encontro el usuario");
    	alert.setContentText("No se encontro el usuario o puede no existir");
    	alert.showAndWait();
    }
    
    public void userSellerBan() {
    	Alert alert= new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("Su usuario se encuentra baneado");
    	alert.setContentText("En estos momentos usted se encuentra baneado, comuniquese con el administrador de la pagina para mas información");
    	alert.showAndWait();
    }
    
    public void banConfirmationAlert(int t) {
    	if(t == 0) {
    		Alert alert= new Alert(AlertType.INFORMATION);
        	alert.setHeaderText("Baneado correctamente");
        	alert.setContentText("El usuario que usted digito se baneo exitosamente");
        	alert.showAndWait();
    	}else if(t == 1){
    		Alert alert= new Alert(AlertType.INFORMATION);
        	alert.setHeaderText("Desbaneado correctamente");
        	alert.setContentText("El usuario que usted digito se desbaneo exitosamente");
        	alert.showAndWait();
    	}
    }

    public void serializableSaveAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("No es posible serializar");
    	alert.setContentText("No es posible guardar la informacion en un archivo serializable");
    	alert.showAndWait();
    }
    
    public void fileExportAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Archivo para exportar no encontrado");
    	alert.setContentText("El archivo o la ruta en la que se deseaba exportar no existe");
    	alert.showAndWait();
    }
    
    public void fileImportAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Archivo para importar no encontrado");
    	alert.setContentText("El archivo o la ruta en la que se deseaba importar no existe");
    	alert.showAndWait();
    }
    
    public void importClientsRepeatAlert(ArrayList<Integer> listNum) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Usuarios no importados");
    	String alertText = "En las lineas ";
    	
    	for(int i = 0; i<listNum.size();i++) {
    		if(i == listNum.size()-1) {
    			alertText += String.valueOf(listNum.get(i)) + " ";
    		}else {
    			alertText += String.valueOf(listNum.get(i)) + ",";
    		}
    	}
    	
    	alertText += "el numero de identificacion o nombre de usuario se repitieron";
    	alert.setContentText(alertText);
    	alert.showAndWait();
    }
    
    public void importArticlesRepeatAlert(ArrayList<Integer> listNum) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Articulos no importados");
    	String alertText = "En las lineas ";
    	
    	for(int i = 0; i<listNum.size();i++) {
    		if(i == listNum.size()-1) {
    			alertText += String.valueOf(listNum.get(i)) + " ";
    		}else {
    			alertText += String.valueOf(listNum.get(i)) + ",";
    		}
    	}
    	
    	alertText += "el codigo de articulo ya existe";
    	alert.setContentText(alertText);
    	alert.showAndWait();
    }
    
    public void usernameRepeatAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("Usuario repetido");
    	alert.setContentText("El nombre de usuario con el que intento registrarse ya esta en uso");
    	alert.showAndWait();
    }
    
    public void identificationRepeatAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("Identificacion repetida");
    	alert.setContentText("El numero de identificacion con la que intento registrarse ya esta en uso");
    	alert.showAndWait();
    }
    
    public void importedSuccessfullyAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("Importación completada");
    	alert.setContentText("Los datos fueron importados de manera exitosa");
    	alert.showAndWait();
    }
    
    public void buyArticleAlert() throws CloneNotSupportedException, IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("¿Esta seguro de comprar el articulo?");
    	alert.setContentText("Confirme si desea llevar el articulo que selecciono");
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		int calification = 0;
    		calification = buySuccessfulAlert();
    		buyArticleAdder(calification);
    		modalStage.close();
    	} 
    	
    }
    
    public void addToCartAlert() throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("¿Esta seguro de que quiere agregar al carrito?");
    	alert.setContentText("Confirme si desea agregar el articulo que selecciono");
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		cartAdder();
    		modalStageCart.close();
    	} 
		
	} 
    
    public void cartQuantityAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Cantidad no disponible");
    	alert.setContentText("La cantidad que desea pedir excede la cantidad disponible incluyendo los items en tu carrito");
    	alert.showAndWait();
		
	}
    public void cartSuccessfulAlert() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("Articulo agregado al carrito exitosamente");
    	alert.setContentText("El articulo fue agregado al carrito de manera exitosa");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		loginManagement(skymarket.getCurrentUser());
    	}
		
	}

	public void outOfStockAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Articulo no disponible");
    	alert.setContentText("No se encuentran cantidades disponibles");
    	alert.showAndWait();
		
	}
    
    public int buySuccessfulAlert() throws IOException {
    	int calification = 0;
    	ArrayList<Integer> choices = new ArrayList<>();
    	choices.add(1);
    	choices.add(2);
    	choices.add(3);
    	choices.add(4);
    	choices.add(5);

    	ChoiceDialog<Integer> dialog = new ChoiceDialog<>(5, choices);
    	dialog.setTitle("Compra exitosa");
    	dialog.setHeaderText("Su compra fue realizada exitosamente");
    	dialog.setContentText("Califica tu vendedor:");

    	
    	Optional<Integer> result = dialog.showAndWait();
    	if (result.isPresent()){
    		//Capturar la calificacion
    		calification = result.get();
    		loginManagement(skymarket.getCurrentUser());
    		
    	}
    	return calification;
    }
    
    public void historyArticleSoldEmpty() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Lista vacia");
    	alert.setContentText("No ha vendido articulos aun");
    	alert.showAndWait();
    }
    
    public void historyArticlePurchasedEmpty() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText("Lista vacia");
    	alert.setContentText("No ha comprado articulos aun");
    	alert.showAndWait();
    }
}
