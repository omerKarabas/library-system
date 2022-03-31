package com.sahabt.borrow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.library.applications.BorrowApplication;
import com.sahabt.library.applications.bussiness.StandardBorrowApplication;
import com.sahabt.library.infra.EventPublisher;
import com.sahabt.library.repository.BorrowRepository;

@Configuration
public class BorrowAppConfig {
	@Bean
	public BorrowApplication createApBrplication(
			BorrowRepository employeeRepository, 
			EventPublisher eventPublisher) {
		return new StandardBorrowApplication(employeeRepository, eventPublisher);
	}
}
