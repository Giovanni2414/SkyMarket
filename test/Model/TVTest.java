package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.TV;

class TVTest {

	public void setupStage1(){
		
	}
	
	@Test
	void testTechnology() {
		setupStage1();
		TV tvTest = new TV("oled", "12345", 1500000, "TV ultima tecnologia", "data/PictureTVOled", 10,4000,20,4,"Hisilicon Kirin",true,4);
		
		assertEquals("Y9", tvTest.getName());
		assertEquals("12345", tvTest.getCode());
		assertEquals(1000000, tvTest.getPrice());
		assertEquals("Celular gama media", tvTest.getDescription());
		assertEquals("data/PictureHuaweiY9", tvTest.getPicture());
		assertEquals(3, tvTest.getQuantity());
		assertNull(tvTest.getNextArticle());
		assertNull(tvTest.getPrevArticle());
		assertEquals(2000, tvTest.getBatteryWatts());
		assertEquals(20, tvTest.getScreenSize());
		assertEquals(4, tvTest.getRam());
		assertEquals("Hisilicon Kirin", tvTest.getProcessor());
		assertEquals(true,tvTest.isSmart());
		assertEquals(4,tvTest.getNumberOfPorts());
	}
	
	@Test
	public void testGettersAndSetters(){
		setupStage1();
		TV cellPhoneTest = new TV(" "," ",0," "," ",0,0,0,0,"",false,0);
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
		cellPhoneTest.setSmart(true);
		cellPhoneTest.setNumberOfPorts(4);
		
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
		
	}

}
