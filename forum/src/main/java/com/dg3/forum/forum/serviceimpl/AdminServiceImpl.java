package com.dg3.forum.forum.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.repository.AdminRepository;
import com.dg3.forum.forum.repository.UserstRepository;
import com.dg3.forum.forum.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	UserstRepository userstRepository;
	@Autowired
	AdminRepository adminRepository;

	/**
	 * Insert User with role is Manager or Dealer(not through dto)
	 * 
	 * @param Users
	 * @return true or false
	 */
	public boolean insertUser(Users users) {
		if (Objects.isNull(userstRepository.save(users))) {
			return false;
		}
		;
		return true;
	}

	
	/**
	 * find id Users exist
	 * @param id
	 * @return true or false
	 */
	@Override
	public boolean existById(Long id) {
		return userstRepository.existsById(id);
	}


	/*
	 * insert account have role User or manager
	 */
	/**
	 * Insert User with role is Manager or Dealer( through dto)
	 * 
	 * @param Users
	 * @return 0 or 1
	 */
	@Override
	public int insertUserManagerOrDealer(Users users) {
		if (Objects.isNull(adminRepository.insertUserManagerOrDealer(users.getEmail(), users.getPassword(),
				users.getUsername(), users.getRole(), users.getPhone_number(), users.getAddress(),
				users.getDate_of_birth(), users.getImg_avatar(), users.getDescription(), users.getExpire()))) {
			return 0;
		}
		;
		return 1;
	}

	/**
	 * block account
	 * 
	 * @param User_pk
	 * @return account blocked
	 */
	@Override
	public void blockAccount(Long User_pk) {
		adminRepository.blockUser(User_pk);

	}
	/**
	 * delete account
	 * 
	 * @param User_pk
	 * @return account deleted
	 */
	@Override
	public void deleteAccount(Long id) {
		adminRepository.deleteAccount(id);

	}

	/**
	 * disable account when expire contract
	 * 
	 * @param 
	 * @return enable_users= false
	 */
	@Override
	public void disableAccountExpireContract() {

		adminRepository.disableAccountExpireContract();

	}
	/**
	 * get All Account Expire today
	 * 
	 * @param 
	 * @return list account Expire today
	 */
	@Override
	public List<Users> getAllAccoutExpiretoday() {
		return adminRepository.getAllAccoutExpiretoday();
	}

}