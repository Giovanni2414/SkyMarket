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
	
	@Test
	public void testAddArticleToHistory() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserSeller userTest = new UserSeller("","","","","","","",ld);
		userTest.addArticleToHistorySeller(new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3));
		assertNotNull(userTest.getHistory());
		assertNull(userTest.getHistory().getNextArticle());
		userTest.addArticleToHistorySeller(new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3));
		assertNotNull(userTest.getHistory().getNextArticle());
		assertNull(userTest.getHistory().getNextArticle().getNextArticle());
		assertNull(userTest.getHistory().getPrevArticle());
	}
	
	@Test
	public void testModifyQuantity() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserSeller userTest = new UserSeller("","","","","","","",ld);
		userTest.addArticleToSellArticles(new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3));
		assertEquals(3, userTest.getSellArticles().getQuantity());
		userTest.modifyQuantity("12345", 2);
		assertEquals(1, userTest.getSellArticles().getQuantity());
	}

	@Test
	public void testAddArticleToSellArticles() {
		setupStage1();
		LocalDate ld = LocalDate.now();
		UserSeller userTest = new UserSeller("","","","","","","",ld);
		assertNull(userTest.getSellArticles());
		userTest.addArticleToSellArticles(new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3));
		assertNotNull(userTest.getSellArticles());
		userTest.addArticleToSellArticles(new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3));
		assertNotNull(userTest.getSellArticles().getNextArticle());
	}

}
