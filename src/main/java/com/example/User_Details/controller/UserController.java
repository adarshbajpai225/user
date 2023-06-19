package com.example.User_Details.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	    @PersistenceContext
	    private EntityManager entityManager;

	
	
	@PostMapping("/post")
	public User Save(@RequestBody User user)
	{
		EntityManager em = DBUtility.getEntityManager();
	    EntityTransaction et=   em.getTransaction();
	    
	    try {
	         et.begin();
	         em.persist(user);
		      et.commit();
	    }
	    catch(Exception e)
	    {  
	    	  
	          et.rollback(); 
	          String errorMessage = e.getMessage();
	         
	    }
	    finally
	    {
	    	em.close();
	    }
		
		
		return user;
		
	}

	

	
	@GetMapping("/get")
	public List<User> getUser(){
		
		EntityManager entityManager = DBUtility.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT o from " + User.class.getSimpleName() + " o",
				User.class);
		return query.getResultList();
		
		
	}
	
	
	
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Long id)
	{
		
		EntityManager entityManager = DBUtility.getEntityManager();

		return entityManager.find(User.class, id);
		
	}
	
	   

	   @GetMapping("/join")
	   public List<UserWithProfileDto> getUsersWithProfile() {
		   EntityManager entityManager=DBUtility.getEntityManager();
		   
	       String sqlQuery = "SELECT u.id, u.firstname, u.lastname, u.email, u.password, u.status, up.up_id, up.dob " +
	                         "FROM user u " +
	                         "LEFT JOIN userprofile up ON u.id = up.userid";
	       
	       Query query = entityManager.createNativeQuery(sqlQuery);
	       List<Object[]> result = query.getResultList();
	       
	       List<UserWithProfileDto> userWithProfileList = new ArrayList<>();
	       for (Object[] row : result) {
	           Integer userId = (Integer) row[0];
	           String firstname = (String) row[1];
	           String lastname = (String) row[2];
	           String email = (String) row[3];
	           String password = (String) row[4];
	           Byte status = (Byte) row[5];
	           Integer profileId = (Integer) row[6];
	           Date dob =(Date) row[7];
	          
	           
	           UserWithProfileDto userWithProfile = new UserWithProfileDto(userId, firstname, lastname, email, password, status, profileId, dob);
	           userWithProfileList.add(userWithProfile);
	       }
	       
	       return userWithProfileList;
	   }
        
	   
	// Example method to fetch level 2 data (User Address) using userId
	 
		
		
//		@GetMapping("/get")
//		public void getUser(){
//			SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		    Session session = factory.openSession();
	//
//		    String query = "SELECT * FROM user";
//		    NativeQuery<Object[]> nativeQuery = session.createNativeQuery(query);
	//
//		    List<Object[]> resultList = nativeQuery.list();
	//
//		    for (Object[] user : resultList) {
//		        System.out.println(Arrays.toString(user));
//		        System.out.println(user[0] + " : " + user[1]);
//		    }
	//
//		    session.close();
//		    factory.close();
//			
//		}
	
	
}
 