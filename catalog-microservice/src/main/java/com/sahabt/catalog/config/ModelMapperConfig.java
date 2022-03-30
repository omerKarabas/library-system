package com.sahabt.catalog.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.catalog.dto.request.AddCatalogRequest;
import com.sahabt.catalog.dto.response.CatalogResponse;
import com.sahabt.library.domain.catalog.Catalog;

@Configuration
public class ModelMapperConfig {
	
	private static final Converter<AddCatalogRequest,Catalog>
	ADD_CATALOG_REQUEST_TO_CATALOG_CONVERTER = (context) ->{
		
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
	@Bean
	public ModelMapper modelMapper() {
		 var modelMapper = new ModelMapper();
		 modelMapper.addConverter(ADD_CATALOG_REQUEST_TO_CATALOG_CONVERTER,
				 AddCatalogRequest.class,Catalog.class);
		 modelMapper.addConverter(CATALOG_TO_CATALOG_RESPONSE_CONVERTER,
				 Catalog.class, CatalogResponse.class);
		 return modelMapper;
	}
}
