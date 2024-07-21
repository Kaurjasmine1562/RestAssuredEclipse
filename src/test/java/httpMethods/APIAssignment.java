package httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class APIAssignment {
  @Test
  public void ListOfUsers() {
	  given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.log().body();
	  System.out.println("List of all the users");
  }


  @Test
  public void PostWithHashMap() {
    HashMap<String,Object>data = new HashMap<String,Object>();
    data.put("name", "Jasmine");
    data.put("job", "QA");

   given()
  .contentType("application/json")
  .body(data)
  
  .when()
  .post("https://reqres.in/api/users")
  
  .then()
  .statusCode(201)
  .log().body();
 }
  
  
  @Test
  public void post_POJO() {
 	 
 	 POJOData data = new POJOData();
 	 data.setName("Jasmine");
 	 data.setJob("QA");
 	 
 	 
 	 given()
 	 .contentType("application/json")
 	 .body(data)
 	 
 	 .when().post("https://reqres.in/api/users")
 	 
 	 .then()
 	 .statusCode(201)
 	 .log().body();
 	
 	 
  }
  
  
  @Test
  public void DeleteUser() {
	  
	   given()
	  
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  
	   .then()
	   .statusCode(204);
	   
	   System.out.println("User deleted");
	   }
  
  
  
  @Test
  public void OAuth2Auth() {
	  	  
	given()
	.auth().oauth2("12345")
	
	.when().get("https://postman-echo.com")
	
	.then()
	.statusCode(200)
	.log().body();
	
	System.out.println("OAuth2 authentication is completed!");
	   }






































}