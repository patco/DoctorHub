package com.patco.doctorhub.client.model;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ActivitiesRecord extends ListGridRecord {

	// as per ActivitiesContextAreaListGrid
	private static final String ICON = "icon";
	// private static final String ICON_DISPLAY_NAME = "#";
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

	public ActivitiesRecord() {
	}

	public ActivitiesRecord(String icon, String activityType, String subject,
			String regarding, String priority, String startDate, String dueDate) {
		setIcon(icon);
		setActivityType(activityType);
		setSubject(subject);
		setRegarding(regarding);
		setPriority(priority);
		setStartDate(startDate);
		setDueDate(dueDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ACTIVITY_TYPE_DISPLAY_NAME).append(": ")
				.append(getActivityType()).append(", ");
		sb.append(SUBJECT_DISPLAY_NAME).append(": ").append(getSubject())
				.append(", ");
		sb.append(REGARDING_DISPLAY_NAME).append(": ").append(getRegarding())
				.append(", ");
		sb.append(PRIORITY_DISPLAY_NAME).append(": ").append(getPriority())
				.append(", ");
		sb.append(START_DATE_DISPLAY_NAME).append(": ").append(getStartDate())
				.append(", ");
		sb.append(DUE_DATE_DISPLAY_NAME).append(": ").append(getDueDate());

		return sb.toString();
	}

	public void setIcon(String icon) {
		setAttribute(ICON, icon);
	}

	public void setActivityType(String activityType) {
		setAttribute(ACTIVITY_TYPE, activityType);
	}

	public void setSubject(String subject) {
		setAttribute(SUBJECT, subject);
	}

	public void setRegarding(String regarding) {
		setAttribute(REGARDING, regarding);
	}

	public void setPriority(String priority) {
		setAttribute(PRIORITY, priority);
	}

	public void setStartDate(String startDate) {
		setAttribute(START_DATE, startDate);
	}

	public void setDueDate(String dueDate) {
		setAttribute(DUE_DATE, dueDate);
	}

	public String getIcon() {
		return getAttributeAsString(ICON);
	}

	public String getActivityType() {
		return getAttributeAsString(ACTIVITY_TYPE);
	}

	public String getSubject() {
		return getAttributeAsString(SUBJECT);
	}

	public String getRegarding() {
		return getAttributeAsString(REGARDING);
	}

	public String getPriority() {
		return getAttributeAsString(PRIORITY);
	}

	public String getStartDate() {
		return getAttributeAsString(START_DATE);
	}

	public String getDueDate() {
		return getAttributeAsString(DUE_DATE);
	}

}
