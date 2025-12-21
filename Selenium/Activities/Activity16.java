import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity16 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/selects");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class,'h-10')]"));
        
        Select select = new Select(dropdown);
         select.selectByVisibleText("Two");
         System.out.println("Second option: " + select.getFirstSelectedOption().getText());
         select.selectByIndex(3);
         System.out.println("Third option: " + select.getFirstSelectedOption().getText());
        select.selectByValue("four");
         System.out.println("fourth option: " + select.getFirstSelectedOption().getText());
         
         List<WebElement> options  = select.getOptions();
         for(WebElement option: options) {
        	 System.out.println(option.getText());
         }
        	 

        driver.quit();
    }
}
