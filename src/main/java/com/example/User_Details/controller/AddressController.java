package com.example.User_Details.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Details.entity.Address;
import com.example.User_Details.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/post")
	public Address add(@RequestBody Address address)
	{
		addressService.add(address);
		return address;
	}
	
	@GetMapping("/get/{id}")
	public Address get(@PathVariable Long id)
	{
		return addressService.get(id);
	}
	
	@GetMapping("/get")
	public List<Address> getAll()
	{
		return addressService.getAll();
	}
	

}
