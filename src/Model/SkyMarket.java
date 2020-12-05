package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Exceptions.EmptyFieldException;
import Exceptions.IdentificationRepeatException;
import Exceptions.PasswordNotEqualsException;
import Exceptions.RepeatArticleCodeException;
import Exceptions.UsernameRepeatException;

public class SkyMarket {

	/**
	 * Constant of path serializable users
	 */
	public final static String FILE_SERIALIZABLE_USERS = "data/serializableData/clientsData.ap2";
	
	/**
	 * Constant of path serializable articles
	 */
	public final static String FILE_SERIALIZABLE_ARTICLE = "data/serializableData/articlesData.ap2";
	
	/**
	 * Constant of path for export data users
	 */
	public final static String FILE_DATA_EXPORT_USERS = "data/exportData/usersData.csv";
	
	/**
	 * Constant of path for export data articles
	 */
	public final static String FILE_DATA_EXPORT_ARTICLES = "data/exportData/articlesData.csv";
	
	/**
	 * Constant of path for import data articles
	 */
	public final static String FILE_DATA_IMPORT_CLIENTS = "data/importData/clientsData.csv";
	
	/**
	 * Constant of path for import data articles
	 */
	public final static String FILE_DATA_IMPORT_ARTICLES = "data/importData/articlesData.csv";
	
	/**
	 * The current user logged in the program
	 */
	private User currentUser;
	
	/**
	 * Linked list with the users created on the application
	 */
	private LinkedList<User> users;
	
	/**
	 * Linked list with the products to sell
	 */
	public LinkedList<Article> articles;
	
	/**
	 * Root of binary tree
	 */
	private UserSeller rootSeller;
	
	/**
	 * List
	 */
	ArrayList<UserSeller> binaryList = new ArrayList<>();
	
	/**
	 * Constructor of SkyMarket, set the currentUser on null
	 * <br>Pre:<b></b>
	 * <br>Post:<b>object of SkyMarket with currentUser started in null</b>
	 */
	public SkyMarket() {
		currentUser = null;
		users = new LinkedList<>();
		setArticles(new LinkedList<>());
		rootSeller = null;
	}
	
	/**
	 * Method to verify password
	 * <br>Pre:<b>password diferent to null</b>
	 * <br>Post:<b>the password are the same</b>
	 * @param  password password of the user
	 * @param  passwordVerify password to verify to the user
	 */
	public void verificationPasswords(String password, String passwordVerify) throws PasswordNotEqualsException{
		if(!password.equals(passwordVerify)) {
			throw new PasswordNotEqualsException();
		}
	}
	
	/**
	 * Orchest the creation of the binary tree and
	 * <br>Pre:<b></b>
	 * <br>Post:<b> Binary tree created and ArrayList global binaryList filled</b>
	 * @return The List of UsersSellers after the creation of the binary tree
	 */
	public ArrayList<UserSeller> getBinaryList() {
		rootSeller = null;
		binaryList.clear();
		createBinaryTreeCalification();
		createListBinary(rootSeller);
		return binaryList;
	}
	
	/**
	 * Add the binary tree users into an ArrayList global to return
	 * <br>Pre:<b> ArrayList global binaryList must be initializated</b>
	 * <br>Post:<b> Objects added into the global ArrayList bianryList</b>
	 * @param u The actual user to value
	 */
	public void createListBinary(UserSeller u) {
		if(u!=null) {
			createListBinary(u.getRight());
			binaryList.add(u);
			createListBinary(u.getLeft());
		}
	}
	
	/**
	 * Candidate method to create a new binary tree with users, criteria = calification
	 * <br>Pre:<b></b>
	 * <br>Post:<b> The global temp list initializated again and </b>
	 */
	public void createBinaryTreeCalification() {
		ArrayList<UserSeller> tempList = new ArrayList<>();
		for(int c = 0; c < users.size(); c++) {
			if(users.get(c) instanceof UserSeller) {
				UserSeller u = (UserSeller) users.get(c);
				u.setRight(null);
				u.setLeft(null);
				u.setFather(null);
				tempList.add(u);
			}
		}
		for(int c = 0; c < tempList.size(); c++) {
			addSellerBinaryTree(tempList.get(c));
		}
	}
	
	/**
	 * Method to add an UserSeller into a binary tree
	 * <br>Pre:<b></b>
	 * <br>Post:<b> A new user added into the binary tree</b>
	 * @param u The new user to add
	 */
	private void addSellerBinaryTree(UserSeller u) {
		if(getRootSeller() == null) {
			setRootSeller(u);
		} else {
			addSellerBinaryTree(getRootSeller(), u);
		}
	}
	
