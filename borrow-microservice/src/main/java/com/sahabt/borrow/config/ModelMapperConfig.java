package com.sahabt.borrow.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahabt.borrow.document.BorrowDocument;
import com.sahabt.borrow.dto.request.AddBorrowRequest;
import com.sahabt.borrow.dto.response.BorrowResponse;
import com.sahabt.library.domain.borrow.BookId;
import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowCounter;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.domain.borrow.Deadline;
import com.sahabt.library.domain.borrow.Delivery;
import com.sahabt.library.domain.borrow.Punishment;
import com.sahabt.library.domain.user.IdentityNo;



@Configuration
public class ModelMapperConfig {
	private static final Converter<AddBorrowRequest,Borrow>
	ADD_BORROW_REQUEST_TO_BORROW_CONVERTER = (context) -> {
		var request = context.getSource();
		return new Borrow.Builder()
				        .borrowId(request.getBorrowId())
				        .identityNo(request.getIdentity())
				        .bookId(request.getBookId())
				        //.deadline(request.getDeadline())
				        //.date(request.getDate())
				        .punishment(request.getPunishment())
				        .borrowCounter(request.getBorrowCounter())
				        .build();
	};
	
	private static final Converter<BorrowDocument,Borrow>
	BORROW_DOCUMENT_TO_BORROW_CONVERTER = (context) -> {
		var document = context.getSource();
		return new Borrow.Builder()
				.borrowId(document.getBorrowId())
				.identityNo(document.getIdentity())
				.deadline(document.getDeadline().getDay(), document.getDeadline().getMount(), document.getDeadline().getYear())
				.date(document.getDate().getDay(), document.getDate().getMount(), document.getDate().getYear())
				.punishment(document.getPunishment())
				.borrowCounter(document.getBorrowCounter())
				.bookId(document.getBookId())
				.build();
	};

		private static final Converter<Borrow,BorrowResponse>
		BORROW_TO_BORROW_RESPONSE_CONVERTER = (context) -> {
		var borrow = context.getSource();
		var deadline= borrow.getDeadline();
		
		var response = new BorrowResponse();
		response.setBorrowId(borrow.getBorrowId().getId());
		response.setIdentity(borrow.getIdentityNo().getIdentityNo());
		response.setBookId(borrow.getBookId().getBookId());
		//response.setDeadline();
		//response.setDate(borrow.getDate());
		response.setPunishment(borrow.getPunishment().getPunishmentAmount());
		response.setBorrowCounter(borrow.getBorrowCounter().getBorrowCounter());
		return response;
	};

		private static final Converter<Borrow,BorrowDocument>
		BORROW_TO_BORROW_DOCUMENT_CONVERTER = (context) -> {
		var borrow = context.getSource();
//		var fullname = employee.getFullname();
		var document = new BorrowDocument();
		document.setBorrowId(borrow.getBorrowId().getId());
		document.setIdentity(borrow.getIdentityNo().getIdentityNo());
		document.setBookId(borrow.getBookId().getBookId());
		//document.setDeadline(borrow.getDeadline().getDay());
		//document.setDate(null);
		document.setPunishment(borrow.getPunishment().getPunishmentAmount());
		document.setBorrowCounter(borrow.getBorrowCounter().getBorrowCounter());
		return document;
	};
	private int borrowCounter;
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(ADD_BORROW_REQUEST_TO_BORROW_CONVERTER, 
				AddBorrowRequest.class, Borrow.class);
		modelMapper.addConverter(BORROW_TO_BORROW_RESPONSE_CONVERTER, 
				Borrow.class, BorrowResponse.class);
		modelMapper.addConverter(BORROW_DOCUMENT_TO_BORROW_CONVERTER, 
				BorrowDocument.class, Borrow.class);
		modelMapper.addConverter(BORROW_TO_BORROW_DOCUMENT_CONVERTER, 
				Borrow.class, BorrowDocument.class);
		return modelMapper;
	}
}
