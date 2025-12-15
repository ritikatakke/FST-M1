import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver   driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The Title of page is; "+driver.getTitle());
		
	    WebElement checkbox = driver.findElement(By.id("checkbox"));
	    checkbox.click();
	    if(checkbox.isSelected()) {
	    	System.out.println("The checkbox is selected");
	    }
	    else {
	    	System.out.println("The checkbox is not selected");
	    }
	    checkbox.click();
	    if(checkbox.isSelected()) {
	    	System.out.println("The checkbox is selected");
	    }
	    else {
	    	System.out.println("The checkbox is not selected");
	    }
	    driver.quit();
	}

}
