import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.get("https://training-support.net/webelements/target-practice");
		WebElement header3 = driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
	    System.out.println("The text of header 3 is :" +header3.getText());
	    String header5 = driver.findElement(By.xpath("//h5[contains(text(),'#5')]")).getCssValue("color");
	    Color fithheader = Color.fromString(header5);
	    System.out.println("The color of header 5 as rgb is: "+fithheader.asRgb() );
	    System.out.println("The color of header 5 as hex is: "+fithheader.asHex() );
	    System.out.println("The color of header 5 is: "+header5);
	    
	    WebElement purpleButton = driver.findElement(By.xpath("//button[text()=\"Purple\"]"));
	    System.out.println(purpleButton.getDomAttribute("class"));
	    WebElement slateButton = driver.findElement(By.xpath("//button[text()=\"Slate\"]"));
	    System.out.println(slateButton.getText());
	    
	    driver.quit();
	    
	    
	    

	}

}
