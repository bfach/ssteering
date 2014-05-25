package com.bfc.sobersteering.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="stop_info")
public class StopInfo {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="stop_info_id")
//	private int stopInfoId;

	@EmbeddedId
	private StopInfoPK location;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((routeInfo == null) ? 0 : routeInfo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StopInfo other = (StopInfo) obj;
		if (active != other.active)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (routeInfo == null) {
			if (other.routeInfo != null)
				return false;
		} else if (!routeInfo.equals(other.routeInfo))
			return false;
		return true;
	}
	public StopInfoPK getLocation() {
		return location;
	}
	public void setLocation(StopInfoPK location) {
		this.location = location;
	}
	@Column(name="stop_active", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public RouteInfo getRouteInfo() {
		return routeInfo;
	}
	public void setRouteInfo(RouteInfo routeInfo) {
		this.routeInfo = routeInfo;
	}
	//bi-direction relationship with route stop is associated with
	@ManyToOne
	@JoinColumn(name="route_info_id", insertable = false, updatable = false)
	private RouteInfo routeInfo;
	
	
}
