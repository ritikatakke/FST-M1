package Activities;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {
	
	String base_uri= "https://petstore.swagger.io/v2/pet";
  @Test(priority=1)
  public void addPet() {
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77232);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");

		Response response = given()
			.baseUri(base_uri) 
			.header("Content-Type", "application/json") 
			.body(reqBody) 
			.when().post(); 

		response.then().statusCode(200);
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
  }
  
  
  @Test(priority=2)
  
  public void getPetData() {
	  Response response = given()
				.baseUri(base_uri) 
				.header("Content-Type", "application/json") 
				.when().pathParam("petId", 77232) 
				.get("/{petId}"); 

			response.then().body("id", equalTo(77232));
			response.then().body("name", equalTo("Riley"));
			response.then().body("status", equalTo("alive"));

  }
  
  
  @Test(priority=3)
  public void deletePet() {
	  Response response = given()
				.baseUri(base_uri) 
				.header("Content-Type", "application/json") 
				.when().pathParam("petId", 77232) 
				.delete("/{petId}");
	  
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("77232"));
	  
  }
  
}
