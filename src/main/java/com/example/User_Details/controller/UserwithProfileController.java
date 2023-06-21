package com.example.User_Details.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.User_Details.entity.User;
import com.example.User_Details.util.DBUtility;

@RestController
public class UserwithProfileController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/alluser/{state}/{city}")
	public List<User> getUserWithProfile(@PathVariable("state") String state, @PathVariable("city") String city) {

		EntityManager entityManager = DBUtility.getEntityManager();

		TypedQuery<User> query;
		if ((state==null || state.equalsIgnoreCase("null")) && (city==null)|| city.equalsIgnoreCase("null")) {
			
			query = entityManager.createQuery("SELECT u FROM User u JOIN Address a ON u.id = a.userid ", User.class);
		

		} else if (state!= null && (city == null || city.equalsIgnoreCase("null"))) {
			query = entityManager.createQuery("SELECT u FROM User u JOIN Address a ON u.id = a.userid WHERE a.state =:state ", User.class);
			query.setParameter("state", state);
			
		} else {
			query = entityManager.createQuery("SELECT u FROM User u JOIN Address a ON u.id = a.userid WHERE a.state =:state AND a.city =:city",User.class);
			query.setParameter("state",state); 
			query.setParameter("city",city);

		}
		List<User> userList = query.getResultList();

		return userList;
	}

}
