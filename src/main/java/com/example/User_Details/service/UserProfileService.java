package com.example.User_Details.service;

import java.util.List;

import com.example.User_Details.entity.UserProfile;

public interface UserProfileService {
	
	
	public void post(UserProfile userprofile);
	
	List<UserProfile> getAll();
	
	UserProfile getById(Long id);
	

}
