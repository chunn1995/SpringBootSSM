package org.boot.cnn.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.boot.cnn.po.User;

@Mapper
public interface UserMapper {

	List<User> findAll();

	User findUserById(int id);

	User findUserByName(String name);
	
	int insertUserInMapper(User user);
	
	boolean deleteUser(int id);

	@Select("SELECT * FROM T_USER WHERE LOGINNAME = #{loginName}")
	User findUserByLoginName(String loginName);
	
	@Insert("INSERT INTO T_USER(LOGINNAME,PASSWORD,NAME,AGE,SEX,BIRTHDAY,ADDRESS) VALUES(#{loginName},#{password},#{name},#{age},#{sex},#{birthday},#{address})")
	int insertUser(@Param("loginName") String loginName, @Param("password") String password, @Param("name") String name,
			@Param("age") int age, @Param("sex") String sex, @Param("birthday") Date birthday,
			@Param("address") String address);
}