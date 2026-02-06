package StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Fixtures extends BaseClass {
    @BeforeAll
    public static void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    @AfterAll
    public static void tearDown() {
        // Close the browser
        driver.quit();
    }
}
