package com.sahabt.catalog.controller;

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

public class CatalogRepositorySpringDataMongoAdapter implements CatalogRepository {

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
		var catalog = catalogDocumentRepository.findCatalogByBookId(bookId);
		catalogDocumentRepository.delete(modelMapper.map(catalog, CatalogDocument.class));
		return Optional.of(catalog);
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
	public List<Catalog> findAllCatalogByIsbn(ISBN isbn) {
		return   catalogDocumentRepository.findAllCatalogByIsbn(isbn)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public Optional<Catalog> findCatalogByBookId(BookId bookId) {
		return Optional.of(catalogDocumentRepository.findCatalogByBookId(bookId));
	}

	@Override
	public List<Catalog> findAllCatalogByAuthor(Author author) {
		return   catalogDocumentRepository.findAllCatalogByAuthor(author)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByTitle(Title title) {
		return   catalogDocumentRepository.findAllCatalogByTitle(title)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByPublishDate(PublishDate publishDate) {
		return   catalogDocumentRepository.findAllCatalogByPublishDate(publishDate)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByPublishigHouse(PublishingHouse publishingHouse) {
		return   catalogDocumentRepository.findAllCatalogByPublishigHouse(publishingHouse)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByLanguage(Language language) {
		return   catalogDocumentRepository.findAllCatalogByLanguage(language)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByType(Type type) {
		return   catalogDocumentRepository.findAllCatalogByType(type)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByTopic(Topic topic) {
		return   catalogDocumentRepository.findAllCatalogByTopic(topic)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByUseTarget(UseTarget useTarget) {
		return   catalogDocumentRepository.findAllCatalogByUseTarget(useTarget)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

	@Override
	public List<Catalog> findAllCatalogByPeriodical(Periodical periodical) {
		return   catalogDocumentRepository.findAllCatalogByPeriodical(periodical)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}
	
	@Override
	public List<Catalog> findAllCatalogByAvailable(Available available) {
		return   catalogDocumentRepository.findAllCatalogByAvailable(available)
				.stream()
				.map(cat ->modelMapper.map(cat, Catalog.class))
				.toList();
	}

}
