package com.sahabt.catalog.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sahabt.catalog.dto.request.CatalogRequest;
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

	public Catalog addCatalog(CatalogRequest request) {
		var catalog = modelMapper.map(request, Catalog.class);
		var addCatalog = catalogApplication.addCatalog(catalog)
				.orElseThrow(() -> new IllegalArgumentException("Already exisiting catalog."));
		return modelMapper.map(addCatalog, Catalog.class);
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
	public Catalog findCatalogByBookId(BookId bookId) {
		
		var getCatalog = catalogApplication.findCatalogByBookId(bookId);
		return   modelMapper.map(getCatalog, Catalog.class);
				
		
	}

	public List<Catalog> findAllCatalogByIsbn(ISBN isbn) {
		return   catalogApplication.findAllCatalogByIsbn(isbn)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	public List<Catalog> findAllCatalogByAuthor(Author author) {
		return   catalogApplication.findAllCatalogByAuthor(author)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	public List<Catalog> findAllCatalogByTitle(Title title) {
		return   catalogApplication.findAllCatalogByTitle(title)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	public List<Catalog> findAllCatalogByPublishDate(PublishDate publishDate) {
		return   catalogApplication.findAllCatalogByPublishDate(publishDate)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	public List<Catalog> findAllCatalogByPublishigHouse(PublishingHouse publishingHouseName) {
		
		return   catalogApplication.findAllCatalogByPublishigHouse(publishingHouseName)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	public List<Catalog> findAllCatalogByLanguage(Language language) {
		
		return   catalogApplication.findAllCatalogByLanguage(language)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	public List<Catalog> findAllCatalogByType(Type type) {
		
		return  catalogApplication.findAllCatalogByType(type)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	public List<Catalog> findAllCatalogByTopic(Topic topic) {
		
		return   catalogApplication.findAllCatalogByTopic(topic)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	public List<Catalog> findAllCatalogByUseTarget(UseTarget useTarget) {
		
		return   catalogApplication.findAllCatalogByUseTarget(useTarget)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	public List<Catalog> findAllCatalogByPeriodical(Periodical periodical) {
		return   catalogApplication.findAllCatalogByPeriodical(periodical)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	public List<Catalog> findAllCatalogByAvailable(Available available) {
		
		return   catalogApplication.findAllCatalogByAvailable(available)
				.stream()
				.map(cat -> modelMapper.map(cat, Catalog.class))
				.toList();
	    
	}	
}