	/**
	 * MEthod to add an UserSeller into a binary tree
	 * <br>Pre:<b></b>
	 * <br>Post:<b> New user added to the binary tree</b>
	 * @param miracle The actual node to value
	 * @param u The new user to add
	 */
	private void addSellerBinaryTree(UserSeller miracle, UserSeller u) {
		if(miracle.getCalification()>=u.getCalification()) {
            if(miracle.getLeft()==null) {
            	miracle.setLeft(u);
                u.setFather(miracle);
            }else {
            	addSellerBinaryTree(miracle.getLeft(),u);
            }
        }else {
            if(miracle.getRight()==null) {
            	miracle.setRight(u);
                u.setFather(miracle);
            }else {
            	addSellerBinaryTree(miracle.getRight(),u);
            }
        }
	}
	
	/**
	 * Method to verify info of register
	 * <br>Pre:<b> </b>
	 * <br>Post:<b>the info  to register is not null</b>
	 * @param name Name of the user
	 * @param lastname LastName of the user
	 * @param identification Identification of the user
	 * @param password Password of login from the new user
	 * @param username Username of the user
	 * @param picture Picture of the user
	 * @param type Type of account, 0 = Buyer, 1 = Seller, 2 = Admin
	 */
	public void verificationFieldsRegister(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) throws EmptyFieldException{
		if(name==null || lastName == null ||identification == null || email == null || password == null || username == null || picture == null || birthday == null) {
			throw new EmptyFieldException();
		}
	}
	
	/**
	 * Method to add a new registered user
	 * <br>Pre:<b>LinkedList users must be initializated</b>
	 * <br>Post:<b>New object of User added to users linked list</b>
	 * @param name Name of the user
	 * @param lastname Lastname of the user
	 * @param identification Identification of the user
	 * @param password Password of login from the new user
	 * @param username Username of the user
	 * @param picture Picture of the user
	 * @param type Type of account, 0 = Buyer, 1 = Seller, 2 = Admin
	 */
	public void newUser(String name, String lastname, String identification,String email, String password, String username, String picture, LocalDate birthday,int type) {
		User newUserObject = null;
		if(type == 0) {
			newUserObject = new UserBuyer(name, lastname, identification, email, password, username, picture,birthday);
		} else if(type == 1) {
			newUserObject = new UserSeller(name, lastname, identification, email, password, username, picture,birthday);
		} else if(type == 3) {
			newUserObject = new Administraitor(name, lastname, identification, email, password, username, picture,birthday,users);
		}
		if(users.isEmpty()) {
			users.add(newUserObject);
		} else {
			int c = 0;
			while(c < users.size() && comparatorAddUser(username, (users.get(c)).getUsername()) >= 1) {
				c++;
			}
			users.add(c, newUserObject);
		}
	}
	
	/**
	 * Method to logout from the application with the put of currentUser = null
	 * <br>Pre:<b>currentUser must be different of null</b>
	 * <br>Post:<b>currentUser setted on null</b>
	 */
	public void logout() {
		if(currentUser != null) {
			currentUser = null;
		}
	}
	
	/**
	 * Comparator to add users in order
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param username1 First name to compare
	 * @param username2 Second name to compare
	 * @return Return a number with the comparation of compareToIgnoreCase
	 */
	private int comparatorAddUser(String username1, String username2) {
		return username1.compareToIgnoreCase(username2);
	}
	
	/**
	 * Binary search to get an user using the username
	 * <br>Pre:<b>users must be initializated</b>
	 * <br>Post:<b></b>
	 * @param username Username of user to search
	 * @return Return the user if exists
	 */
	public User binarySearchUser(String username) {
		User userSeek = null;
		if(users.size() > 0) {
			boolean find = false;
			int in = 0;
			int fin = users.size();
			
			while(in <= fin && !find) {
				int pos = (int) Math.floor((in+fin)/2);
				if(pos != users.size()) {
					String el = users.get(pos).getUsername();
					int compar = username.compareToIgnoreCase(el);
					if(compar == 0) {
						userSeek = users.get(pos);
						find = true;
					} else if(compar < 0) {
						fin = pos - 1;
					} else if(compar > 0) {
						in = pos + 1;
					}
				}
			}
		}
		return userSeek;
	}
	
