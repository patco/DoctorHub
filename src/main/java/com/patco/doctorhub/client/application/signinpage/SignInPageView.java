package com.patco.doctorhub.client.application.signinpage;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class SignInPageView extends ViewWithUiHandlers<SignInPageUiHandlers> implements SignInPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, SignInPageView> {
    }


    @UiField TextBox userNameField;
	@UiField PasswordTextBox passwordField;
    @UiField Button signInButton;

    
    @Inject
    SignInPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    public TextBox getUserNameField() {
		return userNameField;
	}


	public PasswordTextBox getPasswordField() {
		return passwordField;
	}


	public Button getSignInButton() {
		return signInButton;
	}
	
	@Override
	public void resetAndFocus() {
		userNameField.setFocus(true);
		userNameField.selectAll();
	}
    
}