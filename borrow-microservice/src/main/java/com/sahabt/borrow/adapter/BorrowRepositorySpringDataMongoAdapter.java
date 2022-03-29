package com.sahabt.borrow.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.sahabt.borrow.document.BorrowDocument;
import com.sahabt.borrow.repository.BorrowDocumentRepository;
import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.repository.BorrowRepository;

public class BorrowRepositorySpringDataMongoAdapter implements BorrowRepository{
	
	private BorrowDocumentRepository borrowDocumentRepository;
	private ModelMapper modelMapper;
	
	public BorrowRepositorySpringDataMongoAdapter(BorrowDocumentRepository borrowDocumentRepository,ModelMapper modelMapper) {
		this.borrowDocumentRepository = borrowDocumentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean exists(BorrowId borrowId) {
		return borrowDocumentRepository.existsById(borrowId.getId());
	}

	@Override
	public Borrow createBorrow(Borrow borrow) {
		var borrowDocument = modelMapper.map(borrow, BorrowDocument.class);
		var newEmployeeDocument = borrowDocumentRepository.save(borrowDocument);
		return modelMapper.map(newEmployeeDocument, Borrow.class);
	}

	@Override
	public Optional<Borrow> removeBorrow(BorrowId borrowId) {
		var borrowDocument = borrowDocumentRepository.findById(borrowId.getId());
		if (borrowDocument.isEmpty())
			return Optional.empty();
		var document = borrowDocument.get();		
		borrowDocumentRepository.delete(document);
		return Optional.of(modelMapper.map(document, Borrow.class));
	}

	@Override
	public Optional<Borrow> findBorrowByIdentityNo(BorrowId borrowId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borrow updateBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
