package com.patco.doctorhub.shared.dto;

import java.io.Serializable;

public class AccountsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5275915838902491445L;
	// as per AccountsRecord
	private static final String ACCOUNT_ID_DISPLAY_NAME = "Account Id";
	private static final String ACCOUNT_NAME_DISPLAY_NAME = "Account Name";
	private static final String MAIN_PHONE_DISPLAY_NAME = "Main Phone";
	private static final String LOCATION_DISPLAY_NAME = "Location";
	private static final String PRIMARY_CONTACT_DISPLAY_NAME = "Primary Contact";
	private static final String EMAIL_PRIMARY_CONTACT_DISPLAY_NAME = "Email (Primary Contact)";

	private Long accountId;
	private String accountName;
	private String mainPhone;
	private String location;
	private String primaryContact;
	private String emailPrimaryContact;

	public AccountsDto() {
	}

	public AccountsDto(Long accountId) {
		this.accountId = accountId;
	}

	public AccountsDto(Long accountId, String accountName, String mainPhone,
			String location, String primaryContact, String emailPrimaryContact) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.mainPhone = mainPhone;
		this.location = location;
		this.primaryContact = primaryContact;
		this.emailPrimaryContact = emailPrimaryContact;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getEmailPrimaryContact() {
		return emailPrimaryContact;
	}

	public void setEmailPrimaryContact(String emailPrimaryContact) {
		this.emailPrimaryContact = emailPrimaryContact;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ACCOUNT_ID_DISPLAY_NAME).append(": ").append(getAccountId())
				.append(", ");
		sb.append(ACCOUNT_NAME_DISPLAY_NAME).append(": ")
				.append(getAccountName()).append(", ");
		sb.append(MAIN_PHONE_DISPLAY_NAME).append(": ").append(getMainPhone())
				.append(", ");
		sb.append(LOCATION_DISPLAY_NAME).append(": ").append(getLocation())
				.append(", ");
		sb.append(PRIMARY_CONTACT_DISPLAY_NAME).append(": ")
				.append(getPrimaryContact()).append(", ");
		sb.append(EMAIL_PRIMARY_CONTACT_DISPLAY_NAME).append(
				getEmailPrimaryContact());

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountName == null) ? 0 : accountName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountsDto))
			return false;
		AccountsDto other = (AccountsDto) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (emailPrimaryContact == null) {
			if (other.emailPrimaryContact != null)
				return false;
		} else if (!emailPrimaryContact.equals(other.emailPrimaryContact))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mainPhone == null) {
			if (other.mainPhone != null)
				return false;
		} else if (!mainPhone.equals(other.mainPhone))
			return false;
		if (primaryContact == null) {
			if (other.primaryContact != null)
				return false;
		} else if (!primaryContact.equals(other.primaryContact))
			return false;
		return true;
	}
}
