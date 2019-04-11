package org.boot.cnn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.boot.cnn.po.User;
import org.boot.cnn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller/**自动返回json格式数据**/
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	public List<User> userList() {
		List<User> userList = userService.selectUsers();
		return userList;
	}

	@PostMapping("")
	public ResponseEntity addUser(
			@RequestParam(value = "loginName", required = true) String loginName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "age", required = false) int age,
			@RequestParam(value = "birthday", required = false) String birthday,
			@RequestParam(value = "address", required = false) String address
			) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setName(name);
		int sexNum = 0;
		if ("女".equals(sex)) {
			sexNum = 1;
		}
		user.setSex(sexNum);
		user.setAge(age);
		try {
			user.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("日期转换错误");
		}
		user.setAddress(address);
		userService.insert(user);
		return ResponseEntity.ok("添加成功");
	}

	@DeleteMapping("")
	public ResponseEntity deleteUser(@RequestParam(value = "id", required = true) int id) {
		userService.deleteUserById(id);
		return ResponseEntity.ok("删除成功");
	}

	@PutMapping("")
	public ResponseEntity updateUser(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "loginName", required = true) String loginName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "age", required = false) int age,
			@RequestParam(value = "birthday", required = false) String birthday,
			@RequestParam(value = "address", required = false) String address
			) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user =  userService.selectUserById(id);
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setName(name);
		int sexNum = 0;
		if ("女".equals(sex)) {
			sexNum = 1;
		}
		user.setSex(sexNum);
		user.setAge(age);
		try {
			user.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("日期转换错误");
		}
		user.setAddress(address);
		userService.updateUser(user);
		return ResponseEntity.ok("更新成功");
	}

	@GetMapping("")
	public ResponseEntity getUsers() {
		return ResponseEntity.ok(userService.selectUsers());
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public int addUser(User user) {
		return userService.insert(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/all")
	public Object findAllUsers(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return userService.findAllUsers(pageNum, pageSize);
	}
}
