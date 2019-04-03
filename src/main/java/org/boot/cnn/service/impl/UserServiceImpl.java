package org.boot.cnn.service.impl;

import java.util.List;

import org.boot.cnn.dao.UserMapper;
import org.boot.cnn.po.User;
import org.boot.cnn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	public List<User> findAllUser(){
		List<User> userList = userMapper.findAll();
		return userList;
	}
	
}
