package com.patco.doctorhub.client.model;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class AccountsRecord extends ListGridRecord{
	  // as per AccountsContextAreaListGrid
	  private static final String ICON = "icon";  
	  // private static final String ICON_DISPLAY_NAME = "#";
	  private static final String ACCOUNT_ID = "accountId";  
	  private static final String ACCOUNT_ID_DISPLAY_NAME = "Account Id"; 
	  private static final String ACCOUNT_NAME = "accountName";  
	  private static final String ACCOUNT_NAME_DISPLAY_NAME = "Account Name"; 
	  private static final String MAIN_PHONE = "mainPhone"; 
	  private static final String MAIN_PHONE_DISPLAY_NAME = "Main Phone"; 
	  private static final String LOCATION = "location"; 
	  private static final String LOCATION_DISPLAY_NAME = "Location"; 
	  private static final String PRIMARY_CONTACT = "primaryContact"; 
	  private static final String PRIMARY_CONTACT_DISPLAY_NAME = "Primary Contact"; 
	  private static final String EMAIL_PRIMARY_CONTACT = "emailPrimaryContact"; 
	  private static final String EMAIL_PRIMARY_CONTACT_DISPLAY_NAME = "Email (Primary Contact)"; 
		
	  public AccountsRecord() {}
		
	  public AccountsRecord(String icon, 
	      Long accountId,
		    String accountName,
		    String mainPhone,
	      String location,
	      String primaryContact,
	      String emailPrimaryContact) {
	    setIcon(icon);
	    setAccountId(accountId);
	    setAccountName(accountName);
	    setMainPhone(mainPhone);
	    setLocation(location);
	    setPrimaryContact(primaryContact);
	    setEmailPrimaryContact(emailPrimaryContact);  
	  }	
	  
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(ACCOUNT_ID_DISPLAY_NAME).append(": ").append(getAccountId()).append(", ");
	    sb.append(ACCOUNT_NAME_DISPLAY_NAME).append(": ").append(getAccountName()).append(", ");
	    sb.append(MAIN_PHONE_DISPLAY_NAME).append(": ").append(getMainPhone()).append(", ");
	    sb.append(LOCATION_DISPLAY_NAME).append(": ").append(getLocation()).append(", ");
	    sb.append(PRIMARY_CONTACT_DISPLAY_NAME).append(": ").append(getPrimaryContact()).append(", ");
	    sb.append(EMAIL_PRIMARY_CONTACT_DISPLAY_NAME).append(": ").append(getEmailPrimaryContact());
	    
	    return sb.toString();
	  }       
	    
	  public void setIcon(String icon) {
	    setAttribute(ICON, icon);
	  }    
	  
	  public void setAccountId(Long accountId) {
	    setAttribute(ACCOUNT_ID, accountId);
	  }
	    
	  public void setAccountName(String accountName) {
	    setAttribute(ACCOUNT_NAME, accountName);
	  }

	  public void setMainPhone(String mainPhone) {
	    setAttribute(MAIN_PHONE, mainPhone);
	  }
	    
	  public void setLocation(String location) {
	    setAttribute(LOCATION, location);
	  }    
	    
	  public void setPrimaryContact(String primaryContact) {
	    setAttribute(PRIMARY_CONTACT, primaryContact);
	  }   
	    
	  public void setEmailPrimaryContact(String emailPrimaryContact) {
	    setAttribute(EMAIL_PRIMARY_CONTACT, emailPrimaryContact);
	  }        
	    
	  public String getIcon() {
	    return getAttributeAsString(ICON);
	  }    

	  public Long getAccountId() {
	    return (Long) getAttributeAsObject(ACCOUNT_ID);
	  }
	  
	  public String getAccountName() {
	    return getAttributeAsString(ACCOUNT_NAME);
	  }
	    
	  public String getMainPhone() {
	    return getAttributeAsString(MAIN_PHONE);
	  }
	  
	  public String getLocation() {
	    return getAttributeAsString(LOCATION);
	  }    

	  public String getPrimaryContact() {
	    return getAttributeAsString(PRIMARY_CONTACT);
	  }
	    
	  public String getEmailPrimaryContact() {
	    return getAttributeAsString(EMAIL_PRIMARY_CONTACT);
	  } 
}
