package com.bfc.sobersteering.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bfc.sobersteering.bean.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO{
	@Autowired
    private SessionFactory sessionFactory;
 

	@Override
	public void registerVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.merge(vehicle);
	        
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			
		} finally{
			session.close();
		}
		
	}

	public Vehicle findVehicleByVIN(String vin) {
		Session session = sessionFactory.openSession();
		
        try{
        	return (Vehicle) session.get(Vehicle.class, vin);
        }finally{
        	session.close();
        }
 
    }
 
	//@Transactional(propagation = Propagation.REQUIRED)
	public void deleteVehicle(Vehicle vehicle) {
        Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(vehicle);
	        transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			
		} finally{
			session.close();
		}

	
	}
}
