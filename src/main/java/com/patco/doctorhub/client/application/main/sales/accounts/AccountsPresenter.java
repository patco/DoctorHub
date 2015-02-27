package com.patco.doctorhub.client.application.main.sales.accounts;

import java.util.List;

import org.apache.log4j.Logger;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.http.client.Response;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.patco.doctorhub.client.application.main.MainPresenter;
import com.patco.doctorhub.client.place.NameTokens;
import com.patco.doctorhub.client.util.ErrorHandlerAsyncCallback;
import com.patco.doctorhub.shared.dto.AccountsDto;
import com.patco.doctorhub.shared.rest.api.AccountsResource;

public class AccountsPresenter extends
		Presenter<AccountsPresenter.MyView, AccountsPresenter.MyProxy>
		implements AccountsUiHandlers {

	interface MyView extends View, HasUiHandlers<AccountsUiHandlers> {
		public void setServerResponse(List<AccountsDto> accountDtos);
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Accounts = new Type<RevealContentHandler<?>>();

	private final PlaceManager placeManager;

	private final ResourceDelegate<AccountsResource> accountsdelegate;

	@NameToken(NameTokens.Accounts)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<AccountsPresenter> {
	}

	@Inject
	AccountsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
			PlaceManager placeManager,
			ResourceDelegate<AccountsResource> accountsdelegate) {
		super(eventBus, view, proxy, MainPresenter.SLOT_Main);
		getView().setUiHandlers(this);
		this.placeManager = placeManager;
		this.accountsdelegate = accountsdelegate;
	}

	@Override
	public void onRecordDoubleClicked(String accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onReset() {
		super.onReset();
		retrieveAccounts();
	}

	protected void retrieveAccounts() {
		Log.debug("retrieveaccounts()");
		accountsdelegate.withCallback(new ErrorHandlerAsyncCallback<List<AccountsDto>>(){
			@Override
			public void onSuccess(List<AccountsDto> result) {
				Log.debug("onSuccess retrieveaccounts()");
				getView().setServerResponse(result);
			}
			
		}).getAccounts();

	}

}