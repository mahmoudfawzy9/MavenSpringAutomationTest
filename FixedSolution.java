package com.si;

import org.eclipse.jubula.client.api.converter.annotations.SrcNode;
import org.hamcrest.generator.qdox.tools.QDoxTester.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

/*
 * author Mahmoud Fawzy @ ScadaInnovations
 */


public class FixedSolution {

	public static boolean validatePageURL() throws Exception {

		System.setProperty("webdriver.gecko.driver", Configration.getGeckoDriverPath());

		return true;
	}
	
	//Adding a new Recipe
	
	public static boolean clickaddRecipe() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", Configration.getGeckoDriverPath());

		IWebDriver.driver.get(PropertiesConfigration.baseURLT);
		Thread.sleep(2000);

		IWebDriver.driver.manage().window().maximize();	
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show"))); css=input[type=’submit’]
        
		//Just to count Frames number
        int countIframesInFrame1 = IWebDriver.driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);
     
       WebElement frameElement = IWebDriver.driver.findElement(By.id("result"));

        IWebDriver.driver.switchTo().frame(frameElement);
		Thread.sleep(1500);

        WebElement showButton = IWebDriver.driver.findElement(By.id("show"));
         showButton.click();
 		Thread.sleep(1500);

         WebElement recipeName = IWebDriver.driver.findElement(By.id("title"));
         recipeName.sendKeys("Pizza");
 		Thread.sleep(1500);

         WebElement ingredients = IWebDriver.driver.findElement(By.id("ingredients"));
             ingredients.sendKeys("Tomatoes, Cheese, Mushroom, Flour");
         
         WebElement addButton = IWebDriver.driver.findElement(By.id("addButton"));
             addButton.click();
//           
//             //option1 for the New Recipe Visibility
//
         String expectedText ="Pizza"; 
         String actualText = IWebDriver.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div[1]/h4/a")).getText();
         org.junit.Assert.assertEquals(expectedText,actualText);
         System.out.println(actualText);

         //option2 for the New Recipe Visibility
         try{
             if( IWebDriver.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div[1]/h4/a")).isDisplayed()){
               System.out.println("Element ==== Pizza is Visible");
               org.junit.Assert.assertEquals(actualText, expectedText); //asserts that recipe is edit
             }
    
        else{
          System.out.println("Element is InVisible");
             }
	}catch (NoSuchElementException e) {
        e.printStackTrace();
}
         // To check console that the Pizza is added successfully
 		Thread.sleep(12000);

//         endSessions();

		return true;		
	  }

	//Edit existed Recipe
	public static boolean editRecipe() throws InterruptedException {

//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", Configration.getGeckoDriverPath());

		IWebDriver.driver.get(PropertiesConfigration.baseURLT);
		Thread.sleep(2000);

		IWebDriver.driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
        WebElement frameElement = IWebDriver.driver.findElement(By.id("result"));

        IWebDriver.driver.switchTo().frame(frameElement);
        
		WebElement spaghetti = IWebDriver.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div[1]/h4/a"));
		spaghetti.click();
		
		Thread.sleep(2500);
		WebElement editButton = IWebDriver.driver.findElement(By.id("btn-edit1"));
                   editButton.click();
           		Thread.sleep(2500);
               
                  WebElement eraseRecipeName = IWebDriver.driver.findElement(By.id("title"));
                  eraseRecipeName.clear();
          		Thread.sleep(2000);

                  WebElement eraseRecipeIngredients = IWebDriver.driver.findElement(By.id("ingredients"));
                  eraseRecipeIngredients.clear();
          		Thread.sleep(2000);

                  eraseRecipeIngredients.sendKeys("strawberry, honey, banana");
          		Thread.sleep(2000);

                  WebElement editRecipeName = IWebDriver.driver.findElement(By.id("title"));
                         editRecipeName.sendKeys("Fruit Salad");
                 	Thread.sleep(2000);
                  
         WebElement confirmIsEdited = IWebDriver.driver.findElement(By.id("addButton"));
                  confirmIsEdited.click();

            Thread.sleep(5000);      
//            endSessions();
                  return true;
	}
	
	//Delete a previous added Recipe Action (if expected or happened)

	public static boolean deleteTheAddedRecipe() throws Exception {

		System.setProperty("webdriver.gecko.driver", Configration.getGeckoDriverPath());

		IWebDriver.driver.get(PropertiesConfigration.baseURLT);
		Thread.sleep(2000);

		IWebDriver.driver.manage().window().maximize();

		
        WebElement frameElement = IWebDriver.driver.findElement(By.id("result"));
		Thread.sleep(2000);

        IWebDriver.driver.switchTo().frame(frameElement);
		Thread.sleep(2000);

        WebElement showButton = IWebDriver.driver.findElement(By.id("show"));
        
        showButton.click();
		Thread.sleep(2000);

///////////// expected not to be added  but added due to test running order, TestNG will solve cases orders later : )
        WebElement recipeName = IWebDriver.driver.findElement(By.id("title"));
        recipeName.sendKeys("Pizza");
		Thread.sleep(2000);

        WebElement ingredients = IWebDriver.driver.findElement(By.id("ingredients"));
            ingredients.sendKeys("Tomatoes, Cheese, Mushroom, Flour");
    		Thread.sleep(2000);

        WebElement addButton = IWebDriver.driver.findElement(By.id("addButton"));
            addButton.click();
    		Thread.sleep(2000);

///////////// expected to not be added before but added due to test running order, TestNG will solve cases orders later : )
		WebElement pizza = IWebDriver.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div[1]/h4/a"));
		pizza.click();
		Thread.sleep(2000);

		
		WebElement deleteButton = IWebDriver.driver.findElement(By.id("btn-del3"));
		deleteButton.click();
		Thread.sleep(2000);

		//Validate Text isDeleted
		try{
		    String expectedText = "Pizza";
	        String actualText = IWebDriver.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div[1]/h4/a")).getText();
if(actualText == null || expectedText != actualText) {
    System.out.println("ElementIsNotFound or Deleted" + actualText);
}else {
	System.out.println(actualText);
}  
	        }catch(NoSuchElementException e){
	            System.out.println("ElementIsNotFound or Deleted");

//	            e.printStackTrace();    hashed for clean code purpose no exception would be thrown
	        }	

		Thread.sleep(2000);
//		endSessions();
		
		return true;
	
	}

	public static boolean endSessions() {

	    if (IWebDriver.driver != null)
	      IWebDriver.driver.close();
		return true;
	}
	
	}


	
	

	
		
	

		
		
		
	

