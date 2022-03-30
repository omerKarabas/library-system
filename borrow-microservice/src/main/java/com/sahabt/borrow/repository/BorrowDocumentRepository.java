package com.sahabt.borrow.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahabt.borrow.document.BorrowDocument;

public interface BorrowDocumentRepository extends MongoRepository<BorrowDocument, String>{

	List<BorrowDocument> findAllBorrowByIdentity(String identity);

	
}
