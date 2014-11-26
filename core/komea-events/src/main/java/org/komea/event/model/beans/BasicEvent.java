package org.komea.event.model.beans;

import java.io.Serializable;
import java.util.Date;

import org.komea.event.model.api.IBasicEvent;

public class BasicEvent implements Serializable, IBasicEvent {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_evt_storage.provider
	 *
	 * @mbggenerated Sun Nov 16 12:30:58 CET 2014
	 */

	private String provider;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_evt_storage.eventKey
	 *
	 * @mbggenerated Sun Nov 16 12:30:58 CET 2014
	 */

	private String eventType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_evt_storage.date
	 *
	 * @mbggenerated Sun Nov 16 12:30:58 CET 2014
	 */

	private Date date;

	public BasicEvent() {
		super();
		this.date = new Date();
	}

	public BasicEvent(final String _provider, final String _eventType) {
		super();
		this.provider = _provider;
		this.eventType = _eventType;
		this.date = new Date();
	}

	public BasicEvent(final String _provider, final String _eventType,
			final Date _date) {
		super();
		this.provider = _provider;
		this.eventType = _eventType;
		this.date = _date;
	}

	@Override
	public final Date getDate() {
		return this.date;
	}

	@Override
	public final String getEventType() {
		return this.eventType;
	}

	@Override
	public final String getProvider() {
		return this.provider;
	}

	public final void setDate(final Date date) {
		this.date = date;
	}

	public final void setEventKey(final String eventKey) {
		this.eventType = eventKey;
	}

	public void setEventType(final String _eventType) {
		this.eventType = _eventType;
	}

	public final void setProvider(final String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "BasicEvent [provider=" + this.provider + ", eventType="
				+ this.eventType + ", date=" + this.date + "]";
	}

}