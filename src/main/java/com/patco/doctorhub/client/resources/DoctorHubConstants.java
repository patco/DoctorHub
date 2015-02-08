package com.patco.doctorhub.client.resources;

public interface DoctorHubConstants extends com.google.gwt.i18n.client.Constants{
	 // Menus
	
	  @DefaultStringValue("<u>N</u>ew Activity")
	  String NewActivityMenuName();
	  
	  @DefaultStringValue("Task, Fax, Phone Call, Email, Letter, Appointment")
	  String NewActivityMenuItemNames(); 
	  
	  @DefaultStringValue("New Re<u>c</u>ord")
	  String NewRecordMenuName();  
	  
	  @DefaultStringValue("Account, Contact, separator, Lead, Opportunity")
	  String NewRecordMenuItemNames();
	  
	  @DefaultStringValue("<u>G</u>o To")
	  String GoToMenuName();  
	  
	  @DefaultStringValue("Sales")
	  String SalesMenuItemName();

	  @DefaultStringValue("Activities, Calendar, Leads, Opportunities, Accounts, Contacts")
	  String SalesMenuItemNames();  
	  
	  @DefaultStringValue("Settings")
	  String SettingsMenuItemName();

	  @DefaultStringValue("Administration, Templates, Data Management")
	  String SettingsMenuItemNames();    
	  
	  @DefaultStringValue("Resource Centre")
	  String ResourceCentreMenuItemName();

	  @DefaultStringValue("Highlights, Sales, Settings")
	  String ResourceCentreMenuItemNames();
	  
	  @DefaultStringValue("<u>T</u>ools")
	  String ToolsMenuName();  
	  
	  @DefaultStringValue("Import Data, Duplicate Detection, Advanced Find, Options")
	  String ToolsMenuItemNames();

	  @DefaultStringValue("<u>H</u>elp")
	  String HelpMenuName();  
	  
	  @DefaultStringValue("Help on this Page, Contents, Serendipity Online, About Serendipity")
	  String HelpMenuItemNames();
	  
	  // Navigation Pane Header
	  
	  @DefaultStringValue("Workplace")
	  String Workplace();
	  
	  @DefaultStringValue("Activities")
	  String Activities();
	  
	  // Navigation Pane 
	  
	  @DefaultStringValue("Sales")
	  String SalesStackSectionName();
	  
	  @DefaultStringValue("Settings")
	  String SettingsStackSectionName();
	  
	  @DefaultStringValue("Resource Centre")
	  String ResourceCentreStackSectionName();
	  
	  @DefaultStringValue("Details")
	  String AccountDetailsStackSectionName();
	  
	  // Toolbar
	  
	  @DefaultStringValue("New")
	  String NewButton();
	  
	  // StatusBar
	  
	  @DefaultStringValue("1 of 50 selected")
	  String SelectedLabel();
	  
	  @DefaultStringValue("Page 1")
	  String PageNumberLabel();
	  
	  // Form Toolbar
	  
	  @DefaultStringValue("Save and Close")
	  String SaveAndCloseButton();
	  
	  @DefaultStringValue("Help")
	  String HelpButton();
	  
	  // Form Tabs
	  
	  @DefaultStringValue("General")
	  String GeneralTab();
	  
	  @DefaultStringValue("Administration")
	  String AdministrationTab();  
	  
	  @DefaultStringValue("Notes")
	  String NotesTab(); 
}
