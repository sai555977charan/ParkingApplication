package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.repository.ViewSlotRepository;

@Service
public class CronJobService {
	@Autowired
	ViewSlotRepository viewSlotRepository;
	public void update(int userId,String status,String date) {
		
	
	viewSlotRepository.revert(userId,status,date);
	}
}
