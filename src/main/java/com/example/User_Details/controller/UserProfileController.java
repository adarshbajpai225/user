package com.example.User_Details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.service.UserProfileService;



@RestController
@RequestMapping("/up")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@PostMapping("/post")
	public UserProfile post(@RequestBody UserProfile userProfile)
	{
		userProfileService.post(userProfile);
		return userProfile;
	}
	
	@GetMapping("/get")
	public List<UserProfile> getAll()
	{
		return userProfileService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public UserProfile getById(@PathVariable Long id)
	{
		return userProfileService.getById(id);
	}
	
	
	

}
