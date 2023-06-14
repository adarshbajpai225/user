package com.example.User_Details.service;

import java.util.List;

import com.example.User_Details.entity.Mobile;

public interface MobileService {

	

	void save(Mobile mobile);

	Mobile getById(Long id);

	List<Mobile> getAll();

	

}
