package httpMethods;

import org.testng.Assert;

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
  
 @Test
 public void post_POJO() {
	 
	 //Payload
	 
	 POJOData data = new POJOData();
	 data.setName("Jasmine");
	 data.setJob("QA");
	 
	 
	 given()
	 .contentType("application/json")
	 .body(data)
	 
	 .when().post("https://reqres.in/api/users")
	 
	 .then()
	 .statusCode(201)
	 .body("job", equalTo("QA"))
	 .log().body();
	 
	 System.out.println(data.getName());
	 Assert.assertTrue(data.getName().equals("Jasmine"), "Assertion Fail: Name is not matching!");
	 System.out.println("Assertion Pass: Name is matching");
	 
 }
  
  
  
  
  
  
  
  
  
  
  
  
}
