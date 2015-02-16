package com.patco.doctorhub.server.domain.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = EntityTokens.ADDRESS_TABLE)
public class Address {
	  @Id
	  @Column(name = EntityTokens.ADDRESS_ID_COLUMN)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  protected Long addressId;

	  @Column(name = EntityTokens.ADDRESS_NAME_COLUMN, length = EntityTokens.ADDRESS_NAME_COLUMN_LENGTH) 
	  protected String addressName;
	  
	  @Column(name = EntityTokens.ADDRESS_LINE_1_COLUMN, length = EntityTokens.ADDRESS_LINE_COLUMN_LENGTH) 
	  protected String addressLine1;
	  
	  @Column(name = EntityTokens.ADDRESS_LINE_2_COLUMN, length = EntityTokens.ADDRESS_LINE_COLUMN_LENGTH) 
	  protected String addressLine2;
	  
	  @Column(name = EntityTokens.ADDRESS_LINE_3_COLUMN, length = EntityTokens.ADDRESS_LINE_COLUMN_LENGTH) 
	  protected String addressLine3;
	  
	  @Column(name = EntityTokens.CITY_COLUMN, length = EntityTokens.CITY_COLUMN_LENGTH)  
	  protected String city;
	  
	  @Column(name = EntityTokens.STATE_COLUMN, length = EntityTokens.STATE_COLUMN_LENGTH)  
	  protected String state;
	  
	  @Column(name = EntityTokens.POSTAL_CODE_COLUMN, length = EntityTokens.POSTAL_CODE_COLUMN_LENGTH)  
	  protected String postalCode;
	  
	  @Column(name = EntityTokens.COUNTRY_COLUMN, length = EntityTokens.COUNTRY_COLUMN_LENGTH)  
	  protected String country;
	  
	  @Column(name = EntityTokens.ADDRESS_TYPE_COLUMN, length = EntityTokens.ADDRESS_TYPE_COLUMN_LENGTH)  
	  protected String addressType;
	  
	  // JPA requires a no-argument constructor
	  public Address() {}
	  
	  public Address(String addressName, 
	      String addressLine1, String addressLine2, String addressLine3,
	      String city, String state, String postalCode, 
	      String country, String addressType) {
	    this.addressName = addressName;
	    this.addressLine1 = addressLine1;
	    this.addressLine2 = addressLine2;
	    this.addressLine3 = addressLine3;
	    this.city = city;
	    this.state = state;
	    this.postalCode = postalCode;
	    this.country = country;
	    this.addressType = addressType;
	  }

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}  
	  
	  

}
