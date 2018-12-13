package org.elastica;

public class SuiteDataDTO {

	
	private String username = null;
	private String password = null;
	private String environment = null;
	private String url = null;
	private String tenantToken = null;
	private String csrfToken = null;
	private String sessionId = null;
	private String rid = null;
	private String refererUrl = null;
	private String host = null;

	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setEnvironment(String environment){
		this.environment = environment;
	}
	
	public String getEnvironment(){
		return environment;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setTenantToken(String tenantToken){
		this.tenantToken = tenantToken;
	}
	
	public String getTenantToken(){
		return tenantToken;
	}
	
	public void setCSRFToken(String csrfToken){
		this.csrfToken = csrfToken;
	}
	
	public String getCSRFToken(){
		return csrfToken;
	}
	
	public void setSessionID(String sessionId){
		this.sessionId = sessionId;
	}
	
	public String getSessionID(){
		return sessionId;
	}
	
	public void setRID(String rid){
		this.rid = rid;
	}
	
	public String getRID(){
		return rid;
	}
	
	public void setRefererUrl(String refererUrl){
		this.refererUrl = refererUrl;
	}
	
	public String getRefererUrl(){
		return refererUrl;
	}
	
	public void setHost(String host){
		this.host = host;
	}
	
	public String getHost(){
		return host;
	}
}
