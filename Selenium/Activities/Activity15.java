import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity15 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/dynamic-attributes");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement name = driver.findElement(By.cssSelector("input[id^='full-name']"));
        WebElement email = driver.findElement(By.cssSelector("input[id$='email']"));
        WebElement date = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
        WebElement additionalDetail = driver.findElement(By.xpath("//textarea[contains(@name, '-additional-details-')]"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        WebElement success_message = driver.findElement(By.id("action-confirmation"));
        
        name.sendKeys("ritika");
        email.sendKeys("ritika.takke@gmail.com");
        date.sendKeys("2025-06-21");
        additionalDetail.sendKeys("we are testing dynamic page");
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if(success_message.isDisplayed()) {
        	System.out.println("Success message is dsiplayed");
        }
        
        
        
        driver.quit();
    }
}
