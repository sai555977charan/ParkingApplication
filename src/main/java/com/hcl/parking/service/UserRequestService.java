package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.repository.UserRequestRepository;

@Service
public class UserRequestService {
	@Autowired
	UserRequestRepository userRequestRepository;
	public void delete(int userId) {
	userRequestRepository.deleteByUserId(userId);
	}

}
