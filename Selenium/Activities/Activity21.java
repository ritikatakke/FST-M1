import java.util.List;
import java.util.Set;

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

public class Activity21 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/tabs");
        System.out.println("Title of page is : " + driver.getTitle());
    	
        String parentHandle = driver.getWindowHandle();

        WebElement tabButton = driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
        tabButton.click();
    	
        Set<String> handles = driver.getWindowHandles();
         
        // Loop through the Set and switch to the window
        // whose handle doesn't match the parentHandle
        for(String handle : handles) {
           
             System.out.println(handle);
            }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

      
        System.out.println("New tab title: " + driver.getTitle());
        System.out.println("New tab message: " +driver.findElement(By.tagName("h2")).getText());
        WebElement tabButton2 = driver.findElement(By.xpath("//button[text()='Open Another One']"));
        tabButton2.click();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

      
        System.out.println("New tab title: " + driver.getTitle());
        System.out.println("New tab message: " +driver.findElement(By.tagName("h2")).getText());
        
        driver.quit();
    }
    
   
    
}
