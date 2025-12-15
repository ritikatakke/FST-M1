import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.get("https://training-support.net/webelements/login-form");
		
		System.out.println("Title of Page is " + driver.getTitle());
		WebElement username = driver.findElement(By.id("username"));
		WebElement password= driver.findElement(By.id("password"));
	   username.sendKeys("admin");
	   password.sendKeys("password");
	   WebElement button =  driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
	   button.click();
	   
	   WebElement message = driver.findElement(By.tagName("h1"));
	  System.out.println( message.getText());
	 
	   Thread.sleep(6000);
	   driver.quit();
		
		// TODO Auto-generated method stub
		
	}

}
