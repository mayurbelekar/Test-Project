package org.elastica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Reporter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

/**
 * Hello world!
 *
 */
public class ClientUtils {
    public Client client;
    public ClientResponse response;
    public WebResource resource;
    
    public ClientResponse getBasicOperation(String uri, String appType){
    	client = Client.create();
    	resource = client.resource(uri);
    	WebResource.Builder builder = resource.getRequestBuilder();
    	
    	 response = builder.accept(appType).get(ClientResponse.class);
    	 Reporter.log("GET: "+uri, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 return response;
    }
    
    
    public ClientResponse getOperation(String uri, String appType, SuiteDataDTO suiteData){
    	client = Client.create();
    	resource = client.resource(uri);
    	WebResource.Builder builder = resource.getRequestBuilder();
    	Map<String, String> headers = new Authorization().getAllHeaders(suiteData);
    	 if(headers != null){
    		 for (String key : headers.keySet()){
    			 builder = builder.header(key, headers.get(key));
    		 }
    	 }
    	 response = builder.accept(appType).get(ClientResponse.class);
    	 Reporter.log("========================================", true);
    	 Reporter.log("GET: "+uri, true);
    	 Reporter.log("Headers: "+headers, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 Reporter.log("Operation: "+response.getStatusInfo().getFamily().name(), true);
    	 Reporter.log("========================================", true);
    	 return response;
    }
    
    public ClientResponse putOperation(String uri, String appType, String payload, SuiteDataDTO suiteData){
    	client = Client.create();
    	resource = client.resource(uri);
    	WebResource.Builder builder = resource.getRequestBuilder();
    	Map<String, String> headers = new Authorization().getAllHeaders(suiteData);
    	 if(headers != null){
    		 for (String key : headers.keySet()){
    			 builder = builder.header(key, headers.get(key));
    		 }
    	 }
    	 response = builder.accept(appType).put(ClientResponse.class, payload);
    	 Reporter.log("========================================", true);
    	 Reporter.log("PUT: "+uri, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 Reporter.log("Operation: "+response.getStatusInfo().getFamily().name(), true);
    	 Reporter.log("========================================", true);
    	 return response;
    }
    
    public ClientResponse deleteOperation(String uri, String appType, SuiteDataDTO suiteData){
    	client = Client.create();
    	response = client.resource(uri).delete(ClientResponse.class);
    	 Reporter.log("========================================", true);
    	 Reporter.log("DELETE: "+uri, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 Reporter.log("Operation: "+response.getStatusInfo().getFamily().name(), true);
    	 Reporter.log("========================================", true);
    	return response;
    }
    
    public ClientResponse postOperation(String uri, String appType, String payload, SuiteDataDTO suiteData){
    	client = Client.create();
    	resource = client.resource(uri);
    	WebResource.Builder builder = resource.getRequestBuilder();
    	Map<String, String> headers = new Authorization().getAllHeaders(suiteData);
    	if(headers != null){
    		 for (String key : headers.keySet()){
    			 builder = builder.header(key, headers.get(key));
    		 }
    	 }
    	 response = builder.accept(appType).post(ClientResponse.class, payload);
    	 Reporter.log("========================================", true);
    	 Reporter.log("POST: "+uri, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 Reporter.log("Operation: "+response.getStatusInfo().getFamily().name(), true);
    	 Reporter.log("========================================", true);
    	 return response;
    }
    
    public String getResponseBody(ClientResponse response){
    	String jsonString = response.getEntity(String.class);
    	Reporter.log("Response Body: "+jsonString);
    	return jsonString;
    }
    
    public List<Map<String, Object>> getJsonArrayValues(String json) throws JSONException, JsonParseException, JsonMappingException, IOException{
    	JSONArray array = new JSONArray(json);
    	List<Map<String, Object>> jsonValues = new ArrayList<Map<String,Object>>();
    	for (int i = 0; i < array.length(); i++) {
    		Map mapper = new ObjectMapper().readValue(array.getString(i), HashMap.class);
    		jsonValues.add(mapper);
    	}
    	return jsonValues;
    }
    
    public Map getAllJsonValues(String json) throws JsonParseException, JsonMappingException, IOException{
    	Map mapper = new ObjectMapper().readValue(json, HashMap.class);
		return mapper;
    }
    
    public String getJsonValue(String json, String key) throws JSONException{
    	JSONObject object = new JSONObject(json);
    	String keyValue = object.getString(key);
    	return keyValue;
    }
    
    public void getHeaderValue(MultivaluedMap<String, String> headers, String headerKey){
    	try{

    	}catch(Exception e){
    		
    	}
    }
}
