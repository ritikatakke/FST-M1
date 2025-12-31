package TestActivity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class Activity2 {
	ChromeDriver driver;
	@BeforeClass
	public  void initiate() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@AfterClass
	public  void close() {
		driver.quit();
	}
	@Test
    public void testCase1() {
        
                Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
    }
 
    @Test
    public void testCase2() {
        
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
    
    }
 
    @Test(enabled = false)
    public void testCase3() {
    	 WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
         Assert.assertTrue(blackButton.isDisplayed());
     
    }
 
    @Test
    public void testCase4() {
    	 throw new SkipException("Skipping test case");
    	 
     
       
    }
	

}
