package com.sahabt.library.applications.bussiness;

import java.util.List;
import java.util.Optional;

import com.sahabt.library.applications.BorrowApplication;
import com.sahabt.library.domain.borrow.Borrow;
import com.sahabt.library.domain.borrow.BorrowId;
import com.sahabt.library.domain.borrow.IdentityNo;
import com.sahabt.library.infra.EventPublisher;
import com.sahabt.library.repository.BorrowRepository;

public class StandardBorrowApplication implements BorrowApplication  {
	
	private BorrowRepository borrowRepository;
	private EventPublisher eventPublisher;
	
	public StandardBorrowApplication(BorrowRepository borrowRepository, EventPublisher eventPublisher) {
		this.borrowRepository = borrowRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Optional<Borrow> addBorrow(Borrow borrow) {
		var borrowId= borrow.getBorrowId();
		if(borrowRepository.exists(borrowId))
			return Optional.empty();
		//eventPublisher.publish(new BorrowAddedEvent(borrowId));
		return Optional.of(borrowRepository.createBorrow(borrow));
	}
	
	@Override
	public Optional<Borrow> removeBorrow(BorrowId borrowId) {
		Optional<Borrow> firedEmployee = 
				borrowRepository.removeBorrow(borrowId);
		//firedEmployee.ifPresent( emp -> eventPublisher.publish(new BorrowRemovedEvent(brr)));
		return firedEmployee;
	}
	
	@Override
	public Optional<List<Borrow>> getAllBorrowByIdentityNo(IdentityNo identityNo) {
		
		return borrowRepository.findBorrowsByIdentityNo(identityNo);
	}

	@Override
	public Optional<List<Borrow>> getAllBorrow() {
		
		return borrowRepository.getAllBorrows();
	}

	@Override
	public Optional<Borrow> getInformationBorrow(BorrowId borrowId) {
		
		return borrowRepository.findBorrowByBorrowId(borrowId);
	}

	@Override
	public Optional<Borrow> updateBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return null;
	}

}
