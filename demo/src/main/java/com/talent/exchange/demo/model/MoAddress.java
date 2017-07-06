package com.talent.exchange.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.talent.exchange.demo.model.MoUserEnum.ADDRESS_TYPE;

@Entity
@Table(name = "tex_address")
public class MoAddress extends MoBase {

	@Column(name = "address_type", length = 16)
	@Enumerated(EnumType.STRING)
	private ADDRESS_TYPE addressType = ADDRESS_TYPE.MAILING;	

	@Column(name = "address_line1", length = 255)
	private String addressLine1;

	@Column(name = "address_line2", length = 255)
	private String addressLine2;

	@Column(name = "city", length = 128)
	private String city;

	@Column(name = "state", length = 64)
	private String state;

	@Column(name = "mail_code", length = 10)
	private String mailCode;

	@Column(name = "country", length = 64)
	private String country;

	@Column(name = "us_address")
	private boolean usAddress = false;

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getMailCode() {
		return mailCode;
	}

	public String getCountry() {
		return country;
	}

	public boolean isUSAddress() {
		return usAddress;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUSAddress(boolean addressIsUS) {
		this.usAddress = addressIsUS;
	}

	@Override
	public String toString() {
		return "MoAddress [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", mailCode=" + mailCode + ", country=" + country + ", usAddress=" + usAddress
				+ "]";
	}

	public ADDRESS_TYPE getAddressType() {
		return addressType;
	}

	public void setAddressType(ADDRESS_TYPE addressType) {
		this.addressType = addressType;
	}

}
