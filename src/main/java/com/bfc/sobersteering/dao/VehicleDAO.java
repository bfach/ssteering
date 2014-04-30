package com.bfc.sobersteering.dao;

import com.bfc.sobersteering.bean.Vehicle;

public interface VehicleDAO {

	void registerVehicle(Vehicle vehicle);
	Vehicle findVehicleByVIN(String vin);
	void deleteVehicle(Vehicle vehicle);

}
