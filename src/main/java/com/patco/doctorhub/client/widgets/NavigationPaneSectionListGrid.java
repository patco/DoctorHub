package com.patco.doctorhub.client.widgets;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;

public class NavigationPaneSectionListGrid extends ListGrid {
	private static final String ICON = "icon";
	private static final String ICON_DISPLAY_NAME = "Icon";
	private static final String NAME = "name";
	private static final String NAME_DISPLAY_NAME = "Name";
	private static final String URL_PREFIX = "icons/16/";
	private static final String URL_SUFFIX = ".png";

	private static final int ICON_FIELD_WIDTH = 27;

	public NavigationPaneSectionListGrid(DataSource dataSource) {
		super();
		GWT.log("NavigationPaneSectionListGrid");
		// initialise the List Grid
		this.setBaseStyle("crm-NavigationPaneGridCell");
		this.setDataSource(dataSource);
		this.setWidth100();
		this.setHeight100();
		this.setShowAllRecords(true);
		this.setShowHeader(false);

		// initialise the Icon field
		ListGridField appIconField = new ListGridField(ICON, ICON_DISPLAY_NAME,
				ICON_FIELD_WIDTH);
		appIconField.setImageSize(16);
		appIconField.setAlign(Alignment.RIGHT);
		appIconField.setType(ListGridFieldType.IMAGE);
		appIconField.setImageURLPrefix(URL_PREFIX);
		appIconField.setImageURLSuffix(URL_SUFFIX);
		appIconField.setCanEdit(false);

		// initialise the Name field
		ListGridField appNameField = new ListGridField(NAME, NAME_DISPLAY_NAME);

		// set the fields into the List Grid
		this.setFields(new ListGridField[] { appIconField, appNameField });

		// register the Data Arrived Handler
		this.addDataArrivedHandler(new DataArrivedHandler() {
			@Override
			public void onDataArrived(DataArrivedEvent event) {
				GWT.log("onDataArrived()");

				selectRecord(0);
			}
		});

		// populate the List Grid
		GWT.log("setAutoFetchData(true)");
		this.setAutoFetchData(true);
	}

}
