package com.patco.doctorhub.client.widgets;

import com.smartgwt.client.widgets.grid.ListGrid;

public class SalesContextAreaListGrid extends ListGrid {

	public SalesContextAreaListGrid() {
		super();

		// Initialize the List Grid
		this.setBaseStyle("crm-ContextArea-GridCell");
		this.setShowAllRecords(true);
		this.setSortField(1);

		// show the List Grid filter editor
		this.setShowFilterEditor(true);
		this.setHeight100();
		// this.setFilterOnKeypress(true);
	}
}
