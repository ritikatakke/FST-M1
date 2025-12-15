import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver   driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The Title of page is; "+driver.getTitle());
		
	    WebElement inputBox = driver.findElement(By.id("textInput"));
	    inputBox.click();
	    if(inputBox.isEnabled()) {
	    	System.out.println("The input box is enabled");
	    }
	    else {
	    	System.out.println("The input box is disabled");
	    }
	    WebElement enableInputBox = driver.findElement(By.id("textInputButton"));  
	    enableInputBox.click();
	    inputBox.sendKeys("Hello");
	    if(inputBox.isEnabled()) {
	    	System.out.println("The input box is enabled");
	    	System.out.println(inputBox.getDomProperty("value"));
	    }
	    else {
	    	System.out.println("The input box is disabled");
	    }
	    driver.quit();
	}

}
