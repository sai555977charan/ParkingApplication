package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.parking.entity.UserRequest;

public interface  UserRequestRepository  extends JpaRepository<UserRequest,String>{
	@Transactional
	@Modifying
void deleteByUserId(int userId);

}
