import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/mouse-events");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));

        action.click(cargoLock)
              .pause(200)
              .moveToElement(cargoToml)
              .pause(200)
              .click(cargoToml)
              .build()
              .perform();

        WebElement message = driver.findElement(By.id("result"));
        System.out.println("Confirmation text when we click on cargo.toml is " + message.getText());

        action.doubleClick(src)
              .pause(200)
              .contextClick(target)
              .pause(1000)
              .build()
              .perform();

        WebElement open = driver.findElement(By.xpath("//ul/li[1]/button"));
        action.click(open).pause(200).build().perform();

        WebElement targetMessage = driver.findElement(By.id("result"));
        System.out.println("Confirmation text when we click on src is : " + targetMessage.getText());

        driver.quit();
    }
}
