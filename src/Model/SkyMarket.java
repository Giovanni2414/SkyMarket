package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Exceptions.EmptyFieldException;
import Exceptions.PasswordNotEqualsException;
import Exceptions.RepeatArticleCodeException;

public class SkyMarket {

	public final static String FILE_SERIALIZABLE_USERS = "data/serializableData/clientsData";
	public final static String FILE_SERIALIZABLE_ARTICLE = "data/serializableData/articlesData";
	public final static String FILE_DATA_EXPORT_USERS = "data/exportData/usersData.csv";
	
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
	 * Constructor of SkyMarket, set the currentUser on null
	 * <br>Pre:<b></b>
	 * <br>Post:<b>object of SkyMarket with currentUser started in null</b>
	 */
	public SkyMarket() {
		currentUser = null;
		users = new LinkedList<>();
		setArticles(new LinkedList<>());
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
	 * Method to verify info of register
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
		} else {
			newUserObject = new Administraitor(name, lastname, identification, email, password, username, picture,birthday, users);
			//Pendiente por crear el usuario administrador
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
	
	/*
	public void banUser(String identification) {
		for(int i = 0; i<users.size();i++) {
			if(users.get(i).getIdentification().) {
				
			}
		}
	}
	*/
	
	
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
	
	public void addNewArticleToArticles(Article newArticle) throws RepeatArticleCodeException{
		for(int i = 0; i < articles.size(); i++) {
			if(newArticle.getCode()==articles.get(i).getCode()) {
				throw new RepeatArticleCodeException();
			}
		}
		articles.add(newArticle);
	}
	
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
		user.addArticleToArticlesSeller(newArticle);
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
	 * <br>Post:<b>check the content of the fields to add a new article
	 */
	public void verificationFieldsAddArticle(String name,String code,double price, String description, String picture, int quantity,String type) throws EmptyFieldException{
		if(name == null || code == null || price == 0  || description == null || picture == null || quantity == 0 || type == null) {
			throw new EmptyFieldException();
		}
	}
	
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
	
	public LinkedList<User> getListUsersFiltredIdentificationBubble() {
		LinkedList<User> list = new LinkedList<>();
		User[] tempArr = users.toArray(new User[users.size()]);
		User temp = null;
		for(int c = 0; c < tempArr.length; c++) {
			for(int v = 1; v < (tempArr.length - c); v++) {
				if(Integer.parseInt(tempArr[v-1].getIdentification()) > Integer.parseInt(tempArr[v].getIdentification())) {  
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
	
	public LinkedList<Article> getListProductsOnSale() {
		LinkedList<Article> listAllProductsOnSale = new LinkedList<>();
		for(int c = 0; c < articles.size(); c++) {
			listAllProductsOnSale.add(articles.get(c));
		}
		return listAllProductsOnSale;
	}
	
	
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
	
	public void test() {
		for(int i = 0; i<articles.size();i++) {
    		System.out.println("name: " + articles.get(i).getName());
    		System.out.println("code: " + articles.get(i).getCode());
    		System.out.println("price: " + articles.get(i).getPrice());
    	}
	}
	
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
	
	
	
}
