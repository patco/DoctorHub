package com.patco.doctorhub.client.data;

import com.google.gwt.i18n.client.LocaleInfo;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;

public abstract class NavigationPaneSectionDataSource extends DataSource {
	private static final String ICON = "icon";
	private static final String ICON_DISPLAY_NAME = "Icon";
	private static final String NAME = "name";
	private static final String NAME_DISPLAY_NAME = "Name";
	private static final String RECORD_XPATH = "/list/record";

	public NavigationPaneSectionDataSource(String id) {
		setID(id);
		setDataFormat(DSDataFormat.XML);
		setRecordXPath(RECORD_XPATH);
		DataSourceField iconField = new DataSourceField(ICON, FieldType.TEXT,
				ICON_DISPLAY_NAME);
		DataSourceField nameField = new DataSourceField(NAME, FieldType.TEXT,
				NAME_DISPLAY_NAME);
		setFields(iconField, nameField);
	}

	public void setDataURL(String urlPrefix, String urlSuffix) {
		String url = urlPrefix;
		LocaleInfo localeInfo = LocaleInfo.getCurrentLocale();
		String localeName = localeInfo.getLocaleName();

		if (localeName.length() > 0) {
			url = url + "_" + localeName;
		}

		url = url + urlSuffix;
		setDataURL(url);
	}
}
