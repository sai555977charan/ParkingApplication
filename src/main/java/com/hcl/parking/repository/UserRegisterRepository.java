package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.UserRegistration;

@Repository
public interface  UserRegisterRepository extends JpaRepository<UserRegistration,String>{
	
UserRegistration findByUserNameAndUserPassword(String userName,String userPassword);
}
