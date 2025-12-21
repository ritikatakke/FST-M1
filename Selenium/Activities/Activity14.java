import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity14 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/tables");
        System.out.println("Title of page is : " + driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("The number of rows in table is :" +rows.size());
        
        List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("The number of columns in table is :" +columns.size());
       
        WebElement bookName = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("The book name in 5th row is: "+bookName.getText());
        
        WebElement priceHeader = driver.findElement(By.xpath("//table/thead/tr/th[5]"));
        priceHeader.click();
        WebElement bookNameAfter = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("The book name in 5th row after sorting is: "+bookNameAfter.getText());
        
        driver.quit();
    }
}
