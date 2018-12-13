package org.elastica.protect;

import java.util.ArrayList;
import java.util.List;

public class PolicyDTO {

	private String policyName = null;
	public void setPolicyName(String policyName){
		this.policyName = policyName;
	}
	public String getPolicyName(){
		return policyName;
	}
	
	private List<String> userList = new ArrayList<String>();
	public void setUserList(List<String> userList){
		this.userList = userList;
	}
	public List<String> getUserList(){
		return userList;
	}
	
	private List<String> groupList = new ArrayList<String>();
	public void setGroupList(List<String> groupList){
		this.groupList = groupList;
	}
	public List<String> getGroupList(){
		return groupList;
	}
	
	private List<String> domainList = new ArrayList<String>();
	public void setDomainList(List<String> domainList){
		this.domainList = domainList;
	}
	public List<String> getDomainList(){
		return domainList;
	}
	
	private List<String> userExceptionList = new ArrayList<String>();
	public void setUserExceptionList(List<String> userExceptionList){
		this.userExceptionList = userExceptionList;
	}
	public List<String> getUserExceptionList(){
		return userExceptionList;
	}
	
	private List<String> groupExceptionList = new ArrayList<String>();
	public void setGroupExceptionList(List<String> groupExceptionList){
		this.groupExceptionList = groupExceptionList;
	}
	public List<String> getGroupExceptionList(){
		return groupExceptionList;
	}
	
	private List<String> recipientUserList = new ArrayList<String>();
	public void setRecipientUserList(List<String> recipientUserList){
		this.recipientUserList = recipientUserList;
	}
	public List<String> getRecipientUserList(){
		return recipientUserList;
	}
	
	private List<String> recipientGroupList = new ArrayList<String>();
	public void setRecipientGroupList(List<String> recipientGroupList){
		this.recipientGroupList = recipientGroupList;
	}
	public List<String> getRecipientGroupList(){
		return recipientGroupList;
	}
	
	private List<String> recipientDomainList = new ArrayList<String>();
	public void setRecipientDomainList(List<String> recipientDomainList){
		this.recipientDomainList = recipientDomainList;
	}
	public List<String> getRecipientDomainList(){
		return recipientDomainList;
	}
	
	private List<String> recipientUserWhiteList = new ArrayList<String>();
	public void setRecipientUserWhiteList(List<String> recipientUserWhiteList){
		this.recipientUserWhiteList = recipientUserWhiteList;
	}
	public List<String> getRecipientUserWhiteList(){
		return recipientUserWhiteList;
	}
	
	private List<String> recipientGroupWhiteList = new ArrayList<String>();
	public void setRecipientGroupWhiteList(List<String> recipientGroupWhiteList){
		this.recipientGroupWhiteList = recipientGroupWhiteList;
	}
	public List<String> getRecipientGroupWhiteList(){
		return recipientGroupWhiteList;
	}
	
	private List<String> recipientDomainWhiteList = new ArrayList<String>();
	public void setRecipientDomainWhiteList(List<String> recipientDomainWhiteList){
		this.recipientDomainWhiteList = recipientDomainWhiteList;
	}
	public List<String> getRecipientDomainWhiteList(){
		return recipientDomainWhiteList;
	}
	
	private String application = null;
	public void setApplication(String application){
		this.application = application;
	}
	public String getApplication(){
		return application;
	}
	
	private String subfeatures;
	public void setSubfeatures(String subfeature){
		this.subfeatures = subfeature;
	}
	public String getSubfeatures(){
		return subfeatures;
	}
	
	private List<String> siteurls = new ArrayList<String>();
	public void setSiteurls(List<String> siteurls){
		this.siteurls = siteurls;
	}
	public List<String> getSiteurls(){
		return siteurls;
	}
	
	private List<String> teamList = new ArrayList<String>();
	public void setTeams(List<String> teamList){
		this.teamList = teamList;
	}
	public List<String> getTeams(){
		return teamList;
	}
	
	private List<String> channelList = new ArrayList<String>();
	public void setChannels(List<String> channelList){
		this.channelList = channelList;
	}
	public List<String> getChannels(){
		return channelList;
	}
	
	private String subfeatureType;
	public void setSubfeatureType(String subfeatureType){
		this.subfeatureType = subfeatureType;
	}
	public String getSubfeatureType(){
		return subfeatureType;
	}
	
	private List<String> folderList = new ArrayList<String>();
	public void setFolderList(List<String> folderList){
		this.folderList = folderList;
	}
	public List<String> getFolderList(){
		return folderList;
	}
	
	private List<String> folderWhiteList = new ArrayList<String>();
	public void setFolderWhiteList(List<String> folderWhiteList){
		this.folderWhiteList = folderWhiteList;
	}
	public List<String> getFolderWhiteList(){
		return folderWhiteList;
	}
	
	private List<String> ciqProfileList = new ArrayList<String>();
	public void setCIQProfileList(List<String> ciqProfileList){
		this.ciqProfileList = ciqProfileList;
	}
	public List<String> getCIQProfileList(){
		return ciqProfileList;
	}
	
	private List<String> ciqProfileWhiteList = new ArrayList<String>();
	public void setCIQProfileWhiteList(List<String> ciqProfileWhiteList){
		this.ciqProfileWhiteList = ciqProfileWhiteList;
	}
	public List<String> getCIQProfileWhiteList(){
		return ciqProfileWhiteList;
	}
	
	private List<String> vulnerability = new ArrayList<String>();
	public void setVulnerabilityList(List<String> vulnerability){
		this.vulnerability = vulnerability;
	}
	public List<String> getVulnerabilityList(){
		return vulnerability;
	}
	
	private List<String> filePattern = new ArrayList<String>();
	public void setFileList(List<String> filePattern){
		this.filePattern = filePattern;
	}
	public List<String> getFileList(){
		return filePattern;
	}
	
	private int largersize = 0;
	public void setLargerSize(int largersize){
		this.largersize = largersize;
	}
	public int getLargerSize(){
		return largersize;
	}
	
	private int smallersize = 0;
	public void setSmallerSize(int smallersize){
		this.smallersize = smallersize;
	}
	public int getSmallerSize(){
		return smallersize;
	}
	
	private List<String> exposureList = new ArrayList<String>();
	public void setExposures(List<String> exposureList){
		this.exposureList = exposureList;
	}
	public List<String> getExposures(){
		return exposureList;
	}
	
	private String exposureMatch = "any";
	public void setExposureMatch(String exposureMatch){
		this.exposureMatch = exposureMatch;
	}
	public String getExposureMatch(){
		return exposureMatch;
	}
	
	private boolean policyStatus = false;
	public void setActive(boolean policyStatus){
		this.policyStatus = policyStatus;
	}
	public boolean isActive(){
		return policyStatus;
	}
	
	private String policyDesc = "any";
	public void setPolicyDesc(String policyDesc){
		this.policyDesc = policyDesc;
	}
	public String getPolicyDesc(){
		return policyDesc;
	}
	
	private String policyType;
	public void setPolicyType(String policyType){
		this.policyType = policyType;
	}
	public String getPolicyType(){
		return policyType;
	}
	
	private String policyId;
	public void setPolicyId(String policyId){
		this.policyId = policyId;
	}
	public String getPolicyId(){
		return policyId;
	}
}
