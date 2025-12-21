import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity11 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/dynamic-content");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement clickMe = driver.findElement(By.id("genButton"));
        WebElement text = driver.findElement(By.id("word"));
        clickMe.click();
       if(wait.until(ExpectedConditions.textToBePresentInElement(text, "release"))) {
    	   System.out.println("Text Release found");
       }
        
        
        driver.quit();
    }
}
