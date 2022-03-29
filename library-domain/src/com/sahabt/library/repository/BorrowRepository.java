package com.sahabt.library.repository;

import java.util.Optional;

import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;

public interface BorrowRepository {
	
	boolean exists(BorrowId borrowId);

	Borrow createBorrow(Borrow borrow);

	Optional<Borrow> removeBorrow(BorrowId borrowId);

	Optional<Borrow> findBorrowByIdentityNo(BorrowId borrowId);
	
	Borrow updateBorrow(Borrow borrow);

	

}
