package com.patco.doctorhub.client.application.signinpage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
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
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.patco.doctorhub.client.application.signinpage.errordialog.ErrorDialogPresenter;
import com.patco.doctorhub.client.place.NameTokens;
import com.patco.doctorhub.shared.FieldVerifier;

public class SignInPagePresenter extends
		Presenter<SignInPagePresenter.MyView, SignInPagePresenter.MyProxy>
		implements SignInPageUiHandlers {
	interface MyView extends View, HasUiHandlers<SignInPageUiHandlers> {
		public TextBox getUserNameField();

		public PasswordTextBox getPasswordField();

		public Button getSignInButton();

		void resetAndFocus();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SignInPage = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.signin)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<SignInPagePresenter> {
	}

	private final PlaceManager placeManager;
	private final ErrorDialogPresenter errorDialog;

	@Inject
	SignInPagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
			ErrorDialogPresenter errorDialog, PlaceManager placeManager) {
		super(eventBus, view, proxy, RevealType.Root);
		this.placeManager = placeManager;
		this.errorDialog = errorDialog;
		getView().setUiHandlers(this);
	}

	protected void onBind() {
		super.onBind();
		registerHandler(getView().getSignInButton().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						sendCredentialsToServer();
					}
				}));

	}

	@Override
	protected void onReset() {
		super.onReset();
		getView().resetAndFocus();
	}

	private void sendCredentialsToServer() {
		String userName = getView().getUserNameField().getText();
		String password = getView().getPasswordField().getText();

		if (FieldVerifier.isValidUserName(userName)
				&& (FieldVerifier.isValidPassword(password))) {
			PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(
					NameTokens.mainpage).build();
			// If needed, add URL parameters in this way:
			// myRequest = myRequest.with( "key1", "param1" ).with( "key2",
			// "param2" );
			placeManager.revealPlace(placeRequest);
		} else {
			showErrorDialog();
		}
	}

	@Override
	public void showErrorDialog() {
		addToPopupSlot(errorDialog);
	}

}