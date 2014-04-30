package com.bfc.sobersteering.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="vehicle_reports")
public class VehicleReport implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4724902326993067432L;
	@Column(name = "driver_id")
	private int driverId;
	@Column(name = "vehicle_id")
	private int vehicleId;
	
	@Column(name = "gps_lat")
	private double gpslat;

	@Column(name = "gps_long")
	private double gpsLong;
	
	@Column(name = "log_ts")
	private Timestamp log_ts;

	@Column(name = "create_ts")
	private Timestamp create_ts;

	@Column(name = "speed")
	private int speed;
	
	@Column(name="doorOpen", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean doorOpen;
	
	@Column(name="sideSignDeployed", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean sideSignDeployed;

	@Column(name="stopLights", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean stopLights;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public boolean isSideSignDeployed() {
		return sideSignDeployed;
	}

	public void setSideSignDeployed(boolean sideSignDeployed) {
		this.sideSignDeployed = sideSignDeployed;
	}

	public boolean isStopLights() {
		return stopLights;
	}

	public void setStopLights(boolean stopLights) {
		this.stopLights = stopLights;
	}

	public double getGpslat() {
		return gpslat;
	}

	public void setGpslat(double gpslat) {
		this.gpslat = gpslat;
	}

	public double getGpsLong() {
		return gpsLong;
	}

	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Timestamp getLog_ts() {
		return log_ts;
	}

	public void setLog_ts(Timestamp log_ts) {
		this.log_ts = log_ts;
	}

	public Timestamp getCreate_ts() {
		return create_ts;
	}

	public void setCreate_ts(Timestamp create_ts) {
		this.create_ts = create_ts;
	}
	
	
	
}
