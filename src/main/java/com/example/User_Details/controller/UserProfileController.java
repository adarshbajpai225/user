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
		try {
			entityManager = DBUtility.getEntityManager();
			et = entityManager.getTransaction();
			et.begin();
			entityManager.persist(userProfile);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException(e);
		} finally {
			entityManager.close();
		}

		return userProfile;
	}

	@GetMapping("/get")
	public List<UserProfile> getAll() {
		try {
			EntityManager em = DBUtility.getEntityManager();
			TypedQuery<UserProfile> q = em.createQuery("SELECT t from " + UserProfile.class.getSimpleName() + " t",
					UserProfile.class);
			return q.getResultList();
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/get/{id}")
	public UserProfile getById(@PathVariable Long id) {

		try {
			EntityManager em = DBUtility.getEntityManager();
			return em.find(UserProfile.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
