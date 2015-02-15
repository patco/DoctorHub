package com.patco.doctorhub.client.application.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.patco.doctorhub.client.place.NameTokens;
import com.patco.doctorhub.client.resources.DoctorHubConstants;
import com.patco.doctorhub.client.widgets.NavigationPane;
import com.patco.doctorhub.client.widgets.NavigationPaneHeader;

public class MainPresenter extends
		Presenter<MainPresenter.MyView, MainPresenter.MyProxy> implements
		MainUiHandlers {

	private final PlaceManager placeManager;
	private final DoctorHubConstants constants;

	private static NavigationPaneHeader navigationPaneHeader;
	private static NavigationPane navigationPane;

	interface MyView extends View, HasUiHandlers<MainUiHandlers> {
		NavigationPaneHeader getNavigationPaneHeader();

		NavigationPane getNavigationPane();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Main = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.mainpage)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<MainPresenter> {
	}

	@Inject
	MainPresenter(EventBus eventBus, MyView view, MyProxy proxy,
			PlaceManager placeManager, DoctorHubConstants constants) {
		super(eventBus, view, proxy);

		getView().setUiHandlers(this);

		this.placeManager = placeManager;
		this.constants = constants;
		MainPresenter.navigationPaneHeader = view.getNavigationPaneHeader();
		MainPresenter.navigationPane = view.getNavigationPane();
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub
		super.onBind();
		GWT.log("onBind()");

		// expand the first Navigation Pane section
		getView().getNavigationPane().expandSection(
				constants.SalesStackSectionName());

		// reveal the first nested Presenter
        PlaceRequest placRequest = new PlaceRequest.Builder().nameToken(NameTokens.Activities).build();
        placeManager.revealPlace(placRequest);
	}

	@Override
	protected void onReveal() {
		super.onReveal();

		GWT.log("onReveal()");
	}

	@Override
	protected void onReset() {
		super.onReset();

		GWT.log("onReset()");
	}

	@Override
	protected void revealInParent() {
		// RevealRootLayoutContentEvent.fire(this, this);
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	public void onNavigationPaneSectionHeaderClicked(String name) {
		if (name.length() != 0) {
			PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(
					name).build();
			placeManager.revealPlace(placeRequest);
		}

	}

	@Override
	public void onNavigationPaneSectionClicked(String name) {
		if (name.length() != 0) {
			PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(
					name).build();
			placeManager.revealPlace(placeRequest);
		}

	}

	public static NavigationPaneHeader getNavigationPaneHeader() {
		return navigationPaneHeader;
	}

	public static NavigationPane getNavigationPane() {
		return navigationPane;
	}

}