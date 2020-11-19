package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdministraitorTest {

	public void setupStage1() {
		
	}

	@Test
	public void testUser(){
		setupStage1();
		User administraitorTest = new User("Raul","Gomez","1005040032","raulg@gmail.com","raulg10","raulito20","data/PictureRaul");
		
		assertEquals("Raul", administraitorTest.getName());
		assertEquals("Gomez", administraitorTest.getLastName());
		assertEquals("1005040032", administraitorTest.getIdentification());
		assertEquals("raulg@gmail.com", administraitorTest.getEmail());
		assertEquals("raulg10", administraitorTest.getPassword());
		assertEquals("raulito20", administraitorTest.getUsername());
		assertEquals("data/PictureRaul", administraitorTest.getPicture());
	}
	
	@Test
	public void testGettersAndSetters() {
		setupStage1();
		
		Administraitor administraitorTest = new Administraitor("", "", "", "", "", "", "", null);
		administraitorTest.setName("Raul");
		administraitorTest.setLastName("Gomez");
		administraitorTest.setIdentification("1005040032");
		administraitorTest.setEmail("raulg@gmail.com");
		administraitorTest.setPassword("raulg10");
		administraitorTest.setUsername("raulito20");
		administraitorTest.setPicture("data/PictureRaul");
		
		assertEquals("Raul", administraitorTest.getName());
		assertEquals("Gomez", administraitorTest.getLastName());
		assertEquals("1005040032", administraitorTest.getIdentification());
		assertEquals("raulg@gmail.com", administraitorTest.getEmail());
		assertEquals("raulg10", administraitorTest.getPassword());
		assertEquals("raulito20", administraitorTest.getUsername());
		assertEquals("data/PictureRaul", administraitorTest.getPicture());
	}

}
