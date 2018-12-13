package org.elastica.protect;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.elastica.ClientUtils;
import org.elastica.SuiteDataDTO;
import org.elastica.XMLReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.ClientResponse;

public class PolicyAction {

	PolicyQueryBuilder policyBuilder = new PolicyQueryBuilder();
	ClientUtils clientUtils = new ClientUtils();
	XMLReader reader = new XMLReader();
	
	public JSONObject createDataExposurePolicy(SuiteDataDTO suiteData, PolicyDTO policyData) throws IOException, ParserConfigurationException, SAXException{
		String payload = policyBuilder.createDataExposurePolicyQuery(policyData);
		Reporter.log("==============================================", true);
		Reporter.log("Create Policy Payload", true);
		Reporter.log(payload, true);
		Reporter.log("==============================================", true);
		String url = suiteData.getUrl() + reader.apiListReader("dataExposurePolicy");
		ClientResponse response = clientUtils.postOperation(url, "application/json", payload, suiteData);
		String responseBody = clientUtils.getResponseBody(response);
		Reporter.log("==============================================", true);
		Reporter.log("Create Policy Response", true);
		Reporter.log(responseBody, true);
		Reporter.log("==============================================", true);
		JSONObject object = new JSONObject(responseBody);
		return object;
	}
	
	public JSONObject getPolicyList(SuiteDataDTO suiteData, PolicyDTO policyData) throws ParserConfigurationException, SAXException, IOException{
		String url = suiteData.getUrl() + reader.apiListReader("policyList");
		ClientResponse response = clientUtils.getOperation(url, "application/json", suiteData);
		String responseBody = clientUtils.getResponseBody(response);
		JSONObject object = new JSONObject(responseBody);
		return object;
	}
	
	@SuppressWarnings("unused")
	public Map<String, Object> getPolicyDetails(JSONObject object, String policyName) throws JsonParseException, JsonMappingException, IOException{
		JSONArray policyArray = object.getJSONArray("policies");
		Map<String, Object> policyDetails = null;
		for(int i=0; i< policyArray.length(); i++){
			JSONObject policyObject = policyArray.getJSONObject(i);
			if(policyObject.getString("policy_name").equals(policyName)){
				policyDetails = clientUtils.getAllJsonValues(policyObject.toString());
				break;
			}
		}
		return policyDetails;
	}
	
	public void activatePolicy(SuiteDataDTO suiteData, PolicyDTO policyData) throws IOException, ParserConfigurationException, SAXException{
		policyData.setActive(true);
		String payload = policyBuilder.togglePolicy(policyData);
		Reporter.log("==============================================", true);
		Reporter.log("Activate Policy Payload", true);
		Reporter.log(payload, true);
		Reporter.log("==============================================", true);
		String url = suiteData.getUrl() + reader.apiListReader("togglePolicy");
		ClientResponse response = clientUtils.postOperation(url, "application/json", payload, suiteData);
		String responseBody = clientUtils.getResponseBody(response);
		Reporter.log("==============================================", true);
		Reporter.log("Activate Policy Response", true);
		Reporter.log(responseBody, true);
		Reporter.log("==============================================", true);
	}
	
	public void deactivatePolicy(SuiteDataDTO suiteData, PolicyDTO policyData) throws IOException, ParserConfigurationException, SAXException{
		policyData.setActive(false);
		String payload = policyBuilder.togglePolicy(policyData);
		Reporter.log("==============================================", true);
		Reporter.log("Deactivate Policy Payload", true);
		Reporter.log(payload, true);
		Reporter.log("==============================================", true);
		String url = suiteData.getUrl() + reader.apiListReader("togglePolicy");
		ClientResponse response = clientUtils.postOperation(url, "application/json", payload, suiteData);
		String responseBody = clientUtils.getResponseBody(response);
		Reporter.log("==============================================", true);
		Reporter.log("Deactivate Policy Response", true);
		Reporter.log(responseBody, true);
		Reporter.log("==============================================", true);
	}
	
	public void deletePolicy(SuiteDataDTO suiteData, PolicyDTO policyData) throws IOException, ParserConfigurationException, SAXException{
		String payload = policyBuilder.togglePolicy(policyData);
		Reporter.log("==============================================", true);
		Reporter.log("Delete Policy Payload", true);
		Reporter.log(payload, true);
		Reporter.log("==============================================", true);
		String url = suiteData.getUrl() + reader.apiListReader("deletePolicy");
		ClientResponse response = clientUtils.postOperation(url, "application/json", payload, suiteData);
		String responseBody = clientUtils.getResponseBody(response);
		Reporter.log("==============================================", true);
		Reporter.log("Delete Policy Response", true);
		Reporter.log(responseBody, true);
		Reporter.log("==============================================", true);
	}
}
