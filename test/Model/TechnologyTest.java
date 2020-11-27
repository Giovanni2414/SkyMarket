package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TechnologyTest {

	public void setupStage1(){
		
	}
	
	@Test
	void testTechnology() {
		setupStage1();
		Technology technologyTest = new Technology("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3,2000,20,4,"Hisilicon Kirin");
		
		assertEquals("Y9", technologyTest.getName());
		assertEquals("12345", technologyTest.getCode());
		assertEquals(1000000, technologyTest.getPrice());
		assertEquals("Celular gama media", technologyTest.getDescription());
		assertEquals("data/PictureHuaweiY9", technologyTest.getPicture());
		assertEquals(3, technologyTest.getQuantity());
		assertNull(technologyTest.getNextArticle());
		assertNull(technologyTest.getPrevArticle());
		assertEquals(2000, technologyTest.getBatteryWatts());
		assertEquals(20, technologyTest.getScreenSize());
		assertEquals(4, technologyTest.getRam());
		assertEquals("Hisilicon Kirin", technologyTest.getProcessor());
	}
	
	@Test
	public void testGettersAndSetters(){
		setupStage1();
		Technology techArticle = new Technology(" "," ",0," "," ",0,0,0,0,"");
		techArticle.setName("Mate 20");
		techArticle.setCode("1234");
		techArticle.setPrice(3000000);
		techArticle.setDescription("Celular con muy buena camara");
		techArticle.setPicture("data/Picture1");
		techArticle.setQuantity(2);
		techArticle.setNextArticle(null);
		techArticle.setPrevArticle(null);
		techArticle.setBatteryWatts(2000);
		techArticle.setScreenSize(20);
		techArticle.setRam(4);
		techArticle.setProcessor("Hisilicon Kirin");
		
		
		assertEquals("Mate 20", techArticle.getName());
		assertEquals("1234", techArticle.getCode());
		assertEquals(3000000, techArticle.getPrice());
		assertEquals("Celular con muy buena camara", techArticle.getDescription());
		assertEquals("data/Picture1", techArticle.getPicture());
		assertEquals(2, techArticle.getQuantity());
		assertNull(techArticle.getNextArticle());
		assertNull(techArticle.getPrevArticle());
		assertEquals(2000, techArticle.getBatteryWatts());
		assertEquals(20, techArticle.getScreenSize());
		assertEquals(4, techArticle.getRam());
		assertEquals("Hisilicon Kirin", techArticle.getProcessor());
	}
}
