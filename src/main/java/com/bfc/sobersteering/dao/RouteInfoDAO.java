package com.bfc.sobersteering.dao;

import com.bfc.sobersteering.bean.RouteInfo;

public interface RouteInfoDAO {

	void updateRouteInfo(RouteInfo route);

	RouteInfo retrieveRouteInfo(String routeName);
}
