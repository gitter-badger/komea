package org.komea.microservices.events.database.model;

import org.komea.event.model.beans.AbstractEvent;

public class ValueEvent extends AbstractEvent {

	private Double	value;

	public ValueEvent() {
		super();

	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(final Double _value) {
		this.value = _value;
	}

	@Override
	public String toString() {
		return "ValueEvent [value=" + this.value + "]";
	}

}