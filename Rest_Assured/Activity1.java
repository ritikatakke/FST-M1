

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
import org.testng.Reporter;


public class Activity1 {
	
	RequestSpecification requestSpec;
	
	ResponseSpecification responseSpec;
	
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINy/+wRdWw0dsCVQ3n5VCEjo7DwqFUgi/3xt+Hm5sffI azuread\\ritikatakke@IBM-PF399SG4";

    
    int keyId;
	
	@BeforeClass
	public void setUp() {
	    requestSpec = new RequestSpecBuilder()
	        .addHeader("Content-Type", "application/json")
	        .setBaseUri("https://api.github.com")
	        .addHeader("Authorization", "Bearer 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")
	        .build();

	}
	
	


  @Test(priority=1 )
  public void addSSHKey() {
	  
	    String reqBody = "{\n" +
	            "  \"title\": \"TestAPIKey\",\n" +
	            "  \"key\": \"" + sshKey + "\"\n" +
	            "}";

	  Response response =given()
			.spec(requestSpec) 
			.body(reqBody) 
			.when().post("/user/keys")
			.then().log().all()
			.statusCode(201).extract().response();
	      
	      
	      
	      keyId=response.jsonPath().getInt("id");

		  }
  
  
  @Test(priority=2, dependsOnMethods="addSSHKey")
  
  public void getSSHKey() {
	          Response response=  given()
				.spec(requestSpec)  
				.when().pathParam("keyId", keyId) 
				.get("/user/keys/{keyId}")
				.then().log().all()
				.statusCode(200)
				.extract().response();
	            Reporter.log("GET Response: " + response.asPrettyString(), true);
	            

			
  }
  
  
  @Test(priority=3)
  public void deleteSSHKey() {
	  
	          Response response=   given()
				.spec(requestSpec) 
				.header("Content-Type", "application/json") 
				.when().pathParam("keyId", keyId) 
				.delete("/user/keys/{keyId}")
				.then().log().all()
				.statusCode(204)
				.extract().response();
	          Reporter.log("GET Response: " + response.asPrettyString(), true);

		
	  
	  
  }
  
  
}
