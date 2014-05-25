package com.bfc.sobersteering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfc.sobersteering.bean.RouteInfo;
import com.bfc.sobersteering.dao.RouteInfoDAO;

@Controller
public class RouteController {

	@Autowired
	private RouteInfoDAO routeInfoDAO;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/routes/{routeName}", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateRoute(@PathVariable String routeName, @RequestBody RouteInfo route) {
		RouteInfo routeInfo = routeInfoDAO.retrieveRouteInfo(routeName);
		
		if(routeInfo == null){
			routeInfoDAO.updateRouteInfo(route);
		}else{
			//diff route info and update db with new object
			RouteInfo newRouteInfo = update(routeInfo, route);
			//If route already exists by the name
			routeInfoDAO.updateRouteInfo(newRouteInfo);
		}
		routeInfo = routeInfoDAO.retrieveRouteInfo(routeName);
		//user exists?
		return routeInfo == null ? false : true;
	}


	private RouteInfo update(RouteInfo old, RouteInfo routeInfo) {
		if(!old.getStops().equals(routeInfo.getStops())){
			old.setStops(routeInfo.getStops());
		}
		return old;
	}
	
}
