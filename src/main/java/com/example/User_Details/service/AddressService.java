package com.example.User_Details.service;

import java.util.List;

import com.example.User_Details.entity.Address;

public interface  AddressService {
	
	public void add(Address address);
	
	public List<Address> getAll();
	
	public Address get(Long id);

}
