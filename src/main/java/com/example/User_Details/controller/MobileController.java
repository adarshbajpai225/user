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
         Mobile mb=null;
		try {
			em = DBUtility.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(mobile);
			et.commit();
			mb=mobile;
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		} finally {
			if(em !=null && em.isOpen())
			{
				em.close();
			}
			
		}
		return mb;

	}

	@GetMapping("/get/{id}")
	public Mobile getById(@PathVariable Long id) {
		EntityManager et =null;
		Mobile result=null;
		try {
		   et = DBUtility.getEntityManager();

			result= et.find(Mobile.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
      return result;
	}

	@GetMapping("/get")
	public List<Mobile> getAll() {
		EntityManager et = DBUtility.getEntityManager();
		List<Mobile> result=null;
		TypedQuery<Mobile> q ;
		try {
		   et = DBUtility.getEntityManager();

			q= et.createQuery("SELECT t from " + Mobile.class.getSimpleName() + "t", Mobile.class);

			result= q.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;

	}

}
