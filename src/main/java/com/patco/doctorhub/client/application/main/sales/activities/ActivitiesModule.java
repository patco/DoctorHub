package com.patco.doctorhub.client.application.main.sales.activities;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ActivitiesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class, ActivitiesView.class, ActivitiesPresenter.MyProxy.class);
    }
}