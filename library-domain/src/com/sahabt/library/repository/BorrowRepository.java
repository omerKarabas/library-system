package com.sahabt.library.repository;

import java.util.List;
import java.util.Optional;

import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.domain.borrow.IdentityNo;

public interface BorrowRepository {
	
	boolean exists(BorrowId borrowId);

	Borrow createBorrow(Borrow borrow);

	Optional<Borrow> removeBorrow(BorrowId borrowId);

	Optional<List<Borrow>> findBorrowsByIdentityNo(IdentityNo identityNo);
	
	Optional<Borrow> findBorrowByBorrowId(BorrowId borrowId);
	
	Optional<List<Borrow>> getAllBorrows();
	
	Borrow updateBorrow(Borrow borrow);
	
	

	

}
