package com.bfc.sobersteering.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="routes")
public class RouteInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="route_info_id")
	private int routeInfoId;

	
	public int getRouteInfoId() {
		return routeInfoId;
	}

	public void setRouteInfoId(int routeInfoId) {
		this.routeInfoId = routeInfoId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Timestamp getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Timestamp completionTime) {
		this.completionTime = completionTime;
	}

	public Set<StopInfo> getStops() {
		return stops;
	}

	@OneToMany(mappedBy="routeInfo", cascade = CascadeType.ALL)
	private Set<StopInfo> stops = new HashSet<StopInfo>();

	@Column(name="route_name")
	private String routeName;
	
	@Column(name="completion_time")
	private Timestamp completionTime;
	
	
	public void setStops(Set<StopInfo> stops){
		this.stops = stops;
	}
}
