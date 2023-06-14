package com.example.User_Details.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="address")
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long ad_id;
	
    
	private Long userid;
	
	private String houseno;
	private String addressline1;
	private String addressline2;
	
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Address(Long ad_id,Long userid, String houseno, String addressline1, String addressline2, String city,
			String state, String country, String pincode) {
		super();
		this.ad_id = ad_id;
		this.userid = userid;
		this.houseno = houseno;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}



	public Long getAd_id() {
		return ad_id;
	}



	public void setAd_id(Long ad_id) {
		this.ad_id = ad_id;
	}



	public Long getUserid() {
		return userid;
	}



	public void setUserid(Long userid) {
		this.userid = userid;
	}



	public String getHouseno() {
		return houseno;
	}



	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}



	public String getAddressline1() {
		return addressline1;
	}



	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}



	public String getAddressline2() {
		return addressline2;
	}



	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
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



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Address [ad_id=" + ad_id + ", userid=" + userid + ", houseno=" + houseno + ", addressline1="
				+ addressline1 + ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + "]";
	}



	
	
}
