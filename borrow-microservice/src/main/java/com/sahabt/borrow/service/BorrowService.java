package com.sahabt.borrow.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.sahabt.borrow.dto.request.AddBorrowRequest;
import com.sahabt.borrow.dto.response.BorrowResponse;
import com.sahabt.library.applications.BorrowApplication;
import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.domain.borrow.IdentityNo;

public class BorrowService {
	
	private BorrowApplication borrowApplication;
	// Object 2 Object Mapping
	private ModelMapper modelMapper;
	public BorrowService(BorrowApplication borrowApplication, ModelMapper modelMapper) {
		super();
		this.borrowApplication = borrowApplication;
		this.modelMapper = modelMapper;
	}
	
	public BorrowResponse addBorrow(AddBorrowRequest request) {
		var borrow = modelMapper.map(request, Borrow.class);
		var addedBorrow = borrowApplication.addBorrow(borrow)
				.orElseThrow(() -> new IllegalArgumentException("Already exisiting borrow."));
		return modelMapper.map(addedBorrow, BorrowResponse.class);
	}
	
	public BorrowResponse removeBorrow(int borrowId) {
		var removedBorrow = borrowApplication.removeBorrow(BorrowId.of(borrowId))				
				.orElseThrow(() -> new IllegalArgumentException("Borrow does not exist."));
		return modelMapper.map(removedBorrow, BorrowResponse.class);
	}
	
	public BorrowResponse getInformationBorrow(int borrowId) {
		var borrow = borrowApplication.getInformationBorrow(BorrowId.of(borrowId))				
				.orElseThrow(() -> new IllegalArgumentException("Borrow does not exist."));
		return modelMapper.map(borrow, BorrowResponse.class);
	}

	public List<BorrowResponse> getAllBorrow() {	
		return borrowApplication.getAllBorrow()
				.stream()
				.map(borrow -> modelMapper.map(borrow, BorrowResponse.class))
				//.sorted(Comparator.comparing(BorrowResponse::identityNo))
				.toList();
				
	}
	
	public List<BorrowResponse> getAllBorrowByIdentityNo(String identityNo){
		return borrowApplication.getAllBorrowByIdentityNo(IdentityNo.of(identityNo))
				.stream()
				.map(borrow -> modelMapper.map(borrow, BorrowResponse.class))
				.toList();	
	}
	
	//Optional<Borrow> addBorrow(Borrow borrow);
	//Optional<Borrow> removeBorrow(Borrow borrowId);
	//Optional<Borrow> getAllBorrowByIdentityNo(IdentityNo identityNo);
	//Optional<Borrow> getAllBorrow();
	//Optional<Borrow> getInformationBorrow(Borrow borrowId);
	
	

}
