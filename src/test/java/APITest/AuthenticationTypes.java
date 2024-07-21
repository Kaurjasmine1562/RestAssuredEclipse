package APITest;

import org.testng.annotations.Test;

import httpMethods.POJOData;

/* 
 * Given() - pre-requisite ---> Headers/cookies/path/querry param/Request payload(Resource)/authentication

 * 
 * When() - Send Request  ---> GET/PUT/POST/PATCH/DELETE
 * 
 * Then() - Validate Response ---> Status code/response payload/status msg
 * 
 * METHODS----------->
 *   equalTo() - Test equality for data
 *   hasItems() - Check all the items that are in the collection
 *   contains() - Check all the items that are in the collection and in strict order
 *   
 *   Serialization - Conversion of java object into json
 *   
 *   De-Serialization - Conversion of json to java object 
 *   
 *   */
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AuthenticationTypes {
  @Test(priority=1)
  public void BasicAuth() {
	  
	  //Base64 Algorithm
	  
	given()
	.auth().basic("postman","password")
	
	.when().get("https://postman-echo.com/basic-auth")
	
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().body();
	
	System.out.println("Basic authentication is completed!");
	   }
  
  @Test(priority=2)
  public void DigestAuth() {
	  
	  //MD5 Algorithm
	  
	given()
	.auth().digest("postman","password")
	
	.when().get("https://postman-echo.com/digest-auth")
	
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().body();
	
	System.out.println("Digest authentication is completed!");
	   }
  
  @Test(priority=3)
  public void BearerToken() {
	  	  
	given()
	.headers("Authorization","Bearer 12345")
	
	.when().get("https://postman-echo.com")
	
	.then()
	.statusCode(200)
	.log().body();
	
	System.out.println("bearer Token authentication is completed!");
	   }
  
  @Test(priority=4)
  public void GoRest_POST() {
	  POJOData data = new POJOData();
		 data.setName("Jasmine Kaur");
		 data.setJob("QA");
		 
	given()
	.headers("Authorization","Bearer 2777f7a2979d705f7d7d8b2b7c72ae23ecca67b061f6d20ab8ef408f264d1289")
	.body(data)
	.when().get("https://gorest.co.in/public/v2/users")
	
	.then()
	.statusCode(200)
	.log().body();
	
	System.out.println("Go_Rest authentication is completed!");
  
  }
  
  @Test(priority=5)
  public void OAuth2Auth() {
	  
	  //Open Authentication
	  	  
	given()
	.auth().oauth2("12345")
	
	.when().get("https://postman-echo.com")
	
	.then()
	.statusCode(200)
	.log().body();
	
	System.out.println("OAuth2 authentication is completed!");
	   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
