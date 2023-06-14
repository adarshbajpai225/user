package com.example.User_Details.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long up_id;
	
	private Long userid ;

    private Date dob;

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(Long up_id, Long userid, Date dob) {
		super();
		this.up_id = up_id;
		this.userid = userid;
		this.dob = dob;
	}

	public Long getUp_id() {
		return up_id;
	}

	public void setUp_id(Long up_id) {
		this.up_id = up_id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UserProfile [up_id=" + up_id + ", userid=" + userid + ", dob=" + dob + "]";
	}	
	

}
