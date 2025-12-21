import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity20 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement confirmation = driver.findElement(By.id("confirmation"));
        confirmation.click();
        Alert alert = driver.switchTo().alert();
        
        
        System.out.println(alert.getText());
        alert.accept();
        
        System.out.println(driver.findElement(By.id("result")).getText());
        
        
        driver.quit();
    }
    
   
    
}
