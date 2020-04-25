package com.fanxan.RestApi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fanxan.RestApi.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
