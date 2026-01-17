package Activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	    WebDriverWait wait;
	    AndroidDriver driver;

	    // Set up method
	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.android.chrome");
	        options.setAppActivity("com.google.android.apps.chrome.Main");
	        options.noReset();

	        // Server URL
	        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

	        // Driver initialization
	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Open the page in browser
	        driver.get("https://www.training-support.net");
	    }

	    @Test
	    public void PageTitle() {
	       String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")).getText();
	       Assert.assertEquals(pageTitle, "Training Support");
	       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).click();
	       String pageText= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
	       Assert.assertEquals(pageText, "About Us");
	        
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	

}
