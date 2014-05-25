package com.bfc.sobersteering.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StopInfoPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4504476014118099201L;
	@Column(name="long_coordinate")
	private long longCord;
	@Column(name="lat_coordinate")
	private long latCord;
	public long getLongCord() {
		return longCord;
	}
	public void setLongCord(long longCord) {
		this.longCord = longCord;
	}
	public long getLatCord() {
		return latCord;
	}
	public void setLatCord(long latCord) {
		this.latCord = latCord;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (latCord ^ (latCord >>> 32));
		result = prime * result + (int) (longCord ^ (longCord >>> 32));
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
		StopInfoPK other = (StopInfoPK) obj;
		if (latCord != other.latCord)
			return false;
		if (longCord != other.longCord)
			return false;
		return true;
	}
	
	
}
