package com.sahabt.catalog.controller;

import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sahabt.catalog.dto.response.CatalogResponse;
import com.sahabt.catalog.service.CatalogService;
import com.sahabt.library.domain.catalog.Available;
import com.sahabt.library.domain.catalog.Catalog;
import com.sahabt.library.domain.catalog.Language;
import com.sahabt.library.domain.catalog.Periodical;
import com.sahabt.library.domain.catalog.PublishDate;
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
	public CatalogResponse findBookByBookId(int bookId) {
		return catalogService.findBookByBookId(bookId);
	}
	
	@GetMapping 
	public CatalogResponse findBookByIsbn(String isbn) {
		return catalogService.findBookByIsbn(isbn);
	}
	
	@GetMapping
	public CatalogResponse findBookByAuthor(String firstName, String lastName) {
		return catalogService.findBookByAuthor(firstName, lastName);
	}
	
	@GetMapping
	public CatalogResponse findBookByTitle(String title) {
		return catalogService.findBookByTitle(title);
	}
	
	@GetMapping
	public CatalogResponse findBookByPublishDate(PublishDate publishDate) {
		return catalogService.findBookByPublishDate(publishDate);
	}
	
	@GetMapping
	public CatalogResponse findBookByPublishigHouse(String publishingHouseName) {
		return catalogService.findBookByPublishigHouse(publishingHouseName);
	}
	
	@GetMapping
	public CatalogResponse findBookByLanguage(Language language) {
		return catalogService.findBookByLanguage(language);
	}
	
	@GetMapping
	public CatalogResponse findBookByType(Type type) {
		return catalogService.findBookByType(type);
	}
	
	@GetMapping
	public CatalogResponse findBookByTopic(Topic topic) {
		return catalogService.findBookByTopic(topic);
	}
	
	@GetMapping
	public CatalogResponse findBookByUseTarget(UseTarget useTarget) {
		return catalogService.findBookByUseTarget(useTarget);
	}
	
	@GetMapping
	public CatalogResponse findBookByPeriodical(Periodical periodical) {
		return catalogService.findBookByPeriodical(periodical);
	}
	
	@GetMapping
	public CatalogResponse findBookByAvailable(Available available) {
		return catalogService.findBookByAvailable(available);
	}
}
