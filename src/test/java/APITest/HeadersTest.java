package APITest;

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

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersTest {
  @Test
  public void getAllHeaders() {
	  given()
	  
	  .when().get("https://www.google.com")
	  .then()
	  .log().headers();
	  }
  
  
  @Test
  public void ValidateSingleHeader() {
	 Response res=given()
	  
	  .when().get("https://www.google.com");
	  String header = res.getHeader("Content-Type");
  System.out.println(header);          //non dynamic same everytime
  
  //validation
  
  Assert.assertEquals(header, "text/html; charset=ISO-8859-1","Test Fail as headers not match");
  System.out.println("Test Pass as headers match");
  
  }
  
  @Test
  public void TestHeaders() {
	 Response res=given()
			 .when().get("https://www.google.com");
	 
	Headers hd = res.getHeaders();
	 System.out.println(hd);
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
