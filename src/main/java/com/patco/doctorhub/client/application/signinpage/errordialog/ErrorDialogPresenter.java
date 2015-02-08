package com.patco.doctorhub.client.application.signinpage.errordialog;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
public class ErrorDialogPresenter extends Presenter<ErrorDialogPresenter.MyView, ErrorDialogPresenter.MyProxy>  {
    interface MyView extends PopupView  {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_ErrorDialog = new Type<RevealContentHandler<?>>();

    
    @ProxyCodeSplit
    interface MyProxy extends Proxy<ErrorDialogPresenter> {
    }

    @Inject
    ErrorDialogPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.RootPopup);
        
    }
    
    
}