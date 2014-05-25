package com.bfc.sobersteering.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bfc.sobersteering.bean.Vehicle;
import com.bfc.sobersteering.bean.VehicleReport;

@Repository
public class VehicleReportDAOImpl implements VehicleReportDAO{

	@PersistenceContext private EntityManager em;


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void logReport(VehicleReport report) {
		final Timestamp create_ts = new Timestamp(System.currentTimeMillis());
		report.setCreate_ts(create_ts );
		em.persist(report);
		em.flush();
		
	}
	
	public List<VehicleReport> retrieveReports(String vin, Timestamp startTs, Timestamp endTs){
		List<VehicleReport> result = null;
		try {
			TypedQuery<VehicleReport> query = em.createQuery("select vr from VehicleReport vr where ((vr.log_ts >= ? and vr.log_ts <= ?) OR (vr.create_ts >= ? and vr.create_ts <= ?))", VehicleReport.class);
//			TypedQuery<VehicleReport> query = em.createQuery("select vr from VehicleReport vr where vr.vin = ? and ((vr.log_ts >= ? and vr.log_ts <= ?) OR (vr.create_ts >= ? and vr.create_ts <= ?))", VehicleReport.class);
			//query.setParameter(1, vin);
			query.setParameter(1, startTs);
			query.setParameter(2, endTs);
			query.setParameter(3, startTs);
			query.setParameter(4, endTs);
			result = query.getResultList();
		} catch (NoResultException e) {
		// no role found with the given role name
		}
		return result;
	}
}
