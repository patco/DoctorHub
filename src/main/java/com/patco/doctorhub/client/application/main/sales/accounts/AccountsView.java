package com.patco.doctorhub.client.application.main.sales.accounts;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.patco.doctorhub.client.widgets.sales.AccountsContextAreaListGrid;
import com.patco.doctorhub.client.widgets.sales.StatusBar;
import com.patco.doctorhub.client.widgets.sales.ToolBar;
import com.patco.doctorhub.shared.dto.AccountsDto;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

class AccountsView extends ViewWithUiHandlers<AccountsUiHandlers> implements
		AccountsPresenter.MyView {
	interface Binder extends UiBinder<Widget, AccountsView> {
	}

	private static final String CONTEXT_AREA_WIDTH = "*";
	private final ToolBar toolbar;
	private final AccountsContextAreaListGrid listGrid;
	private final StatusBar statusBar;

	private VLayout panel;

	@Inject
	AccountsView(ToolBar toolbar, AccountsContextAreaListGrid listGrid,
			StatusBar statusBar) {
		this.listGrid = listGrid;
		this.toolbar = toolbar;
		this.statusBar = statusBar;

		Log.debug("AccountsView()");

		panel = new VLayout();

		// Initialize the Accounts View layout container
		panel.setStyleName("crm-ContextArea");
		panel.setWidth(CONTEXT_AREA_WIDTH);

		// add the Tool Bar, List Grid, and Status Bar to the Accounts View
		// layout container
		panel.addMember(this.toolbar);
		panel.addMember(this.listGrid);
		panel.addMember(this.statusBar);
		// this.addMember(this.jumpBar);

		bindCustomUiHandlers();

	}

	// as per AccountsRecord
	private static final String ACCOUNT_ID = "accountId";

	protected void bindCustomUiHandlers() {

		// register the ListGird handler's
		listGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				Record record = event.getRecord();
				String accountId = record.getAttributeAsString(ACCOUNT_ID);

				Log.debug("onRecordDoubleClick() - " + accountId);

				if (getUiHandlers() != null) {
					getUiHandlers().onRecordDoubleClicked(accountId);
				}
			}
		});
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	public void setServerResponse(List<AccountsDto> accountDtos) {
		if (accountDtos != null) {
			listGrid.setServerResponse(accountDtos);
		}
	}

	public AccountsContextAreaListGrid getListGrid() {
		return listGrid;
	}

	public ToolBar getToolbar() {
		return toolbar;
	}

}