package com.bfc.sobersteering.dao;

import com.bfc.sobersteering.bean.Account;

public interface AccountDAO {

	
	public void updateUserAccount(Account account);
	
	public Account getUserAccount(String username);
	
	public void deleteUserAccount(String username);
}
