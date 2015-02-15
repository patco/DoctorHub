package com.patco.doctorhub.client.widgets.sales;

import java.util.List;

import com.patco.doctorhub.client.model.AccountsRecord;
import com.patco.doctorhub.client.widgets.SalesContextAreaListGrid;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.patco.doctorhub.shared.dto.AccountsDto;

public class AccountsContextAreaListGrid extends SalesContextAreaListGrid {

	// as per AccountsRecord
	private static final String ICON = "icon";
	private static final String ICON_DISPLAY_NAME = "#";
	// private static final String ACCOUNT_ID = "accountId";
	// private static final String ACCOUNT_ID_DISPLAY_NAME = "Account Id";
	private static final String ACCOUNT_NAME = "accountName";
	private static final String ACCOUNT_NAME_DISPLAY_NAME = "Account Name";
	private static final String MAIN_PHONE = "mainPhone";
	private static final String MAIN_PHONE_DISPLAY_NAME = "Main Phone";
	private static final String LOCATION = "location";
	private static final String LOCATION_DISPLAY_NAME = "Location";
	private static final String PRIMARY_CONTACT = "primaryContact";
	private static final String PRIMARY_CONTACT_DISPLAY_NAME = "Primary Contact";
	private static final String EMAIL_PRIMARY_CONTACT = "emailPrimaryContact";
	private static final String EMAIL_PRIMARY_CONTACT_DISPLAY_NAME = "Email (Primary Contact)";
	private static final String EMPTY_FIELD = "emptyField";
	private static final String EMPTY_FIELD_DISPLAY_NAME = " ";
	private static final String URL_PREFIX = "icons/16/";
	private static final String URL_SUFFIX = ".png";
	private static final String ACCOUNT_ICON = "account";

	private static final int ICON_COLUMN_LENGTH = 27;
	private static final int ACCOUNT_NAME_COLUMN_LENGTH = 140;
	private static final int MAIN_PHONE_COLUMN_LENGTH = 90;
	private static final int LOCATION_COLUMN_LENGTH = 220; // 80
	private static final int PRIMARY_CONTACT_COLUMN_LENGTH = 100;
	private static final int EMAIL_PRIMARY_CONTACT_COLUMN_LENGTH = 120;

	public AccountsContextAreaListGrid() {
		super();

		// Initialize the List Grid fields
		ListGridField iconField = new ListGridField(ICON, ICON_DISPLAY_NAME,
				ICON_COLUMN_LENGTH);
		iconField.setImageSize(16);
		iconField.setAlign(Alignment.CENTER);
		iconField.setType(ListGridFieldType.IMAGE);
		iconField.setImageURLPrefix(URL_PREFIX);
		iconField.setImageURLSuffix(URL_SUFFIX);

		ListGridField accountNameField = new ListGridField(ACCOUNT_NAME,
				ACCOUNT_NAME_DISPLAY_NAME, ACCOUNT_NAME_COLUMN_LENGTH);
		ListGridField mainPhoneField = new ListGridField(MAIN_PHONE,
				MAIN_PHONE_DISPLAY_NAME, MAIN_PHONE_COLUMN_LENGTH);
		ListGridField locationField = new ListGridField(LOCATION,
				LOCATION_DISPLAY_NAME, LOCATION_COLUMN_LENGTH);
		ListGridField primaryContactField = new ListGridField(PRIMARY_CONTACT,
				PRIMARY_CONTACT_DISPLAY_NAME, PRIMARY_CONTACT_COLUMN_LENGTH);
		primaryContactField.setType(ListGridFieldType.LINK);
		ListGridField emailPrimaryContactField = new ListGridField(
				EMAIL_PRIMARY_CONTACT, EMAIL_PRIMARY_CONTACT_DISPLAY_NAME,
				EMAIL_PRIMARY_CONTACT_COLUMN_LENGTH);
		ListGridField emptyField = new ListGridField(EMPTY_FIELD,
				EMPTY_FIELD_DISPLAY_NAME);

		// set the fields into the List Grid
		this.setFields(new ListGridField[] { iconField, accountNameField,
				mainPhoneField, locationField, primaryContactField,
				emailPrimaryContactField, emptyField });
	}

	public void setServerResponse(List<AccountsDto> accountsDtos) {

		AccountsRecord[] accountsRecords = new AccountsRecord[accountsDtos
				.size()];

		for (int i = 0; i < accountsDtos.size(); i++) {
			accountsRecords[i] = createAccountsRecord(accountsDtos.get(i));
		}

		// populate the List Grid
		this.setData(accountsRecords);
	}

	private AccountsRecord createAccountsRecord(AccountsDto accountsDto) {
		return new AccountsRecord(ACCOUNT_ICON, accountsDto.getAccountId(),
				accountsDto.getAccountName(), accountsDto.getMainPhone(),
				accountsDto.getLocation(), accountsDto.getPrimaryContact(),
				accountsDto.getEmailPrimaryContact());
	}

}
