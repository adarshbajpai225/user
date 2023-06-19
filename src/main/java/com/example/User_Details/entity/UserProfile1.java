package com.example.User_Details.entity;

import java.sql.Date;

public class UserProfile1 {
	
	private Long up_id;
	
	private Long userid;
	private Date dob;
	

	public UserProfile1() {
		super();
		
	}


	public UserProfile1(Long up_id, Long userid, Date dob) {
		super();
		this.up_id = up_id;
		this.userid = userid;
		this.dob = dob;
	}


	
}
