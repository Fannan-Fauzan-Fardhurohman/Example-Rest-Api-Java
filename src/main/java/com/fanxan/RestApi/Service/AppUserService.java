package com.fanxan.RestApi.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanxan.RestApi.Model.User;
import com.fanxan.RestApi.Repository.UserRepository;

@Service
@Transactional
public class AppUserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		userRepository.save(user);
		return user;
	}
}
