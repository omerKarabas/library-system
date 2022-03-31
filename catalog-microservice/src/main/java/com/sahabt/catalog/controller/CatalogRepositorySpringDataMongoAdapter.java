package com.sahabt.catalog.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.sahabt.catalog.document.CatalogDocument;
import com.sahabt.catalog.repository.CatalogDocumentRepository;
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
import com.sahabt.library.repository.CatalogRepository;

public class CatalogRepositorySpringDataMongoAdapter implements CatalogRepository{

	private CatalogDocumentRepository catalogDocumentRepository;
	private ModelMapper modelMapper;
	
	public CatalogRepositorySpringDataMongoAdapter(CatalogDocumentRepository catalogDocumentRepository,
			ModelMapper modelMapper) {
		super();
		this.catalogDocumentRepository = catalogDocumentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean exists(BookId bookId) {
		return catalogDocumentRepository.exists(bookId);
		
	}

	@Override
	public Catalog addCatalog(Catalog catalog) {
		var document = modelMapper.map(catalog,CatalogDocument.class);
		var newCatalogDocument= catalogDocumentRepository.save(document);
		return modelMapper.map(newCatalogDocument,Catalog.class);
	}

	@Override
	public Optional<Catalog> removeCatalog(BookId bookId) {
		var catalogDocument = catalogDocumentRepository.findBookByBookId(bookId);
		var document = catalogDocument.getClass(); 
		catalogDocumentRepository.delete(catalogDocument);
		return Optional.of(modelMapper.map(document, Catalog.class));
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
		//var document = catalogDocumentRepository.findBookByIsbn(isbn.getValue());
		//if(document.is)
		return null;
	}

	@Override
	public Optional<Catalog> findBookByBookId(BookId bookId) {
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
		var catalogDocument= catalogDocumentRepository.findBookByTopic(topic);
		return Optional.of(modelMapper.map(catalogDocument, Catalog.class));
	}

	@Override
	public Optional<Catalog> findBookByUseTarget(UseTarget useTarget) {
		var catalogDocument = catalogDocumentRepository.findBookByUseTarget(useTarget);
		return Optional.of(modelMapper.map(catalogDocument, Catalog.class));
	}

	@Override
	public Optional<Catalog> findBookByPeriodical(Periodical periodical) {
		var catalogDocument = catalogDocumentRepository.findBookByPeriodical(periodical);
		return Optional.of(modelMapper.map(catalogDocument, Catalog.class));
	}

	@Override
	public Optional<Catalog> findBookByAvailable(Available available) {
		var catalogDocument = catalogDocumentRepository.findBookByAvailable(available);
		return Optional.of(modelMapper.map(catalogDocument, Catalog.class));
	}

	
	
	
}
