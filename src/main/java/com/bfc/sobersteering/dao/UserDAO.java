package com.bfc.sobersteering.dao;

import com.bfc.sobersteering.bean.User;

public interface UserDAO {

	void saveUser(User user);
	User findUserByName(String userName);
	void deleteUser(User user);
	int retrieveUserId(String username);
}
