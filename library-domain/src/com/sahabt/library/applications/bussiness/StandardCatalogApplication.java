package com.sahabt.library.applications.bussiness;

import java.util.Optional;

import com.sahabt.library.applications.CatalogApplication;
import com.sahabt.library.applications.bussiness.event.catalog.CatalogAddEvent;
import com.sahabt.library.applications.bussiness.event.catalog.CatalogEvent;
import com.sahabt.library.applications.bussiness.event.catalog.CatalogRemovedEvent;
import com.sahabt.library.domain.catalog.Author;
import com.sahabt.library.domain.catalog.Available;
import com.sahabt.library.domain.catalog.BookId;
import com.sahabt.library.domain.catalog.Catalog;
import com.sahabt.library.domain.catalog.Cover;
import com.sahabt.library.domain.catalog.ISBN;
import com.sahabt.library.domain.catalog.Language;
import com.sahabt.library.domain.catalog.NumberOfPages;
import com.sahabt.library.domain.catalog.Periodical;
import com.sahabt.library.domain.catalog.PublishDate;
import com.sahabt.library.domain.catalog.PublishingHouse;
import com.sahabt.library.domain.catalog.Title;
import com.sahabt.library.domain.catalog.Topic;
import com.sahabt.library.domain.catalog.Type;
import com.sahabt.library.domain.catalog.UseTarget;
import com.sahabt.library.infra.EventPublisher;
import com.sahabt.library.repository.CatalogRepository;

public class StandardCatalogApplication implements CatalogApplication {

	private CatalogRepository  catalogRepository;
	private EventPublisher  eventPublisher;
	
	
	public StandardCatalogApplication(CatalogRepository catalogRepository, 
									   EventPublisher eventPublisher) {
		this.catalogRepository = catalogRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Optional<Catalog> addCatalog(Catalog catalog) {
		var book = catalog.getBookId();
		if(catalogRepository.exists(book))
			return Optional.empty();
		//eventPublisher.catalogAddEvent(new CatalogAddEvent(book));
		return null; // Optional.of(catalogRepository.addCatalog(catalog));
	}

	@Override
	public Optional<Catalog> removeCatalog(BookId bookId) {
		Optional<Catalog> removeCatalog = catalogRepository.removeCatalog(bookId);
		
		removeCatalog.ifPresent(cat -> 
						eventPublisher.catalogPublish(new CatalogRemovedEvent(cat)));
		return removeCatalog;
	}

	@Override
	public Optional<Catalog> editCatalog(BookId bookId, Catalog catalog) {
		var bookForUpdate = catalogRepository.findBookByBookId(bookId);
			bookForUpdate.stream().forEach(
					updatedBook -> {
						updatedBook.setBookId(catalog.getBookId());
						updatedBook.setCover(catalog.getCover());
						updatedBook.setIsbn(catalog.getIsbn());
						updatedBook.setAuthor(catalog.getAuthor());
						updatedBook.setTitle(catalog.getTitle());
						updatedBook.setNumberOfPages(catalog.getNumberOfPages());
						updatedBook.setPublishDate(catalog.getPublishDate());
						updatedBook.setPublishingHouse(catalog.getPublishingHouse());	
						updatedBook.setLanguage(catalog.getLanguage());
						updatedBook.setType(catalog.getType());
						updatedBook.setTopic(catalog.getTopic());
						updatedBook.setUseTarget(catalog.getUseTarget());
						updatedBook.setPeriodical(catalog.getPeriodical());
						updatedBook.setAvailable(catalog.getAvailable());
					});
		
		return bookForUpdate;
	}

	@Override
	public Optional<Catalog> getInformationBook(BookId bookId) {
		return catalogRepository.getInformationBook(bookId);
	}

	@Override
	public Optional<Catalog> findBookByIsbn(ISBN isbn) {
		return catalogRepository.findBookByIsbn(isbn);
	}

	@Override
	public Optional<Catalog> findBookByAuthor(Author author) {
		return  catalogRepository.findBookByAuthor(author);
	}

	@Override
	public Optional<Catalog> findBookByTitle(Title title) {
		return  catalogRepository.findBookByTitle(title);
	}

	@Override
	public Optional<Catalog> findBookByPublishDate(PublishDate publishDate) {
		return  catalogRepository.findBookByPublishDate(publishDate);
	}

	@Override
	public Optional<Catalog> findBookByPublishigHouse(PublishingHouse publishingHouse) {
		return catalogRepository.findBookByPublishigHouse(publishingHouse);
	}

	@Override
	public Optional<Catalog> findBookByLanguage(Language language) {
		return catalogRepository.findBookByLanguage(language);
	}

	@Override
	public Optional<Catalog> findBookByType(Type type) {
		return catalogRepository.findBookByType(type);
		
	}

	@Override
	public Optional<Catalog> findBookByTopic(Topic topic) {
		return catalogRepository.findBookByTopic(topic);
	}

	@Override
	public Optional<Catalog> findBookByUseTarget(UseTarget useTarget) {
		return catalogRepository.findBookByUseTarget(useTarget);
	}

	@Override
	public Optional<Catalog> findBookByPeriodical(Periodical periodical) {
		return catalogRepository.findBookByPeriodical(periodical);
	}

	@Override
	public Optional<Catalog> findBookByAvailable(Available available) {
		return catalogRepository.findBookByAvailable(available);
	}

	@Override
	public Optional<Catalog> findBookByBookId(BookId bookId) {
	
		return catalogRepository.findBookByBookId(bookId);
	}

	

	

}
