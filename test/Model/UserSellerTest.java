package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserSellerTest {
	
	public void setupScenary1() {
		
	}
	
	@Test
	public void UserSeller() {
		setupScenary1();
		UserSeller userTest = new UserSeller("Raul","Gomez","1005040032","raulg10","raulito20","data/PictureRaul");
		
		assertEquals("Raul", userTest.getName());
		assertEquals("Gomez", userTest.getLastName());
		assertEquals("1005040032", userTest.getIdentification());
		assertEquals("raulg10", userTest.getPassword());
		assertEquals("raulito20", userTest.getUsername());
		assertEquals("data/PictureRaul", userTest.getPicture());
		assertEquals(0,userTest.getCalification());
		assertNull(userTest.getHistory());
		assertNull(userTest.getSellArticles());
	} 
	
	@Test
	public void testSettersAndGetters() {
		setupScenary1();
		UserSeller userTest = new UserSeller("","","","","","");
		userTest.setName("Raul");
		userTest.setLastName("Gomez");
		userTest.setIdentification("1005040032");
		userTest.setPassword("raulg10");
		userTest.setUsername("raulito20");
		userTest.setPicture("data/PictureRaul");
		
		
		assertEquals("Raul", userTest.getName());
		assertEquals("Gomez", userTest.getLastName());
		assertEquals("1005040032", userTest.getIdentification());
		assertEquals("raulg10", userTest.getPassword());
		assertEquals("raulito20", userTest.getUsername());
		assertEquals("data/PictureRaul", userTest.getPicture());
		assertEquals(0,userTest.getCalification());
		assertNull(userTest.getHistory());
		assertNull(userTest.getSellArticles());
	}

}
