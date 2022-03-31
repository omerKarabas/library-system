package com.sahabt.library.repository;

import java.util.List;
import java.util.Optional;

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

public interface CatalogRepository {

	boolean exists (BookId bookId);
	Catalog addCatalog(Catalog catalog);
	Optional<Catalog> removeCatalog(BookId bookId);
	Optional<Catalog> editCatalog(BookId bookId, Catalog catalog);
	Optional<Catalog> getInformationBook(BookId bookId);
	List<Catalog> findAllCatalogByIsbn(ISBN isbn);
	Optional<Catalog> findCatalogByBookId(BookId bookId);
	List<Catalog> findAllCatalogByAuthor(Author author);
	List<Catalog> findAllCatalogByTitle(Title title);
	List<Catalog> findAllCatalogByPublishDate(PublishDate publishDate);
	List<Catalog> findAllCatalogByPublishigHouse(PublishingHouse publishingHouse);
	List<Catalog> findAllCatalogByLanguage(Language language);
	List<Catalog> findAllCatalogByType(Type type);
	List<Catalog> findAllCatalogByTopic(Topic topic);
	List<Catalog> findAllCatalogByUseTarget(UseTarget useTarget);
	List<Catalog> findAllCatalogByPeriodical(Periodical periodical);
	List<Catalog> findAllCatalogByAvailable(Available available);
}
