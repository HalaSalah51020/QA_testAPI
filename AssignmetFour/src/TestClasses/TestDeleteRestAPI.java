package TestClasses;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.junit.Test;
import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestDeleteRestAPI {
	@Test
	public void TestRestClientHandler() throws Exception {
	System.out.println("Start Detete Testing");

	//  Open Connection 
	String url = URLs.ReqResAPI+"/2";
	
	HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.DELETE, HTTPRequestsContentTypes.JSON);
	
	String DataJSON = JSONUtils.readJSONObjectFromFile(FilesPaths.DeleteUserJSONFile);
	System.out.println("Data :"+"\t"+DataJSON +"\n");

	
	//we send delete req and we response result
	RestClientHandler.sendDelete(connection, DataJSON, HTTPRequestsContentTypes.JSON);
	// we reading response
	System.out.println("\n"+"Connection.getResponseCode() :"+connection.getResponseCode());
	
	String response = RestClientHandler.readResponse(connection);
	System.out.println("\n"+"Data :"+"\t"+"{"+response+"}");
	assertTrue(connection.getResponseCode() == 204);
}
}
