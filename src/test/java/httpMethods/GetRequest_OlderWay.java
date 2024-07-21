package httpMethods;

import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest_OlderWay {
  @Test
  public void SingleUserGetRequest() {
	  Response res =RestAssured.get("https://www.google.com/");
	  System.out.println(res.statusCode());
	  System.out.println(res.statusLine());
	  System.out.println(res.getTime());
	  
	 int actcode = res.getStatusCode();
	  
	  Assert.assertEquals(actcode, 200, "AssertFail: Status code does not match");
	  System.out.println("TestPass: Status code matches 200");
	  
  }
}
