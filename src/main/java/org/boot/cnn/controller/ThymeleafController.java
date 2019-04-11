package org.boot.cnn.controller;

import java.util.List;

import org.boot.cnn.po.User;
import org.boot.cnn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/findUser")
	public String findUser(Model model) {
		User user = userService.selectUserById(1);
		model.addAttribute("u", user);
		List<User> userList = userService.selectUsers();
		model.addAttribute("ul", userList);
		return "users";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(User user) {
		userService.insert(user);
		return "redirect:../thymeleaf/findUser";
	}
	
	
}
