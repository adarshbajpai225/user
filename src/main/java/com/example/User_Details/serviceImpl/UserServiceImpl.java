package com.example.User_Details.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.User_Details.dao.UserDao;
import com.example.User_Details.entity.User;
import com.example.User_Details.service.UserService;

@org.springframework.stereotype.Service
public class UserServiceImpl implements  UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> getUser() {
		
		return userDao.getUser();		
	}
	
	@Override
	public User getUserById(Long id) {
		
		return userDao.getUserById(id);
	}

	

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	
	
	
	
     
	
}
