package com.patco.doctorhub.client.application.main;

import com.gwtplatform.mvp.client.UiHandlers;

interface MainUiHandlers extends UiHandlers {
	  void onNavigationPaneSectionHeaderClicked(String name);
	  void onNavigationPaneSectionClicked(String name);
}