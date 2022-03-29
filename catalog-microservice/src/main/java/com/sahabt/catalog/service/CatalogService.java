package com.sahabt.catalog.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sahabt.catalog.dto.request.AddCatalogRequest;
import com.sahabt.catalog.dto.response.CatalogResponse;
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

@Service
public class CatalogService {

	private CatalogApplication catalogApplication;
	private ModelMapper modelMapper;

	private CatalogService(CatalogApplication catalogApplication, ModelMapper modelMapper) {
		this.catalogApplication = catalogApplication;
		this.modelMapper = modelMapper;
	}

	public CatalogResponse addCatalog(AddCatalogRequest request) {
		var catalog = modelMapper.map(request, Catalog.class);
		var addCatalog = catalogApplication.addCatalog(catalog)
				.orElseThrow(() -> new IllegalArgumentException("Already exisiting catalog."));
		return modelMapper.map(addCatalog, CatalogResponse.class);
	}

	public CatalogResponse removeCatalog(int bookId) {
		var removeCatalog = catalogApplication.removeCatalog(BookId.of(bookId))
				.orElseThrow(() -> new IllegalArgumentException("Book does not exist."));
		return modelMapper.map(removeCatalog, CatalogResponse.class);
	}

	public CatalogResponse editCatalog(int bookId, Catalog catalog) {
		var editCatalog = catalogApplication.editCatalog(BookId.of(bookId),catalog)
				.orElseThrow(() -> new IllegalArgumentException("Book didn't update"));
		return modelMapper.map(editCatalog, CatalogResponse.class);
	}
	public CatalogResponse getInformationBook(int bookId) {

		var getCatalog = catalogApplication.getInformationBook(BookId.of(bookId))
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with book id"));
		return modelMapper.map(getCatalog, CatalogResponse.class);
	}

	public CatalogResponse findBookByIsbn(String isbn) {
		var getCatalogForIsbn = catalogApplication.findBookByIsbn(ISBN.of(isbn))
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this isbn"));
		return modelMapper.map(getCatalogForIsbn, CatalogResponse.class);
	}

	public CatalogResponse findBookByAuthor(String firstName, String lastName) {
		var getCatalogForAuthor = catalogApplication.findBookByAuthor(Author.of(firstName, lastName))
				.orElseThrow(() -> new IllegalArgumentException("There isn't book for  this author name"));
		return modelMapper.map(getCatalogForAuthor, CatalogResponse.class);
	}

	public CatalogResponse findBookByTitle(String title) {
		var getCatalogForTittle = catalogApplication.findBookByTitle(Title.of(title))
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this title"));
		return modelMapper.map(getCatalogForTittle, CatalogResponse.class);
	}

	public CatalogResponse findBookByPublishDate(PublishDate publishDate) {
		var getCatalogForPublishDate = catalogApplication.findBookByPublishDate(publishDate)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this publishDate"));
		return modelMapper.map(getCatalogForPublishDate, CatalogResponse.class);
	}

	public CatalogResponse findBookByPublishigHouse(String publishingHouseName) {
		
		var getCatalogForPublishinghouse = catalogApplication.findBookByPublishigHouse(PublishingHouse.of(publishingHouseName))
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this publishing house"));
		return modelMapper.map(getCatalogForPublishinghouse, CatalogResponse.class);
	}
	
	public CatalogResponse findBookByLanguage(Language language) {
		
		var getCatalogForLanguage = catalogApplication.findBookByLanguage(language)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this language"));
		return modelMapper.map(getCatalogForLanguage, CatalogResponse.class);
	}

	public CatalogResponse findBookByType(Type type) {
		
		var getCatalogForType = catalogApplication.findBookByType(type)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this type"));
		return modelMapper.map(getCatalogForType, CatalogResponse.class);
	}
	
	public CatalogResponse findBookByTopic(Topic topic) {
		
		var getCatalogForTopic = catalogApplication.findBookByTopic(topic)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this type"));
		return modelMapper.map(getCatalogForTopic, CatalogResponse.class);
	}
	
	public CatalogResponse findBookByUseTarget(UseTarget useTarget) {
		
		var getCatalogForUseTarget = catalogApplication.findBookByUseTarget(useTarget)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this use target"));
		return modelMapper.map(getCatalogForUseTarget, CatalogResponse.class);
	}
	
	public CatalogResponse findBookByPeriodical(Periodical periodical) {
		
		var getCatalogForPeriodical = catalogApplication.findBookByPeriodical(periodical)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this periodical"));
		return modelMapper.map(getCatalogForPeriodical, CatalogResponse.class);
	}
	
	public CatalogResponse findBookByAvailable(Available available) {
		
		var getCatalogForPeriodical = catalogApplication.findBookByAvailable(available)
				.orElseThrow(() -> new IllegalArgumentException("There isn't book with this periodical"));
		return modelMapper.map(getCatalogForPeriodical, CatalogResponse.class);
	}
	
	
}
