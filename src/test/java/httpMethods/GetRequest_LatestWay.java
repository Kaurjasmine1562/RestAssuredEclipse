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
 */ 

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequest_LatestWay {
	@Test(priority = 1)
	public void SingleUserRequest() {

		given() 
		
		.when()
		     .get("https://reqres.in/api/users/2")
		
		.then()
		     .statusCode(200)
		     .body("data.first_name",equalTo("Janet"))  //Validating json body 
		     .body("data.email",equalTo("janet.weaver@reqres.in"))
		     .log().all();
		
		System.out.println("Single User Validation is done!");
	}
	
	@Test(priority =2)
	public void ListOfUsers() {
		
		given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.body("data.id[2]",equalTo(9))
		
		//all ID's from Json body
		.body("data.id", hasItems(7,8,9,10,11,12))
		
		//Changing the order
		.body("data.id", hasItems(7,9,8,11,12,10))   //PASS
		
		//partial ID's
		.body("data.id", hasItems(7,9,8))   //PASS 
		
		
		
		//CONTAINS - Check all the items that are in the collection and in strict order
		.body("data.id", hasItems(7,9,8,11,12,10))   //PASS
		
		//partial ID's
		.body("data.id", hasItems(7,9,8))   //FAIL DUE TO STRICT ORDER
		
		
		
		.log().body();
		
	}
	
	
}





















