package com.bfc.sobersteering.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bfc.sobersteering.bean.RouteInfo;
import com.bfc.sobersteering.bean.Vehicle;

@Repository
public class RouteInfoDAOImpl implements RouteInfoDAO{
	@PersistenceContext private EntityManager em;

	@Override
	public void updateRouteInfo(RouteInfo route) {
//		em.persist(route);
		em.merge(route);
		em.flush();
	}

	@Override
	public RouteInfo retrieveRouteInfo(String routeName) {
		RouteInfo result = null;
		try {
			TypedQuery<RouteInfo> query = em.createQuery("select ri from RouteInfo ri where ri.routeName = ?", RouteInfo.class);
			query.setParameter(1, routeName);
			result = query.getSingleResult();
		} catch (NoResultException e) {
			// no role found with the given role name
		}
		return result;
	}

}
