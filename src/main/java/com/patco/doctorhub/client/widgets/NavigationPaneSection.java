package com.patco.doctorhub.client.widgets;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class NavigationPaneSection extends SectionStackSection {

	private static final String NAME = "name";

	private NavigationPaneSectionListGrid listGrid;

	public NavigationPaneSection(String sectionName, DataSource dataSource) {
		super(sectionName);

		this.setID(sectionName);

		listGrid = new NavigationPaneSectionListGrid(dataSource);

		this.addItem(listGrid);
		this.setExpanded(true);
	}

	public ListGrid getListGrid() {
		return listGrid;
	}

	public void selectRecord(int record) {
		listGrid.selectRecord(record);
	}

	public int getRecord(String name) {
		int result = -1;

		// Log.debug("int getRecord() - " + name);

		ListGridRecord[] records = listGrid.getRecords();
		ListGridRecord record = null;
		String recordName = "";

		for (int i = 0; i < records.length; i++) {

			record = listGrid.getRecord(i);
			recordName = record.getAttributeAsString(NAME);

			if (name.contentEquals(recordName)) {
				// Log.debug("name.contentEquals(recordName)");
				result = i;
				break;
			}
		}

		return result;
	}

	public String getSelectedRecord() {
		String name = "";

		ListGridRecord[] records = listGrid.getSelectedRecords();

		if (records.length != 0) {
			// get the name of the first selected record e.g. "Activities"
			name = records[0].getAttributeAsString(NAME);
		} else {
			// Log.debug("getSelectedRecord() - No selected record in ListGrid");

			ListGridRecord record = listGrid.getRecord(0);

			if (record != null) {
				// get the name of the first record in the ListGrid e.g.
				// "Activities"
				name = record.getAttributeAsString(NAME);
			}
		}

		// Log.debug("getSelectedRecord() - " + name);

		return name;
	}

	public void selectRecord(String name) {
		// Log.debug("selectRecord(name) - " + name);

		ListGridRecord[] records = listGrid.getRecords();
		ListGridRecord record = null;
		String recordName = "";

		for (int i = 0; i < records.length; i++) {

			record = listGrid.getRecord(i);
			recordName = record.getAttributeAsString(NAME);

			if (name.contentEquals(recordName)) {
				// Log.debug("name.contentEquals(recordName)");
				listGrid.deselectAllRecords();
				listGrid.selectRecord(i);
				break;
			}
		}
	}

	public void addRecordClickHandler(RecordClickHandler clickHandler) {
		listGrid.addRecordClickHandler(clickHandler);
	}

}
