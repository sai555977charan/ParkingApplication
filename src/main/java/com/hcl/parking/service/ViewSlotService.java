package com.hcl.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.entity.ViewSlot;
import com.hcl.parking.repository.ViewSlotRepository;

@Service
public class ViewSlotService {
	@Autowired
	ViewSlotRepository viewSlotRepository;
	public List<ViewSlot> getall(){
		return viewSlotRepository.findAll();
	}
	

}
