package APITest;

import org.testng.annotations.Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

public class Serialization_Deserialization {
  @Test
  public void SerializationTest() throws JsonProcessingException {
	  POJOData data = new POJOData();
	  data.setName("Jasmine");
	  data.setJob("QA");
	  
	  //Mapper class for conversion
	  ObjectMapper mapper = new ObjectMapper();
	String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	//printing
	System.out.println(json);
	  
  }
  
  @Test
  public void DeSerialization() throws JsonMappingException, JsonProcessingException {
	String jsondata = "{\n"
			+ "  \"name\" : \"Jasmine\",\n"
			+ "  \"job\" : \"QA\"\n"
			+ "}";
  
  //objectmapperclass for conversion
  
	 ObjectMapper mapper= new ObjectMapper();
POJOData data = mapper.readValue(jsondata, POJOData.class);
System.out.println(data.getName());
System.out.println(data.getJob());

  
  
   }
  
  
  
  
  
  
  
  
  
  
  
  
}
