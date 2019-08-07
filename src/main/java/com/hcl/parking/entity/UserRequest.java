package com.hcl.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userrequest")
public class UserRequest {

	@Id
	@Column(name="user_id")
	
	private int userId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_count")
	private int userCount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

}
