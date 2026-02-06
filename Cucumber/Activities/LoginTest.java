package StepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.jupiter.api.Assertions;

public class LoginTest extends BaseClass{
	
	
	@Given("the user is on the login page")
	public void openPage() {
	    driver.get("https://training-support.net/webelements/login-form");
	    Assertions.assertEquals(
	        "Selenium: Login Form",
	        driver.getTitle(),
	        "Login page title mismatch"
	    );
	}

	@When("the user enters {string} and {string}")
	public void enterCredentials(String username, String password) {
	    WebElement usernameField = driver.findElement(By.id("username"));
	    WebElement passwordField = driver.findElement(By.id("password"));

	    usernameField.clear();
	    passwordField.clear();

	    usernameField.sendKeys(username);
	    passwordField.sendKeys(password);
	}

	@And("clicks the submit button")
	public void clickSubmit() {
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("the confirmation message should be {string}")
	public void confirmMessage(String expectedMessage) {
	    By messageLocator = By.cssSelector("h2.mt-5");

	    wait.until(
	        ExpectedConditions.textToBePresentInElementLocated(messageLocator, "Welcome")
	    );

	    String actualMessage = driver.findElement(messageLocator).getText();

	    Assertions.assertEquals(
	        expectedMessage,
	        actualMessage,
	        "Confirmation message mismatch"
	    );
	}


}
