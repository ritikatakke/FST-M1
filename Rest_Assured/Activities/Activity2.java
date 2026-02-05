package Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {
	
	String base_uri= "https://petstore.swagger.io/v2/user";
  @Test(priority=1)
  public void addUser() throws FileNotFoundException {
	  FileInputStream userData = new FileInputStream("src/test/resources/userData.json");
		Response response = given()
			.baseUri(base_uri) 
			.header("Content-Type", "application/json") 
			.body(userData) 
			.when().post(); 

		response.then().statusCode(200);
		response.then().body("message", equalTo("2026"));
		
  }
  
  
  @Test(priority=2)
  
  public void getUserData() {
	  
		File outputJSON = new File("src/test/resources/userGETResponse.json");
	  Response response = given()
				.baseUri(base_uri) 
				.header("Content-Type", "application/json") 
				.when().pathParam("username", "Ritika") 
				.get("/{username}"); 
	  
	  String resBody = response.getBody().asPrettyString();
	  
		try {
			
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		
		response.then().body("id", equalTo(2026));
		response.then().body("username", equalTo("Ritika"));
		response.then().body("firstName", equalTo("Ritu"));
		response.then().body("lastName", equalTo("Takke"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));

			
  }
  
  
  @Test(priority=3)
  public void deletePet() {
	  Response response = given()
				.baseUri(base_uri) 
				.header("Content-Type", "application/json") 
				.when().pathParam("username", "Ritika") 
				.delete("/{username}");
	  
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("Ritika"));
	  
  }
  
}
