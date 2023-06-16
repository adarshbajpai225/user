package com.example.User_Details.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private PersistenceContext persistenceContext;
	
	@PostMapping("/post")
	public Mobile save(@RequestBody Mobile mobile)
	{
		EntityManager et=DBUtility.getEntityManager();
		et.getTransaction().begin();
		et.persist(mobile);
		et.getTransaction().commit();
		return mobile;
		 
	}
	
	@GetMapping("/get/{id}")
	public Mobile getById(@PathVariable Long id)
	{
		EntityManager et=DBUtility.getEntityManager();
		
		return et.find(Mobile.class,id);
	}
	
	@GetMapping("/get")
	public List<Mobile> getAll()
	{
EntityManager et=DBUtility.getEntityManager();
		
		TypedQuery<Mobile> q=et.createQuery("SELECT t from "+ Mobile.class.getSimpleName() +"t", Mobile.class);
		
		return q.getResultList();
		
	}
	

}
