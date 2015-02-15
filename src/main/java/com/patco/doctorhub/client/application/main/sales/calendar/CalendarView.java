package com.patco.doctorhub.client.application.main.sales.calendar;

import java.util.Date;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;

class CalendarView extends ViewImpl implements CalendarPresenter.MyView {
	interface Binder extends UiBinder<Widget, CalendarView> {
	}

	private static final String CONTEXT_AREA_WIDTH = "*";

	private VLayout panel;

	CalendarView() {
		Log.debug("CalendarView()");
		
	    panel = new VLayout();
		// Initialize the Calendar View layout container
		panel.setStyleName("crm-ContextArea");
		panel.setWidth(CONTEXT_AREA_WIDTH);

		DataSource eventDS = new DataSource();
		DataSourceSequenceField eventIdField = new DataSourceSequenceField(
				"eventId");
		eventIdField.setPrimaryKey(true);

		DataSourceTextField nameField = new DataSourceTextField("name");
		DataSourceTextField descField = new DataSourceTextField("description");
		DataSourceDateField startDateField = new DataSourceDateField(
				"startDate");
		DataSourceDateField endDateField = new DataSourceDateField("endDate");

		eventDS.setFields(eventIdField, nameField, descField, startDateField,
				endDateField);
		eventDS.setClientOnly(true);
		eventDS.setTestData(CalendarData.getRecords());

		Calendar calendar = new Calendar();
		calendar.setShowWeekends(false);
		calendar.setShowWorkday(true);
		calendar.setScrollToWorkday(true);
		calendar.setDataSource(eventDS);
		calendar.setAutoFetchData(true);

		LayoutSpacer paddingTop = new LayoutSpacer();
		paddingTop.setHeight(8);

		panel.addMember(paddingTop);
		panel.addMember(calendar);
		
		Log.debug("End of CalendarView()");

	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	@SuppressWarnings("deprecation")
	public static class CalendarData {

		private static CalendarEvent[] records;
		private static Date today = new Date();
		private static int year = today.getYear();
		private static int month = today.getMonth();
		private static int start = today.getDate() - today.getDay();

		public static CalendarEvent[] getRecords() {
			if (records == null) {
				records = getNewRecords();
			}
			return records;
		}

		public static CalendarEvent[] getNewRecords() {
			return new CalendarEvent[] {
					new CalendarEvent(1, "Meeting",
							"Shareholders meeting: monthly forecast report",
							new Date(year, month, start + 2, 9, 0, 0),
							new Date(year, month, start + 2, 14, 0, 0)),
					new CalendarEvent(2, "Realtor",
							"Breakfast with realtor to discuss moving plans",
							new Date(year, month, start + 3, 8, 0, 0),
							new Date(year, month, start + 3, 10, 0, 0)),
					new CalendarEvent(3, "Soccer",
							"Little league soccer finals", new Date(year,
									month, start + 4, 13, 0, 0), new Date(year,
									month, start + 4, 16, 0, 0)),
					new CalendarEvent(4, "Sleep", "Catch up on sleep",
							new Date(year, month, start + 4, 5, 0, 0),
							new Date(year, month, start + 4, 9, 0, 0)),
					new CalendarEvent(5, "Inspection", "Home inspector coming",
							new Date(year, month, start + 4, 10, 0, 0),
							new Date(year, month, start + 4, 12, 0, 0), false,
							"testStyle"),
					new CalendarEvent(6, "Airport run",
							"Pick James up from the airport", new Date(year,
									month, start + 4, 1, 0, 0), new Date(year,
									month, start + 4, 3, 0, 0)),
					new CalendarEvent(7, "Dinner Party",
							"Prepare elaborate meal for friends", new Date(
									year, month, start + 4, 17, 0, 0),
							new Date(year, month, start + 4, 20, 0, 0)),
					new CalendarEvent(8, "Poker", "Poker at Steve's house",
							new Date(year, month, start + 4, 21, 0, 0),
							new Date(year, month, start + 4, 23, 0, 0)),
					new CalendarEvent(
							9,
							"Meeting",
							"Board of directors meeting: discussion of next months strategy",
							new Date(year, month, start + 5, 11, 0, 0),
							new Date(year, month, start + 5, 15, 0, 0)) };
		}
	}

}