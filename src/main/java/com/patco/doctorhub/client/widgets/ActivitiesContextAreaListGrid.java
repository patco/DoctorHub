package com.patco.doctorhub.client.widgets;

import com.patco.doctorhub.client.model.ActivityData;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ActivitiesContextAreaListGrid extends SalesContextAreaListGrid {
	// as per ActivitiesRecord
	private static final String ICON = "icon";
	private static final String ICON_DISPLAY_NAME = "#";
	private static final String ACTIVITY_TYPE = "activityType";
	private static final String ACTIVITY_TYPE_DISPLAY_NAME = "Activity Type";
	private static final String SUBJECT = "subject";
	private static final String SUBJECT_DISPLAY_NAME = "Subject";
	private static final String REGARDING = "regarding";
	private static final String REGARDING_DISPLAY_NAME = "Regarding";
	private static final String PRIORITY = "priority";
	private static final String PRIORITY_DISPLAY_NAME = "Priority";
	private static final String START_DATE = "startDate";
	private static final String START_DATE_DISPLAY_NAME = "Start Date";
	private static final String DUE_DATE = "dueDate";
	private static final String DUE_DATE_DISPLAY_NAME = "Due Date";
	private static final String EMPTY_FIELD = "emptyField";
	private static final String EMPTY_FIELD_DISPLAY_NAME = " ";
	private static final String URL_PREFIX = "icons/16/";
	private static final String URL_SUFFIX = ".png";
	// private static final String ACCOUNT_ICON = "account";

	private static final int ICON_COLUMN_LENGTH = 27;
	private static final int ACTIVITY_TYPE_COLUMN_LENGTH = 90;
	private static final int SUBJECT_COLUMN_LENGTH = 130;
	private static final int REGARDING_COLUMN_LENGTH = 100;
	private static final int PRIORITY_COLUMN_LENGTH = 60;
	private static final int START_DATE_COLUMN_LENGTH = 80;
	private static final int DUE_DATE_COLUMN_LENGTH = 80;

	public ActivitiesContextAreaListGrid() {
		super();
		ListGridField iconField = new ListGridField(ICON, ICON_DISPLAY_NAME, ICON_COLUMN_LENGTH);
	    iconField.setImageSize(16); 
	    iconField.setAlign(Alignment.CENTER);
	    iconField.setType(ListGridFieldType.IMAGE);  
	    iconField.setImageURLPrefix(URL_PREFIX);  
	    iconField.setImageURLSuffix(URL_SUFFIX);  
	  
	    ListGridField activityTypeField = new ListGridField(ACTIVITY_TYPE, ACTIVITY_TYPE_DISPLAY_NAME,
	        ACTIVITY_TYPE_COLUMN_LENGTH);  
	    ListGridField subjectField = new ListGridField(SUBJECT, SUBJECT_DISPLAY_NAME, 
	        SUBJECT_COLUMN_LENGTH);  
	    ListGridField regardingField = new ListGridField(REGARDING, REGARDING_DISPLAY_NAME, 
	        REGARDING_COLUMN_LENGTH);  
	    ListGridField priorityField = new ListGridField(PRIORITY, PRIORITY_DISPLAY_NAME,
	        PRIORITY_COLUMN_LENGTH); 
	    ListGridField startDateField = new ListGridField(START_DATE, START_DATE_DISPLAY_NAME,
	        START_DATE_COLUMN_LENGTH); 
	    ListGridField dueDateField = new ListGridField(DUE_DATE, DUE_DATE_DISPLAY_NAME, 
	        DUE_DATE_COLUMN_LENGTH); 

	    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);    
	    
	    // set the fields into the List Grid  
	    this.setFields(new ListGridField[] {iconField, activityTypeField, subjectField, regardingField, 
	        priorityField, startDateField, dueDateField, emptyField });  
	  
	    // populate the List Grid
	    this.setData(ActivityData.getRecords());   
		
	}
}
