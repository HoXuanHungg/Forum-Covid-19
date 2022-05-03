package com.dg3.forum.forum.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.repository.UserstRepository;
import com.dg3.forum.forum.service.UserService;
import com.dg3.forum.forum.util.UserDetailsImpl;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserstRepository userRepository;


    /**
     * get show all users
     *
     * @return List Users
     */
    @Override
    public List<Users> listAll() {
        return userRepository.findAll();

    }

    /**
     * get all account users request id response whole information of 1 account
     *
     * @param id
     * @return Users have id enter
     */
    @Override
    public Users getUsers(Long id) {
        return userRepository.getById(id);
    }

    /**
     * check exist account  user
     *
     * @param id
     * @return true or false
     */
    @Override
    public boolean existById(Long id) {
        return userRepository.existsById(id);

    }

    /**
     * Find by id
     *
     * @param user_pk
     * @return object Users
     */
    @Override
    public Optional<Users> findById(Long user_pk) {
        return userRepository.findById(user_pk);
    }


    /**
     * Find by name user
     *
     * @param username
     * @return List User have User name enter
     */
    public List<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * insert Users
     *
     * @param users
     * @return information user inserted
     */
    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    /**
     * Check number phone
     *
     * @param phone_number
     * @return List User have number phone  enter
     */
    @Override
    public List<Users> checkPhone_number(String phone_number) {
        return userRepository.existByPhone_number(phone_number);
    }

    /**
     * check email
     *
     * @param email
     * @return List User have email enter
     */
    @Override
    public List<Users> checkEmail(String email) {
        return userRepository.existByEmail(email);
    }

    /**
     * Find email
     *
     * @param email
     * @return Users have email enter
     */
    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * delete user
     *
     * @param id
     * @return delete user
     */
    @Override
    public void deleteAccount(Long id) {
        userRepository.deleteById(id);

    }

    /**
     * get show all users
     *
     * @return list all users
     */
    public List<Users> findAll() {
        return userRepository.findAll();
    }

//	public User findById(int id) {
//		for (User user : listUser) {
//			if (user.getId() == id) {
//				return user;
//			}
//		}
//		return null;
//	}

//	public boolean add(User user) {
//		for (User userExist : listUser) {
//			if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
//				return false;
//			}
//		}
//		listUser.add(user);
//		return true;
//	}

//	public void delete(int id) {
//		listUser.removeIf(user -> user.getId() == id);
//	}

    /**
     * @param username
     * @return
     */
    public Users loadUserByUsername(String username) {

        for (Users user : userRepository.findAll()) {
            if (user.getEmail().equals(username)) {
                UserDetailsImpl.build(user);
                return user;
            }
        }
        return null;
    }

    /**
     * check account when login
     *
     * @param user
     * @return true or false
     */
    public boolean checkLogin(Users user) {

        for (Users userExist : userRepository.findAll()) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                    && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * update Information User
     *
     * @param users
     * @return Information User updated
     */
    @Override
    public void updateInformationUser(Users users) {
        userRepository.updateInformationUser(users.getDescription(), users.getEmail(), users.getPassword(), users.getUsername(), users.getAddress(), users.getImg_avatar(), users.getUser_pk());

    }

    /**
     * Get user name according to id
     *
     * @param user_pk
     * @return user name
     */
    public String getUsersname(Long user_pk) {
        return userRepository.getUsername(user_pk);
    }


}
