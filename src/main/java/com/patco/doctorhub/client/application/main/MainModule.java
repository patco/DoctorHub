package com.patco.doctorhub.client.application.main;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.patco.doctorhub.client.application.main.sales.activities.ActivitiesModule;

public class MainModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ActivitiesModule());
		bindPresenter(MainPresenter.class, MainPresenter.MyView.class, MainView.class, MainPresenter.MyProxy.class);
    }
}