package Project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class WebProjectApp {

    AndroidDriver driver;
    WebDriverWait wait;

    // ==============================
    // SETUP
    // ==============================
    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Handle Chrome first launch popups (if any)
        try {
            driver.findElement(AppiumBy.id("com.android.chrome:id/accept_terms_button")).click();
            driver.findElement(AppiumBy.id("com.android.chrome:id/negative_button")).click();
        } catch (Exception e) {
            // Chrome already configured
        }
    }

    // ==============================
    // 1️⃣ To-Do List Test
    // ==============================
    @Test(priority = 1)
    public void chromeTodoListTest() {

        driver.get("https://training-support.net/webelements");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")
        ));
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.77));
        Point end   = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.23));

        ActionBase.doSwipe(driver, start, end, 100);

        

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='todo-input']")
        ));

        WebElement input =
                driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='todo-input']"));
        WebElement addBtn =
                driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='todo-add']"));

        input.sendKeys("Add tasks to list");
        addBtn.click();

        input.sendKeys("Get number of tasks");
        addBtn.click();

        input.sendKeys("Clear the list");
        addBtn.click();

        List<WebElement> tasks =
                driver.findElements(AppiumBy.xpath("//android.widget.ListView/*"));

        // 2 default + 3 added
        assertEquals(tasks.size(), 5);
    }

    // ==============================
    // 2️⃣ Login Form Test
    // ==============================
    @Test(priority = 2, dependsOnMethods = "chromeTodoListTest")
    public void chromeLoginFormTest() {

        driver.get("https://training-support.net/webelements");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")
        ));

        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.77));
        Point end   = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.23));

        ActionBase.doSwipe(driver, start, end, 500);


        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'Login Form')]")
        )).click();

        //Invalid Login
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("Ritika");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
        String invalid =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")
                )).getText();
        assertTrue(invalid.contains("Invalid credentials"));

       
        
        // VALID LOGIN
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

        String successMsg =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")
                )).getText();
        assertTrue(successMsg.contains("Login Success!"));

        
    }

    // ==============================
    // 3️⃣ Popup Login Test
    // ==============================
    @Test(priority = 3, dependsOnMethods = "chromeLoginFormTest")
    public void chromePopupLoginTest() {

        driver.get("https://training-support.net/webelements");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")
        ));
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.77));
        Point end   = new Point((int) (dims.getWidth() * 0.5),
                                (int) (dims.getHeight() * 0.23));

        ActionBase.doSwipe(driver, start, end, 200);


        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'Popups')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")
        )).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

        String successMsg =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")
                )).getText();
        assertTrue(successMsg.contains("Login Success!"));

        
    }

    
    // ==============================
    // TEARDOWN
    // ==============================
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
