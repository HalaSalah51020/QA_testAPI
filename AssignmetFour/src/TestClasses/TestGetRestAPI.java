package TestClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestGetRestAPI {

	@Test
	public void Testgetlistusers() throws IOException, ParseException {
		
		System.out.println("Testing #1 => Test Get List Of Users"+"\n");

		// Open Connection 
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.ReqResAPIListUsers, HTTPMethod.GET,HTTPRequestsContentTypes.JSON);
		//check connection is successfully opened
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue("unable to connect to webservice", connection.getResponseCode() == 200);
		
		// reading response using input stream and print it
		String response = RestClientHandler.readResponse(connection);
		System.out.println("Response:"+"\t"+response);
		assertNotNull(response);

		//create JSON Object From response string
		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		
		//take key data and put it in data
		String data = jsonObject.get("data").toString();
		System.out.println("Data :" +"\t" + data);
		System.out.println("\n"+"________________________________________"+"\n");
		}
	
	
	@Test
	public void TestgetSingelUser() throws Exception {
		System.out.println("Testing #2 => Test Get Single User"+"\n");

		// Open Connection 
		String url = URLs.ReqResAPI+"/2";
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,HTTPRequestsContentTypes.JSON);
		
		// reading Response
		String response = RestClientHandler.readResponse(connection);
		System.out.println("Response:"+"\t"+response);
		
		
		
		//create JSON Object From response string
		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		System.out.println(jsonObject);
		
		//take key data and put it in data
		String data = jsonObject.get("data").toString();
		System.out.println("Data :" +"\t" + data);
		
		
		//take key first_name and put it in firstname
		String firstName = ((JSONObject) jsonObject.get("data")).get("first_name").toString();
		System.out.println("First Name: "+"\t" + firstName);	
		
		String supportText ="To keep ReqRes free, contributions towards server costs are appreciated!";
		String supportTextAPI =((JSONObject) jsonObject.get("support")).get("text").toString();
		System.out.println("support Text of API: "+"\t" + supportTextAPI);
		assertTrue(supportText.equals(supportTextAPI));
		
		System.out.println("\n"+"________________________________________"+"\n");
		}
	
	@Test 
	public void TestsingleUserNotFound() throws Exception {
		System.out.println("\n"+"Testing #3 => Test Get Single User Not Found"+"\n");

		// Open Connection 
		String url = URLs.ReqResAPI+"/24";
				
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,HTTPRequestsContentTypes.JSON);		
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue(connection.getResponseCode() == 404);
		System.out.println("\n"+"________________________________________"+"\n");
		}
	

}
