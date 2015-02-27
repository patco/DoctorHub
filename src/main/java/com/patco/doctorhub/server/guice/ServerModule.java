package com.patco.doctorhub.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import com.patco.doctorhub.server.dispatch.DispatchModule;
import com.patco.doctorhub.server.rest.api.ApiModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	install(new ApiModule());
    	install(new DispatchModule());
    }
}