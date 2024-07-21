package httpMethods;

import org.testng.annotations.Test;


import io.restassured.response.Response;

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

public class SameUserCreate_Update_Delete {
	String id;
  @Test (priority = 1)
  public void CreateNewUser() {
	  
	  POJOData data = new POJOData();
	  data.setName("Jasmine");
	  data.setJob("QA");
	  
	  //Full response
	  //Response is interface
	  
	/* Response res = given()
	      .contentType("application/json")
	      .body(data)
	  
	  .when()
	  .post("https://reqres.in/api/users");
	  
	  System.out.println(res.asString()); */  //convert in a string to see the data
	  
	  //Json ---> id
	  
	   id = given()
		      .contentType("application/json")
		      .body(data)
		  
		  .when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().get("id");
	  
	  System.out.println("User created with id:" + id); 
	  }
		  
	  @Test(priority=2,dependsOnMethods = "CreateNewUser")
	  public void updateSameUser() {
		   	
		  POJOData data = new POJOData();
		  data.setName("Navjot");
		  data.setJob("Developer");
		  
		   given()
		      .contentType("application/json")
		      .body(data)
		  
		  .when()
		  .put("https://reqres.in/api/users/"+id)
		  
		   .then()
		   .statusCode(200)
		   .log().body();
		   
		   System.out.println("User Updated with id:"+id);
		  
		  
	  }
	  
	  
	  @Test(priority=3,dependsOnMethods = "updateSameUser")
	  public void DeleteSameUser() {
		  
		   given()
		  
		  .when()
		  .delete("https://reqres.in/api/users/"+id)
		  
		   .then()
		   .statusCode(204);
		   
		   System.out.println("User deleted with id:"+id);
		   }
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

