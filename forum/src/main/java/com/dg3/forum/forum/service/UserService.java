package com.dg3.forum.forum.service;

import java.util.List;
import java.util.Optional;

import com.dg3.forum.forum.entity.Users;

public interface UserService {
	/**
	 * get show all users
	 * 
	 * @return list all users
	 */
	List<Users> listAll();

	/**
	 * get only account user depend on id
	 * 
	 * @param id
	 * @return information Users
	 */
	Users getUsers(Long id);

	/**
	 * check exist account user
	 * 
	 * @param id
	 * @return true or false
	 */
	boolean existById(Long id);

	/**
	 * delete user
	 * 
	 * @param id
	 * @return delete user
	 */
	void deleteAccount(Long id);

	/**
	 * Find by id
	 * 
	 * @param user_pk
	 * @return object Users
	 */
	Optional<Users> findById(Long user_pk);

	/**
	 * Find by name user
	 * 
	 * @param username
	 * @return List User have User name enter
	 */
	List<Users> findByUsername(String username);

	/**
	 * insert Users
	 * 
	 * @param users
	 * @return information user inserted
	 */
	Users save(Users users);

//
	/**
	 * Check number phone
	 * 
	 * @param phone_number
	 * @return List User have number phone enter
	 */
	List<Users> checkPhone_number(String phone_number);

	/**
	 * check email
	 * 
	 * @param email
	 * @return List User have email enter
	 */
	List<Users> checkEmail(String email);

	/**
	 * Find email
	 * 
	 * @param email
	 * @return Users have email enter
	 */
	Users findByEmail(String email);

	/**
	 * update Information User
	 * 
	 * @param users
	 * @return Information User updated
	 */
	void updateInformationUser(Users users);

	
	/**
	 * Get user name according to id
	 * @param user_pk
	 * @return user name
	 */
	String getUsersname(Long user_pk);

}
