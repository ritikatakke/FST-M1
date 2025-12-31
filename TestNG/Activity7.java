package TestActivity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.SkipException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class Activity7 {
	ChromeDriver driver;
	@BeforeClass
	public  void initiate() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@AfterClass
	public  void close() {
		driver.quit();
	}
	@Test(dataProvider="data")
	
    public void testCase1(String username, String password) {
		WebElement userID = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement passwrd= driver.findElement(By.xpath("//input[@name=\"password\"]"));
		userID.sendKeys(username);
		passwrd.sendKeys(password);
	   driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	   
	  
	   WebElement success = driver.findElement(By.xpath("//h2[contains(text(), 'Welcome')]"));
	   wait.until(ExpectedConditions.visibilityOfAllElements(success));
       Assert.assertEquals( success.getText(),"Welcome Back, Admin!");
    }
  
	@DataProvider
	public static Object[][] data(){
	return new Object[][] {{"admin","password"},{"ritika","pass"}};
	}
 

}
