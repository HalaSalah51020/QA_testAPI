package TestClasses;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPostRestAPI {
	@Test
	public void testCreate() throws Exception {
		System.out.println("Test Post : Create");

		// Open Connection 
		String url = URLs.ReqResAPI;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST, HTTPRequestsContentTypes.JSON);
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUserJSONFile);
		System.out.println("Object :" +"\t"+resquestJSONObject +"\n");

		
		//we send post req and we response result
		System.out.println("\n");
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		System.out.println("\n");
		// Reading Response
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println("Response:"+"\t"+response);
		assertTrue( connection.getResponseCode() == 201);	
		System.out.println("\n"+"________________________________________"+"\n");

	}
	
	@Test
	public void testregisterSuccessful() throws Exception {
		System.out.println("Test Post : Test Register Successful");

		// Open Connection		
		String url = URLs.ReqResAPISignUp;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,HTTPRequestsContentTypes.JSON);
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.registerSuccessfulJSONFile);
		System.out.println(resquestJSONObject);

		
		// 3. Post Request
		System.out.println("\n");
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		System.out.println("\n");
		// 4. Reading Response
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println("Response:"+"\t"+response);
		assertTrue( connection.getResponseCode() == 200);	
		System.out.println("\n"+"________________________________________"+"\n");

	}
	@Test
	public void testregisterUnSuccessful() throws Exception {
		System.out.println("Test Post : Test Register UN Successful");
		// 1. Open Connection --- HttpURLConnection
		String url = URLs.ReqResAPISignUp;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,HTTPRequestsContentTypes.JSON);
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.registerUnSuccessfulJSONFile);
		System.out.println("Object: "+"\t"+resquestJSONObject);

		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 400);	
		System.out.println("\n"+"________________________________________"+"\n");

	}
	
	
	
	@Test
	public void testLoginSuccessful() throws Exception {
		System.out.println("Test Post : Test Login Successful");


		// 1. Open Connection --- HttpURLConnection
		String url = URLs.ReqResAPISignIn;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,HTTPRequestsContentTypes.JSON);
		// 2. Prepare Json Object
		

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.loginSuccessfulJSONFile);
		System.out.println("Object "+"\t"+resquestJSONObject);

		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		// 4. Reading Response
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 200);
		System.out.println("\n"+"________________________________________"+"\n");
	
	}
	
	@Test
	public void testLoginUnSuccessful() throws Exception {
		System.out.println("Test Post : Test Login UN Successful");

		// 1. Open Connection --- HttpURLConnection
		String url = URLs.ReqResAPISignIn;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST, HTTPRequestsContentTypes.JSON);
		// 2. Prepare Json Object
		

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.loginUnSuccessfulJSONFile);

		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		// 4. Reading Response
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 400);
		System.out.println("\n"+"________________________________________"+"\n");

	}
	
	
}
