package com.example.User_Details.dao;

import java.util.List;

import com.example.User_Details.entity.Mobile;

public interface MobileDao {

	void save(Mobile mobile);

	Mobile getById(Long id);

	List<Mobile> getAll();

}
