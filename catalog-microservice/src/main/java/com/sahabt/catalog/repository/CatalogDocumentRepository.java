package com.sahabt.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahabt.catalog.document.CatalogDocument;
import com.sahabt.catalog.dto.response.CatalogResponse;
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

public interface CatalogDocumentRepository extends MongoRepository<CatalogDocument,Integer> {
	
	boolean exists (BookId bookId);
	
	CatalogResponse getInformationBook(BookId bookId);
    Catalog findBookByIsbn(ISBN isbn);
    Catalog findBookByBookId(BookId bookId);
    Catalog findAllCatalogByAuthor(Author author);
    Catalog findAllCatalogByTitle(Title title);
    Catalog findAllCatalogByPublishDate(PublishDate publishDate);
    Catalog findAllCatalogByPublishigHouse(PublishingHouse publishingHouse);
    Catalog findAllCatalogByLanguage(Language language);
    Catalog findAllCatalogByType(Type type);
    Catalog findAllCatalogByTopic(Topic topic);
    Catalog findAllCatalogByUseTarget(UseTarget useTarget);
    Catalog findAllCatalogByPeriodical(Periodical periodical);
    Catalog findAllCatalogByAvailable(Available available);
}
