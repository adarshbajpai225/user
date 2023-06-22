package com.example.User_Details.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Address result=null;

		try {
			em = DBUtility.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(address);
			et.commit();
			result=address;
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		} finally {
			if(em !=null && em.isOpen())
			{
				em.close();
			}
			
		}

		return result;
	}

	@GetMapping("/get/{id}")
	public Address get(@PathVariable Long id) {
		EntityManager et = null;
		Address result=null;
		
		try {
		    et = DBUtility.getEntityManager();

			result =et.find(Address.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        return result;
	}

	@GetMapping("/get")
	public List<Address> getAll() {
		EntityManager entityManager = null;
		List<Address> list=null;
		TypedQuery<Address> query;
		try {
		  entityManager = DBUtility.getEntityManager();
		   query = entityManager.createQuery("SELECT t from " + Address.class.getSimpleName() + " t", Address.class);

			list= query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable Long id) {
	    EntityManager entityManager = null;
	    EntityTransaction entityTransaction=null;

	    try {
	        entityManager = DBUtility.getEntityManager();
	         entityTransaction= entityManager.getTransaction();
	         entityTransaction.begin();
	        
	        Address address = entityManager.find(Address.class, id);
	        entityManager.remove(address);
	      entityTransaction.commit();
	        
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } finally {
	    	
	        if (entityManager != null && entityManager.isOpen()) {
	            entityManager.close();
	        }
	    }
	}
	
	
	 
	
	@PutMapping("/update/{id}")
      public void update(@PathVariable Long id,@RequestBody Address newaddress)
	{
    	  EntityManager entityManager =null;
    	  EntityTransaction entityTransaction =null;
    	   try {
    	  
    		  entityManager=DBUtility.getEntityManager();
    		  
    		  entityTransaction=entityManager.getTransaction();
    		  entityTransaction.begin();
    		  Address address=entityManager.find(Address.class,id);
    		 
    			  if(address !=null)
    			  {
    				address.setCity(newaddress.getCity());
    				address.setHouseno(newaddress.getHouseno());
    			    entityManager.merge(address);
    			    entityTransaction.commit();
    			  }
    		 
    		  
    	   
           } catch (IllegalArgumentException e) {
              
               System.out.println( e.getMessage());
               
           } catch (RuntimeException e) {
             
               System.out.println("A RuntimeException occurred: " + e.getMessage());
           } catch (Exception e) {
              
               System.out.println("An unexpected exception occurred: " + e.getMessage());
           }
    	  finally {
    		  entityManager.close();
    	  }
      }
	

}
