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

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesTest {
  @Test
  public void getAllCookies() {
	  
	  given()
	  .when().get("https://www.google.com")
	  .then()
	  .log().cookies();
	  
  }
  
  @Test
  public void getSingleCookie() {
	  
	 Response res = given()
	  .when().get("https://www.google.com");
	 String actValue = res.getCookie("AEC");
	 System.out.println(actValue);
	 String exp = "AQTF6HwXmjOAx7Qrkz9j1wuSIvnlsE";
	 //Validation as cookies are dynamic and should not be same
	 Assert.assertFalse(actValue.contains(exp),"Test Fail as cookies are same value");
	 System.out.println("Test Pass as cookies are different");
   }
  
  @Test
  public void getSetofCookies() {
	  
	 Response res = given()
	  .when().get("https://www.google.com");
	 
	 Map<String,String> map = res.getCookies();
	 
	 System.out.println(map);
	 
	 //iteration
	 
	 for(Map.Entry<String,String> i:map.entrySet())
	 {
		 System.out.println(i.getKey()+":"+i.getValue());
	 }
	 
	 
  
  
  
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
