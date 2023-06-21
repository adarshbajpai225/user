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
		EntityManager entityManager = DBUtility.getEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		try {
			et.begin();
			entityManager.persist(userProfile);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			String m = e.getMessage();
		} finally {
			entityManager.close();
		}

		return userProfile;
	}

	@GetMapping("/get")
	public List<UserProfile> getAll() {
		EntityManager em = DBUtility.getEntityManager();

		TypedQuery<UserProfile> q = em.createQuery("SELECT t from " + UserProfile.class.getSimpleName() + " t",
				UserProfile.class);

		return q.getResultList();
	}

	@GetMapping("/get/{id}")
	public UserProfile getById(@PathVariable Long id) {
		EntityManager em = DBUtility.getEntityManager();

		return em.find(UserProfile.class, id);
	}

}
