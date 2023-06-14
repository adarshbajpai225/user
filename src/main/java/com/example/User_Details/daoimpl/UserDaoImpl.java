package com.example.User_Details.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.User_Details.dao.UserDao;
import com.example.User_Details.entity.User;
import com.example.User_Details.util.DBUtility;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName = "userdetails")
	private EntityManager entityManager;

	@Override
	public User getUserById(Long id) {
		EntityManager entityManager = DBUtility.getEntityManager();

		return entityManager.find(User.class, id);

	}

	@Override
	public List<User> getUser() {
		EntityManager entityManager = DBUtility.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT o from " + User.class.getSimpleName() + " o",
				User.class);
		return query.getResultList();

		
	}

	@Override
	public void save(User user) {
		EntityManager entityManager = DBUtility.getEntityManager();
	     entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

}
