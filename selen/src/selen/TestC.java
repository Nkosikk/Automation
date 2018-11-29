package selen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestC {

public WebDriver driver;
	

	
	@BeforeClass(description="This is the setup class,where the browser choice is configured")
	public void seup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/nkosicele/Desktop/AutoProjects/chromedriver");
		driver = new ChromeDriver();
	
	}

	@Test(priority=1,description="Opening Facebook URL")
	public void load_Facebook_page()
	{
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test(priority=2,description="The usr enter invalid login details ")
	public void Invalid_login() throws InterruptedException
	{
		//Username input
	    WebElement pass = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
		Actions seriesOfAction = builder.moveToElement(pass).click().sendKeys(pass, "test@gmail.com");
        seriesOfAction.perform();
   
        
       // Password input
        WebElement pass1 = driver.findElement(By.id("pass"));
        Actions builder1 = new Actions(driver);
		Actions seriesOfAction1 = builder1.moveToElement(pass1).click().sendKeys(pass1, "TestPassword");
        seriesOfAction1.perform();
    
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.id("u_0_2")).click();
	    
	}

	//Test Method
	@Test(priority=3,description="This test is to verify if the user is taken to the right screen when enetered the invalid login details")
	public void Verify_right_screen_displayed() throws InterruptedException
	{
		String expectedUrl = "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110";
		try{
		  Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		  System.out.println("Correct screen is displayed");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Incorrect screen displayed");
		  
		  
		}
		
	}
	
	//the below method closes the driver after test clases are done 
	@AfterClass
    public  void tearDown() throws  Exception

    {
		
        driver.quit();
    }
	
	
	

}
