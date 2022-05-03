package com.dg3.forum.forum.repository;

import com.dg3.forum.forum.entity.Comment;
import com.dg3.forum.forum.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository

public interface UserstRepository extends JpaRepository<Users, Long> {
	/**
	 * Get user information by username
	 * @param username
	 * @return
	 */
	Users getByUsername(String username);

	/**
	 * Find user information by username
	 * @param username
	 * @return
	 */
	List<Users> findByUsername(String username);

	/**
	 * Check number phone
	 * @param phone_number
	 * @return
	 */
	@Query("SELECT u from Users u where u.phone_number = :phone_number")
	List<Users> existByPhone_number(String phone_number);

	/**
	 * Check email exist
	 * @param email
	 * @return
	 */
	@Query("SELECT u from Users u where u.email = :email")
	List<Users> existByEmail(String email);
	/**
	 * find email in db
	 * @param email
	 * @return
	 */
	@Query("SELECT u from Users u where u.email = :email")
	Users findByEmail(String email);

	/**
	 * insert users role dealer / manager
	 * @param users
	 * @return User have role dealer/manager
	 */
	Optional<Users> save(Optional<Users> users);
	/**
	 * update information users
	 * @param user_pk
	 */
	@Modifying
	@Transactional
	@Query("update Users u set u.email = :email,u.password = :password,u.username = :username,u.address = :address,u.img_avatar = :img_avatar,u.description = :description  where u.user_pk = :user_pk")
	void updateInformationUser(@Param("description") String description
			,@Param("email") String email
			,@Param("password") String password
			,@Param("username") String username
			,@Param("address") String address
			,@Param("img_avatar") String img_avatar,@Param("user_pk") Long user_pk);
	
/**
 * Get user name according to id
 * @param user_pk
 * @return user name
 */
	@Query(value = "SELECT users.username"
			+ "	FROM users"
			+ "	WHERE user_pk = :user_pk", nativeQuery = true)
	String  getUsername(@Param("user_pk") Long user_pk);
	

		    
}
