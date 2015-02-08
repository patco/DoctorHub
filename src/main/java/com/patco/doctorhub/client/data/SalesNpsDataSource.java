package com.patco.doctorhub.client.data;

public class SalesNpsDataSource extends NavigationPaneSectionDataSource {

	private static SalesNpsDataSource instance = null;

	private static final String DATA_SOURCE = "salesDS";
	// private static final String DATA_SOURCE = "navigationPaneSectionDS";
	private static final String URL_PREFIX = "datasource/data/salesdatasource";
	private static final String URL_SUFFIX = ".xml";

	public SalesNpsDataSource(String id) {
		super(id);

		setDataURL(URL_PREFIX, URL_SUFFIX);
	}

	public static SalesNpsDataSource getInstance() {
		if (instance == null) {
			instance = new SalesNpsDataSource(DATA_SOURCE);
		}

		return instance;
	}

}
