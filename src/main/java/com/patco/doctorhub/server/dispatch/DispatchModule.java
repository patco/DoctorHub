package com.patco.doctorhub.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class DispatchModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		install(new com.gwtplatform.dispatch.rpc.server.guice.DispatchModule());
	}

}
