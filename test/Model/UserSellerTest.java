package Model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UserSellerTest {
	
	public void setupStage1() {
		
	}
	
	@Test
	public void UserSeller() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserSeller userTest = new UserSeller("Raul","Gomez","1005040032","raulg@gmail.com","raulg10","raulito20","data/PictureRaul",ld);
		
		assertEquals("Raul", userTest.getName());
		assertEquals("Gomez", userTest.getLastName());
		assertEquals("1005040032", userTest.getIdentification());
		assertEquals("raulg@gmail.com", userTest.getEmail());
		assertEquals("raulg10", userTest.getPassword());
		assertEquals("raulito20", userTest.getUsername());
		assertEquals("data/PictureRaul", userTest.getPicture());
		assertEquals(0,userTest.getCalification());
		assertNull(userTest.getHistory());
		assertNull(userTest.getSellArticles());
		assertEquals(ld,userTest.getBirthday());
	} 
	
	@Test
	public void testSettersAndGetters() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserSeller userTest = new UserSeller("","","","","","","",ld);
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
		assertEquals(0,userTest.getCalification());
		assertNull(userTest.getHistory());
		assertNull(userTest.getSellArticles());
		assertEquals(ld,userTest.getBirthday());
	}

}
