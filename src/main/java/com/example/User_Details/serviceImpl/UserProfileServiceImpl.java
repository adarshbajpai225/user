package com.example.User_Details.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Details.dao.UserProfileDao;
import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileDao userProfileDao;

	@Override
	public void post(UserProfile userprofile) {
		
		userProfileDao.post(userprofile);
	}

	@Override
	public List<UserProfile> getAll() {
		
		return userProfileDao.getAll();
	}

	@Override
	public UserProfile getById(Long id) {
		
		return userProfileDao.getById(id);
	}	

}
