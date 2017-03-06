package org.akul.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable //tells hibernate not to create a different table for address class
public class Address {
	@Column(name="CITY_STREET")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="CITY_STATE")
	private String state;
	@Column(name="CITY_PINCODE")
	private int pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
