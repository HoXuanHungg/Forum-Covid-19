package com.dg3.forum.forum.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dg3.forum.forum.entity.Medicine;
import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.util.DateCurrent;

@Repository
public interface AdminRepository extends JpaRepository<Users, Long> {
	/**
	 * Insert User have role is Dealer or Manager
	 * @param insert information user through dto Request is String title_thread, String
	 * content_of_thread, Long post_topic_pk, boolean enable_post_thread, Long
	 * thread_pk 
	 * @return Information inserted
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into Users (email, password, username, role, phone_number, address, date_of_birth, ban_account, img_avatar, description, created_date, expire, enable_users)"
			+ " values (:email, :password, :username, :role, :phone_number, :address, :date_of_birth, 'false', :img_avatar, :description, CURRENT_DATE, :expire, 'true')", nativeQuery = true)
	int insertUserManagerOrDealer(@Param("email") String email, @Param("password") String password,
			@Param("username") String username, @Param("role") String role, @Param("phone_number") String phone_number,
			@Param("address") String address, @Param("date_of_birth") Date date_of_birth,
			@Param("img_avatar") String img_avatar, @Param("description") String description,
			@Param("expire") Date expire);


	/**
	 * block users 
	 * @param user_pk
	 * @return account user have field enable_users= false
	 */
	@Modifying
	@Transactional
	@Query("update Users u set u.enable_users = false where u.user_pk = :user_pk")
	void blockUser(@Param("user_pk") Long user_pk);

	/**
	 * delete account
	 * 
	 * @param user_pk
	 * @return Response account deleted
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from users where user_pk = :user_pk", nativeQuery = true)
	void deleteAccount(@Param("user_pk") Long user_pk);

	/**
	 * disable account when expire contract
	 * @param 
	 * @return enable_user=false
	 */
	@Modifying
	@Transactional
	@Query(value = "update users set enable_users = false where expire = CURRENT_DATE", nativeQuery = true)
	void disableAccountExpireContract();

	/**
	 * get all account expire today
	 * @return list User expire contract
	 */
	@Query(value = "select * from users  where expire = CURRENT_DATE", nativeQuery = true)
	List<Users> getAllAccoutExpiretoday();
}
