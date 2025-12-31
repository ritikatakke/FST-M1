package TestActivity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class Activity1 {
	ChromeDriver driver;
	@BeforeClass
	public  void initiate() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net");
	}
	
	@AfterClass
	public  void close() {
		driver.quit();
	}
	
	@Test
	public void titleCheck() throws InterruptedException {
		AssertJUnit.assertEquals("Training Support",driver.getTitle());
		Thread.sleep(1000);
		}
	@Test
	public void aboutPageTitle() {
		
		WebElement aboutUs = driver.findElement(By.linkText("About Us")); 
		aboutUs.click();
		AssertJUnit.assertEquals("About Training Support",driver.getTitle() );
		
		
	}
	
	

}
