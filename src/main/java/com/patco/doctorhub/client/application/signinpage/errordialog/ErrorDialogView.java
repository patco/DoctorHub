package com.patco.doctorhub.client.application.signinpage.errordialog;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

class ErrorDialogView extends PopupViewImpl implements ErrorDialogPresenter.MyView {
    interface Binder extends UiBinder<Widget, ErrorDialogView> {
    }

    @UiField
    Button okButton;

    @Inject
    ErrorDialogView(EventBus eventBus, Binder uiBinder) {
        super(eventBus);
    
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("okButton")
    void okButtonClicked(ClickEvent event) {
      hide();
    }
    
}