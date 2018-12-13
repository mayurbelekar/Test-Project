package org.elastica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.sun.jersey.api.client.ClientResponse.Status;


/**
 * @author MPandurangan
 *
 */
public class SoftAssertor {
	private static Map<ITestResult,List<String>> verificationFailuresMap = new HashMap<ITestResult,List<String>>();
	/**
	 * 
	 * @param condition
	 * @param errMsg
	 */
	public static void assertTrue(boolean condition, String errMsg) {
    	try {
    		Assert.assertTrue(condition);
    	} catch(Throwable e) {
    		addVerificationFailure(errMsg + " Exception msg: "+e.getMessage());
    	}
    }
 /**
  * 
  * @param condition
  * @param errMsg
  */
    public static void assertFalse(boolean condition, String errMsg)  {
    	try {
    		Assert.assertFalse(condition);
    	} catch(Throwable e) {
    		addVerificationFailure(errMsg + " Exception msg: "+e.getMessage());
    	}
    }
	
	/**
	 * Method to test if the actual is matching with the expected
	 * @Param expected
	 * @param actual
	 * @param assertName
	 */
	 public static void assertNotNull(Object actual, String errMsg)  {
		 try {
			 Assert.assertNotNull(actual);
		 } catch(Throwable e) {
			 addVerificationFailure(errMsg+" Exception msg: "+e.getMessage());
		 }
	 }
	 
	 /** 
	  * 
	  * @param expected
	  * @param actual
	  * @param assertName
	  */
	public static void AssertEqual(Object expected,Object actual,String assertName){
		try{
			if(actual!=null){
				Assert.assertEquals(expected,actual);
			}
        	else {
        		if(expected.equals("NA"))
        		actual="NA";
        	}
        }
        catch(Throwable e){
        	addVerificationFailure(assertName+" Exception msg: "+e.getMessage());
        }
	}
	
	/** 
	 * 
	 * @param response
	 * @param assertName
	 */
    public static void NotNullAssertion(String response, String assertName){
    	 try{
             Assert.assertNotNull(response, assertName);
    	 }
    	 catch(Throwable e){
    		 addVerificationFailure(assertName+" Exception msg: "+e.getMessage());
    	 }
    }
    
    public static void nullAssertion(String response, String assertName){
    	try{
    		Assert.assertNull(response);
    	}catch(Throwable t){
    		addVerificationFailure(assertName+" Exception msg: "+t.getMessage());
    	}
    }
    
    /** 
     * 
     * @param expected
     * @param actual
     * @param assertName
     */
    public static void actualResponseCodeNotMatchingWithExpectedResponseCode(String expected,int actual,String assertName){
    	String vActual = Integer.toString(actual);
    	try{
    		if(vActual!=null){
         	     Assert.assertEquals(expected,vActual);
         	} else {
         		if(expected.equals("NA"))
         			vActual="NA";
         	}
    	}catch(Throwable e){
         	addVerificationFailure(assertName+" Exception msg: "+e.getMessage());
    	}
     }
    
    /** 
     * 
     * @param expected
     * @param actual
     * @param assertName
     */
    public static void actualResponseTextNotMatchingWithExpectedResponseText(String expected,Status actual,String assertName){
    	String vAct = actual.toString(); 
    	try{
    		if(vAct!=null){
    			Assert.assertEquals(expected,vAct);
    		} else {
    			if(expected.equals("NA"))
      			vAct="NA";
    		}
    	}catch(Throwable e){
        	addVerificationFailure(assertName+" Exception msg: "+e.getMessage());
        }
    }
    
    /** 
     * 
     * @return
     */
    public static List<String> getVerificationFailures() {
		List<String> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<String>() : verificationFailures;
	}
    
	private static void addVerificationFailure(String e) {
		List<String> verificationFailures = getVerificationFailures();
		verificationFailures.add(e);
		verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
	}
}