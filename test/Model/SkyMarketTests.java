package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class SkyMarketTests {

	public SkyMarket setupStage1() {
		SkyMarket object = new SkyMarket();
		return object;
	}
	
	public SkyMarket setupStage2() {
		SkyMarket object = new SkyMarket();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/",LocalDate.now(), 0);
		object.newUser("Ramiro", "Alberto", "1006055396", "Giovanni2414g@gmail.com", "1234", "xRamiro", "images/",LocalDate.now(), 1);
		object.newUser("Jairo", "Torres", "1006055396", "Giovanni2414g@gmail.com", "1234", "xJairo", "images/", LocalDate.now(),1);
		object.newUser("Camila", "Andrea", "1006055396", "Giovanni2414g@gmail.com", "1234", "xCamila", "images/", LocalDate.now(),0);
		return object;
	}
	
	@Test
	void newUserTest() {
		SkyMarket object = setupStage1();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/",LocalDate.now(), 0);
		LinkedList<User> testList = object.getUsers();
		assertEquals("The quantities don't match", 1, testList.size());
		assertEquals("Usernames don't match", "xGiovanni", testList.get(0).getUsername());
	}
	
	@Test
	void binarySearchUserTest() {
		SkyMarket object = setupStage2();
		User testObject = object.binarySearchUser("xRamiro");
		User testObjectToNull = object.binarySearchUser("Estela");
		assertEquals("User don't finded", "Alberto", testObject.getLastName());
		assertNull("User finded and that don't exists", testObjectToNull);
	}
	
	@Test
	void loginTest() {
		SkyMarket object = setupStage1();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/", LocalDate.now(),0);
		object.login("xGiovanni", "1234");
		assertNotNull("Login method don't works", object.getCurrentUser());
		object.logout();
		object.login("xGiovanni", "1234567890");
		assertNull("Login method don't works", object.getCurrentUser());
	}
	
	@Test
	void logoutTest() {
		SkyMarket object = setupStage1();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/", LocalDate.now(),0);
		object.login("xGiovanni", "1234");
		object.logout();
		assertNull("Logout method don't works", object.getCurrentUser());
	}
	
	@Test
	public void testGettersAndSetter() {
		SkyMarket object = setupStage1();
		LinkedList<User> listTest = object.getUsers();
		LinkedList<Article> listTestArticles = object.getArticles();
		assertNull("Getter of currentUser don't works", object.getCurrentUser());
		assertTrue("Getter of users don't works", listTest.isEmpty());
		assertTrue("Getter of articles don't works", listTestArticles.isEmpty());
		listTest.add(new UserBuyer("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/",LocalDate.now()));
		listTestArticles.add(new Technology("Lenovo R3", "1605", 1750000, "PC of high performance", "images/", 10, 20, 30, 12, "AMD Ryzen 3 Radeon Vega Graphics"));
		object.setCurrentUser(new UserBuyer("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/",LocalDate.now()));
		object.setArticles(listTestArticles);
		object.setUsers(listTest);
		assertNotNull("Setter of currentUser don't works", object.getCurrentUser());
		assertFalse("Setter of users don't works", (object.getUsers()).isEmpty());
		assertFalse("Setter of articles don't works",(object.getArticles()).isEmpty());
	}

}
