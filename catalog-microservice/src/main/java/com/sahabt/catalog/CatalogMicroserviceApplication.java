package com.sahabt.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@ComponentScan({"com.sahabt.library"})
@EntityScan({"com.sahabt.library.domain"})
@EnableMongoRepositories({"com.sahabt.library.repository.CatalogRepository"} )
@SpringBootApplication
public class CatalogMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogMicroserviceApplication.class, args);
	}

}
