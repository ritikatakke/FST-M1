import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity12 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement toggleCheckbox = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
        if(checkbox.isDisplayed()) {
        	System.out.println("checkbox is visible");
        }
        toggleCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        if (!(checkbox.isDisplayed())) {
        	System.out.println("checkbox is not visible");
        }
        toggleCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        if(checkbox.isDisplayed()) {
        	System.out.println("checkbox is visible");
        	checkbox.click();
        }
     
        
        
        driver.quit();
    }
}
