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

public class Activity17 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/selects");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class,'h-80')]"));
        
        Select select = new Select(dropdown);
         select.selectByVisibleText("HTML");
         select.selectByIndex(3);
         select.selectByIndex(4);
         select.selectByIndex(5);
         select.selectByValue("nodejs");
        
         List<WebElement> options  = select.getAllSelectedOptions();
          display(options);
         select.deselectByIndex(4);
         List<WebElement> options1  = select.getAllSelectedOptions();
         display(options1);
        
        driver.quit();
    }
    
    public static void display(List<WebElement> options) {
    	System.out.println("Selected Option");
    	 for(WebElement option: options) {
        	 System.out.println(option.getText());
         }
    }
}
