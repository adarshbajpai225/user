package com.example.User_Details.controller;

import java.sql.Date;

public class UserWithProfileDto {
	
	    private int userId;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private String password;
	    private Byte status;
	    private int profileId;
	    private Date dob;

	    public UserWithProfileDto(int userId, String firstname, String lastname, String email, String password,
	                              Byte status, int profileId, Date dob) {
	        this.userId = userId;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.email = email;
	        this.password = password;
	        this.status = status;
	        this.profileId = profileId;
	        this.dob = dob;
	    }

		public UserWithProfileDto() {
			// TODO Auto-generated constructor stub
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Byte isStatus() {
			return status;
		}

		public void setStatus(Byte status) {
			this.status = status;
		}

		public int getProfileId() {
			return profileId;
		}

		public void setProfileId(int profileId) {
			this.profileId = profileId;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

	   

}
