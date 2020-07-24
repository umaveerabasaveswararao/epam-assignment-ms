package com.order.epam.orderms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	public int id;
	public String addressType;
	public String state;
	public Long pincode;
	public String addressLine1;
	public String city;
	public Long mobileNumber;
	@JsonIgnore
	public int orderId;
	
	public Address() {
	
	}
	public Address(int id, String addressType, String state, Long pincode, String addressLine1, String city,
			Long mobileNumber, int orderId) {
		super();
		this.id = id;
		this.addressType = addressType;
		this.state = state;
		this.pincode = pincode;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.orderId = orderId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressType=" + addressType + ", state=" + state + ", pincode=" + pincode
				+ ", addressLine1=" + addressLine1 + ", city=" + city + ", mobileNumber=" + mobileNumber + "]";
	}

}
