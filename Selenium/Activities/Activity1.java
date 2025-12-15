import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		  ChromeDriver driver = new ChromeDriver();
	      
	      driver.get("https://training-support.net");
	      //driver.getTitle();
	      System.out.println(driver.getTitle());
	      
	      WebElement button=  driver.findElement(By.linkText("About Us"));
	      button.click();
	      Thread.sleep(200);
	      
	      System.out.println("New Title: " +driver.getTitle());
	      
	      driver.quit();

	}

}
