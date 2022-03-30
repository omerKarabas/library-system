package com.sahabt.library.applications.bussiness.event.catalog;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.sahabt.library.domain.catalog.Catalog;

public class CatalogEvent {
	
	private static AtomicLong counter = new AtomicLong();
	private final String eventId;
	private final long orderId;
	private final ZonedDateTime dateTime;
	private final Catalog catalog;
	
	public CatalogEvent(Catalog catalog) {
		eventId = UUID.randomUUID().toString();
		dateTime = ZonedDateTime.now();
		orderId = counter.getAndIncrement();
		this.catalog = catalog;
	}
	
	public String getEventId() {
		return eventId;
	}

	public long getOrderId() {
		return orderId;
	}

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	public Catalog getCatalog() {
		return catalog;
	}
	
	
	

	
	
	
}
