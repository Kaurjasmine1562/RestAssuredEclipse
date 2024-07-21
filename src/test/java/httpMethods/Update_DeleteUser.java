package httpMethods;

import org.testng.annotations.Test;

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
 *  POST --->
 *   Create resource on server
 *   1.HashMap
 *   2.POJO - plain old java object class[Encapsulation: data + function]
 */ 

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Update_DeleteUser {
  @Test
  public void PutRequest() {
	  
	  //payload
	  
	  POJOData data =new POJOData();
	  data.setName("Jasmine");
	  data.setJob("Automation Engineer");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when().put("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(200)
	  .log().body();
	   }
  
  @Test
  public void DELETERequest() {
	  
	  given()
	  
	  .when().delete("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(204)
	  .log().all();
  }
  
  
  
}
