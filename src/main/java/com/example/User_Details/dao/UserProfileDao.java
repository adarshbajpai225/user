package com.example.User_Details.dao;

import java.util.List;

import com.example.User_Details.entity.UserProfile;



public interface UserProfileDao {
	
	
	public void post(UserProfile userProfile);
	
	UserProfile getById(Long id);
	
	

	public List<UserProfile> getAll();

}
