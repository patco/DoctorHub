package com.patco.doctorhub.client.widgets;

import com.google.inject.Inject;
import com.patco.doctorhub.client.resources.DoctorHubConstants;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;

public class StatusBar extends HLayout {
	private static final String STATUSBAR_HEIGHT = "23px";

	@Inject
	public StatusBar(DoctorHubConstants constants) {
		super();

		// Initialize the StatusBar layout container
		this.setStyleName("crm-StatusBar");
		this.setHeight(STATUSBAR_HEIGHT);

		// Initialize the Selected label
		Label selectedLabel = new Label();
		selectedLabel.setStyleName("crm-StatusBar-Label");
		selectedLabel.setContents(constants.SelectedLabel());
		selectedLabel.setAlign(Alignment.LEFT);
		selectedLabel.setOverflow(Overflow.HIDDEN);

		// Initialize the Result Set First button
		ImgButton resultSetFirstButton = new ImgButton();
		resultSetFirstButton.setShowRollOver(false);
		resultSetFirstButton.setShowDisabled(false);
		resultSetFirstButton.setShowDown(false);
		resultSetFirstButton.setSize(12);
		resultSetFirstButton.setLayoutAlign(VerticalAlignment.CENTER);
		resultSetFirstButton.setSrc("statusbar/resultsetfirst.png");

		// Initialize the Result Set Previous button
		ImgButton resultSetPreviousButton = new ImgButton();
		resultSetPreviousButton.setShowRollOver(false);
		resultSetPreviousButton.setShowDisabled(false);
		resultSetPreviousButton.setShowDown(false);
		resultSetPreviousButton.setSize(12);
		resultSetPreviousButton.setLayoutAlign(VerticalAlignment.CENTER);
		resultSetPreviousButton.setSrc("statusbar/resultsetprevious.png");

		// Initialize the Page Number label
		Label pageNumberLabel = new Label();
		pageNumberLabel.setStyleName("crm-StatusBar-Label");
		pageNumberLabel.setContents(constants.PageNumberLabel());
		pageNumberLabel.setWidth(50);
		pageNumberLabel.setAlign(Alignment.RIGHT);
		pageNumberLabel.setOverflow(Overflow.HIDDEN);

		// Initialize the Result Set Next button
		ImgButton resultSetNextButton = new ImgButton();
		resultSetNextButton.setShowRollOver(false);
		resultSetNextButton.setShowDisabled(false);
		resultSetNextButton.setShowDown(false);
		resultSetNextButton.setSize(12);
		resultSetNextButton.setLayoutAlign(VerticalAlignment.CENTER);
		resultSetNextButton.setSrc("statusbar/resultsetnext.png");

		// add the widgets to the StatusBar layout container
		this.addMember(selectedLabel);
		// force right alignment
		Label alignRight = new Label("&nbsp;");
		alignRight.setAlign(Alignment.RIGHT);
		alignRight.setOverflow(Overflow.HIDDEN);
		this.addMember(alignRight);
		this.addMember(resultSetFirstButton);
		this.addMember(resultSetPreviousButton);
		this.addMember(pageNumberLabel);
		this.addMember(resultSetNextButton);
		// add some padding
		LayoutSpacer paddingRight = new LayoutSpacer();
		paddingRight.setWidth(8);
		this.addMember(paddingRight);
	}

}
