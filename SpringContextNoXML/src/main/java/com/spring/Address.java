package com.spring;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	String street ="Gachibowli";
	
	int pincode;
	
	String country = "India";
	
	public Address() {
		
	}

	public Address(String street, int pincode, String country) {
		super();
		this.street = street;
		this.pincode = pincode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", pincode=" + pincode + ", country=" + country + "]";
	}
	
	

}
