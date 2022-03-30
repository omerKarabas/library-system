package com.sahabt.catalog.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.catalog.dto.request.AddCatalogRequest;
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
	
	@Bean
	public ModelMapper modelMapper() {
		 var modelMapper = new ModelMapper();
		 modelMapper.addConverter(ADD_CATALOG_REQUEST_TO_CATALOG_CONVERTER,
				 AddCatalogRequest.class,Catalog.class);
		 return modelMapper;
	}
}
