package com.patco.doctorhub.client.application.main;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.patco.doctorhub.client.application.main.sales.activities.ActivitiesModule;
import com.patco.doctorhub.client.application.main.sales.calendar.CalendarModule;
import com.patco.doctorhub.client.application.main.sales.accounts.AccountsModule;

public class MainModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new AccountsModule());
		install(new CalendarModule());
		install(new ActivitiesModule());
		bindPresenter(MainPresenter.class, MainPresenter.MyView.class, MainView.class, MainPresenter.MyProxy.class);
    }
}