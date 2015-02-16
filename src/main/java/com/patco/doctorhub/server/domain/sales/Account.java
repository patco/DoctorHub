package com.patco.doctorhub.server.domain.sales;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = EntityTokens.ACCOUNT_TABLE)
public class Account implements Serializable {

	private static final long serialVersionUID = 7851999723073538242L;

	@Id
	@Column(name = EntityTokens.ACCOUNT_ID_COLUMN)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long accountId;

	@Column(name = EntityTokens.ACCOUNT_NAME_COLUMN, length = EntityTokens.ACCOUNT_NAME_COLUMN_LENGTH)
	protected String accountName;

	@Column(name = EntityTokens.ACCOUNT_NUMBER_COLUMN, length = EntityTokens.ACCOUNT_NUMBER_COLUMN_LENGTH)
	protected String accountNumber;

	@Column(name = EntityTokens.PARENT_ACCOUNT_COLUMN, length = EntityTokens.PARENT_ACCOUNT_COLUMN_LENGTH)
	protected String parentAccount;

	@Column(name = EntityTokens.PRIMARY_CONTACT_COLUMN, length = EntityTokens.PRIMARY_CONTACT_COLUMN_LENGTH)
	protected String primaryContact;

	@Column(name = EntityTokens.EMAIL_PRIMARY_CONTACT_COLUMN, length = EntityTokens.EMAIL_PRIMARY_CONTACT_COLUMN_LENGTH)
	protected String emailPrimaryContact;

	protected String relationshipType;

	// Address details
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = EntityTokens.ACCOUNT_ADDRESS_JOIN_TABLE, joinColumns = { @JoinColumn(name = EntityTokens.ACCOUNT_ID_COLUMN) }, inverseJoinColumns = { @JoinColumn(name = EntityTokens.ADDRESS_ID_COLUMN) })
	protected List<Address> addresses;

	// Electronic Address details
	@Column(name = EntityTokens.MAIN_PHONE_COLUMN, length = EntityTokens.MAIN_PHONE_COLUMN_LENGTH)
	protected String mainPhone;
	protected String fax;
	protected String otherPhone;
	protected String webSite;
	protected String email;

	// JPA requires a no-argument constructor
	public Account() {
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(String parentAccount) {
		this.parentAccount = parentAccount;
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

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final String NO_ADDRESS_DETAILS_MESSAGE = "No Address details";

	public String getLocation() {
		StringBuilder sb = new StringBuilder();
		String addressElement;

		int size = addresses.size();

		if (size > 0) {
			Iterator<Address> it = addresses.iterator();

			Address address = it.next();

			addressElement = address.getAddressLine1();
			sb.append(addressElement).append(", ");
			addressElement = address.getAddressLine2();
			sb.append(addressElement).append(" ");
			addressElement = address.getCity();
			sb.append(addressElement).append(" ");
			addressElement = address.getState();
			sb.append(addressElement).append(" ");
			addressElement = address.getPostalCode();
			sb.append(addressElement);
		} else {
			sb.append(NO_ADDRESS_DETAILS_MESSAGE);
		}

		// e.g. "Level 111, 111 Kent Street Sydney NSW 2000"
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(getAccountId()).append(", ");
		sb.append("Name: ").append(getAccountName()).append(", ");
		sb.append("Number: ").append(getAccountNumber()).append(", ");

		sb.append("Address: ").append(getLocation());

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
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
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
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}

}
