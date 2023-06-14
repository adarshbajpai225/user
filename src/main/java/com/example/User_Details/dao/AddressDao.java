package com.example.User_Details.dao;

import java.util.List;

import com.example.User_Details.entity.Address;

public interface AddressDao {
	
	public void add(Address address);
	
	public Address get(Long id);
	
	public List<Address> getAll();

}
