package org.elastica;

import java.io.File;

public class Constants {

	public static final String USERNAME = "userName";
	public static final String PASSWORD = "password";
	public static final String ENVIRONMENT = "environment";
	public static final String URL = "url";
	public static final String TENANT_TOKEN = "tenantToken";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String MAIN_PATH = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "org" + File.separator + "elastica"; 
	public static final String TEST_PATH = PROJECT_PATH + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "org" + File.separator + "elastica";
	public static final String API_LIST = MAIN_PATH + File.separator + "APIList.xml";
	
	public static final String CSRF_TOKEN = "csrftoken";
	public static final String R_ID = "rid";
	public static final String SESSION_ID = "sessionid";
	
	public static final String ALPHA_LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	public static final String ALPHA_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMERIC = "0123456789";
}
