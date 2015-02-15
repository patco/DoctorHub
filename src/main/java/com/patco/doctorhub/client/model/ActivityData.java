package com.patco.doctorhub.client.model;

public class ActivityData {
	 private static ActivitiesRecord[] records;
	  
	  public static ActivitiesRecord[] getRecords() {
	    if (records == null) {
	      records = getNewRecords();
	    }
	    
	    return records;
	  }  
	  
	  public static ActivitiesRecord[] getNewRecords() {
	    return new ActivitiesRecord[]{
	      new ActivitiesRecord("task", "Task", "Get A4 Paper", "Printer", 
	          "High", "01/10/2010", "30/10/2010"), 
	      new ActivitiesRecord("fax", "Fax", "Send Invoice", "Consulting", 
	          "High", "01/10/2010", "30/10/2010"), 
	      new ActivitiesRecord("phonecall", "Phone Call", "Follow-up Call", "Meeting", 
	          "Normal", "01/10/2010", "30/10/2010"),
	      new ActivitiesRecord("email", "Email", "Sales Proposal", "New Product", 
	          "Normal", "01/10/2010", "30/10/2010"),
	      new ActivitiesRecord("letter", "Letter", "Finish Proposal", "New Client", 
	          "High", "01/10/2010", "30/10/2010"),
	      new ActivitiesRecord("appointment", "Appointment", "New Assignment", "New Client", 
	          "High", "01/10/2010", "30/10/2010")          
	    };
	  }
}
