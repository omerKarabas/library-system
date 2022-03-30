package com.sahabt.library.applications.bussiness.event.catalog;

import com.sahabt.library.domain.catalog.BookId;
import com.sahabt.library.domain.catalog.Catalog;

public class CatalogAddEvent extends CatalogEvent{
	private final BookId bookId;

	public CatalogAddEvent(Catalog catalog, BookId bookId) {
		super(catalog);
		this.bookId = bookId;
	}

	public BookId getBookId() {
		return bookId;
	}
		
}
