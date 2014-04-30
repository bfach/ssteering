package com.bfc.sobersteering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfc.sobersteering.bean.Vehicle;
import com.bfc.sobersteering.dao.VehicleDAO;

@Controller
public class VehicleController {
	@Autowired
	private VehicleDAO dao;

	@RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.POST)
	@ResponseBody
	public String addVehicle(@PathVariable String vin, @RequestBody Vehicle vehicle) {
		
		try {
			dao.registerVehicle(vehicle);
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		
		return "" + vehicle.getId();
	}
	
	@RequestMapping(value = "/users/{vin}", method = RequestMethod.GET)
	@ResponseBody
	public Vehicle getVehicle(@PathVariable String vin) {
		return dao.findVehicleByVIN(vin);
	}

	@RequestMapping(value = "/users/{vin}", method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable String vin) {
		Vehicle vehicle = dao.findVehicleByVIN(vin);
		
		if(vehicle == null){
			System.err.println("Vehicle does not exist to delete, aborting ");
			return;
		}

		
		dao.deleteVehicle(vehicle);
	}
}
