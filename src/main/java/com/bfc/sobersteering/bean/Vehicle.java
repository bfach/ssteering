package com.bfc.sobersteering.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -933442164293934954L;

	//@Id
	private String vin;
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

//	@GenericGenerator(name="gen",strategy="increment")
//	@GeneratedValue(generator="gen")
//	@Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "model")
	private String model;

	@Column(name = "year")
	private String year;
	
}
