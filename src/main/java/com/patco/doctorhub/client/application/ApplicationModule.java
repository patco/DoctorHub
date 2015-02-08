package com.patco.doctorhub.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.patco.doctorhub.client.application.main.MainModule;
import com.patco.doctorhub.client.application.signinpage.SignInPageModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new MainModule());
		install(new SignInPageModule());
		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}