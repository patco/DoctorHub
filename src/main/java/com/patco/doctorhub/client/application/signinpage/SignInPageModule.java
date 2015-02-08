package com.patco.doctorhub.client.application.signinpage;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.patco.doctorhub.client.application.signinpage.errordialog.ErrorDialogModule;

public class SignInPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new ErrorDialogModule());
		bindPresenter(SignInPagePresenter.class, SignInPagePresenter.MyView.class, SignInPageView.class, SignInPagePresenter.MyProxy.class);
    }
}