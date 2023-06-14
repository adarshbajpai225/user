package com.example.User_Details.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Details.dao.MobileDao;
import com.example.User_Details.entity.Mobile;
import com.example.User_Details.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {
	
	@Autowired
	private MobileDao mobileDao;

	@Override
	public void save(Mobile mobile) {
		mobileDao.save(mobile);
		
	}

	@Override
	public Mobile getById(Long id) {
		
		return mobileDao.getById(id);
	}

	@Override
	public List<Mobile> getAll() {
		
		return mobileDao.getAll();
	}

}
