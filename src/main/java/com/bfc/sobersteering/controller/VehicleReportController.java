package com.bfc.sobersteering.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfc.sobersteering.bean.Vehicle;
import com.bfc.sobersteering.bean.VehicleReport;
import com.bfc.sobersteering.dao.VehicleDAO;
import com.bfc.sobersteering.dao.VehicleReportDAO;

@Controller
public class VehicleReportController {
	@Autowired
	private VehicleDAO vDao;
	
	@Autowired
	private VehicleReportDAO dao;
	private static final Logger LOG = LoggerFactory.getLogger(VehicleReportController.class);


	@RequestMapping(value = "/vehicles/{vin}/report", method = RequestMethod.POST)
	@ResponseBody
	public String vehicleReport(@PathVariable String vin, @RequestBody VehicleReport report) {
		
		try {
			dao.logReport(report);
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		
		return "Vehicle Report " + report.toString() +" added";
	}
	
	@RequestMapping(value = "/vehicles/{vin}/report", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleReport> retrieveVehicleReport(@PathVariable String vin, @RequestParam(value = "startTs") long startTs, 
			@RequestParam(value = "endTs") long endTs) {
		try {
			Vehicle vehicle = vDao.findVehicleByVIN(vin);
			
			return dao.retrieveReports(vin, new Timestamp(startTs), new Timestamp(endTs));
		} catch (Exception e) {
			LOG.error("Failure to lookup vehicle reports for vin " + vin);
			return null;
		}
	}
}
