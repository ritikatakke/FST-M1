import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver   driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The Title of page is; "+driver.getTitle());
		
	    WebElement checkbox = driver.findElement(By.id("checkbox"));
	    if(checkbox.isDisplayed()) {
	    	System.out.println("The checkbox is displayed");
	    }
	    else {
	    	System.out.println("The checkbox is not displayed");
	    }
	    WebElement toggle_checkbox = driver.findElement(By.xpath("//button[text()=\"Toggle Checkbox\"]"));
	    toggle_checkbox.click();
	    if(checkbox.isDisplayed()) {
	    	System.out.println("The checkbox is displayed");
	    }
	    else {
	    	System.out.println("The checkbox is not displayed");
	    }
	    driver.quit();
	}

}
