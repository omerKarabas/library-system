package com.sahabt.library.applications.bussiness;

import java.util.List;
import java.util.Optional;

import com.sahabt.library.applications.CatalogApplication;
import com.sahabt.library.applications.bussiness.event.catalog.CatalogAddEvent;
import com.sahabt.library.applications.bussiness.event.catalog.CatalogRemovedEvent;
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
	public Optional<Catalog>addCatalog(Catalog catalog) {
	
		if(catalogRepository.exists(catalog.getBookId()))
			return Optional.empty();
		eventPublisher.catalogAddEvent(new CatalogAddEvent(catalog));
		return Optional.of(catalogRepository.addCatalog(catalog));
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
//		var bookForUpdate = catalogRepository.findBookByBookId(bookId);
//			bookForUpdate.stream().forEach(
//					updatedBook -> {
//						updatedBook.setBookId(catalog.getBookId());
//						updatedBook.setCover(catalog.getCover());
//						updatedBook.setIsbn(catalog.getIsbn());
//						updatedBook.setAuthor(catalog.getAuthor());
//						updatedBook.setTitle(catalog.getTitle());
//						updatedBook.setNumberOfPages(catalog.getNumberOfPages());
//						updatedBook.setPublishDate(catalog.getPublishDate());
//						updatedBook.setPublishingHouse(catalog.getPublishingHouse());	
//						updatedBook.setLanguage(catalog.getLanguage());
//						updatedBook.setType(catalog.getType());
//						updatedBook.setTopic(catalog.getTopic());
//						updatedBook.setUseTarget(catalog.getUseTarget());
//						updatedBook.setPeriodical(catalog.getPeriodical());
//						updatedBook.setAvailable(catalog.getAvailable());
//					});
//		
//		return bookForUpdate;
		return null;
	}

	@Override
	public Optional<Catalog> getInformationBook(BookId bookId) {
		return catalogRepository.getInformationBook(bookId);
	}

	@Override
	public List<Catalog> findAllCatalogByIsbn(ISBN isbn) {
		return catalogRepository.findAllCatalogByIsbn(isbn);
	}

	@Override
	public List<Catalog> findAllCatalogByAuthor(Author author) {
		return  catalogRepository.findAllCatalogByAuthor(author);
	}

	@Override
	public List<Catalog> findAllCatalogByTitle(Title title) {
		return  catalogRepository.findAllCatalogByTitle(title);
	}

	@Override
	public List<Catalog> findAllCatalogByPublishDate(PublishDate publishDate) {
		return catalogRepository.findAllCatalogByPublishDate(publishDate);
	}


	@Override
	public List<Catalog> findAllCatalogByPublishigHouse(PublishingHouse publishingHouse) {
		return  catalogRepository.findAllCatalogByPublishigHouse(publishingHouse);
	}

	@Override
	public List<Catalog> findAllCatalogByLanguage(Language language) {
		return  catalogRepository.findAllCatalogByLanguage(language);
	}

	@Override
	public List<Catalog> findAllCatalogByType(Type type) {
		return catalogRepository.findAllCatalogByType(type);
	}

	@Override
	public List<Catalog> findAllCatalogByTopic(Topic topic) {
		return catalogRepository.findAllCatalogByTopic(topic);
	}

	@Override
	public List<Catalog> findAllCatalogByUseTarget(UseTarget useTarget) {
		return catalogRepository.findAllCatalogByUseTarget(useTarget);
	}

	@Override
	public List<Catalog> findAllCatalogByPeriodical(Periodical periodical) {
		return catalogRepository.findAllCatalogByPeriodical(periodical);
	}

	@Override
	public List<Catalog> findAllCatalogByAvailable(Available available) {
		return catalogRepository.findAllCatalogByAvailable(available);
	}

	@Override
	public Optional<Catalog> findCatalogByBookId(BookId bookId) {
	
		return catalogRepository.findCatalogByBookId(bookId);
	}
}
