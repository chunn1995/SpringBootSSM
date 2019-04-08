package org.boot.cnn.controller;

import org.boot.cnn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	public void login() {
		
	}
	
}
