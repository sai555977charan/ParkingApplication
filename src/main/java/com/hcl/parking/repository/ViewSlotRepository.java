package com.hcl.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.parking.entity.ViewSlot;

public interface  ViewSlotRepository extends JpaRepository<ViewSlot,String>{
	List<ViewSlot> findByParkingIdAndParkingSlotStatus(int parkingId,String parkingStatus);
/*	@Transactional
	@Modifying
	@Query("update ViewSlot e set e.UserId=:userid,e.parkingSlotStatus=:slotstatus where e.slotId=:slotid and e.parkingSlotDate=:slotdate")
	void update(@Param("userid") int userId, @Param("slotid") int slotId,@Param("slotdate") String parkingSlotDate,@Param("slotstatus") String parkingSlotStatus);*/

	@Transactional
	@Modifying
	@Query("update ViewSlot e set e.UserId=:id,e.parkingSlotStatus=:slotstatus where e.UserId=:userid")
	void release(@Param("id") int Id,@Param("userid") int userId,@Param("slotstatus") String parkingSlotStatus);
	
	@Transactional
	@Modifying
	@Query("update ViewSlot e set e.UserId=:userid,e.parkingSlotStatus=:slotstatus, e.parkingSlotDate=:date")
	void revert(@Param("userid") int userId,@Param("slotstatus") String parkingSlotStatus,@Param("date") String Date);

List<ViewSlot> findByParkingSlotStatus(String parkingSlotStatus);
@Transactional
@Modifying
@Query("update ViewSlot e set e.UserId=:userid,e.parkingSlotStatus=:slotstatus where e.slotId=:slotid")
void assign(@Param("userid") int userId,@Param("slotstatus") String parkingSlotStatus,@Param("slotid") int SlotId);
}
