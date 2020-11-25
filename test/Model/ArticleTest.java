package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Article;

class ArticleTest {

	public void setupStage1() {
		
	}
	
	@Test
	public void testArticle() {
		setupStage1();
		Article articleTest = new Article("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3);
		
		assertEquals("Y9", articleTest.getName());
		assertEquals("12345", articleTest.getCode());
		assertEquals(1000000, articleTest.getPrice());
		assertEquals("Celular gama media", articleTest.getDescription());
		assertEquals("data/PictureHuaweiY9", articleTest.getPicture());
		assertEquals(3, articleTest.getQuantity());
		assertNull(articleTest.getNextArticle());
	}
	
	@Test
	public void testGettersAndSetters(){
		setupStage1();
		Article articleTest = new Article(" "," ",0," "," ",0);
		articleTest.setName("Mate 20");
		articleTest.setCode("1234");
		articleTest.setPrice(3000000);
		articleTest.setDescription("Celular con muy buena camara");
		articleTest.setPicture("data/Picture1");
		articleTest.setQuantity(2);
		articleTest.setNextArticle(null);
		
		assertEquals("Mate 20", articleTest.getName());
		assertEquals("1234", articleTest.getCode());
		assertEquals(3000000, articleTest.getPrice());
		assertEquals("Celular con muy buena camara", articleTest.getDescription());
		assertEquals("data/Picture1", articleTest.getPicture());
		assertEquals(2, articleTest.getQuantity());
		assertNull(articleTest.getNextArticle());
	}
}
