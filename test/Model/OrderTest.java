package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	public Article setupStage1(){
		Article newArticle = new Article("iphone","123",1400000,"Celular","data/articlePath", 2);
		return newArticle;
		
	}
	
	@Test
	public void testOrder() {
		Article newArticle = setupStage1();
		Order orderTest = new Order(2341,newArticle);
		
		assertEquals(2341,orderTest.getOrderCode());
		assertEquals(newArticle, orderTest.getArticles());
	}
	
	@Test
	public void testGettersAndSetter() {
		Order orderTest = new Order(0, null);
		Article newArticle = setupStage1(); 
		
		orderTest.setOrderCode(123332);
		orderTest.setArticles(newArticle);
		
		assertNotNull(orderTest.getDate());
		assertEquals(123332,orderTest.getOrderCode());
		assertEquals(newArticle, orderTest.getArticles());
	}

}
