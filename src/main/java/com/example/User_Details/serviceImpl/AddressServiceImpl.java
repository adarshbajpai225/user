package com.example.User_Details.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Details.dao.AddressDao;
import com.example.User_Details.entity.Address;
import com.example.User_Details.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public void add(Address address) {
		addressDao.add(address);
		
	}

	@Override
	public List<Address> getAll() {
		
		return addressDao.getAll();
	}

	@Override
	public Address get(Long id) {
		
		return addressDao.get(id);
	}
	
	

}
