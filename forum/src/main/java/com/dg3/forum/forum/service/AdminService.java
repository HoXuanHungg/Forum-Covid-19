package com.dg3.forum.forum.service;

import java.util.List;

import com.dg3.forum.forum.entity.Users;

public interface AdminService {
	// insert a User have role Manager/Dealer
	public boolean insertUser(Users users);

	// check exist id of users
	public boolean existById(Long id);



	// insert a User have role Manager/Dealer through dto
	public int insertUserManagerOrDealer(Users users);

	// block account users
	public void blockAccount(Long user_pk);
	
	//delete account 
	void deleteAccount(Long id);
	
	//disable account when expire contract
	void disableAccountExpireContract();
	
	//get all account expire today
	List<Users> getAllAccoutExpiretoday();
}
