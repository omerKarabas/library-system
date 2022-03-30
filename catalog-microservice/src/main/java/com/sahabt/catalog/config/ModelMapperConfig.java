package com.sahabt.catalog.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.catalog.document.CatalogDocument;
import com.sahabt.catalog.dto.request.CatalogRequest;
import com.sahabt.catalog.dto.response.CatalogResponse;
import com.sahabt.library.domain.catalog.Catalog;

@Configuration
public class ModelMapperConfig {
	
	private static final Converter<CatalogRequest,Catalog>
	CATALOG_REQUEST_TO_CATALOG_CONVERTER = (context) ->{
		
		var request = context.getSource();
		return new Catalog.Builder()
					.bookId(request.getBookId())
					.cover(request.getCover())
					.isbn(request.getIsbn())
					.title(request.getTitle())
					.author(request.getFirstName(),request.getLastName())
					.publishDate(request.getDay(), request.getMounth(), request.getYear())
					.publishingHouse(request.getPublishingHouseName())
					.language(request.getLanguage().name())
					.type(request.getType().name())
					.topic(request.getTopic().name())
					.useTarget(request.getUseTarget().name())
					.periodical(request.getPeriodical().name())
					.available(request.getAvailable().name())
					.build();
	};
	private static final Converter<Catalog,CatalogResponse>
	CATALOG_TO_CATALOG_RESPONSE_CONVERTER =(context) ->{
		var catalog = context.getSource();
		
		var response = new CatalogResponse();
		response.setBookId(catalog.getBookId().getBookId());
		response.setCover(catalog.getCover().getCover());
		response.setIsbn(catalog.getIsbn().getIsbn());
		response.setTitle(catalog.getTitle().getTitle());
		response.setAuthor(catalog.getAuthor());
		response.setNumberOfPages(catalog.getNumberOfPages().getNumberOfPages());
		response.setPublishDate(catalog.getPublishDate());
		response.setPublishingHouseName(catalog.getPublishingHouse().getPublishingHouseName());
		response.setLanguage(catalog.getLanguage());
		response.setType(catalog.getType());
		response.setTopic(catalog.getTopic());
		response.setUseTarget(catalog.getUseTarget());
		response.setPeriodical(catalog.getPeriodical());
		response.setAvailable(catalog.getAvailable());
		return response;	
	};
	public static final Converter<Catalog,CatalogDocument>
	CATALOG_TO_CATALOG_DOCUMENT_CONVERTER =(context) ->{
		var catalog = context.getSource();
		var document = new CatalogDocument();
		document.setBookId(catalog.getBookId().getBookId());
		document.setCover(catalog.getCover().getCover());
		document.setIsbn(catalog.getIsbn().getIsbn());
		document.setTitle(catalog.getTitle().getTitle());
		document.setAuthor(catalog.getAuthor());
		document.setNumberOfPages(catalog.getNumberOfPages().getNumberOfPages());
		document.setPublishDate(catalog.getPublishDate());
		document.setPublishingHouseName(catalog.getPublishingHouse().getPublishingHouseName());
		document.setLanguage(catalog.getLanguage());
		document.setType(catalog.getType());
		document.setTopic(catalog.getTopic());
		document.setUseTarget(catalog.getUseTarget());
		document.setPeriodical(catalog.getPeriodical());
		document.setAvailable(catalog.getAvailable());
		return document;
	};
	
	public static final Converter<CatalogDocument,Catalog>
	CATALOG_DOCUMENT_TO_CATALOG_CONVERTER =(context) ->{
		var document = context.getSource();
		return new Catalog.Builder()
				.bookId(document.getBookId())
				.cover(document.getCover())
				.isbn(document.getIsbn())
				.title(document.getTitle())
				.author(document.getAuthor().getFirstName(),
						document.getAuthor().getLastName())
				.publishDate(document.getPublishDate().getDay(),
						document.getPublishDate().getMounth(),
						document.getPublishDate().getYear())
				.publishingHouse(document.getPublishingHouseName())
				.language(document.getLanguage().name())
				.type(document.getType().name())
				.topic(document.getTopic().name())
				.useTarget(document.getUseTarget().name())
				.periodical(document.getPeriodical().name())
				.available(document.getAvailable().name())
				.build();
	};
	
	@Bean
	public ModelMapper modelMapper() {
		 var modelMapper = new ModelMapper();
		 modelMapper.addConverter(CATALOG_REQUEST_TO_CATALOG_CONVERTER,
				 CatalogRequest.class,Catalog.class);
		 modelMapper.addConverter(CATALOG_TO_CATALOG_RESPONSE_CONVERTER,
				 Catalog.class, CatalogResponse.class);
		 modelMapper.addConverter(CATALOG_TO_CATALOG_DOCUMENT_CONVERTER,
				 Catalog.class, CatalogDocument.class);
		 modelMapper.addConverter(CATALOG_DOCUMENT_TO_CATALOG_CONVERTER,
				 CatalogDocument.class,Catalog.class);
		 return modelMapper;
	}
}
