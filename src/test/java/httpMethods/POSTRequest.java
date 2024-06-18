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

import java.util.HashMap;

public class POSTRequest {
  @Test
  public void PostWithHashMap() {
	  
	  //Request Payload
	  HashMap<String,Object>data = new HashMap<String,Object>();
	  data.put("name", "Priyanka");
	  data.put("job", "SDET");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  .when()
	  .post("https://reqres.in/api/users") 
	  .then()
	  .statusCode(201)
	  .body("name", equalTo("Priyanka"))
	  .log().body();
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
