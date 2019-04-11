package org.boot.cnn.service.impl;

import java.util.List;

import org.boot.cnn.dao.UserMapper;
import org.boot.cnn.po.User;
import org.boot.cnn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	public int insert(User user) {
		return userMapper.insert(user);
	}
	
	public void deleteUserById(int id) {
		userMapper.deleteUser(id);
	}
	
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public List<User> selectUsers(){
		return userMapper.findAllUser();
	}
	
	public User selectUserById(int id) {
		return userMapper.findUserById(id);
	}
	
	/*
	    * 这个方法中用到了配置依赖的分页插件pagehelper
	    * 只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
	    * pageNum 开始页数
	    * pageSize 每页显示的数据条数
	    * */
	public PageInfo<User> findAllUsers(int pageNum,int pageSize){
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.findAllUser();
		PageInfo result = new PageInfo(users);
		return result;
	}
	
	
}
