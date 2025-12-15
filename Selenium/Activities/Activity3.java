import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.get("https://training-support.net/webelements/login-form");
		
		System.out.println("Title of Page is " + driver.getTitle());
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement password= driver.findElement(By.xpath("//input[@name=\"password\"]"));
	   username.sendKeys("admin");
	   password.sendKeys("password");
	   WebElement button =  driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
	   button.click();
	   Thread.sleep(1000);
	   String message = driver.findElement(By.xpath("//h1")).getText();
	  System.out.println( message);
	 
	  
	   driver.quit();
		
		// TODO Auto-generated method stub
		
	}

}
