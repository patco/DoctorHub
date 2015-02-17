package com.patco.doctorhub.client.application.main.sales.accounts;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.patco.doctorhub.client.application.main.MainPresenter;
import com.patco.doctorhub.client.place.NameTokens;
public class AccountsPresenter extends Presenter<AccountsPresenter.MyView, AccountsPresenter.MyProxy> implements AccountsUiHandlers {
	
    interface MyView extends View , HasUiHandlers<AccountsUiHandlers> {
    	
    }
    
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Accounts = new Type<RevealContentHandler<?>>();
    
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;

    @NameToken(NameTokens.Accounts)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<AccountsPresenter> {
    }

    @Inject
    AccountsPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager placeManager,
            DispatchAsync dispatcher) {
        super(eventBus, view, proxy, MainPresenter.SLOT_Main);
        getView().setUiHandlers(this);
        this.placeManager=placeManager;
        this.dispatcher=dispatcher;
    }
    
    

	@Override
	public void onRecordDoubleClicked(String accountId) {
		// TODO Auto-generated method stub
		
	}
    
    
}