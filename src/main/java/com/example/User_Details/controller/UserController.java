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
		EntityManager em = null;
		EntityTransaction et = null;
		User u1=null;

		try {
			em = DBUtility.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(user);
			et.commit();
			u1=user;
		} catch (Exception e) {

			et.rollback();
			throw new RuntimeException(e);

		} finally {
			if(em !=null && em.isOpen())
			{
				em.close();
			}	
		}

		return u1;

	}

	@GetMapping("/get")
	public List<User> getUser() {
		EntityManager entityManager = null;
		List<User> u1=null;
		try {
			entityManager = DBUtility.getEntityManager();
			TypedQuery<User> query = entityManager.createQuery("SELECT o from " + User.class.getSimpleName() + " o",
					User.class);
			u1= query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        return u1;
	}

	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Long id) {
         User u1=null;
		try {
			EntityManager entityManager = DBUtility.getEntityManager();

			u1= entityManager.find(User.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return u1;

	}

}
