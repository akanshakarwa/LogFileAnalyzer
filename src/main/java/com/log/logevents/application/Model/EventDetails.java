package com.log.logevents.application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Akansha Karwa
 *
 */
@Entity
public class EventDetails {
	
	@Id
	private String eventId;
	
	private long duration;
	
	@Column(nullable = true)
	private String host;
	
	@Column(nullable = true)
	private String type;
	
	private boolean alert;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}
	
	
	

}
