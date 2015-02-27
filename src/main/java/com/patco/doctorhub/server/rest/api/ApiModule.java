package com.patco.doctorhub.server.rest.api;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.patco.doctorhub.shared.rest.api.AccountsResource;
import com.patco.doctorhub.shared.rest.api.JacksonProvider;

public class ApiModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JacksonProvider.class).in(Singleton.class);
		bind(AccountsResource.class).to(AccountsResourceImpl.class);
	}

}
