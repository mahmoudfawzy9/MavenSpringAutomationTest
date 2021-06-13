package com.si;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.testng.annotations.*;
import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class , classes = { PropertiesConfigration.class })


public class TestopiaTest extends TestCase{
	private static boolean init;
	
	@Before
	public  void  validatePageURL()  {
		if(!init) {
			init=true;
		try {
			System.setProperty("webdriver.gecko.driver", Configration.getGeckoDriverPath());
			IWebDriver.driver.get(PropertiesConfigration.baseURLT);
			String ActualTitle = IWebDriver.driver.getTitle();
			String ExpectedTitle = "Simple React CRUD Application";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

	
	@Test
	public void addnewRecipe() {
		try {
			Assert.assertTrue(FixedSolution.clickaddRecipe());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void editRecipe() {
		try {
			Assert.assertTrue(FixedSolution.editRecipe());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void deleteRecipe() {
		try {
			Assert.assertTrue(FixedSolution.deleteTheAddedRecipe());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
	
	@AfterClass
	public static void endSessions() {
		try {
			Assert.assertTrue(FixedSolution.endSessions());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
