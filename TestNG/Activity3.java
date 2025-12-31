package TestActivity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class Activity3 {
	ChromeDriver driver;
	@BeforeClass
	public  void initiate() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@AfterClass
	public  void close() {
		driver.quit();
	}
	@Test
    public void testCase1() {
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement password= driver.findElement(By.xpath("//input[@name=\"password\"]"));
	   username.sendKeys("admin");
	   password.sendKeys("password");
	   driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
	  
	   String success = driver.findElement(By.cssSelector("h2.text-center")).getText();
	   
       Assert.assertEquals( success,"Welcome Back, Admin!");
    }
 
 

}
