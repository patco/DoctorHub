package com.patco.doctorhub.client.widgets;

import com.google.gwt.core.shared.GWT;
import com.google.inject.Inject;
import com.patco.doctorhub.client.resources.DoctorHubConstants;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class NavigationPaneHeader extends HLayout {
	private static final String WEST_WIDTH = "20%";
	private static final String NAVIGATION_PANE_HEADER_HEIGHT = "27px";

	private Label navigationPaneHeaderLabel;
	private Label contextAreaHeaderLabel;

	
	public NavigationPaneHeader() {
		super();
		GWT.log("NavigationPaneHeader()");
		// initialise the Navigation Pane Header layout container
		this.setStyleName("crm-NavigationPane-Header");
		this.setHeight(NAVIGATION_PANE_HEADER_HEIGHT);

		// initialise the Navigation Pane Header Label
		navigationPaneHeaderLabel = new Label();
		navigationPaneHeaderLabel
				.setStyleName("crm-NavigationPane-Header-Label");
		navigationPaneHeaderLabel.setWidth(WEST_WIDTH);
		navigationPaneHeaderLabel.setContents("Workplace");//TODO fix constants
		navigationPaneHeaderLabel.setAlign(Alignment.LEFT);
		navigationPaneHeaderLabel.setOverflow(Overflow.HIDDEN);

		// initialise the Context Area Header Label
		contextAreaHeaderLabel = new Label();
		contextAreaHeaderLabel.setStyleName("crm-ContextArea-Header-Label");
		contextAreaHeaderLabel.setContents("Activities"); //TODO fix constants
		contextAreaHeaderLabel.setAlign(Alignment.LEFT);
		contextAreaHeaderLabel.setOverflow(Overflow.HIDDEN);

		// add the Labels to the Navigation Pane Header layout container
		this.addMember(navigationPaneHeaderLabel);
		this.addMember(contextAreaHeaderLabel);
	}

	public Label getNavigationPaneHeaderLabel() {
		return navigationPaneHeaderLabel;
	}

	public Label getContextAreaHeaderLabel() {
		return contextAreaHeaderLabel;
	}

	public void setNavigationPaneHeaderLabelContents(String contents) {
		navigationPaneHeaderLabel.setContents(contents);
	}

	public String getNavigationPaneHeaderLabelContents() {
		return navigationPaneHeaderLabel.getContents();
	}

	public void setContextAreaHeaderLabelContents(String contents) {
		contextAreaHeaderLabel.setContents(contents);
	}

	public String getContextAreaHeaderLabelContents() {
		return contextAreaHeaderLabel.getContents();
	}

}
