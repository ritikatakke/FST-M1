package TestActivity;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





@Test
public class Activity9 {
	
	ChromeDriver driver;
	@BeforeClass
	public  void initiate() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Opening Chrome Browser");
	}
	
	@AfterClass
	public  void close() {
		driver.quit();
		Reporter.log("Cosing Browser");
	}
	@BeforeMethod
	public void switchTopage() {
		
		driver.switchTo().defaultContent();
		Reporter.log("Switch To Main Window ");
		
	}
	
	@Test
	public void testSimpleAlert() {
		
		WebElement simpleAlert = driver.findElement(By.id("simple"));
		Reporter.log("Finding simple Alert Button");
		simpleAlert.click();
		Reporter.log("Click on simple Alert Button");
		Alert alert = driver.switchTo().alert();
		Reporter.log("Switching To Alert");
		String text = alert.getText();
		Reporter.log("Alert Text");
		Assert.assertEquals("You've just triggered a simple alert!", text);
		alert.accept();
		Reporter.log("Accept Alert");
		Reporter.log("End of Testcase");
		
		
		}
	
	@Test
	public void testConfirmationAlert() {
		
		WebElement simpleAlert = driver.findElement(By.id("confirmation"));
		Reporter.log("Finding simple Alert Button");
		simpleAlert.click();
		Reporter.log("Click on simple Alert Button");
		Alert alert = driver.switchTo().alert();
		Reporter.log("Switching To Alert");
		String text = alert.getText();
		Reporter.log("Alert Text");
		Assert.assertEquals("You've just triggered a confirmation alert!", text);
		alert.accept();
		Reporter.log("Accept Alert");
		Reporter.log("End of Testcase");
		
		
		}
	
	@Test
	public void testpromptAlert() {
		
		WebElement simpleAlert = driver.findElement(By.id("prompt"));
		Reporter.log("Finding simple Alert Button");
		simpleAlert.click();
		Reporter.log("Click on simple Alert Button");
		Alert alert = driver.switchTo().alert();
		Reporter.log("Switching To Alert");
		String text = alert.getText();
		Reporter.log("Alert Text");
		Assert.assertEquals("I'm a Prompt! Type something into me!", text);
		alert.sendKeys("Hello Ritika");
		Reporter.log("Sending text to Alert");
		alert.accept();
		Reporter.log("Accept Alert");
		Reporter.log("End of Testcase");
		
		
		}

}
