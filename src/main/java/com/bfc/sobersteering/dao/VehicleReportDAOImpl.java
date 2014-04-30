package com.bfc.sobersteering.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bfc.sobersteering.bean.VehicleReport;

@Repository
public class VehicleReportDAOImpl implements VehicleReportDAO{

	@Autowired
    private SessionFactory sessionFactory;
 

	@Override
	public void logReport(VehicleReport report) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		final Timestamp create_ts = new Timestamp(System.currentTimeMillis());
		report.setCreate_ts(create_ts );
		
		try {
			transaction = session.beginTransaction();
			session.merge(report);
	        
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			
		} finally{
			session.close();
		}
		
	}
	
	public List<VehicleReport> retrieveReports(Timestamp startTs, Timestamp endTs){
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from VehicleReport as vr where vr.log_ts >= startTs and vr.log_ts <= endTs");
			@SuppressWarnings("unchecked")
			List<VehicleReport> reportList = (List<VehicleReport>)query.list();
			return reportList;
	    } catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return null;
	}
}