	/**
	 * Method to search an user using the identification
	 * <br>Pre:<b>List of users must be initializated</b>
	 * <br>Post:<b></b>
	 * @param username Username to search
	 * @return Return the users finded or null
	 */
	public UserSeller searchUserByIdentification(String username) {
		LinkedList<UserSeller> list = getListUsersSellers();
		UserSeller search = null; 
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getUsername().equals(username)) {
				search = list.get(i);
			}
		}
		
		return search;
	}

	/**
	 * Method to set an user in currentUser and login into the application
	 * <br>Pre:<b></b>
	 * <br>Post:<b>currentUser change to the user logged or not</b>
	 * @param username Username from the user was trying to login
	 * @param password Password from the user was trying to login
	 */
	public void login(String username, String password) {
		User tryUse = binarySearchUser(username);
		if(tryUse != null) {
			if(tryUse.getPassword().equals(password)) {
				setCurrentUser(tryUse);
			} else {
				//Falta acción en caso de que no
			}
		}
	}
	
	/**
	 * Method helper to add a new article into articles list
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param newArticle
	 * @throws RepeatArticleCodeException
	 */
	public void addNewArticleToArticles(Article newArticle) throws RepeatArticleCodeException{
		for(int i = 0; i < articles.size(); i++) {
			if(newArticle.getCode().equals(articles.get(i).getCode())) {
				throw new RepeatArticleCodeException();
			}
		}
		articles.add(newArticle);
	}
	
	/**
	 * Method to add a new article in sale
	 * <br>Pre:<b> ArrayList of users and articles must be initializated</b>
	 * <br>Post:<b> A new article to sale has been added</b>
	 * @param username The username of the user seller
	 * @param newArticle The new article to add
	 */
	public void addNewArticleToUserSeller(String username, Article newArticle) {
		boolean find = false; 
		UserSeller user = null;
		while(!find) {
			for(int i = 0; i<users.size();i++) {
				if(username.equals(users.get(i).getUsername())) {
					user = (UserSeller) users.get(i);
					find = true;
				}
			}
		}
		user.addArticleToSellArticles(newArticle);
	}
	
	/**
	 * Getter of users linked list
	 * <br>Pre:<b>LinkedList users must be initializated</b>
	 * <br>Post:<b></b>
	 * @return LinkedList of users registered in the application
	 */
	public LinkedList<User> getUsers() {
		return users;
	}
	
	/**
	 * Setter of users linked list
	 * <br>Pre:<b></b>
	 * <br>Post:<b>The linked list of users setted</b>
	 * @param newList The new list of users
	 */
	public void setUsers(LinkedList<User> newList) {
		users = newList;
	}
	
	/**
	 * Getter of currentUser
	 * <br>Pre:<b>currentUser must be initializated</b>
	 * <br>Post:<b></b>
	 * @return currentUser the actual user logged in the application
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	
	/**
	 * Setter of currentUser
	 * <br>Pre:<b></b>
	 * <br>Post:<b>The current user change with the new received from parameter</b>
	 * @param newUser The new user logged in the program
	 */
	public void setCurrentUser(User newUser) {
		currentUser = newUser;
	}
	
	/**
	 * Getter of articles
	 * <br>Pre:<b>Linked list articles must be initializated</b>
	 * <br>Post:<b></b>
	 * @return The list of articles
	 */
	public LinkedList<Article> getArticles() {
		return articles;
	}

	
	
	/**
	 * Setter of articles
	 * <br>Pre:<b></b>
	 * <br>Post:<b>Setted a new list of articles</b>
	 * @param articles The new list of articles to set
	 */
	public void setArticles(LinkedList<Article> articles) {
		this.articles = articles;
	}
	
	/**
	 * generateRandomNumber
	 * <br>Pre:<b></b>
	 * <br>Post:<b>Generated a new random number
	 * @return new code String, is a new number generated automatic
	 */
	public String generateRandomNumber() {
		int number = (int)(Math.random()*((99999999+1)-10000000)+10000000);
		String newCode = String.valueOf(number);
		return newCode;
	}
	
	/**
	 * verificationFieldsAddArticle
	 * <br>Pre:<b></b>
	 * <br>Post:<b>check the content of the fields to add a new article</b>
	 */
	public void verificationFieldsAddArticle(String name,String code,double price, String description, String picture, int quantity,String type) throws EmptyFieldException{
		if(name == null || code == null || price == 0  || description == null || picture == null || quantity == 0 || type == null) {
			throw new EmptyFieldException();
		}
	}
	
	/**
	 * Method to get the list of users sorted using algorithm of insertion
	 * <br>Pre:<b> users ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A sorted list of users
	 */
	public LinkedList<User> getListUsersFiltredNameInsertion() {
		LinkedList<User> list = new LinkedList<>();
		User[] tempArr = users.toArray(new User[users.size()]);
		for(int c = 0; c < tempArr.length; c++) {
			User key = tempArr[c];
			int i = c - 1;
			while((i > -1) && ((tempArr[i].getName()).compareToIgnoreCase(key.getName()) > 0)) {
				tempArr[i + 1] = tempArr[i];
				i--;
			}
			tempArr[i + 1] = key;
		}
		for(int c = 0; c < tempArr.length; c++) {
			list.add(tempArr[c]);
		}
		return list;
	}
	
	/**
	 * Method to get the list of users sorted using algorithm of selection
	 * <br>Pre:<b> users ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A sorted list of users
	 */
	public LinkedList<User> getListUsersFiltredNameSelection() {
	    LinkedList<User> list = new LinkedList<>();
	    User[] tempArr = users.toArray(new User[users.size()]);
	    for(int c = 0; c < tempArr.length - 1; c++ ) {
	        int menor= c;
	        int index = c;

	        for(int v = c+1; v < tempArr.length; v++) {
	            if(tempArr[v].getName().compareToIgnoreCase(tempArr[menor].getName()) > 0) {
	                menor=v;
	                index = v;
	            }
	        }
	        User temp = tempArr[c];
	        tempArr[c] = tempArr[menor];
	        tempArr[index] = temp;
	    }
	    for(int c = 0; c < tempArr.length; c++) {
	        list.add(tempArr[c]);
	    }
	    return list;
	}
	
	/**
	 * Method to get the list of users sorted using algorithm of bubble
	 * <br>Pre:<b> users ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A sorted list of users
	 */
	public LinkedList<User> getListUsersFiltredIdentificationBubble() {
		LinkedList<User> list = new LinkedList<>();
		User[] tempArr = users.toArray(new User[users.size()]);
		User temp = null;
		for(int c = 0; c < tempArr.length; c++) {
			for(int v = 1; v < (tempArr.length - c); v++) {
				if(Long.parseLong(tempArr[v-1].getIdentification()) > Long.parseLong(tempArr[v].getIdentification())) {  
                    //swap elements  
                    temp = tempArr[v-1];  
                    tempArr[v-1] = tempArr[v];  
                    tempArr[v] = temp;  
				}
			}
		}
		for(int c = 0; c < tempArr.length; c++) {
			list.add(tempArr[c]);
		}
		return list;
	}
	
	/**
	 * Method to get the list of articles on sale from a seller
	 * <br>Pre:<b> First node of articles in the seller must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list of articles
	 */
	public LinkedList<Article> getArticlesSeller() {
		LinkedList<Article> listSellerArticles = new LinkedList<>();
		UserSeller currentU=  (UserSeller)(currentUser);
		Article current= currentU.getSellArticles();
		
		while(current!=null) {
			listSellerArticles.add(current);
			current = current.getNextArticle();
		}
		
		return listSellerArticles;
	}
	
	
	/**
	 * Method to get a list with sold history from a seller
	 * <br>Pre:<b> First node of history into the seller must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list of articles
	 */
	public LinkedList<Article> getArticlesSolds(){
		LinkedList<Article> listArticlesSolds = new LinkedList<>();
		UserSeller currentU=  (UserSeller)(currentUser);
		Article currentArticle = currentU.getHistory();
		
		while(currentArticle!=null) {
			listArticlesSolds.add(currentArticle);
			currentArticle = currentArticle.getNextArticle();
		}
		return listArticlesSolds;
	}
	
	/**
	 * Method to get a lish with purchased articles from a buyer
	 * <br>Pre:<b> First node of history into the buyer must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list of articles
	 */
	public LinkedList<Article> getArticlesPurchased(){
		LinkedList<Article> listArticlesPurchased = new LinkedList<Article>();
		UserBuyer currentU = (UserBuyer)(currentUser);
		Article currentArticle = currentU.getHistory();
		
		while(currentArticle!=null) {
			listArticlesPurchased.add(currentArticle);
			currentArticle = currentArticle.getNextArticle();
		}
		return listArticlesPurchased;
	}
	
	/**
	 * Method to get a list of articles on sale
	 * <br>Pre:<b> ArrayList of articles must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list of articles
	 */
	public LinkedList<Article> getListProductsOnSale() {
		LinkedList<Article> listAllProductsOnSale = new LinkedList<>();
		for(int c = 0; c < articles.size(); c++) {
			listAllProductsOnSale.add(articles.get(c));
		}
		return listAllProductsOnSale;
	}
	
	/**
	 * Method to get a list of users sellers
	 * <br>Pre:<b> Arraylist of users must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list of users sellers
	 */
	public LinkedList<UserSeller> getListUsersSellers() {
		LinkedList<UserSeller> listAllUsersSellers = new LinkedList<>();
		
		for(int i = 0; i < users.size();i++) {
			if(users.get(i) instanceof UserSeller) {
				UserSeller current = (UserSeller)(users.get(i));
				listAllUsersSellers.add(current);
			}
		}
		
		return listAllUsersSellers;
	}
	
	/**
	 * Method to export data clients in a file with extension .csv
	 * <br>Pre:<b> users ArrayList must be initializated</b>
	 * <br>Post:<b> A file with extension .csv created on the FILE_DATA_EXPORT_USERS path</b>
	 * @throws FileNotFoundException Exception if the file can't be created
	 */
	public void exportDataClients() throws FileNotFoundException {
		String s = File.pathSeparator;
		PrintWriter pw = new PrintWriter(FILE_DATA_EXPORT_USERS);
		pw.print("Nombre" + s + "Apellido" + s + "Identificación" + s + "Email" + s +"Contraseña" + s +"Username" + s + "ruta foto" + s + "Fecha nacimiento" + "\n");
		for(int i = 0; i < users.size(); i++) {
			User current = users.get(i);
			pw.print(current.getName()+s+current.getLastName()+s+current.getIdentification()+s+current.getEmail()+s+current.getPassword()+s+current.getUsername()+s+current.getPicture()+s+current.getBirthday().toString() + "\n");
		}
		pw.close();
	}
	
	/**
	 * Method to export data articles in a file with extension .csv
	 * <br>Pre:<b> articles ArrayList must be initializated</b>
	 * <br>Post:<b> A file with extension .csv created on the FILE_DATA_EXPORT_ARTICLES path</b>
	 * @throws FileNotFoundException Exception if the file can't be created
	 */
	public void exportDataArticles() throws FileNotFoundException {
		String s = File.pathSeparator;
		LinkedList<CellPhone> listCellphone = getOnlyCellphone();
		LinkedList<Computer> listComputer = getOnlyComputer();
		LinkedList<Fridge> listFridge = getOnlyFridge();
		LinkedList<Stove> listStove = getOnlyStove();
		
		PrintWriter pw = new PrintWriter(FILE_DATA_EXPORT_ARTICLES);
		
		pw.print("ARTICULOS CELULARES\n");
		pw.print("Nombre"+s+"Codigo"+s+"Precio"+s+"Descripción"+s+"Ruta foto"+s+"Cantidad"+s+"Bateria en watts"+s+"Tamaños de pantalla"+s+"Ram"+s+"Procesador"+s+"Numero de sims"+s+"Numero de camaras\n");
		for(int i = 0; i<listCellphone.size();i++) {
			CellPhone current = listCellphone.get(i);
			pw.print(current.getName()+s+current.getCode()+s+current.getPrice()+s+current.getDescription()+s+current.getPicture()+s+current.getQuantity()+s+current.getBatteryWatts()+s+current.getScreenSize()+s+current.getRam()+s+current.getProcessor()+s+current.getNumberOfSims()+s+current.getNumberOfCameras()+"\n");
		}
		
		pw.print("\nARTICULOS COMPUTADORES\n");
		pw.print("Nombre"+s+"Codigo"+s+"Precio"+s+"Descripción"+s+"Ruta foto"+s+"Cantidad"+s+"Bateria en watts"+s+"Tamaños de pantalla"+s+"Ram"+s+"Procesador"+s+"Numero de puertos"+s+"Touch\n");
		for(int i = 0; i<listComputer.size();i++) {
			Computer current = listComputer.get(i);
			pw.print(current.getName()+s+current.getCode()+s+current.getPrice()+s+current.getDescription()+s+current.getPicture()+s+current.getQuantity()+s+current.getBatteryWatts()+s+current.getScreenSize()+s+current.getRam()+s+current.getProcessor()+s+current.getNumberOfPorts()+s+current.isTouchString()+"\n");
		}
		
		pw.print("\nARTICULOS NEVERAS\n");
		pw.print("Nombre"+s+"Codigo"+s+"Precio"+s+"Descripción"+s+"Ruta foto"+s+"Cantidad"+s+"Peso"+s+"Capacidad"+s+"Consumo en watts"+s+"Altura"+s+"Ancho"+s+"Smart"+s+"Sistema frost\n");
		for(int i = 0; i<listFridge.size();i++) {
			Fridge current = listFridge.get(i);
			pw.print(current.getName()+s+current.getCode()+s+current.getPrice()+s+current.getDescription()+s+current.getPicture()+s+current.getQuantity()+s+current.getWeight()+s+current.getCapacity()+s+current.getWattsConsum()+s+current.getHeight()+s+current.getWidth()+s+current.isSmartString()+s+current.isFrostString()+"\n");
		}
		
		pw.print("\nARTICULOS NEVERAS\n");
		pw.print("Nombre"+s+"Codigo"+s+"Precio"+s+"Descripción"+s+"Ruta foto"+s+"Cantidad"+s+"Peso"+s+"Capacidad"+s+"Consumo en watts"+s+"Altura"+s+"Ancho"+s+"Numero de boquillas"+s+"tipo de estufa\n");
		for(int i = 0; i<listStove.size();i++) {
			Stove current = listStove.get(i);
			pw.print(current.getName()+s+current.getCode()+s+current.getPrice()+s+current.getDescription()+s+current.getPicture()+s+current.getQuantity()+s+current.getWeight()+s+current.getCapacity()+s+current.getWattsConsum()+s+current.getHeight()+s+current.getWidth()+s+current.getNumberOfNozzles()+s+current.getTypeStove()+"\n");
		}
		pw.close();
	}
	
	/**
	 * Method to get a list with only articles of class Cellphone
	 * <br>Pre:<b> articles ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list only with cellphone articles
	 */
	public LinkedList<CellPhone> getOnlyCellphone() {
		LinkedList<CellPhone> list = new LinkedList<>();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i) instanceof CellPhone) {
				CellPhone cp = (CellPhone) articles.get(i);
				list.add(cp);
			}
		}
		return list;
	}
	
	/**
	 * Method to get a list with only articles of class Computer
	 * <br>Pre:<b> articles ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list only with Computer articles
	 */
	public LinkedList<Computer> getOnlyComputer() {
		LinkedList<Computer> list = new LinkedList<>();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i) instanceof Computer) {
				Computer c = (Computer) articles.get(i);
				list.add(c);
			}
		}
		return list;
	}
	
	/**
	 * Method to get a list with only articles of class Fridge
	 * <br>Pre:<b> articles ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list only with Fridge articles
	 */
	public LinkedList<Fridge> getOnlyFridge() {
		LinkedList<Fridge> list = new LinkedList<>();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i) instanceof Fridge) {
				Fridge f = (Fridge) articles.get(i);
				list.add(f);
			}
		}
		return list;
	}
	
	/**
	 * Method to get a list with only articles of class Stove
	 * <br>Pre:<b> articles ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @return A list only with Stove articles
	 */
	public LinkedList<Stove> getOnlyStove() {
		LinkedList<Stove> list = new LinkedList<>();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i) instanceof Stove) {
				Stove s = (Stove) articles.get(i);
				list.add(s);
			}
		}
		return list;
	}
	
	/**
	 * Method to import data clients from a .csv file
	 * <br>Pre:<b> </b>
	 * <br>Post:<b> Records of the file saved into the application, ArrayList of users</b>
	 * @return A list with the errors on especfic lines
	 * @throws IOException Exception if the file can't be readed
	 */
	public ArrayList<Integer> importDataClient() throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		ArrayList<Integer> numLineError = new ArrayList<>();
		int cont = 2;
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_DATA_IMPORT_CLIENTS));
		String line = br.readLine();
		String [] info;
		line = br.readLine();
		
		while(line != null) {
			boolean repeat = false;
			info = line.split(";");
			try {
				verifyIdentificationNotRepeat(info[2]);
				verifyUsernameNotRepeat(info[5]);
			}catch(IdentificationRepeatException | UsernameRepeatException irure) {
				numLineError.add(cont);
				repeat = true; 
			}
			
			if(!repeat) {
				String date = info[7];
				LocalDate lc = LocalDate.parse(date,formatter);
				newUser(info[0], info[1], info[2], info[3], info[4], info[5], info[6],lc, Integer.parseInt(info[8]));
			}
			cont += 1;
			line = br.readLine();
		}
		br.close();
		return numLineError;
	}
	
	/**
	 * Method to verify the new user dont contains a repeated username
	 * <br>Pre:<b> users ArrayList must be initializated</b>
	 * <br>Post:<b> </b>
	 * @param username The new user name to value
	 * @throws UsernameRepeatException Exception if the username repeat
	 */
	public void verifyUsernameNotRepeat(String username) throws UsernameRepeatException{
		for(int i = 0; i<users.size();i++) {
			if(username.equalsIgnoreCase(users.get(i).getUsername())) {
				throw new UsernameRepeatException();
			}
		}
	}
	
	/**
	 * Method to verify don't duplicate identification
	 * <br>Pre:<b> ArrayList users must be initializated</b>
	 * <br>Post:<b></b>
	 * @param identification The idenfitication to value
	 * @throws IdentificationRepeatException Exception if the idenficiation already exists
	 */
	public void verifyIdentificationNotRepeat(String identification) throws IdentificationRepeatException{
		for(int i = 0; i<users.size();i++) {
			if(identification.equalsIgnoreCase(users.get(i).getIdentification())) {
				throw new IdentificationRepeatException();
			}
		}
	}
	
	/**
	 * Method to import data clients from a .csv file
	 * <br>Pre:<b></b>
	 * <br>Post:<b> Users added into the ArrayList users</b>
	 * @return Return a list of number lines where errores has ocurred
	 * @throws IOException Exception if the file can't be reader
	 */
	public ArrayList<Integer> importDataArticles() throws IOException {
		ArrayList<Integer> numLineError = new ArrayList<>();
		int cont = 2;
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_DATA_IMPORT_ARTICLES));
		String line = br.readLine();
		String [] info;
		line = br.readLine();
		
		while(line!=null) {
			info = line.split(";");
			Article newArticle = null;
			
			if(info[0].equals("1")) {
				newArticle = importNewCellphone(info);
			}else if(info[0].equals("2")){
				newArticle = importNewComputer(info);
			}else if(info[0].equals("3")){
				newArticle = importNewFridge(info);
			}else if(info[0].equals("4")){
				newArticle = importNewStove(info);
			}
			newArticle.setNameSeller(info[1]);
			try {
				addNewArticleToArticles(newArticle);
				addNewArticleToUserSeller(info[1], newArticle);
			}catch(RepeatArticleCodeException race) {
				numLineError.add(cont);
			}
			cont += 1;
			line = br.readLine();
		}
		br.close();
		return numLineError;
	}
	
	/**
	 * Helper to import the Cellphone from a .csv file
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param info Receive a line to split
	 * @return Return an object of type Cellphone
	 */
	public CellPhone importNewCellphone(String[] info) {
		CellPhone cp = new CellPhone(info[2], info[3], Double.parseDouble(info[4]), info[5], info[6], Integer.parseInt(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), info[11], Integer.parseInt(info[12]), Integer.parseInt(info[13]));
		return cp;
	}
	
	/**
	 * Helper to import the Computer from a .csv file
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param info Receive a line to split
	 * @return Return an object of type Computer
	 */
	public Computer importNewComputer(String [] info) {
		boolean touch = (info[13].equalsIgnoreCase("Si"))?true:false;
		Computer c = new Computer(info[2], info[3], Double.parseDouble(info[4]), info[5], info[6], Integer.parseInt(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), info[11] , Integer.parseInt(info[12]),touch);
		return c;
	}

	/**
	 * Helper to import the Fridge from a .csv file
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param info Receive a line to split
	 * @return Return an object of type Fridge
	 */
	public Fridge importNewFridge(String [] info) {
		boolean smart = (info[13].equalsIgnoreCase("SI"))?true:false;
		boolean frost = (info[14].equalsIgnoreCase("SI"))?true:false;
		Fridge f = new Fridge(info[2],info[3],Double.parseDouble(info[4]),info[5],info[6],Integer.parseInt(info[7]),Double.parseDouble(info[8]),Double.parseDouble(info[9]),Double.parseDouble(info[10]),Double.parseDouble(info[11]),Double.parseDouble(info[12]),smart,frost);
		return f;
	}

	/**
	 * Helper to import the stove from a .csv file
	 * <br>Pre:<b></b>
	 * <br>Post:<b></b>
	 * @param info Receive a line to split
	 * @return Return an object of type stove
	 */
	public Stove importNewStove(String [] info) {
		Stove s = new Stove(info[2],info[3],Double.parseDouble(info[4]),info[5],info[6],Integer.parseInt(info[7]),Double.parseDouble(info[8]),Double.parseDouble(info[9]),Double.parseDouble(info[10]),Double.parseDouble(info[11]),Double.parseDouble(info[12]),Integer.parseInt(info[13]),info[14]);
		return s;
	}
	
	/**
	 * Method to search an article using the code
	 * <br>Pre:<b>The ArrayList of articles must be initializated</b>
	 * <br>Post:<b></b>
	 * @param Code the code of article to search
	 * @return Return finded article
	 */
	public Article searchArticleByCode(String code) {
		Article article = null;
		for(int i = 0; i < articles.size(); i++) {
			if(code.equals(articles.get(i).getCode())) {
				article = articles.get(i);
			}
		}

		return article;
	}
	
	/**
	 * Method to add an sold article into the history of their seller
	 * <br>Pre:<b>ArrayList of users must be initializated</b>
	 * <br>Post:<b></b>
	 * @param username Username of the seller
	 * @param articleSold The article to add
	 */
	public void addArticleSoldToSeller(String username, Article articleSold) {
		UserSeller seller = null;
		for(int i = 0; i<users.size(); i++) {
			if(username.equals(users.get(i).getUsername())) {
				seller = (UserSeller)(users.get(i));
			}
		}
		seller.addArticleToHistorySeller(articleSold);
		seller.modifyQuantity(articleSold.getCode(), articleSold.getQuantity());
	}
	
	public void addArticleBuyToBuyer(Article articleSold) {
		UserBuyer buyer = (UserBuyer)(currentUser);
		buyer.addArticleToHistory(articleSold);
	}
	
	
	/**
	 * laadDataClients
	 * allows load the data serializable
	 * <br>Pre:<b>a serialized file must exist</b>
	 * <br>Post:<b>the file was deserialized
	 */
	@SuppressWarnings("unchecked")
	public void loadDataClients() throws IOException, ClassNotFoundException{	
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SERIALIZABLE_USERS));
		users = (LinkedList<User>)ois.readObject();
		ois.close();
	}
	
	/**
	 * saveDataClients
	 * <br>Pre:<b>There must be information to serialize</b>
	 * <br>Post:<b>The file was serialized
	 */
	public void saveDataClients() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SERIALIZABLE_USERS));
		oos.writeObject(users);
		oos.close();
	}
	
	/**
	 * laadDataAricles
	 * allows load the data serializable
	 * <br>Pre:<b>a serialized file must exist</b>
	 * <br>Post:<b>the file was deserialized
	 */
	@SuppressWarnings("unchecked")
	public void loadDataArticles() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SERIALIZABLE_ARTICLE));
		articles = (LinkedList<Article>)ois.readObject();
		ois.close();
	}
	
	/**
	 * saveDataArticles
	 * <br>Pre:<b>There must be information to serialize</b>
	 * <br>Post:<b>The file was serialized
	 */
	public void saveDataArticles() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SERIALIZABLE_ARTICLE));
		oos.writeObject(articles);
		oos.close();
	}
	
	/**
	 * Method to get a sorted LinkedList with articles, criteria: Price
	 * <br>Pre:<b>The ArrayList of articles must be initializated</b>
	 * <br>Post:<b></b>
	 * @param fil The type of criteria to sort
	 * @return Return a sorted list of articles
	 */
	public LinkedList<Article> getArticlesPricesComparator(int fil) {
		LinkedList<Article> list = new LinkedList<>();
		for(int c = 0; c < articles.size(); c++) {
			list.add(articles.get(c));
		}
		switch(fil) {
		case 1:
			priceComparatorMayToMen pcm = new priceComparatorMayToMen();
			Collections.sort(list, pcm);
			break;
		case 2:
			priceComparatorMenToMay pcn = new priceComparatorMenToMay();
			Collections.sort(list, pcn);
			break;
		}
		return list;
	}
	
	public class priceComparatorMayToMen implements Comparator<Article> {
		@Override
		public int compare(Article u1, Article u2) {
			int response = 0;
			if(u1.getPrice() > u2.getPrice()) {
				response = -1;
			} else if(u1.getPrice() < u2.getPrice()) {
				response = 1;
			}
			return response;
		}
	}
	
	public class priceComparatorMenToMay implements Comparator<Article> {
		@Override
		public int compare(Article u1, Article u2) {
			int response = 0;
			if(u1.getPrice() < u2.getPrice()) {
				response = -1;
			} else if(u1.getPrice() > u2.getPrice()) {
				response = 1;
			}
			return response;
		}
	}
	
	/**
	 * Method to get a sorted LinkedList with articles
	 * <br>Pre:<b>The ArrayList of articles must be initializated</b>
	 * <br>Post:<b></b>
	 * @param fil The type of sort, 1 = A-Z, 2 = Z-A
	 * @return A list with the sorted articles
	 */
	public LinkedList<Article> getArticlesAZ(int fil) {
		LinkedList<Article> list = new LinkedList<>();
		for(int c = 0; c < articles.size(); c++) {
			list.add(articles.get(c));
		}
		switch(fil) {
			case 1:
				nameComparatorZA nc = new nameComparatorZA();
				Collections.sort(list, nc);
				break;
			case 2:
				nameComparatorAZ cn = new nameComparatorAZ();
				Collections.sort(list, cn);
				break;
		}
		return list;
	}
	
	public class nameComparatorAZ implements Comparator<Article> {
		@Override
		public int compare(Article u1, Article u2) {
			int response = 0;
			if(u1.getName().compareToIgnoreCase(u2.getName()) > 0) {
				response = -1;
			} else if(u1.getName().compareToIgnoreCase(u2.getName()) < 0) {
				response = 1;
			}
			return response;
		}
	}
	
	public class nameComparatorZA implements Comparator<Article> {
		@Override
		public int compare(Article u1, Article u2) {
			int response = 0;
			if(u1.getName().compareToIgnoreCase(u2.getName()) > 0) {
				response = 1;
			} else if(u1.getName().compareToIgnoreCase(u2.getName()) < 0) {
				response = -1;
			}
			return response;
		}
	}
	
	/**
	 * Method to crean an administrator
	 * <br>Pre:<b>ArrayList of users must be initializated</b>
	 * <br>Post:<b>A new user of type administrator added into the ArrayList users</b>
	 */
	public void crearAdministrador() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "12/01/1964";

        LocalDate localDate = LocalDate.parse(date, formatter);

        newUser("Jeff", "Bezos", "190234853", "jeff@amazon.com", "jeffrey", "TheBigJeff", "Jeff.jpg", localDate , 3);
        try {
            saveDataClients();
        }catch(IOException ioe) {

        }
    }

	/**
	 * Getter of rootSeller
	 * <br>Pre:<b>The variable must be initializated</b>
	 * <br>Post:<b></b>
	 * @return Return the rootSeller variable
	 */
	public UserSeller getRootSeller() {
		return rootSeller;
	}

	/**
	 * Setter of roomSeller
	 * <br>Pre:<b></b>
	 * <br>Post:<b>A new root seller has been setter</b>
	 * @param rootSeller The new rootSeller to set
	 */
	public void setRootSeller(UserSeller rootSeller) {
		this.rootSeller = rootSeller;
	}
}
