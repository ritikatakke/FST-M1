package Activities;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	
	RequestSpecification requestSpec;
	
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
	    requestSpec = new RequestSpecBuilder()
	        .addHeader("Content-Type", "application/json")
	        .setBaseUri("https://petstore.swagger.io/v2/pet")
	        .build();

	    responseSpec = new ResponseSpecBuilder()
	        .expectStatusCode(200)
	        .expectContentType("application/json")
	        .expectBody("status", equalTo("alive"))
	        .build();
	}
	
	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}


  @Test(priority=1,dataProvider = "petInfo")
  public void addPet(int petId, String petName, String petStatus) {
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
	        given()
			.spec(requestSpec) 
			.body(reqBody) 
			.when().post().then().spec(responseSpec).body("name", equalTo(petName)); 

		  }
  
  
  @Test(priority=2,dataProvider = "petInfo")
  
  public void getPetData(int petId, String petName, String petStatus) {
	            given()
				.spec(requestSpec)  
				.when().pathParam("petId", petId) 
				.get("/{petId}")
				.then().spec(responseSpec) // Assertions using responseSpec
			    .body("name", equalTo(petName)) // Additional Assertion
			    .log().all(); // Log for request details
; 

			
  }
  
  
  @Test(priority=3,dataProvider = "petInfo")
  public void deletePet(int petId, String petName, String petStatus) {
	             given()
				.spec(requestSpec) 
				.header("Content-Type", "application/json") 
				.when().pathParam("petId", petId) 
				.delete("/{petId}")
				.then()
				.body("code", equalTo(200))
				.body("message", equalTo(""+petId)); 
	  
	  
  }
  
}
