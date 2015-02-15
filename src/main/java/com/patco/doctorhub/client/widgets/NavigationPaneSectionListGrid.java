package com.patco.doctorhub.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
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
		Log.debug("NavigationPaneSectionListGrid");
		// Initialize the List Grid
		this.setBaseStyle("crm-NavigationPaneGridCell");
		this.setDataSource(dataSource);
		this.setWidth100();
		this.setHeight100();
		this.setShowAllRecords(true);
		this.setShowHeader(false);

		// Initialize the Icon field
		ListGridField appIconField = new ListGridField(ICON, ICON_DISPLAY_NAME,
				ICON_FIELD_WIDTH);
		appIconField.setImageSize(16);
		appIconField.setAlign(Alignment.RIGHT);
		appIconField.setType(ListGridFieldType.IMAGE);
		appIconField.setImageURLPrefix(URL_PREFIX);
		appIconField.setImageURLSuffix(URL_SUFFIX);
		appIconField.setCanEdit(false);

		// Initialize the Name field
		ListGridField appNameField = new ListGridField(NAME, NAME_DISPLAY_NAME);

		// set the fields into the List Grid
		this.setFields(new ListGridField[] { appIconField, appNameField });

		// register the Data Arrived Handler
		this.addDataArrivedHandler(new DataArrivedHandler() {
			@Override
			public void onDataArrived(DataArrivedEvent event) {
				Log.debug("onDataArrived()");

				selectRecord(0);
			}
		});

		// populate the List Grid
		Log.debug("setAutoFetchData(true)");
		this.setAutoFetchData(true);
	}

}
