package com.hcl.parking.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.parking.entity.UserRegistration;
import com.hcl.parking.entity.UserRequest;
import com.hcl.parking.entity.ViewSlot;
import com.hcl.parking.service.AssignSlotService;
import com.hcl.parking.service.CronJobService;
import com.hcl.parking.service.ReleaseSlotService;
import com.hcl.parking.service.UserLoginService;
import com.hcl.parking.service.UserRegistrationService;
import com.hcl.parking.service.UserRequestService;
import com.hcl.parking.service.ViewSlotService;
@EnableScheduling
@RestController
@RequestMapping("/parking")
public class ParkingApplicationController {
	@Autowired 
	UserRegistrationService userRegistrationService ;
	@PostMapping("/parking")
	public ResponseEntity<String> userRegistration(@RequestBody UserRegistration userRegistration) {
		userRegistrationService.register(userRegistration);
		return new ResponseEntity<String>("User ADDED succesfully",HttpStatus.OK);
	}
	@Autowired 
	UserLoginService userLoginService ;
	@Autowired
	ViewSlotService viewSlotService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UserRegistration userRegistration)
	{
	UserRegistration user=	userLoginService.login(userRegistration);
	List<ViewSlot> viewSlot=viewSlotService.getall();

	if(user.getUserName().equals(userRegistration.getUserName())&&user.getUserPassword().equals(userRegistration.getUserPassword())){
		
		
		return new ResponseEntity<>(viewSlot,HttpStatus.OK);
	}
	else
		return new ResponseEntity<>("USERiD OR PAASSWORD MAY BE WRONG",HttpStatus.OK);
	}
	@Autowired
	ReleaseSlotService releaseSlotService;

	
@PostMapping("/deleteSlot/{userId}")
public ResponseEntity delete(@PathVariable int userId) {
	String status="available";
	int id=0;
	releaseSlotService.release(id,userId,status);

	return new ResponseEntity<>("slotreleased SUCCESFUULY",HttpStatus.OK);
}
	@Autowired
	AssignSlotService assignSlotService;
	@Autowired
	UserRequestService 	userRequestService;
	

@PostMapping("/assignslot")
	public ResponseEntity<String> assign() {

		int userId = 0;
		int slotId = 0;
		List<UserRequest> userRequests = assignSlotService.getall();
		Set<UserRequest> userRequest=new HashSet<UserRequest>(userRequests);
		final String STATUS_AVAILABLE = "available";
		final String STATUS_BOOKED = "booked";
		for (UserRequest userRequest1 : userRequest) {
			userId = userRequest1.getUserId();

			if (userId != 0) {
				List<ViewSlot> viewSlots = assignSlotService.getall(STATUS_AVAILABLE);
				Set<ViewSlot> viewSlot=new HashSet<ViewSlot> (viewSlots);
				for (ViewSlot viewslot1 : viewSlot) {
					slotId = viewslot1.getSlotId();
				}

				assignSlotService.assign(userId, STATUS_BOOKED, slotId);
				userRequestService.delete(userId);

			}

		}
		return new ResponseEntity<String>("Assigned  Slots  SUCCESFUULY", HttpStatus.OK);
	}
@Autowired
CronJobService cronJobService;
	@Scheduled(fixedRate = 120000)
	public ResponseEntity<String> revert(){
		System.out.println("cronjob started");
		int userId=0;
	final String STATUS_REVERT="available";
		LocalDateTime date1=LocalDateTime.now();
		DateTimeFormatter dtf=	DateTimeFormatter.ofPattern("dd-MM-yyyy");
String date=dtf.format(date1);
	cronJobService.update(userId,STATUS_REVERT,date);
	
		System.out.println("cron job ended");
		return new ResponseEntity<String>("cron job implemented success",HttpStatus.OK);
	}

}

