package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.User;

import java.util.List;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(int id);
	
	List<User> findAllUsers();

}

