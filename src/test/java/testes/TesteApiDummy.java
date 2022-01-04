package testes;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.Test;

//import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteApiDummy {


		@Test()
		public void test1_getAllEmployee() throws Exception {
		
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
			
			Thread.sleep(60000);
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
		public void test2_postEmployee() throws Exception {
			
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();

			JSONObject requestParams = new JSONObject();
			
			Thread.sleep(60000);
			
			requestParams.put("employee_name", "Jose");
			requestParams.put("employee_salary", "31222");
			requestParams.put("employee_age", "38");
			requestParams.put("profile_image", "");

			request.body(requestParams.toJSONString());
			Response response = request.post("/create");

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
		
			String jsonString = response.asString();
			System.out.println(jsonString);
		    Assert.assertEquals(jsonString.contains("Successfully! Record has been added."), true);
		}
		
		@Test()
		public void test3_getIDEmployee() throws Exception {
		
			int id = 1;	
			
			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
		
			Thread.sleep(60000);
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
		public void test4_putEmployee() throws Exception {
			
			int id = 100;

			RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
			
			Thread.sleep(60000);
			JSONObject requestParams = new JSONObject();
			requestParams.put("employee_name", "Kleber");
			requestParams.put("employee_salary", "3133");
			requestParams.put("employee_age", "32");
			
			request.body(requestParams.toJSONString());
			Response response = request.put("/update/"+ id);
		
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200); 			
			
			String jsonString = response.asString();
			System.out.println(jsonString);
		    Assert.assertEquals(jsonString.contains("Successfully! Record has been updated."), true);
		}
			
			@Test()
			public void test5_deleteEmployee() throws Exception {
			
			int id = 3;
			
			Thread.sleep(60000);	
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
