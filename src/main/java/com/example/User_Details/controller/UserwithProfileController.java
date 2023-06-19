package com.example.User_Details.controller;

import javax.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.User;
import com.example.User_Details.entity.User1;
import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.entity.UserProfile1;
import com.example.User_Details.entity.UserwithProfile;
import com.example.User_Details.util.DBUtility;

@RestController
public class UserwithProfileController {
	
	@GetMapping("/user-with-profile/{id}")
	public UserwithProfile getUserWithProfile(@PathVariable Long id) {
	    EntityManager entityManager = DBUtility.getEntityManager();

	    // level 1
	    User user = entityManager.find(User.class,id);
	    User1 user1 = new User1(user.getId(),user.getFirstname(), user.getLastname());

	   

	    //  level 2
	    UserProfile userProfile = entityManager.find(UserProfile.class, id);
	    UserProfile1 userProfile1 = new UserProfile1(userProfile.getUp_id(),userProfile.getUserid(),userProfile.getDob());


	    
	    UserwithProfile userwithProfile = new UserwithProfile(user1, userProfile1);

	    return userwithProfile	;
	}
}
