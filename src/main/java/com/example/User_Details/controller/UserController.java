package com.example.User_Details.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.User;
import com.example.User_Details.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/post")
	public User Save(@RequestBody User user)
	{
         userService.save(user);
	    return user;
	}

	
	
	
//	@GetMapping("/get")
//	public void getUser(){
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//	    Session session = factory.openSession();
//
//	    String query = "SELECT * FROM user";
//	    NativeQuery<Object[]> nativeQuery = session.createNativeQuery(query);
//
//	    List<Object[]> resultList = nativeQuery.list();
//
//	    for (Object[] user : resultList) {
//	        System.out.println(Arrays.toString(user));
//	        System.out.println(user[0] + " : " + user[1]);
//	    }
//
//	    session.close();
//	    factory.close();
//		
//	}
	
	@GetMapping("/get")
	public List<User> getUser(){
		
		return userService.getUser();
		
		
	}
	
	
	
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Long id)
	{
		
	    return userService.getUserById(id);
		
	}
	
	
	
}
 