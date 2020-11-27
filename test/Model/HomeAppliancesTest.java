package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HomeAppliancesTest {

	public void setupStage1(){
		
	}
	
	@Test
	void testHomeAppliances() {
		setupStage1();
		HomeAppliances homeAppliancesTest = new HomeAppliances("Nevera LG", "12346", 2000000, "Nevera con alto nivel de congelamiento", "data/PictureNeveraLG", 4,100,1000,200,200,100);
		
		assertEquals("Nevera LG", homeAppliancesTest.getName());
		assertEquals("12346", homeAppliancesTest.getCode());
		assertEquals(2000000, homeAppliancesTest.getPrice());
		assertEquals("Nevera con alto nivel de congelamiento", homeAppliancesTest.getDescription());
		assertEquals("data/PictureNeveraLG", homeAppliancesTest.getPicture());
		assertEquals(4, homeAppliancesTest.getQuantity());
		assertNull(homeAppliancesTest.getNextArticle());
		assertNull(homeAppliancesTest.getPrevArticle());
		assertEquals(100, homeAppliancesTest.getWeight());
		assertEquals(1000, homeAppliancesTest.getCapacity());
		assertEquals(200, homeAppliancesTest.getWattsConsum());
		assertEquals(200, homeAppliancesTest.getHeight());
		assertEquals(100, homeAppliancesTest.getWidth());
	}
	
	@Test
	public void testGettersAndSetters(){
		setupStage1();
		HomeAppliances homeArticle = new HomeAppliances(" "," ",0," "," ",0,0,0,0,0,0);
		homeArticle.setName("Nevera LG");
		homeArticle.setCode("12346");
		homeArticle.setPrice(2000000);
		homeArticle.setDescription("Nevera con alto nivel de congelamiento");
		homeArticle.setPicture("data/PictureNeveraLG");
		homeArticle.setQuantity(4);
		homeArticle.setNextArticle(null);
		homeArticle.setPrevArticle(null);
		homeArticle.setWeight(100);
		homeArticle.setCapacity(1000);
		homeArticle.setWattsConsum(200);
		homeArticle.setHeight(200);
		homeArticle.setWidth(100);
		
		assertEquals("Nevera LG", homeArticle.getName());
		assertEquals("12346", homeArticle.getCode());
		assertEquals(2000000, homeArticle.getPrice());
		assertEquals("Nevera con alto nivel de congelamiento", homeArticle.getDescription());
		assertEquals("data/PictureNeveraLG", homeArticle.getPicture());
		assertEquals(4, homeArticle.getQuantity());
		assertNull(homeArticle.getNextArticle());
		assertNull(homeArticle.getPrevArticle());
		assertEquals(100, homeArticle.getWeight());
		assertEquals(1000, homeArticle.getCapacity());
		assertEquals(200, homeArticle.getWattsConsum());
		assertEquals(200, homeArticle.getHeight());
		assertEquals(100, homeArticle.getWidth());
	}

}
