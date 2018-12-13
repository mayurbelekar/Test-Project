package org.elastica.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.elastica.common.CommonUtils;
import org.elastica.protect.PolicyAction;
import org.elastica.protect.PolicyDTO;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class PolicyTests extends CommonUtils{

	String policyName = null;
	
	@BeforeClass
	public void init(){
		policyName = getRandomString(8);
	}
	
	@Test(priority=1)
	public void createPolicy() throws IOException, ParserConfigurationException, SAXException{
		policyData.setPolicyName(policyName);
		policyData.setPolicyDesc("PolicyDescription");
		
		List<String> userList = new ArrayList<String>();
		userList.add("protectauto@protectbeatle.com");
		policyData.setUserList(userList);
		
		policyData.setApplication("Google Apps");
		policyData.setSubfeatures("Drive");
		policyData.setSubfeatureType("Drive");
		
		List<String> ciqList = new ArrayList<String>();
		ciqList.add("PII");
		policyData.setCIQProfileList(ciqList);
		
		List<String> exposureList = new ArrayList<String>();
		exposureList.add("public");
		exposureList.add("external");
		policyData.setExposures(exposureList);
		
		List<String> fileList = new ArrayList<String>();
		fileList.add("test1234");
		policyData.setFileList(fileList);
		
		JSONObject policyJSON = policyAction.createDataExposurePolicy(suiteData, policyData);
	}
	
	@Test(priority=2)
	public void activatePolicy() throws IOException, ParserConfigurationException, SAXException{
		JSONObject policiesObject =  policyAction.getPolicyList(suiteData, policyData);
		Map<String, Object> policyDetails = policyAction.getPolicyDetails(policiesObject, policyName);
		policyData.setPolicyId(policyDetails.get("id").toString());
		policyData.setPolicyType(policyDetails.get("policy_type").toString());
		policyAction.activatePolicy(suiteData, policyData);
	}
	
	@Test(priority=3)
	public void deactivatePolicy() throws IOException, ParserConfigurationException, SAXException{
		policyAction.deactivatePolicy(suiteData, policyData);
	}
	
	@Test(priority=4)
	public void deletePolicy() throws IOException, ParserConfigurationException, SAXException{
		policyAction.deletePolicy(suiteData, policyData);
	}
}
