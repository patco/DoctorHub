package com.patco.doctorhub.client.widgets.sales;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.patco.doctorhub.client.resources.DoctorHubConstants;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class ToolBar extends HLayout {

	private static final String TOOLBAR_HEIGHT = "25px";
	private static final String TOOLSTRIP_WIDTH = "*";

	private static final String NEW_BUTTON = "toolbar/new.png";
	private static final String PRINT_PREVIEW_BUTTON = "toolbar/printpreview.png";
	private static final String EXPORT_BUTTON = "toolbar/export.png";
	private static final String MAIL_MERGE_BUTTON = "toolbar/mailmerge.png";
	private static final String REPORTS_BUTTON = "toolbar/reports.png";
	private static final String ASSIGN_BUTTON = "toolbar/assign.png";
	private static final String DELETE_BUTTON = "toolbar/delete.png";
	private static final String EMAIL_BUTTON = "toolbar/sendemail.png";

	@Inject
	public ToolBar(DoctorHubConstants constants) {
		super();
		Log.debug("ToolBar()");

		// Initialize the ToolStrip
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.setHeight(TOOLBAR_HEIGHT);
		toolStrip.setWidth(TOOLSTRIP_WIDTH);

		// Initialize the New button
		ToolStripButton newButton = new ToolStripButton();
		newButton.setIcon(NEW_BUTTON);
		newButton.setTitle(constants.NewButton());
		newButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				SC.say("You clicked the New button.");
			}
		});

		toolStrip.addButton(newButton);
		toolStrip.addSeparator();

		// Initialize the Print Preview button
		ToolStripButton printPreviewButton = new ToolStripButton();
		printPreviewButton.setIcon(PRINT_PREVIEW_BUTTON);
		toolStrip.addButton(printPreviewButton);

		// Initialize the Export button
		ToolStripButton exportButton = new ToolStripButton();
		exportButton.setIcon(EXPORT_BUTTON);
		toolStrip.addButton(exportButton);

		// Initialize the Mail Merge button
		ToolStripButton mailMergeButton = new ToolStripButton();
		mailMergeButton.setIcon(MAIL_MERGE_BUTTON);
		toolStrip.addButton(mailMergeButton);

		// Initialize the Reports button
		ToolStripButton reportsButton = new ToolStripButton();
		reportsButton.setIcon(REPORTS_BUTTON);
		toolStrip.addButton(reportsButton);

		toolStrip.addSeparator();

		// Initialize the Assign button
		ToolStripButton assignButton = new ToolStripButton();
		assignButton.setIcon(ASSIGN_BUTTON);
		toolStrip.addButton(assignButton);

		// Initialize the Delete button
		ToolStripButton deleteButton = new ToolStripButton();
		deleteButton.setIcon(DELETE_BUTTON);
		toolStrip.addButton(deleteButton);

		// Initialize the Email button
		ToolStripButton emailButton = new ToolStripButton();
		emailButton.setIcon(EMAIL_BUTTON);
		toolStrip.addButton(emailButton);

		// add the ToolStrip to the ToolBar layout container
		this.addMember(toolStrip);

	}
}
