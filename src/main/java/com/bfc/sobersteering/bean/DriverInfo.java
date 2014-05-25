package com.bfc.sobersteering.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="driver_info")
public class DriverInfo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="driver_info_id")
	private int driverInfoId;

	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", driverType=" + driverType + ", startDate="
				+ startDate + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229255472917151841L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	

	@Column(name = "driver_type")
	private String driverType;
	
	@Column(name = "start_date")
	private Long startDate;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDriverType() {
		return driverType;
	}

	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}