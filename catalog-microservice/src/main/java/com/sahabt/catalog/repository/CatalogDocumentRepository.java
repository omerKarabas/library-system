package com.sahabt.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahabt.catalog.document.CatalogDocument;
import com.sahabt.catalog.dto.response.CatalogResponse;
import com.sahabt.library.domain.catalog.Author;
import com.sahabt.library.domain.catalog.Available;
import com.sahabt.library.domain.catalog.BookId;
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
    CatalogResponse findBookByIsbn(ISBN isbn);
    CatalogResponse findBookByBookId(BookId bookId);
    CatalogResponse findBookByAuthor(Author author);
    CatalogResponse findBookByTitle(Title title);
    CatalogResponse findBookByPublishDate(PublishDate publishDate);
    CatalogResponse findBookByPublishigHouse(PublishingHouse publishingHouse);
    CatalogResponse findBookByLanguage(Language language);
    CatalogResponse findBookByType(Type type);
    CatalogResponse findBookByTopic(Topic topic);
    CatalogResponse findBookByUseTarget(UseTarget useTarget);
    CatalogResponse findBookByPeriodical(Periodical periodical);
    CatalogResponse findBookByAvailable(Available available);
}
