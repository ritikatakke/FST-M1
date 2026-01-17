package Activities;

import java.io.File;
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

public class Activity3 {
	
	    WebDriverWait wait;
	    AndroidDriver driver;

	    // Set up method
	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	    	File appFile = new File("src/test/resources/calculator.apk");
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setApp(appFile.getAbsolutePath());
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
	    	driver.findElement(AppiumBy.id("digit_5")).click();
	    	driver.findElement(AppiumBy.accessibilityId("plus")).click();
	    	driver.findElement(AppiumBy.id("digit_9")).click();
	    	
	    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    	String result = driver.findElement(AppiumBy.id("result_final")).getText();
	    	Assert.assertEquals(result, "14");
	    	
	        // Wait for elements to load
	    }
	    @Test
	    public void testSubtraction() {
	    	driver.findElement(AppiumBy.id("digit_1")).click();
	    	driver.findElement(AppiumBy.id("digit_0")).click();
	    	driver.findElement(AppiumBy.accessibilityId("minus")).click();
	    	driver.findElement(AppiumBy.id("digit_5")).click();
	    	
	    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    	String result = driver.findElement(AppiumBy.id("result_final")).getText();
	    	Assert.assertEquals(result, "5");
	    	
	        // Wait for elements to load
	    }
	    @Test
	    public void testMultiplication() {
	    	driver.findElement(AppiumBy.id("digit_5")).click();
	    	driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	    	driver.findElement(AppiumBy.id("digit_1")).click();
	    	driver.findElement(AppiumBy.id("digit_0")).click();
	    	driver.findElement(AppiumBy.id("digit_0")).click();
	    	
	    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    	String result = driver.findElement(AppiumBy.id("result_final")).getText();
	    	Assert.assertEquals(result, "500");
	    	
	        // Wait for elements to load
	    }
	    
	    @Test
	    public void testDivision() {
	    	driver.findElement(AppiumBy.id("digit_5")).click();
	    	driver.findElement(AppiumBy.id("digit_0")).click();
	    	driver.findElement(AppiumBy.accessibilityId("divide")).click();
	    	driver.findElement(AppiumBy.id("digit_2")).click();
	    	
	    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    	String result = driver.findElement(AppiumBy.id("result_final")).getText();
	    	Assert.assertEquals(result, "25");
	    	
	        // Wait for elements to load
	    }
	    

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	

}
