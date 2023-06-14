package com.example.User_Details.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long m_id;
	
	private  Long user_id;
	
	private String mobileno;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(Long m_id,Long user_id, String mobileno) {
		super();
		this.m_id = m_id;
		this.user_id = user_id;
		this.mobileno = mobileno;
	}

	public Long getM_id() {
		return m_id;
	}

	public void setM_id(Long m_id) {
		this.m_id = m_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "Mobile [m_id=" + m_id + ", user_id=" + user_id + ", mobileno=" + mobileno + "]";
	}
	
	
}
