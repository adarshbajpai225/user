package com.example.User_Details.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.User_Details.dao.AddressDao;
import com.example.User_Details.entity.Address;
import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.util.DBUtility;
import com.mysql.cj.Query;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(Address address) {
	     EntityManager et=DBUtility.getEntityManager();
	     et.getTransaction().begin();
	     et.persist(address);
	     et.getTransaction().commit();
	     
		
		
	}

	@Override
	public Address get(Long ad_id) {
		
		EntityManager et=DBUtility.getEntityManager();
		
		return et.find(Address.class, ad_id);	
		
	}

	@Override
	public List<Address> getAll() {
		
		EntityManager entityManager=DBUtility.getEntityManager();
		  TypedQuery<Address> query = entityManager.createQuery("SELECT t from "+ Address.class.getSimpleName() +" t",Address.class);
		
		  return query.getResultList();
	}

}
