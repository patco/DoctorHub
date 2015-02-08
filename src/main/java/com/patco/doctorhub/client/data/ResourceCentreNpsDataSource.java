package com.patco.doctorhub.client.data;

public class ResourceCentreNpsDataSource extends
		NavigationPaneSectionDataSource {

	private static final String DATA_SOURCE = "resourceCentreDS";
	// private static final String DATA_SOURCE = "navigationPaneSectionDS";
	private static final String URL_PREFIX = "datasource/data/resourcecentredatasource";
	private static final String URL_SUFFIX = ".xml";

	private static ResourceCentreNpsDataSource instance = null;

	public static ResourceCentreNpsDataSource getInstance() {
		if (instance == null) {
			instance = new ResourceCentreNpsDataSource(DATA_SOURCE);
		}
		return instance;
	}

	public ResourceCentreNpsDataSource(String id) {
		super(id);

		setDataURL(URL_PREFIX, URL_SUFFIX);
	}

}
