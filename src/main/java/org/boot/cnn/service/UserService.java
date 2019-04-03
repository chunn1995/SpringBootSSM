package org.boot.cnn.service;

import java.util.List;

import org.boot.cnn.po.User;

public interface UserService {
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUser();
}
