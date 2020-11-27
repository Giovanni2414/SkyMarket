package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoveTest {

	public void setupStage1() {
		
	}
	
	@Test
	public void testStove() {
		setupStage1();
		Stove stoveTest = new Stove("Estufa mabe","1223",700000,"Estufa elegante","data/pathPictureStove",2,80,500,1000,1,1,4,"Gas");
		
		assertEquals("Estufa mabe", stoveTest.getName());
		assertEquals("1223",stoveTest.getCode());
		assertEquals(700000,stoveTest.getPrice());
		assertEquals("Estufa elegante",stoveTest.getDescription());
		assertEquals("data/pathPictureStove",stoveTest.getPicture());
		assertEquals(2,stoveTest.getQuantity());
		assertEquals(80,stoveTest.getWeight());
		assertEquals(500,stoveTest.getCapacity());
		assertEquals(1000,stoveTest.getWattsConsum());
		assertEquals(1,stoveTest.getHeight());
		assertEquals(1,stoveTest.getWidth());
		assertEquals(4,stoveTest.getNumberOfNozzles());
		assertEquals("Gas",stoveTest.getTypeStove());
		
	}
	
	@Test
	public void settersAndGetters() {
		setupStage1();
		Stove stoveTest = new Stove("","",0,"","",0,0,0,0,0,0,0,"");
		
		stoveTest.setName("Estufa mabe");
		stoveTest.setCode("1223");
		stoveTest.setPrice(700000);
		stoveTest.setDescription("Estufa elegante");
		stoveTest.setPicture("data/pathPictureStove");
		stoveTest.setQuantity(2);
		stoveTest.setWeight(80);
		stoveTest.setCapacity(500);
		stoveTest.setWattsConsum(1000);
		stoveTest.setHeight(1);
		stoveTest.setWidth(1);
		stoveTest.setNumberOfNozzles(4);
		stoveTest.setTypeStove("Electrica");
		
		assertEquals("Estufa mabe", stoveTest.getName());
		assertEquals("1223",stoveTest.getCode());
		assertEquals(700000,stoveTest.getPrice());
		assertEquals("Estufa elegante",stoveTest.getDescription());
		assertEquals("data/pathPictureStove",stoveTest.getPicture());
		assertEquals(2,stoveTest.getQuantity());
		assertEquals(80,stoveTest.getWeight());
		assertEquals(500,stoveTest.getCapacity());
		assertEquals(1000,stoveTest.getWattsConsum());
		assertEquals(1,stoveTest.getHeight());
		assertEquals(1,stoveTest.getWidth());
		assertEquals(4,stoveTest.getNumberOfNozzles());
		assertEquals("Electrica",stoveTest.getTypeStove());
	}
}
