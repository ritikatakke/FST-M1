package Activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	
	    WebDriverWait wait;
	    AndroidDriver driver;

	    // Set up method
	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	    	//File appFile = new File("src/test/resources/calculator.apk");
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.contacts");
	        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
	        //options.setApp(appFile.getAbsolutePath());
	        options.noReset();

	        // Server URL
	        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

	        // Driver initialization
	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Open the page in browser
	       // driver.get("https://www.training-support.net/selenium/target-practice");
	    }

	    @Test
	    public void addition() {
	    	//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"View contacts\"]")).click();
	    	driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
	        //wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]"))).sendKeys("Ritika");
	    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Riya ");
	    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Takke");
	    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]")).sendKeys("+919768911985");
	    	
	    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Save\"]")).click();
	    	WebElement name = driver.findElement(AppiumBy.id("large_title"));
	        wait.until(ExpectedConditions.visibilityOf(name));
	    	Assert.assertEquals(name.getText(), "Riya Takke");
	    }
	   
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	

}
