package com.sahabt.catalog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sahabt.catalog.dto.response.CatalogResponse;
import com.sahabt.catalog.service.CatalogService;
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

@RestController
@RequestMapping("catalog")
@RequestScope
@Validated
@CrossOrigin
public class CatalogRestController {

	private CatalogService catalogService;

	public CatalogRestController(CatalogService catalogService) {
		super();
		this.catalogService = catalogService;
	}

	@DeleteMapping("{bookId}")
	public CatalogResponse removeCatalog(int bookId) {
		return catalogService.removeCatalog(bookId);
	}

	@GetMapping
	public Catalog findCatalogByBookId(BookId bookId) {
		return catalogService.findCatalogByBookId(bookId);
	}
	
	@GetMapping 
	public List<Catalog> findAllCatalogByIsbn(ISBN isbn) {
		return catalogService.findAllCatalogByIsbn(isbn);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByAuthor(Author author) {
		return catalogService.findAllCatalogByAuthor(author);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByTitle(Title title) {
		return catalogService.findAllCatalogByTitle(title);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByPublishDate(PublishDate publishDate) {
		return catalogService.findAllCatalogByPublishDate(publishDate);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByPublishigHouse(PublishingHouse publishingHouseName) {
		return catalogService.findAllCatalogByPublishigHouse(publishingHouseName);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByLanguage(Language language) {
		return catalogService.findAllCatalogByLanguage(language);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByType(Type type) {
		return catalogService.findAllCatalogByType(type);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByTopic(Topic topic) {
		return catalogService.findAllCatalogByTopic(topic);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByUseTarget(UseTarget useTarget) {
		return catalogService.findAllCatalogByUseTarget(useTarget);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByPeriodical(Periodical periodical) {
		return catalogService.findAllCatalogByPeriodical(periodical);
	}
	
	@GetMapping
	public List<Catalog> findAllCatalogByAvailable(Available available) {
		return catalogService.findAllCatalogByAvailable(available);
	}
}
