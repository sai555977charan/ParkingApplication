package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.repository.ViewSlotRepository;

@Service
public class ReleaseSlotService {
	@Autowired
	ViewSlotRepository viewSlotRepository;
	public void release(int Id,int userId,String status) {
		
		 viewSlotRepository.release(Id,userId,status);
	
		
	}

}
