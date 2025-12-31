package TestActivity;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	ChromeDriver driver;
	@BeforeClass(alwaysRun = true)
	public  void initiate() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@AfterClass(alwaysRun = true)
	public  void close() {
		driver.quit();
	}
	
	@Test
	public void testTitle() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	
	@Test(groups = {"headerTest"})
	public void testHeader3() {
		WebElement header3 = driver.findElement(By.tagName("h3"));
		Assert.assertEquals(header3.getText(), "Heading #3");
	
		
	}
	@Test(groups = {"headerTest"})
	public void testHeader5() {
		Color header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
	}

	@Test(groups = {"buttonTest"})
	public void buttonTest()
	{
		Assert.assertEquals("Emerald", driver.findElement(By.className("emerald")).getText());
	}
	@Test(groups = {"buttonTest"})
	public void buttonTest2() {
		Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#581c87");
	}
}
