import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {
    public static void main(String[] args) {

        WebDriver driver = new  ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/popups");
        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("launcher")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
        System.out.println("Message display after Login " + message);

        driver.quit();
    }
}
