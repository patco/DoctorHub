package com.patco.doctorhub.client.application.main.sales.activities;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.patco.doctorhub.client.application.main.MainPresenter;
import com.patco.doctorhub.client.place.NameTokens;
public class ActivitiesPresenter extends Presenter<ActivitiesPresenter.MyView, ActivitiesPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Activities = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.Activities)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<ActivitiesPresenter> {
    }

    @Inject
    ActivitiesPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, MainPresenter.SLOT_Main);
        
    }
    
    @Override
    protected void onReveal() {
    	super.onReveal();
        MainPresenter.getNavigationPaneHeader().setContextAreaHeaderLabelContents(NameTokens.Activities);
        MainPresenter.getNavigationPane().selectRecord(NameTokens.Activities);
    }
    
    

    @Override
    protected void revealInParent() {
      RevealContentEvent.fire(this, MainPresenter.SLOT_Main, this);
    }
    
}