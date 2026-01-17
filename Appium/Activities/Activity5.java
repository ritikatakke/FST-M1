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

public class Activity5 {
	
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
	        options.setAppPackage("com.google.android.apps.messaging");
	        options.setAppActivity(".ui.ConversationListActivity");
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
	    	driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Riya Takke\"]"))).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text"))).sendKeys("Hello from Appium");
	    	driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"Compose:Draft:Send\"]/android.widget.Button")).click();
	    	String message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"You said  Hello from Appium 10:59 PM .\"]")).getText();
	    	Assert.assertEquals(message, "Hello from Appium");
	         }
	   
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	

}
