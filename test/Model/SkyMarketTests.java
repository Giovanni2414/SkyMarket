package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class SkyMarketTests {

	public SkyMarket setupStage1() {
		SkyMarket object = new SkyMarket();
		return object;
	}
	
	@Test
	void newUserTest() {
		SkyMarket object = setupStage1();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/", 0);
		LinkedList<User> testList = object.getUsers();
		assertEquals("The quantities don't match", 1, testList.size());
		
	}
	/*
	@Test
	void loginTest() {
		SkyMarket object = setupStage1();
		object.newUser("Giovanni", "Mosquera", "1006055396", "Giovanni2414g@gmail.com", "1234", "xGiovanni", "images/", 0);
		object.login("xGiovanni", "1234");
		assertNotNull("Login method don't works", object.getCurrentUser());
	}*/

}
