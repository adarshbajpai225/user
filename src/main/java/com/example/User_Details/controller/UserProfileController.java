package com.example.User_Details.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.util.DBUtility;

@RestController
@RequestMapping("/up")
public class UserProfileController {

	@PostMapping("/post")
	public UserProfile post(@RequestBody UserProfile userProfile) {
		EntityManager entityManager = null;
		EntityTransaction et = null;
		UserProfile up=null;
		
		
		try {
			entityManager = DBUtility.getEntityManager();
			et = entityManager.getTransaction();
			et.begin();
			entityManager.persist(userProfile);
			et.commit();
			up=userProfile;
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		} finally {
			if(entityManager !=null && entityManager.isOpen())
			{
				entityManager.close();
			}
		
		}

		return up;
	}

	@GetMapping("/get")
	public List<UserProfile> getAll() {
		EntityManager em=null;
		List<UserProfile> result=null;
		TypedQuery<UserProfile> q;
		try {
		   em = DBUtility.getEntityManager();
			q = em.createQuery("SELECT t from " + UserProfile.class.getSimpleName() + " t",UserProfile.class);
			result= q.getResultList();
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@GetMapping("/get/{id}")
	public UserProfile getById(@PathVariable Long id) {
		EntityManager em=null;
		UserProfile up=null;
		try {
		    em = DBUtility.getEntityManager();
			up= em.find(UserProfile.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return up;
	}

}
