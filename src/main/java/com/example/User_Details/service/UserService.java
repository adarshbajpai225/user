package com.example.User_Details.service;

import java.util.List;
import java.util.Optional;


import com.example.User_Details.entity.User;
import com.example.User_Details.entity.UserProfile;

public interface UserService {
	
	

	public User getUserById(Long id);
	
	
	
	public List<User> getUser();




	public void save(User user);



	
	
	

}
