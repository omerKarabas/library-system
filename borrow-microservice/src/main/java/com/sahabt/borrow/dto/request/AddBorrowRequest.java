package com.sahabt.borrow.dto.request;

import javax.validation.constraints.NotBlank;

import com.sahabt.borrow.validation.TcKimlikNo;
import com.sahabt.library.domain.borrow.Deadline;
import com.sahabt.library.domain.borrow.Delivery;

public class AddBorrowRequest {
	
	
	private int borrowId;
	@TcKimlikNo
	private String identity;
	@NotBlank
	private int bookId;	
	@NotBlank
	private Deadline deadline; 	
	@NotBlank
	private Delivery date;	
	
	private int punishment;
	@NotBlank
	private int borrowCounter;
	public AddBorrowRequest() {
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
		return "AddBorrowRequest [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId
				+ ", deadline=" + deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter="
				+ borrowCounter + "]";
	}
	
	
}
