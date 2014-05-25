package com.bfc.sobersteering.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bfc.sobersteering.bean.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO{
	@PersistenceContext private EntityManager em;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerVehicle(Vehicle vehicle) {
		em.persist(vehicle);
		em.flush();
	}

	public Vehicle findVehicleByVIN(String vin) {
		Vehicle result = null;
		try {
			TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v where v.vin = ?", Vehicle.class);
			query.setParameter(1, vin);
			result = query.getSingleResult();
		} catch (NoResultException e) {
		// no role found with the given role name
		}
		return result;
    }
 
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteVehicle(Vehicle vehicle) {
		try {
			Query query = em.createQuery("delete from Vehicle v where v.vin = ?");
			query.setParameter(1, vehicle.getVin());
			query.executeUpdate();
		} catch (NoResultException e) {
		// no role found with the given role name
		}
	
	}
}
