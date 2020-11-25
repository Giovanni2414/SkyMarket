package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Fridge;

class FridgeTest {

	public void setupStage1() {
		
	}
	
	public Fridge setupStage2() {
		Fridge fridge = new Fridge("Nevera LG","12345",2000000, "Nevera con alto nivel de congelamiento", "data/PictureNeveraLG", 4,100,1000,200,200,100,true,true);
		return fridge;
	}
	
	public Fridge setupStage3() {
		Fridge fridge = new Fridge("Nevera LG","12345",2000000, "Nevera con alto nivel de congelamiento", "data/PictureNeveraLG", 4,100,1000,200,200,100,false,false);
		return fridge;
	}
	
	@Test
	public void testFridge() {
		setupStage1();
		Fridge fridgeTest = new Fridge("Nevera LG", "12346", 2000000, "Nevera con alto nivel de congelamiento", "data/PictureNeveraLG", 4,100,1000,200,200,100,true,false);
		
		assertEquals("Nevera LG", fridgeTest.getName());
		assertEquals("12346", fridgeTest.getCode());
		assertEquals(2000000, fridgeTest.getPrice());
		assertEquals("Nevera con alto nivel de congelamiento", fridgeTest.getDescription());
		assertEquals("data/PictureNeveraLG", fridgeTest.getPicture());
		assertEquals(4, fridgeTest.getQuantity());
		assertNull(fridgeTest.getNextArticle());
		assertNull(fridgeTest.getPrevArticle());
		assertEquals(100, fridgeTest.getWeight());
		assertEquals(1000, fridgeTest.getCapacity());
		assertEquals(200, fridgeTest.getWattsConsum());
		assertEquals(200, fridgeTest.getHeight());
		assertEquals(100, fridgeTest.getWidth());
		assertTrue(fridgeTest.isSmart());
		assertFalse(fridgeTest.isFrost());
	}
	
	@Test
	public void settersAndGetters() {
		setupStage1();
		Fridge fridgeTest = new Fridge(" "," ",0," "," ",0,0,0,0,0,0,false,false);
		fridgeTest.setName("Nevera LG");
		fridgeTest.setCode("12346");
		fridgeTest.setPrice(2000000);
		fridgeTest.setDescription("Nevera con alto nivel de congelamiento");
		fridgeTest.setPicture("data/PictureNeveraLG");
		fridgeTest.setQuantity(4);
		fridgeTest.setNextArticle(null);
		fridgeTest.setPrevArticle(null);
		fridgeTest.setWeight(100);
		fridgeTest.setCapacity(1000);
		fridgeTest.setWattsConsum(200);
		fridgeTest.setHeight(200);
		fridgeTest.setWidth(100);
		fridgeTest.setSmart(true);
		fridgeTest.setFrost(true);
		
		
		assertEquals("Nevera LG", fridgeTest.getName());
		assertEquals("12346", fridgeTest.getCode());
		assertEquals(2000000, fridgeTest.getPrice());
		assertEquals("Nevera con alto nivel de congelamiento", fridgeTest.getDescription());
		assertEquals("data/PictureNeveraLG", fridgeTest.getPicture());
		assertEquals(4, fridgeTest.getQuantity());
		assertNull(fridgeTest.getNextArticle());
		assertNull(fridgeTest.getPrevArticle());
		assertEquals(100, fridgeTest.getWeight());
		assertEquals(1000, fridgeTest.getCapacity());
		assertEquals(200, fridgeTest.getWattsConsum());
		assertEquals(200, fridgeTest.getHeight());
		assertEquals(100, fridgeTest.getWidth());
		assertTrue(fridgeTest.isSmart());
		assertTrue(fridgeTest.isSmart());
	}
	
	@Test
	public void testIsSmartStringAndIsNoFrozeStringTrue() {
		Fridge fridgeTest = setupStage2();
		
		assertEquals("SI",fridgeTest.isSmartString());
		assertEquals("SI",fridgeTest.isFrostString());
	}
	
	@Test
	public void testIsSmartStringAndIsNoFrozeStringFalse() {
		Fridge fridgeTest = setupStage3();
		
		assertEquals("NO",fridgeTest.isSmartString());
		assertEquals("NO",fridgeTest.isFrostString());
	}

}
