package org.elastica.protect;

import java.io.IOException;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

public class PolicyQueryBuilder {

	public String deletePolicy(PolicyDTO policyData) throws IOException{
		XContentBuilder builder = XContentFactory.jsonBuilder().
				startObject().
					field("policy_type", policyData.getPolicyType()).
					field("action", true).
					field("sub_id", policyData.getPolicyId()).
				endObject();
		return builder.string();
	}
	
	public String togglePolicy(PolicyDTO policyData) throws IOException{
		XContentBuilder builder = XContentFactory.jsonBuilder().
				startObject().
					field("policy_type", policyData.getPolicyType()).
					field("sub_id", policyData.getPolicyId()).
					field("status", policyData.isActive()).
				endObject();
		return builder.string();
	}
	
	public String createDataExposurePolicyQuery(PolicyDTO policyData) throws IOException{
		XContentBuilder builder = XContentFactory.jsonBuilder().
				startObject().
					field("policy_name", policyData.getPolicyName()).
					startObject("users_scope").
						startArray("users");
							if(!policyData.getUserList().isEmpty()){
								for(int i=0; i<policyData.getUserList().size(); i++){
									builder.value(policyData.getUserList().get(i));
								}
							} else {
								if(policyData.getGroupList().isEmpty()){
									builder.value("__ALL_EL__");
								}
							}
						builder.endArray().
						startArray("groups");
							if(!policyData.getGroupList().isEmpty()){
								for(int i=0; i<policyData.getGroupList().size(); i++){
									builder.value(policyData.getGroupList().get(i));
								}
							} else {
								if(policyData.getUserList().isEmpty()){
									builder.value("__ALL_EL__");
								}
							}
						builder.endArray().
						startArray("domains").
							value("__ALL_EL__").
						endArray().
						startArray("org_unit").
							value("__ALL_EL__").
						endArray().
					endObject().
					startObject("users_scope_whitelist").
						startArray("users");
							if(!policyData.getUserExceptionList().isEmpty()){
								for(int i=0; i< policyData.getUserExceptionList().size(); i++){
									builder.value(policyData.getUserExceptionList());
								}
							}
						builder.endArray().
						startArray("groups");
							if(!policyData.getGroupExceptionList().isEmpty()){
								for(int i=0; i< policyData.getGroupExceptionList().size(); i++){
									builder.value(policyData.getGroupExceptionList());
								}
							}
						builder.endArray().
					endObject().
					startObject("recipient_scope").
						startArray("users");
							if(!policyData.getRecipientUserList().isEmpty()){
								for(int i=0; i<policyData.getRecipientUserList().size(); i++){
									builder.value(policyData.getRecipientUserList().get(i));
								}
							} else {
								if(policyData.getRecipientGroupList().isEmpty() && policyData.getRecipientDomainList().isEmpty()){
									builder.value("__ALL_EL__");
								}
							}
						builder.endArray().
						startArray("groups");
							if(!policyData.getRecipientGroupList().isEmpty()){
								for(int i=0; i<policyData.getRecipientGroupList().size(); i++){
									builder.value(policyData.getRecipientGroupList().get(i));
								}
							} else {
								if(policyData.getRecipientUserList().isEmpty() && policyData.getRecipientDomainList().isEmpty()){
									builder.value("__ALL_EL__");
								}
							}
						builder.endArray().
						startArray("domains");
							if(!policyData.getRecipientDomainList().isEmpty()){
								for(int i=0; i<policyData.getRecipientDomainList().size(); i++){
									builder.value(policyData.getRecipientDomainList().get(i));
								}
							} else {
								if(policyData.getRecipientUserList().isEmpty() && policyData.getRecipientGroupList().isEmpty()){
									builder.value("__ALL_EL__");
								}
							}
						builder.endArray().
					endObject().
					startObject("recipient_scope_whitelist").
						startArray("users");
							if(!policyData.getRecipientUserWhiteList().isEmpty()){
								for(int i=0; i< policyData.getRecipientUserWhiteList().size(); i++){
									builder.value(policyData.getRecipientUserWhiteList());
								}
							}
						builder.endArray().
						startArray("groups");
							if(!policyData.getRecipientGroupWhiteList().isEmpty()){
								for(int i=0; i< policyData.getRecipientGroupWhiteList().size(); i++){
									builder.value(policyData.getRecipientGroupWhiteList());
								}
							}
						builder.endArray().
						startArray("domains");
							if(!policyData.getRecipientDomainWhiteList().isEmpty()){
								for(int i=0; i< policyData.getRecipientDomainWhiteList().size(); i++){
									builder.value(policyData.getRecipientDomainWhiteList());
								}
							}
						builder.endArray().
					endObject().
					startArray("applications").
						value(policyData.getApplication()).
					endArray().
					startArray("sub_features").
						value(policyData.getSubfeatures()).
					endArray().
					startArray("site_urls");
						for(int i=0; i< policyData.getSiteurls().size(); i++){
							builder.value(policyData.getSiteurls().get(i));
						}
					builder.endArray().
					startArray("teams_scope");
						for(int i=0; i< policyData.getTeams().size(); i++){
							builder.value(policyData.getTeams().get(i));
						}
					builder.endArray().
					startArray("channels_scope");
						for(int i=0; i< policyData.getChannels().size(); i++){
							builder.value(policyData.getChannels().get(i));
						}
					builder.endArray().
					startArray("sub_feature_type").
						value(policyData.getSubfeatureType()).
					endArray().
					startArray("folder_scope");
						for(int i=0; i< policyData.getFolderList().size(); i++){
							builder.value(policyData.getFolderList().get(i));
						}
					builder.endArray().
					startArray("folder_scope_whitelist");
						for(int i=0; i< policyData.getFolderWhiteList().size(); i++){
							builder.value(policyData.getFolderWhiteList().get(i));
						}
					builder.endArray().
					startArray("content_profiles");
						for(int i=0; i< policyData.getCIQProfileList().size(); i++){
							builder.value(policyData.getCIQProfileList().get(i));
						}
					builder.endArray().
					startArray("content_profiles_whitelist");
						for(int i=0; i< policyData.getCIQProfileWhiteList().size(); i++){
							builder.value(policyData.getCIQProfileWhiteList().get(i));
						}
					builder.endArray().
					field("classification_label", "").
					startArray("file_type").
						value("__ALL_EL__").
					endArray().
					startArray("file_type_whitelist").
					endArray().
					startArray("vulnerability_type");
						for(int i=0; i<policyData.getVulnerabilityList().size(); i++){
							builder.startObject().
								field("type", policyData.getVulnerabilityList().get(i)).
								startObject("meta_info").
								endObject().
							endObject();
						}
					builder.endArray().
					startArray("filename_pattern");
						for(int i=0; i<policyData.getFileList().size(); i++){
							builder.value(policyData.getFileList().get(i));
						}
					builder.endArray().
					startObject("file_size").
						field("larger_than", policyData.getLargerSize()).
						field("smaller_than", policyData.getSmallerSize()).
					endObject().
					startObject("file_modified").
					endObject().
					startArray("exposure_scope");
						for(int i=0; i<policyData.getExposures().size(); i++){
							builder.value(policyData.getExposures().get(i));
						}
					builder.endArray().
					field("exposure_match", policyData.getExposureMatch()).
					startArray("response").
						startObject().
							field("type", "NOTIFY_USER").
							startObject("meta_info").
								field("notify_user", true).
							endObject().
						endObject().
						/*startObject().
							field("type", "NOTIFY_EXTERNAL_USERS").
							startObject("meta_info").
								field("notify_external_users", true).
							endObject().
						endObject().*/
						startObject().
							field("type", "SEVERITY_LEVEL").
							startObject("meta_info").
								field("severity_level", "high").
							endObject().
						endObject().
					endArray().
					startArray("instance").
					endArray().
					field("apply_policy", false).
					field("schedule_time", 0).
					field("receive_schedule_notification", "").
					field("is_active", policyData.isActive()).
					field("policy_type", "documentshareapi").
					field("policy_description", policyData.getPolicyDesc()).
				endObject();
					
		return builder.string();
	}
}
