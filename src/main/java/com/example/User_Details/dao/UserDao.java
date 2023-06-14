package com.example.User_Details.dao;

import java.util.List;
import java.util.Optional;
import com.example.User_Details.entity.User;

public interface UserDao  {
 
	
      
	 User getUserById(Long id);
  
	 List<User> getUser();

       public void save(User user);

	

	
	
	
}
