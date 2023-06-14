package com.example.User_Details.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.User_Details.dao.UserProfileDao;
import com.example.User_Details.entity.UserProfile;
import com.example.User_Details.util.DBUtility;


@Repository
public class UserProfileDaoImpl implements UserProfileDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void post(UserProfile userProfile) {
		
		EntityManager entityManager=DBUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(userProfile);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public UserProfile getById(Long up_id) {
		
		EntityManager em=DBUtility.getEntityManager();
		
		return em.find(UserProfile.class,up_id);
		
	}

	@Override
	public List<UserProfile> getAll() {
		EntityManager em=DBUtility.getEntityManager();
		
		TypedQuery<UserProfile> q= em.createQuery("SELECT t from "+ UserProfile.class.getSimpleName() +" t", UserProfile.class);
		 
		
		return q.getResultList();
	}
	
	

}
