package com.hcl.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="viewslot")
public class ViewSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="slot_id")
	private int slotId;
	@Column(name="user_id")
	private int UserId;
	@Column(name="parking_id")
	private int parkingId;
	@Column(name="parking_type")
	private String parkingType;
	
	
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public String getParkingType() {
		return parkingType;
	}
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}
	public int getParkingSlotCount() {
		return parkingSlotCount;
	}
	public void setParkingSlotCount(int parkingSlotCount) {
		this.parkingSlotCount = parkingSlotCount;
	}
	public int getParkingSlotNumber() {
		return parkingSlotNumber;
	}
	public void setParkingSlotNumber(int parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}
	@Column(name="parking_slot_count")
	private int parkingSlotCount;
	@Column(name="parking_slot_status")
	private String parkingSlotStatus;
	@Column(name="parking_slot_date")
	private String parkingSlotDate;
	public String getParkingSlotStatus() {
		return parkingSlotStatus;
	}
	public void setParkingSlotStatus(String parkingSlotStatus) {
		this.parkingSlotStatus = parkingSlotStatus;
	}
	@Column(name="parking_slot_number")
	private int parkingSlotNumber;

}
