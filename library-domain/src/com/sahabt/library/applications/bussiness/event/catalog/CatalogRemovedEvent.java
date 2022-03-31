package com.sahabt.library.applications.bussiness.event.catalog;

import com.sahabt.library.domain.catalog.Catalog;

public class CatalogRemovedEvent extends CatalogEvent {

	public CatalogRemovedEvent(Catalog catalog) {
		super(catalog);
	}	
}
