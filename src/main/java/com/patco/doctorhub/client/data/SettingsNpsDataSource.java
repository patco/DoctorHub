package com.patco.doctorhub.client.data;

public class SettingsNpsDataSource extends NavigationPaneSectionDataSource {

	private static final String DATA_SOURCE = "settingsDS";
	// private static final String DATA_SOURCE = "navigationPaneSectionDS";
	private static final String URL_PREFIX = "datasource/data/settingsdatasource";
	private static final String URL_SUFFIX = ".xml";

	private static SettingsNpsDataSource instance = null;

	public static SettingsNpsDataSource getInstance() {
		if (instance == null) {
			instance = new SettingsNpsDataSource(DATA_SOURCE);
		}

		return instance;
	}

	public SettingsNpsDataSource(String id) {
		super(id);

		setDataURL(URL_PREFIX, URL_SUFFIX);
	}
}
