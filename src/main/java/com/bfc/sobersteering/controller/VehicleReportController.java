package com.bfc.sobersteering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfc.sobersteering.bean.VehicleReport;
import com.bfc.sobersteering.dao.VehicleReportDAO;

@Controller
public class VehicleReportController {
	@Autowired
	private VehicleReportDAO dao;

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
	
}
