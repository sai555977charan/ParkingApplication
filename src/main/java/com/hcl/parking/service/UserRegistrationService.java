package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.entity.UserRegistration;
import com.hcl.parking.repository.UserRegisterRepository;

@Service
public class UserRegistrationService {
@Autowired
UserRegisterRepository userRegisterRepository;
	public UserRegistration register(UserRegistration user)
	{
		return userRegisterRepository.save(user);
	}
}
