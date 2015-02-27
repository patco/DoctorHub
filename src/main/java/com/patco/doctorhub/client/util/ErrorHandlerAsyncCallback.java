package com.patco.doctorhub.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Response;
import com.gwtplatform.dispatch.rest.client.RestCallback;
import com.smartgwt.client.util.SC;

public abstract class ErrorHandlerAsyncCallback<R> implements RestCallback<R> {

	@Override
	public void onFailure(Throwable caught) {
		SC.warn(caught.getMessage());
	}
	
    @Override
    public void setResponse(Response response) {
        GWT.log("HTTP " + response.getStatusCode() + ": " + response.getStatusText());
    }
}
