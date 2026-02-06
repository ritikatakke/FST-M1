package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps extends BaseClass{
	
	
    @When("the user enters username and password")
    public void enterCred() {
    	WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement password= driver.findElement(By.xpath("//input[@name=\"password\"]"));
	   username.sendKeys("admin");
	   password.sendKeys("password");
    	
    }

	/*
	 * @And("clicks the submit button") public void submit() { WebElement button =
	 * driver.findElement(By.xpath("//button[text()=\"Submit\"]")); button.click();
	 * 
	 * }
	 */
    @Then("get the confirmation message and verify it")
    public void verifyResult() {
    	
    	WebElement confirmationMessage = driver.findElement(By.xpath("//h1"));
    	wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
    	assertEquals(confirmationMessage,"confirmed");
    	
  	 
    	
    }
	
	

}
