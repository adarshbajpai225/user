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

import com.example.User_Details.entity.Address;
import com.example.User_Details.util.DBUtility;

@RestController
@RequestMapping("/address")
public class AddressController {

	@PostMapping("/post")
	public Address add(@RequestBody Address address) {
		EntityManager em = null;

		EntityTransaction et = null;

		try {
			em = DBUtility.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(address);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}

		return address;
	}

	@GetMapping("/get/{id}")
	public Address get(@PathVariable Long id) {
		try {
			EntityManager et = DBUtility.getEntityManager();

			return et.find(Address.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@GetMapping("/get")
	public List<Address> getAll() {
		try {
			EntityManager entityManager = DBUtility.getEntityManager();
			TypedQuery<Address> query = entityManager
					.createQuery("SELECT t from " + Address.class.getSimpleName() + " t", Address.class);

			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
