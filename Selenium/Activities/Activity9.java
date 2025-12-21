import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/keyboard-events");
        System.out.println("Title of page is : " + driver.getTitle());

        
        action.sendKeys("Hi My name is ritika").sendKeys(Keys.RETURN).build().perform();
        
       String textEntered = driver.findElement(By.cssSelector("h1.mt-3")).getText();
       System.out.println("The entered text :" +textEntered);
      
        driver.quit();
    }
}
