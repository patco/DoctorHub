package com.patco.doctorhub.client.application.signinpage.errordialog;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ErrorDialogModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ErrorDialogPresenter.class, ErrorDialogPresenter.MyView.class, ErrorDialogView.class, ErrorDialogPresenter.MyProxy.class);
    }
}