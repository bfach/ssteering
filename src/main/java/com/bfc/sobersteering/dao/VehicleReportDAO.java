package com.bfc.sobersteering.dao;

import java.sql.Timestamp;
import java.util.List;

import com.bfc.sobersteering.bean.VehicleReport;

public interface VehicleReportDAO {
	void logReport(VehicleReport report);
	List<VehicleReport> retrieveReports(String vin, Timestamp startTs, Timestamp endTs);
}
