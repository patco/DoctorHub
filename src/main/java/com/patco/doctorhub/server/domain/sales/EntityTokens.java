package com.patco.doctorhub.server.domain.sales;

public class EntityTokens {
	 //
	  // Account table
	  //
	  public static final String ACCOUNT_TABLE = "\"Account\"";
	  // Account column names
	  public static final String ACCOUNT_ID_COLUMN = "\"AccountId\"";
	  public static final String ACCOUNT_NAME_COLUMN = "\"AccountName\"";
	  public static final String ACCOUNT_NUMBER_COLUMN = "\"AccountNumber\"";
	  public static final String PARENT_ACCOUNT_COLUMN = "\"ParentAccount\"";
	  public static final String PRIMARY_CONTACT_COLUMN = "\"PrimaryContact\"";
	  public static final String EMAIL_PRIMARY_CONTACT_COLUMN = "\"EmailPrimaryContact\"";
	  public static final String MAIN_PHONE_COLUMN = "\"MainPhone\"";
	  // Account column lengths
	  public static final int ACCOUNT_NAME_COLUMN_LENGTH = 100;
	  public static final int ACCOUNT_NUMBER_COLUMN_LENGTH = 50;
	  public static final int PARENT_ACCOUNT_COLUMN_LENGTH = 100;
	  public static final int PRIMARY_CONTACT_COLUMN_LENGTH = 100;
	  public static final int EMAIL_PRIMARY_CONTACT_COLUMN_LENGTH = 50;
	  public static final int MAIN_PHONE_COLUMN_LENGTH = 50;

	  //
	  // Address table
	  //
	  public static final String ADDRESS_TABLE = "\"Address\"";
	  // Address column names
	  public static final String ADDRESS_ID_COLUMN = "\"AddressId\"";
	  public static final String ADDRESS_NAME_COLUMN = "\"AddressName\"";
	  public static final String ADDRESS_LINE_1_COLUMN = "\"AddressLine1\"";
	  public static final String ADDRESS_LINE_2_COLUMN = "\"AddressLine2\"";
	  public static final String ADDRESS_LINE_3_COLUMN = "\"AddressLine3\"";
	  public static final String CITY_COLUMN = "\"City\"";
	  public static final String STATE_COLUMN = "\"State\"";
	  public static final String POSTAL_CODE_COLUMN = "\"PostalCode\"";
	  public static final String COUNTRY_COLUMN = "\"Country\"";
	  public static final String ADDRESS_TYPE_COLUMN = "\"AddressType\"";
	  // Account column lengths
	  public static final int ADDRESS_NAME_COLUMN_LENGTH = 100;  
	  public static final int ADDRESS_LINE_COLUMN_LENGTH = 100;  
	  public static final int CITY_COLUMN_LENGTH = 50;
	  public static final int STATE_COLUMN_LENGTH = 50;
	  public static final int POSTAL_CODE_COLUMN_LENGTH = 10;
	  public static final int COUNTRY_COLUMN_LENGTH = 50;
	  public static final int ADDRESS_TYPE_COLUMN_LENGTH = 50;
	  
	  //
	  // Account Address join table name
	  //
	  public static final String ACCOUNT_ADDRESS_JOIN_TABLE = "\"AccountAddress\"";
	  

	  //
	  // BaseEntity is a MappedSuperclass (e.g. no table name)
	  //
	  // BaseEntity column names
	  public static final String VERSION_COLUMN = "\"Version\"";
	  public static final String CREATED_BY_COLUMN = "\"CreatedBy\"";
	  public static final String CREATED_TIMESTAMP_COLUMN = "\"CreatedTimestamp\"";
	  public static final String UPDATED_BY_COLUMN = "\"UpdatedBy\"";
	  public static final String UPDATED_TIMESTAMP_COLUMN = "\"UpdatedTimestamp\"";
	  // BaseEntity column lengths
	  public static final int CREATED_BY_COLUMN_LENGTH = 50;
	  public static final int UPDATED_BY_COLUMN_LENGTH = 50;
	  // Account column nullable (default is true)
	  public static final boolean VERSION_COLUMN_NULLABLE = false;
	  public static final boolean CREATED_BY_COLUMN_NULLABLE = false;  
	  public static final boolean CREATED_TIMESTAMP_COLUMN_NULLABLE = false;
	  public static final boolean UPDATED_BY_COLUMN_NULLABLE = false;
	  public static final boolean UPDATED_TIMESTAMP_COLUMN_NULLABLE = false;  
}
