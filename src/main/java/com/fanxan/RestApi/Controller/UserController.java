package com.fanxan.RestApi.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fanxan.RestApi.Model.AppUser;
import com.fanxan.RestApi.Model.User;
import com.fanxan.RestApi.Service.AppUserService;
import com.fanxan.RestApi.Service.UserService;

@RestController
public class UserController {

	@Autowired
	AppUserService appUserService;
	
	@PostMapping("/user")
	public ResponseEntity post(@RequestBody AppUser appUser) {
//		UserService userService;
		try {
			UserService userService = new UserService();
			Integer r = userService.insertNewUser(appUser);
			return new ResponseEntity(r,HttpStatus.CREATED);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/user/org")
	public ResponseEntity postOr(@RequestBody User appUser) {
//		UserService userService;
		return new ResponseEntity(appUserService.save(appUser),HttpStatus.CREATED);
		
	}
}

