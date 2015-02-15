package com.patco.doctorhub.client.application.main;

import javax.inject.Inject;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.patco.doctorhub.client.data.ResourceCentreNpsDataSource;
import com.patco.doctorhub.client.data.SalesNpsDataSource;
import com.patco.doctorhub.client.data.SettingsNpsDataSource;
import com.patco.doctorhub.client.resources.DoctorHubConstants;
import com.patco.doctorhub.client.widgets.ApplicationMenu;
import com.patco.doctorhub.client.widgets.Masthead;
import com.patco.doctorhub.client.widgets.NavigationPane;
import com.patco.doctorhub.client.widgets.NavigationPaneHeader;
import com.patco.doctorhub.client.widgets.NavigationPaneSection;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickHandler;
import com.smartgwt.client.widgets.menu.Menu;

class MainView extends ViewWithUiHandlers<MainUiHandlers> implements MainPresenter.MyView {
    interface Binder extends UiBinder<Widget, MainView> {
    }
        
    
	private static final int NORTH_HEIGHT = 85;
	private static final int DEFAULT_MENU_WIDTH = 70;
	private static final String DEFAULT_MARGIN = "0px";
	
	private final Masthead masthead;
	private final ApplicationMenu applicationMenu;
	private final NavigationPaneHeader navigationPaneHeader;
	private final NavigationPane navigationPane;

	private VLayout panel;
	private HLayout northLayout;
	private HLayout southLayout;
	private VLayout westLayout;

	private final DoctorHubConstants constants;

    @Inject
    MainView(Masthead masthead,
			ApplicationMenu applicationMenu,
			NavigationPaneHeader navigationPaneHeader,
			NavigationPane navigationPane, DoctorHubConstants constants) {
    	
        this.masthead = masthead;
        this.applicationMenu = applicationMenu;
        this.navigationPaneHeader = navigationPaneHeader;
        this.navigationPane = navigationPane;
        this.constants=constants;
        
        // get rid of scroll bars, and clear out the window's built-in margin,
        // because we want to take advantage of the entire client area
        Window.enableScrolling(false);
        Window.setMargin(DEFAULT_MARGIN);    
        
        // initialise the main layout container
        panel = new VLayout();
        panel.setWidth100();  
        panel.setHeight100();  
        
        // initialise the North layout container
        northLayout = new HLayout();  
        northLayout.setHeight(NORTH_HEIGHT); 
     
        initApplicationMenu();
        
        // initialise the nested layout container
        VLayout vLayout = new VLayout(); 
        vLayout.addMember(this.masthead);
        vLayout.addMember(this.applicationMenu);
        vLayout.addMember(this.navigationPaneHeader); 
           
        // add the nested layout container to the North layout container
        northLayout.addMember(vLayout);
        
        initNavigationPane();
        
        // Initialize the West layout container
        westLayout = this.navigationPane;
       
        // Initialize the South layout container
        southLayout = new HLayout(); 
        
        // add the North and South layout containers to the main layout container
        panel.addMember(northLayout);  
        panel.addMember(southLayout);  
        
        bindCustomUiHandlers();
    }
    
 // as per NavigationPaneDataSource
 	private static final String NAME = "name";

 	protected void bindCustomUiHandlers() {

 		// register the Application Menu handler's

 		// register the Navigation Pane handler's
 		navigationPane
 				.addSectionHeaderClickHandler(new SectionHeaderClickHandler() {
 					@Override
 					public void onSectionHeaderClick(
 							SectionHeaderClickEvent event) {
 						SectionStackSection section = event.getSection();
 						String name = ((NavigationPaneSection) section)
 								.getSelectedRecord();

 						GWT.log("onSectionHeaderClick() - " + name);

 						if (getUiHandlers() != null) {
 							getUiHandlers()
 									.onNavigationPaneSectionHeaderClicked(name);
 						}
 					}
 				});

 		navigationPane.addRecordClickHandler(constants.SalesStackSectionName(),
 				new RecordClickHandler() {
 					@Override
 					public void onRecordClick(RecordClickEvent event) {
 						onRecordClicked(event);
 					}
 				});

 		navigationPane.addRecordClickHandler(
 				constants.SettingsStackSectionName(), new RecordClickHandler() {
 					@Override
 					public void onRecordClick(RecordClickEvent event) {
 						onRecordClicked(event);
 					}
 				});

 		navigationPane.addRecordClickHandler(
 				constants.ResourceCentreStackSectionName(),
 				new RecordClickHandler() {
 					@Override
 					public void onRecordClick(RecordClickEvent event) {
 						onRecordClicked(event);
 					}
 				});
 	}

 	private void onRecordClicked(RecordClickEvent event) {
 		Record record = event.getRecord();
 		String name = record.getAttributeAsString(NAME);

 		GWT.log("onRecordClicked() - " + name);

 		if (getUiHandlers() != null) {
 			getUiHandlers().onNavigationPaneSectionClicked(name);
 		}
 	}

 	@Override
 	public Widget asWidget() {
 		return panel;
 	}

 	@Override
 	public void setInSlot(Object slot, IsWidget content) {
 		GWT.log("Main View setInSlot()");

 		if (slot == MainPresenter.SLOT_Main) {
 			if (content != null) {
 				southLayout.setMembers(westLayout, (VLayout) content.asWidget());
 			}
 		} else {
 			super.setInSlot(slot, content);
 		}
 	}
 	
 	@Override
 	public void removeFromSlot(Object slot, IsWidget content) {
 		// TODO Auto-generated method stub
 		super.removeFromSlot(slot, content);
 		GWT.log("removeFromSlot()");
 	}

 	private void initApplicationMenu() {
 		applicationMenu.addMenu(constants.NewActivityMenuName(), DEFAULT_MENU_WIDTH, constants.NewActivityMenuItemNames(), null);
 		applicationMenu.addMenu(constants.NewRecordMenuName(),DEFAULT_MENU_WIDTH, constants.NewRecordMenuItemNames(), null);
 		Menu goToMenu = applicationMenu.addMenu(constants.GoToMenuName(), DEFAULT_MENU_WIDTH - 30);
 		applicationMenu.addSubMenu(goToMenu, constants.SalesMenuItemName(), constants.SalesMenuItemNames(), null);
 		applicationMenu.addSubMenu(goToMenu, constants.SettingsMenuItemName(), constants.SettingsMenuItemNames(), null);
 		applicationMenu.addSubMenu(goToMenu, constants.ResourceCentreMenuItemName(), constants.ResourceCentreMenuItemNames(), null);
 		applicationMenu.addMenu(constants.ToolsMenuName(),DEFAULT_MENU_WIDTH - 30, constants.ToolsMenuItemNames(), null);
 		applicationMenu.addMenu(constants.HelpMenuName(),DEFAULT_MENU_WIDTH - 30, constants.HelpMenuItemNames(), null);
 	}

 	private void initNavigationPane() {
 		navigationPane.addSection(constants
 				.SalesStackSectionName(), SalesNpsDataSource.getInstance());
 		navigationPane.addSection(constants.SettingsStackSectionName(), SettingsNpsDataSource.getInstance());
 		navigationPane.addSection(constants.ResourceCentreStackSectionName(), ResourceCentreNpsDataSource.getInstance());
 	}

 	public ApplicationMenu getApplicationMenu() {
 		return applicationMenu;
 	}

 	public NavigationPaneHeader getNavigationPaneHeader() {
 		return navigationPaneHeader;
 	}

 	public NavigationPane getNavigationPane() {
 		return navigationPane;
 	}
}