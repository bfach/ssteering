package com.bfc.sobersteering.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	private static final Logger LOG = LoggerFactory.getLogger(VehicleController.class);

	@RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.POST)
	@ResponseBody
	public String addVehicle(@PathVariable String vin, @RequestBody Vehicle vehicle) {
		if(dao.findVehicleByVIN(vin) != null){
			LOG.debug("Vehicle already registered, specifying ID to update content");
			dao.registerVehicle(vehicle);
			return "Vehicle " + vehicle.getId() + " content updated";
		}
		dao.registerVehicle(vehicle);
		return "Vehicle with vin " + vin + " added";
	}
	
	@RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.GET)
	@ResponseBody()
	public Vehicle getVehicle(@PathVariable String vin) {
		return dao.findVehicleByVIN(vin);
	}

	@RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable String vin) {
		Vehicle vehicle = dao.findVehicleByVIN(vin);
		
		if(vehicle == null){
			System.err.println("Vehicle does not exist to delete, aborting ");
			return;
		}

		
		dao.deleteVehicle(vehicle);
	}
	
	@ExceptionHandler(Throwable.class)
	public void handle(@RequestBody Vehicle vehicle){
		LOG.error("Error handling request for vehicle with vin " + vehicle.getVin());
	}
}
