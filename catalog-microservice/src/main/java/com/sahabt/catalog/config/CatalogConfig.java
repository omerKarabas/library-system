package com.sahabt.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.library.applications.CatalogApplication;
import com.sahabt.library.applications.bussiness.StandardCatalogApplication;
import com.sahabt.library.infra.EventPublisher;
import com.sahabt.library.repository.CatalogRepository;

@Configuration
public class CatalogConfig {

	@Bean
	public CatalogApplication createCatalogApplication (
						CatalogRepository catalogRepository,
						EventPublisher eventPublisher) {
		return new StandardCatalogApplication(catalogRepository,eventPublisher); 
	}
}
