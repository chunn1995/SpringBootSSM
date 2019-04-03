package org.boot.cnn.controller;

import java.util.List;

import org.boot.cnn.po.User;
import org.boot.cnn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController/**自动返回json格式数据**/
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("userList")
	public List<User> userList(){
		List<User> userList = userService.findAllUser();
		return userList;
	}
	
}
