package com.sahabt.borrow.dto.response;

import com.sahabt.library.domain.borrow.Deadline;
import com.sahabt.library.domain.borrow.Delivery;

public class BorrowResponse {

	private int borrowId;
	private String identity;
	private int bookId;	
	private Deadline deadline; 	
	private Delivery date;	
	private int punishment;
	private int borrowCounter;
	public BorrowResponse() {
	}

	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	public Delivery getDate() {
		return date;
	}

	public void setDate(Delivery date) {
		this.date = date;
	}

	public int getPunishment() {
		return punishment;
	}
	public void setPunishment(int punishment) {
		this.punishment = punishment;
	}
	public int getBorrowCounter() {
		return borrowCounter;
	}
	public void setBorrowCounter(int borrowCounter) {
		this.borrowCounter = borrowCounter;
	}

	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public int getBookId() {	
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "BorrowResponse [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId + ", deadline="
				+ deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter=" + borrowCounter + "]";
	}


	
	
	
	
	
}
