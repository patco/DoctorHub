package com.patco.doctorhub.client.gin;

import com.patco.doctorhub.client.application.ApplicationModule;
import com.patco.doctorhub.client.place.NameTokens;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder().tokenFormatter(RouteTokenFormatter.class).build());
        install(new ApplicationModule());

        // DefaultPlaceManager Places
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signin);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.signin);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.signin);
        
    }
}