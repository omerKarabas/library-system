package com.sahabt.borrow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.sahabt.library"})
@EntityScan({"com.sahabt.library.domain"})
@EnableMongoRepositories({"com.sahabt.library.repository.BorrowRepository"})
public class BorrowMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowMicroserviceApplication.class, args);
	}

}
