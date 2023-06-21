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

import com.example.User_Details.entity.Mobile;
import com.example.User_Details.util.DBUtility;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@PostMapping("/post")
	public Mobile save(@RequestBody Mobile mobile) {
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = DBUtility.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(mobile);

			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		return mobile;

	}

	@GetMapping("/get/{id}")
	public Mobile getById(@PathVariable Long id) {
		try {
			EntityManager et = DBUtility.getEntityManager();

			return et.find(Mobile.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@GetMapping("/get")
	public List<Mobile> getAll() {
		try {
			EntityManager et = DBUtility.getEntityManager();

			TypedQuery<Mobile> q = et.createQuery("SELECT t from " + Mobile.class.getSimpleName() + "t", Mobile.class);

			return q.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
