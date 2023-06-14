package com.example.User_Details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.Mobile;
import com.example.User_Details.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@PostMapping("/post")
	public Mobile save(@RequestBody Mobile mobile)
	{
		 mobileService.save(mobile);
		 return mobile;
		 
	}
	
	@GetMapping("/get/{id}")
	public Mobile getById(@PathVariable Long id)
	{
		return mobileService.getById(id);
	}
	
	@GetMapping("/get")
	public List<Mobile> getAll()
	{
		return mobileService.getAll();
	}
	

}
