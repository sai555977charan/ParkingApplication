package com.hcl.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.entity.UserRequest;
import com.hcl.parking.entity.ViewSlot;
import com.hcl.parking.repository.UserRequestRepository;
import com.hcl.parking.repository.ViewSlotRepository;

@Service
public class AssignSlotService {
	@Autowired
UserRequestRepository userRequestRepository;
	@Autowired
	ViewSlotRepository viewSlotRepository;
	public List<UserRequest> getall() {
		return userRequestRepository.findAll();
		
	}
public List<ViewSlot> getall(String status){
	return viewSlotRepository.findByParkingSlotStatus(status);
}
public void assign(int userId,String status,int slotId) {
	viewSlotRepository.assign(userId,status,slotId);
}

}
