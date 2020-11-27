package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ComputerTest {
	
	public Computer setupStage1() {
		return new Computer("Ideapad S145", "1005", 1700000, "High performance PC", "", 10, 150, 10, 12, "AMD Ryzen 3 Vega Graphics", 3, false);
	}

	@Test
	public void testGettersAndSetters() {
		Computer object = setupStage1();
		assertFalse("Getter touch don't works", object.getTouch());
		object.setToch(true);
		assertTrue("Setter touch don't works", object.getTouch());
		assertEquals("Getter of numberPorts don't works", 3, object.getNumberOfPorts());
		object.setNumberOfPorts(2);
		assertEquals("Getter of numberPorts don't works", 2, object.getNumberOfPorts());
	}

}
