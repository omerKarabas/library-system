package com.sahabt.library.applications;

import java.util.List;
import java.util.Optional;

import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.domain.borrow.IdentityNo;

public interface BorrowApplication {

	Optional<Borrow> addBorrow(Borrow borrow);
	Optional<Borrow> removeBorrow(BorrowId borrowId);
	Optional<List<Borrow>> getAllBorrowByIdentityNo(IdentityNo identity);
	Optional<List<Borrow>> getAllBorrow();
	Optional<Borrow> getInformationBorrow(BorrowId borrowId);
	Optional<Borrow> updateBorrow(Borrow borrow);
	
	

}
