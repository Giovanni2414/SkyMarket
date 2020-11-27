package Model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UserBuyerTest {

	public void setupStage1() {
		
	}
	
	@Test
	public void testUserBuyer() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserBuyer userTest = new UserBuyer("Raul","Gomez","1005040032","raulg@gmail.com","raulg10","raulito20","data/PictureRaul",ld);
		
		assertEquals("Raul", userTest.getName());
		assertEquals("Gomez", userTest.getLastName());
		assertEquals("1005040032", userTest.getIdentification());
		assertEquals("raulg@gmail.com", userTest.getEmail());
		assertEquals("raulg10", userTest.getPassword());
		assertEquals("raulito20", userTest.getUsername());
		assertEquals("data/PictureRaul", userTest.getPicture());
		assertNull(userTest.getBasket());
		assertNull(userTest.getHistory());
		assertEquals(ld,userTest.getBirthday());
	} 
	
	@Test
	public void testGettersAndSetters() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserBuyer userTest = new UserBuyer("","","","","","","",ld);
		userTest.setName("Raul");
		userTest.setLastName("Gomez");
		userTest.setIdentification("1005040032");
		userTest.setEmail("raulg@gmail.com");
		userTest.setPassword("raulg10");
		userTest.setUsername("raulito20");
		userTest.setPicture("data/PictureRaul");
		
		
		assertEquals("Raul", userTest.getName());
		assertEquals("Gomez", userTest.getLastName());
		assertEquals("1005040032", userTest.getIdentification());
		assertEquals("raulg@gmail.com", userTest.getEmail());
		assertEquals("raulg10", userTest.getPassword());
		assertEquals("raulito20", userTest.getUsername());
		assertEquals("data/PictureRaul", userTest.getPicture());
		assertNull(userTest.getBasket());
		assertNull(userTest.getHistory());
		assertEquals(ld,userTest.getBirthday());
	}
}
