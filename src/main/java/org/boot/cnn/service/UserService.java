package org.boot.cnn.service;

import java.util.List;

import org.boot.cnn.po.User;

import com.github.pagehelper.PageInfo;

public interface UserService {
	
	int insert(User user);
	
	void deleteUserById(int id);
	
	void updateUser(User user);

	List<User> selectUsers();
	
	User selectUserById(int id);
	
	// 使用pagehelper
	PageInfo<User> findAllUsers(int pageNum,int pageSize);
}
