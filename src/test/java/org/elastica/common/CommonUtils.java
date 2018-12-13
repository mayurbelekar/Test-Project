package org.elastica.common;

import java.util.Random;

import org.elastica.Constants;
import org.elastica.SuiteDataDTO;
import org.elastica.protect.PolicyAction;
import org.elastica.protect.PolicyDTO;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class CommonUtils {

	public SuiteDataDTO suiteData = new SuiteDataDTO();
	public PolicyDTO policyData = new PolicyDTO();
	public PolicyAction policyAction = new PolicyAction();
	
	
	
	@BeforeClass(alwaysRun=true)
	public SuiteDataDTO readTestNGSuiteData(ITestContext testContext){
		
		String userName = testContext.getCurrentXmlTest().getParameter("userName");
		String password = testContext.getCurrentXmlTest().getParameter("password");
		String environment = testContext.getCurrentXmlTest().getParameter("environment");
		String tenantToken = testContext.getCurrentXmlTest().getParameter("tenantToken");
		
		if(environment.equals("eoe")){
			
		} else if(environment.equals("prod")){
			suiteData.setHost("app.elastica.net");
			suiteData.setUrl("https://app.elastica.net/");
			suiteData.setRefererUrl(suiteData.getUrl() + "static/ng/appLogin/index.html");
		}if(environment.equals("eu")){
			suiteData.setHost("app.eu.elastica.net");
			suiteData.setUrl("https://app.eu.elastica.net/");
			suiteData.setRefererUrl(suiteData.getUrl() + "static/ng/appLogin/index.html");
		}
		suiteData.setUsername(userName);
		suiteData.setPassword(password);
		suiteData.setEnvironment(environment);
		suiteData.setTenantToken(tenantToken);

		
		return suiteData;
	}
	
	private String generateString(String characters, int length){
	     char[] text = new char[length];
	     for (int i = 0; i < length; i++){
	         text[i] = characters.charAt(new Random().nextInt(characters.length()));
	     }
	     return new String(text);
	}
	
	public String getRandomString(int i){
		return generateString(Constants.ALPHA_LOWER_CASE + Constants.ALPHA_UPPER_CASE+ Constants.NUMERIC, i);
	}
}
