package com.example.User_Details.controller;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.User_Details.entity.User;

class UserControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	void getProductById() {
		User result;
		UserController ctrl;
		ctrl = new UserController();
		result = ctrl.getUserById(1L);
		Assert.isTrue(null != result);
	}
}
