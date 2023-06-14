package com.example.User_Details.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.User_Details.dao.MobileDao;
import com.example.User_Details.entity.Mobile;
import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.util.DBUtility;

@Repository
public class MobileDaoImpl implements MobileDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Mobile mobile) {
		EntityManager et=DBUtility.getEntityManager();
		et.getTransaction().begin();
		et.persist(mobile);
		et.getTransaction().commit();
		
	}

	@Override
	public Mobile getById(Long m_id) {
		EntityManager et=DBUtility.getEntityManager();
			
		return et.find(Mobile.class, m_id);
	}

	@Override
	public List<Mobile> getAll() {
		EntityManager et=DBUtility.getEntityManager();
		
		TypedQuery<Mobile> q=et.createQuery("SELECT t from "+ Mobile.class.getSimpleName() +"t", Mobile.class);
		
		return q.getResultList();
		
	}
	
	
	

}
