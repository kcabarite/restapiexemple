package testes;

import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteApiDummy {
	
		@Test()
		public void test2_getAllEmployees() throws IOException, Exception {
			
			String url = "https://dummy.restapiexample.com/api/v1";	
			URL obj = new URL(url);
		
			RestAssured.baseURI = url;
			RequestSpecification request = RestAssured.given();
		
			Thread.sleep(60000);
		
			HttpsURLConnection hc = (HttpsURLConnection) obj.openConnection(); 
			hc.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
			hc.connect();
		
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
		public void test1_postEmployee() throws IOException, Exception {
			
			String url = "https://dummy.restapiexample.com/api/v1";	
			URL obj = new URL(url);
			
			RestAssured.baseURI = url;
			RequestSpecification request = RestAssured.given();

			Thread.sleep(60000);
			
			HttpsURLConnection hc = (HttpsURLConnection) obj.openConnection(); 
	        hc.setRequestProperty("User-Agent","PostmanRuntime/7.28.4");
	        hc.connect();
	        
			JSONObject requestParams = new JSONObject();

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
			
			String url = "https://dummy.restapiexample.com/api/v1";	
			URL obj = new URL(url);
			
			RestAssured.baseURI = url;
			RequestSpecification request = RestAssured.given();

			Thread.sleep(60000);
			
			HttpsURLConnection hc = (HttpsURLConnection) obj.openConnection(); 
	        hc.setRequestProperty("User-Agent","Java/1.8.0_301");
	        hc.connect();
	        
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
			
			int id = 21;

			String url = "https://dummy.restapiexample.com/api/v1";	
			URL obj = new URL(url);
			
			RestAssured.baseURI = url;
			RequestSpecification request = RestAssured.given();

			Thread.sleep(60000);
			
			HttpsURLConnection hc = (HttpsURLConnection) obj.openConnection(); 
	        hc.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
	        hc.connect();
	        
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
			
			String url = "https://dummy.restapiexample.com/api/v1";	
			URL obj = new URL(url);
			
			RestAssured.baseURI = url;
			RequestSpecification request = RestAssured.given();

			Thread.sleep(60000);
			
			HttpsURLConnection hc = (HttpsURLConnection) obj.openConnection(); 
	        hc.setRequestProperty("User-Agent", "Java/1.7.0_11");
	        hc.connect();
				
			request.header("Content-Type", "application/json");	
			
			Response response = request.delete("/delete/"+ id);		

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			
			String jsonString =response.asString();
			Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);
			}
}
