package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.CellPhone;

class CellPhoneTest {

	public void setupStage1(){
		
	}
	
	@Test
	void testTechnology() {
		setupStage1();
		CellPhone cellPhoneTest = new CellPhone("Y9", "12345", 1000000, "Celular gama media", "data/PictureHuaweiY9", 3,2000,20,4,"Hisilicon Kirin",2,3);
		
		assertEquals("Y9", cellPhoneTest.getName());
		assertEquals("12345", cellPhoneTest.getCode());
		assertEquals(1000000, cellPhoneTest.getPrice());
		assertEquals("Celular gama media", cellPhoneTest.getDescription());
		assertEquals("data/PictureHuaweiY9", cellPhoneTest.getPicture());
		assertEquals(3, cellPhoneTest.getQuantity());
		assertNull(cellPhoneTest.getNextArticle());
		assertNull(cellPhoneTest.getPrevArticle());
		assertEquals(2000, cellPhoneTest.getBatteryWatts());
		assertEquals(20, cellPhoneTest.getScreenSize());
		assertEquals(4, cellPhoneTest.getRam());
		assertEquals("Hisilicon Kirin", cellPhoneTest.getProcessor());
		assertEquals(2,cellPhoneTest.getNumberOfSims());
		assertEquals(3,cellPhoneTest.getNumberOfCameras());
	}
	
	@Test
	public void testGettersAndSetters(){
		setupStage1();
		CellPhone cellPhoneTest = new CellPhone(" "," ",0," "," ",0,0,0,0,"",0,0);
		cellPhoneTest.setName("Mate 20");
		cellPhoneTest.setCode("1234");
		cellPhoneTest.setPrice(3000000);
		cellPhoneTest.setDescription("Celular con muy buena camara");
		cellPhoneTest.setPicture("data/Picture1");
		cellPhoneTest.setQuantity(2);
		cellPhoneTest.setNextArticle(null);
		cellPhoneTest.setPrevArticle(null);
		cellPhoneTest.setBatteryWatts(2000);
		cellPhoneTest.setScreenSize(20);
		cellPhoneTest.setRam(4);
		cellPhoneTest.setProcessor("Hisilicon Kirin");
		cellPhoneTest.setNumberOfSims(2);
		cellPhoneTest.setNumberOfCameras(3);
		
		assertEquals("Mate 20", cellPhoneTest.getName());
		assertEquals("1234", cellPhoneTest.getCode());
		assertEquals(3000000, cellPhoneTest.getPrice());
		assertEquals("Celular con muy buena camara", cellPhoneTest.getDescription());
		assertEquals("data/Picture1", cellPhoneTest.getPicture());
		assertEquals(2, cellPhoneTest.getQuantity());
		assertNull(cellPhoneTest.getNextArticle());
		assertNull(cellPhoneTest.getPrevArticle());
		assertEquals(2000, cellPhoneTest.getBatteryWatts());
		assertEquals(20, cellPhoneTest.getScreenSize());
		assertEquals(4, cellPhoneTest.getRam());
		assertEquals("Hisilicon Kirin", cellPhoneTest.getProcessor());
		assertEquals(2,cellPhoneTest.getNumberOfSims());
		assertEquals(3,cellPhoneTest.getNumberOfCameras());
	}
}
