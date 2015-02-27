package com.patco.doctorhub.server.guice;

import com.arcbees.guicyresteasy.GuiceRestEasyFilterDispatcher;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.patco.doctorhub.shared.rest.api.ApiPaths;

public class DispatchServletModule extends ServletModule {
    @Override
    public void configureServlets() {
    	install(new JpaPersistModule("com.patco.doctorhub"));
        filter("/*").through(PersistFilter.class);
        filter(ApiPaths.ROOT + "/*").through(GuiceRestEasyFilterDispatcher.class);
        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);
    }
}