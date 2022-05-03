package com.dg3.forum.forum.controller;

import javax.servlet.http.HttpServletRequest;
import com.dg3.forum.forum.serviceimpl.UserServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.serviceimpl.AdminServiceImpl;
import com.dg3.forum.forum.serviceimpl.CSVServiceImpl;
import com.dg3.forum.forum.serviceimpl.JwtServiceImpl;




@RestController
@RequestMapping("/api/v1/")
public class LoginController {
	  private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
@Autowired
AdminServiceImpl adminServiceImpl;
	
	
  @Autowired
  CSVServiceImpl fileService;
  
  @Autowired 
  JwtServiceImpl jwtServiceImpl;
  @Autowired
  UserServiceimpl userServiceimpl;
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody Users user) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (userServiceimpl.checkLogin(user)) {
				result = jwtServiceImpl.generateTokenLogin(user.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
  
  
  
