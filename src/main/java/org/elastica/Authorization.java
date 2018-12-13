package org.elastica;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.Reporter;
import org.xml.sax.SAXException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;


public class Authorization {

	ClientUtils clientUtils = new ClientUtils();
	XMLReader reader = new XMLReader();
	public static String getAuthParam(String username, String password){
		//String authParam = "Basic "+new String(Base64.encodeBase64((username + ":" + password).getBytes()));
		String authParam = "Basic "+new String(Base64.encode((username + ":" + password).getBytes()));
		return authParam;
	}
	
	public Map<String, String> getAllHeaders(SuiteDataDTO suiteData) {
		String csrfToken = null;
		String rid = null;
		String sessionId = null;
		Map<String, String> sessionMap = new HashMap<String, String>();
		try{
			String uri = suiteData.getUrl() + reader.apiListReader("deployment"); 
			ClientResponse response = clientUtils.getBasicOperation(uri, "application/json");
			MultivaluedMap<String, String> headers =  response.getHeaders();
			csrfToken = getCSRFToken(headers);
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Connection", "keep-alive");
			headerMap.put("Accept", "application/json, text/plain, */*");
			headerMap.put("Origin", suiteData.getUrl());
			headerMap.put("X-Requested-With", "XMLHttpRequest");
			headerMap.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
			headerMap.put("X-CSRFToken", csrfToken);
			headerMap.put("Content-Type", "application/json;charset=UTF-8");
			headerMap.put("Referer", suiteData.getRefererUrl());
			headerMap.put("Accept-Language", "en-US,en;q=0.5");
			headerMap.put("Cookie", "csrftoken="+csrfToken+";mf_authenticated=EzTxmV5reXvpfmyULo45lsawAeFgT1UZ1uCxSrI8");
			
			String loginUri = suiteData.getUrl()+reader.apiListReader("login");
			String payload = "{\"email\":\""+suiteData.getUsername()+"\",\"password\":\""+suiteData.getPassword()+"\",\"custdomain\":\"\"}";
			ClientResponse loginResponse = postOperation(loginUri, "application/json", payload, headerMap);
			sessionId = getSessionId(loginResponse.getHeaders());
			rid = getRid(loginResponse.getHeaders());
			csrfToken = getCSRFToken(loginResponse.getHeaders());
			/*Reporter.log("========================================", true);
			Reporter.log("CSRF Token: "+csrfToken, true);
			Reporter.log("__R_ID__: "+rid, true);
			Reporter.log("Session Id: "+sessionId, true);
			Reporter.log("========================================", true);*/
			sessionMap.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
			sessionMap.put("Referer", suiteData.getRefererUrl());
			sessionMap.put("X-CSRFToken", csrfToken);
			sessionMap.put("X-Session", sessionId);
			sessionMap.put("X-TenantToken", suiteData.getTenantToken());
			sessionMap.put("X-User", suiteData.getUsername());
			sessionMap.put(HttpHeaders.COOKIE, "csrftoken="+csrfToken+";sessionid="+sessionId+";");
			sessionMap.put(HttpHeaders.AUTHORIZATION, getAuthParam(suiteData.getUsername(), suiteData.getPassword()));
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}catch(SAXException se){
			se.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return sessionMap;
	}
	

	public Client client;
    public ClientResponse response;
    public WebResource resource;
	public ClientResponse postOperation(String uri, String appType, String payload, Map<String, String> headers){
    	client = Client.create();
    	resource = client.resource(uri);
    	WebResource.Builder builder = resource.getRequestBuilder();
    	
    	if(headers != null){
    		 for (String key : headers.keySet()){
    			 builder = builder.header(key, headers.get(key));
    		 }
    	 }
    	 response = builder.accept(appType).post(ClientResponse.class, payload);
    	 Reporter.log("POST: "+uri, true);
    	 Reporter.log("Status: "+response.getStatus()+" "+response.getStatusInfo(), true);
    	 return response;
    }
	
	public String getCSRFToken(MultivaluedMap<String, String> headers){
		String csrftoken = null;
		List<String> cookies = headers.get("Set-Cookie");
		for(int i=0; i<cookies.size(); i++){
			if(cookies.get(i).contains("csrftoken")){
				csrftoken = cookies.get(i).substring(cookies.get(i).indexOf("=")+1, cookies.get(i).indexOf(";"));
				break;
			}
		}
		return csrftoken;
	}
	
	public String getRid(MultivaluedMap<String, String> headers){
		String rid = null;
		List<String> cookies = headers.get("Set-Cookie");
		for(int i=0; i<cookies.size(); i++){
			if(cookies.get(i).contains("__rid__")){
				rid = cookies.get(i).substring(cookies.get(i).indexOf("=")+1, cookies.get(i).indexOf(";"));
				break;
			}
		}
		return rid;
	}
	
	public String getSessionId(MultivaluedMap<String, String> headers){
		String sessionId = null;
		List<String> cookies = headers.get("Set-Cookie");
		for(int i=0; i<cookies.size(); i++){
			if(cookies.get(i).contains("sessionid")){
				sessionId = cookies.get(i).substring(cookies.get(i).indexOf("=")+1, cookies.get(i).indexOf(";"));
				break;
			}
		}
		return sessionId;
	}
}