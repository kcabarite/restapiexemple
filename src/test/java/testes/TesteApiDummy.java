package testes;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.junit.FixMethodOrder;
//import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteApiDummy {


		@Test()
		public void test1_getAllEmployee() {
		
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
		
			JSONObject requestParams = new JSONObject();	
			request.body(requestParams.toJSONString());
			Response response = request.get("/employees");
	
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200); 
		
			String jsonString = response.asString();
			System.out.println(jsonString);
			Assert.assertEquals(jsonString.contains("Successfully! All records has been fetched."), true);
		}
		
		@Test
		public void test2_postEmployee() {
			
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();

			JSONObject requestParams = new JSONObject();
			
			requestParams.put("name", "Kleber");
			requestParams.put("salary", "9000");
			requestParams.put("age", "39");

			request.body(requestParams.toJSONString());
			Response response = request.post("/create");

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
		
			String jsonString = response.asString();
			System.out.println(jsonString);
		    Assert.assertEquals(jsonString.contains("Successfully! Record has been added."), true);
		}
		
		@Test()
		public void test3_getIDEmployee() {
		
			int id = 719;	
			
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
		
			JSONObject requestParams = new JSONObject();	
			request.body(requestParams.toJSONString());
			Response response = request.get("/employee/" + id);
	
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200); 
					
			String jsonString = response.asString();
			System.out.println(jsonString);
		
			Assert.assertEquals(jsonString.contains("Successfully! Record has been fetched."), true);
		}
				
		@Test()
		public void test4_putEmployee() {
			
			int id = 21;

			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
			
			JSONObject requestParams = new JSONObject();
			requestParams.put("name", "Jose");
			requestParams.put("age", "25");
			requestParams.put("salary", "8000");

			request.body(requestParams.toJSONString());
			Response response = request.put("/update/"+ id);
		
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200); 			
			
			String jsonString = response.asString();
		    Assert.assertEquals(jsonString.contains("Successfully! Record has been updated."), true);
		}
			
			@Test()
			public void test5_deleteEmployee() {
			
			int id = 719;
				
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();	
				
			request.header("Content-Type", "application/json");	
			
			Response response = request.delete("/delete/"+ id);		

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			
			String jsonString =response.asString();
			Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);
			}
}
