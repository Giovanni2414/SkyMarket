package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

import Exceptions.EmptyFieldException;
import Exceptions.PasswordNotEqualsException;
import Exceptions.RepeatArticleCodeException;
import Model.Article;
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
import Thread.ProgressBarThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

import javafx.event.EventHandler;

public class SkyMarketGUI {
	
	private final static String PATH_PICTURE_PEOPLE = "data/picturesPeople/";
	
	private Article currentArticle;

	private SkyMarket skymarket;
	
	
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
    
	//Constructor
	public SkyMarketGUI(SkyMarket sk){
		skymarket = sk;
		pb= new ProgressBar();
		serializeData();
	}
	
	public void serializeData(){
		try {
			skymarket.loadDataClients();
		}catch(IOException | ClassNotFoundException iocnfe) {
			serializableAlert();
		}
		
		try {
			skymarket.loadDataArticles();
		}catch(IOException | ClassNotFoundException iocnfe) {
			iocnfe.printStackTrace();
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
	
	 //ProgressBar Methods
	 
	 public void loadProgressBar() throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("progress-bar.fxml"));
			
			fxmlLoader.setController(this);
			
			Parent progressPane = fxmlLoader.load();
			
			mainPanel.getChildren().clear();
	    	mainPanel.setCenter(progressPane); 	
	    	 pb.setActive(true);
			 new ProgressBarThread(pb,this).start();
			 
			 
		}
	 
	 
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
        	skymarket.saveDataClients();
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
    void historyShopping(ActionEvent event) {
    	skymarket.test();
    }

    @FXML
    void viewBasket(ActionEvent event) {
    	skymarket.crearAdministrador();
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
    	/*
    	tvArticlesTSUB.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //managementArticleToBuy(tvArticlesOnSale.getSelectionModel().getSelectedItem());
            }
        });
        */
    }
    
    public void managementArticleToBuy(Article article) {
    	try {
    		if(article instanceof CellPhone) {
        		CellPhone articleC = (CellPhone)(article);
    			loadCellPhoneInfoToBuy(articleC);
        	}
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
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
    	tvUserSellerListB.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                System.out.println("clicked on " + tvUserSellerListB.getSelectionModel().getSelectedItem());
            }
        });
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
    			
    			break;
    	}
    	tvFiltedUsers.setItems(observableList);
    	tcNameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
    	tcLastnameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Lastname"));
    	tcIdentificationFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Identification"));
    	tcEmailFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
    	tcUsernameFiltredTv.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
    }

    @FXML
    public void showUsersByNameFromLowestToHighest(ActionEvent event) {

    }

    @FXML
    public void showUsersByNumberIdentification(ActionEvent event) {

    }
    
    //methods optionsShowArticles
    
    @FXML
    void showArticlesByNameFromHighestToLowest(ActionEvent event) {

    }

    @FXML
    void showArticlesByNameFromLowestToHighest(ActionEvent event) {

    }

    @FXML
    void showArticlesByPriceFromLowestToHighest(ActionEvent event) {

    }

    @FXML
    void showArticlesByPricepriceFromHighestToLowest(ActionEvent event) {

    }
    
    //methods banUserScreen
    
    @FXML
    public void ban(ActionEvent event) {
    	if(txtUsernameToBan != null) { 
    		if(skymarket.searchUserByIdentification(txtUsernameToBan.getText()) != null) {
    			UserSeller search = (UserSeller)(skymarket.binarySearchUser(txtUsernameToBan.getText()));
    			search.setBan(true);
    		}else {
    			clientIdentificationAlert();
    		}
    	}else {
    		fieldEmptyAlert();
    	}
    }
    
    //methods menuImports
    
    @FXML
    void importArticles(ActionEvent event) {

    }

    @FXML
    void importUsers(ActionEvent event) {

    }

    @FXML
    void importUsersAndArticles(ActionEvent event) {

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
    	skymarket.test();
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
    	int screenSize = Integer.parseInt(txtScreenSizeNT.getText());
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
        		
        	}
     	}catch(IOException ioe) {
     		fxmlNotFound();
     	}
    		
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
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenAddNewFridge.fxml"));
    	
    	fxmlLoader.setController(this);
    	
    	Parent screenAddNewFridgePane = fxmlLoader.load();
    	
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(screenAddNewFridgePane);
    }
    
    //Methods screenAddNewComputer
    
    @FXML
    void addNewArticleComputer(ActionEvent event) {
    	int numberOfPorts = Integer.parseInt(txtNumberPortsPC.getText());
    	Toggle toggleTouch = tgTouch.getSelectedToggle();
    	String touchString = toggleTouch.toString();
    	boolean touch = (touchString.equals("Si"))?true:false;
    	
    	
    	Technology currentArticleT = (Technology)currentArticle;
    	Computer newComputer = new Computer(currentArticleT.getName(), currentArticleT.getCode(), currentArticleT.getPrice(), currentArticleT.getDescription(), currentArticleT.getPicture(), currentArticleT.getQuantity(), currentArticleT.getBatteryWatts(), currentArticleT.getScreenSize(), currentArticleT.getRam(), currentArticleT.getProcessor(),numberOfPorts,touch );
    	
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
    	Stove newFridge = new Stove(currentArticleH.getName(), currentArticleH.getCode(), currentArticleH.getPrice(), currentArticleH.getDescription(), currentArticleH.getPicture(), currentArticleH.getQuantity(), currentArticleH.getWeight(), currentArticleH.getCapacity(), currentArticleH.getWattsConsum(), currentArticleH.getHeight(), currentArticleH.getWidth(), numberOfNozzles , typeStove);
    	
    	addNewArticle(newFridge);
    	
    	try {
    		loginManagement(skymarket.getCurrentUser());
    	}catch(IOException ioe) {
    		fxmlNotFound();
    	}
    }
    
    //methods articleCellphoneBuy
    
    @FXML
    void btnBuyButton(ActionEvent event) {

    }
    
    //methods share screenAddNewCellphone, screenAddNewFridge, screenAddNewStove
    
    public void addNewArticle(Article newArticle) {
    	try {
    		skymarket.addNewArticleToArticles(newArticle);
    		skymarket.addNewArticleToUserSeller(skymarket.getCurrentUser().getUsername(), newArticle);
    		skymarket.saveDataArticles();
    	}catch(RepeatArticleCodeException race) {
    		newArticle.setCode(skymarket.generateRandomNumber());
    		addNewArticle(newArticle);
    	}catch(IOException ioe) {
    		
    	}
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


    public void serializableSaveAlert() {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setHeaderText("No es posible serializar");
    	alert.setContentText("No es posible guardar la informacion en un archivo serializable");
    	alert.showAndWait();
    }

}
