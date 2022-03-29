package com.sahabt.library.applications.bussiness;

import java.util.Optional;

import com.sahabt.library.applications.CatalogApplication;
import com.sahabt.library.domain.catalog.Author;
import com.sahabt.library.domain.catalog.Available;
import com.sahabt.library.domain.catalog.BookId;
import com.sahabt.library.domain.catalog.Catalog;
import com.sahabt.library.domain.catalog.ISBN;
import com.sahabt.library.domain.catalog.Language;
import com.sahabt.library.domain.catalog.Periodical;
import com.sahabt.library.domain.catalog.PublishDate;
import com.sahabt.library.domain.catalog.PublishingHouse;
import com.sahabt.library.domain.catalog.Title;
import com.sahabt.library.domain.catalog.Topic;
import com.sahabt.library.domain.catalog.Type;
import com.sahabt.library.domain.catalog.UseTarget;

public class StandardCatalogApplication implements CatalogApplication {

	@Override
	public Optional<Catalog> addCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> removeCatalog(BookId bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> editCatalog(BookId bookId, Catalog catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> getInformationBook(BookId bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByIsbn(ISBN isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByTitle(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByPublishDate(PublishDate publishDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByPublishigHouse(PublishingHouse publishingHouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByLanguage(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByTopic(Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByUseTarget(UseTarget useTarget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByPeriodical(Periodical periodical) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalog> findBookByAvailable(Available available) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
