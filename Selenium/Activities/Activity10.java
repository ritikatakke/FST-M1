import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://training-support.net/webelements/drag-drop");
        System.out.println("Title of page is : " + driver.getTitle());

        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        WebElement ball = driver.findElement(By.id("ball"));

        WebElement dropzoneText = driver.findElement(By.className("dropzone-text"));
        		
        action.clickAndHold(ball).moveToElement(dropzone1).release().build().perform();
        if(dropzoneText.getText().equals("Dropped!")) {
        	System.out.println("Ball is dropped in zone1");
        }
        else {
        	System.out.println("Ball is not dropped in zone1");
        }
        
        action.dragAndDrop(ball,dropzone2).build().perform();
        if(dropzoneText.getText().equals("Dropped!")) {
        	System.out.println("Ball is dropped in zone2");
        }
        else {
        	System.out.println("Ball is not dropped in zone2");
        }
        driver.quit();
    }
}
