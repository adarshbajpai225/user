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

import com.example.User_Details.entity.User;
import com.example.User_Details.util.DBUtility;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/post")
	public User Save(@RequestBody User user) {
		EntityManager em = DBUtility.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(user);
			et.commit();
		} catch (Exception e) {

			et.rollback();
			throw new RuntimeException(e);

		} finally {
			em.close();
		}

		return user;

	}

	@GetMapping("/get")
	public List<User> getUser() {
		try {
			EntityManager entityManager = DBUtility.getEntityManager();
			TypedQuery<User> query = entityManager.createQuery("SELECT o from " + User.class.getSimpleName() + " o",
					User.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Long id) {

		try {
			EntityManager entityManager = DBUtility.getEntityManager();

			return entityManager.find(User.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
