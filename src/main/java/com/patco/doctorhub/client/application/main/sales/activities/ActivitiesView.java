package com.patco.doctorhub.client.application.main.sales.activities;

import javax.inject.Inject;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.patco.doctorhub.client.model.ActivityData;
import com.patco.doctorhub.client.widgets.sales.ActivitiesContextAreaListGrid;
import com.patco.doctorhub.client.widgets.sales.StatusBar;
import com.patco.doctorhub.client.widgets.sales.ToolBar;
import com.smartgwt.client.widgets.layout.VLayout;

class ActivitiesView extends ViewImpl implements ActivitiesPresenter.MyView {
	interface Binder extends UiBinder<Widget, ActivitiesView> {
	}

	private static final String CONTEXT_AREA_WIDTH = "*";

	private final ToolBar toolbar;
	private final ActivitiesContextAreaListGrid listGrid;
	private final StatusBar statusBar;

	private VLayout panel;

	@Inject
	ActivitiesView(ToolBar toolbar,
			ActivitiesContextAreaListGrid listGrid, StatusBar statusBar) {
		super();
		Log.debug("ActivitiesView()");

		this.toolbar = toolbar;
		this.listGrid = listGrid;
		this.statusBar = statusBar;

		panel = new VLayout();

		// Initialize the Activities View layout container
		panel.setStyleName("crm-ContextArea");
		panel.setWidth(CONTEXT_AREA_WIDTH);
		// add the Tool Bar, List Grid, and Status Bar to the Activities View
		// layout container
		panel.addMember(this.toolbar);
		panel.addMember(this.listGrid);
		panel.addMember(this.statusBar);

	}
	
	@Override
	public Widget asWidget() {
		return panel;
	}

	public void setData() {
		listGrid.setData(ActivityData.getRecords());
	}

}