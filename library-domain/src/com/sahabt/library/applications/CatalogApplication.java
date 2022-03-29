package com.sahabt.library.applications;

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

public interface CatalogApplication {

	Optional<Catalog> addCatalog(Catalog catalog);
	Optional<Catalog> removeCatalog(BookId bookId);
	Optional<Catalog> editCatalog(BookId bookId, Catalog catalog);
	Optional<Catalog> getInformationBook(BookId bookId);
	Optional<Catalog> findBookByIsbn(ISBN isbn);
	Optional<Catalog> findBookByAuthor(Author author);
	Optional<Catalog> findBookByTitle(Title title);
	Optional<Catalog> findBookByPublishDate(PublishDate publishDate);
	Optional<Catalog> findBookByPublishigHouse(PublishingHouse publishingHouse);
	Optional<Catalog> findBookByLanguage(Language language);
	Optional<Catalog> findBookByType(Type type);
	Optional<Catalog> findBookByTopic(Topic topic);
	Optional<Catalog> findBookByUseTarget(UseTarget useTarget);
	Optional<Catalog> findBookByPeriodical(Periodical periodical);
	Optional<Catalog> findBookByAvailable(Available available);
}
