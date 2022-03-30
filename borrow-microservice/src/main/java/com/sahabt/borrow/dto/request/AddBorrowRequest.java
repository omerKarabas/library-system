package com.sahabt.borrow.dto.request;

import javax.validation.constraints.NotBlank;

import com.sahabt.borrow.validation.TcKimlikNo;

public class AddBorrowRequest {
	
	
	private String borrowId;
	@TcKimlikNo
	private String identity;
	@NotBlank
	private String bookId;	
	@NotBlank
	private String deadline; 	
	@NotBlank
	private String date;	
	
	private int punishment;
	@NotBlank
	private int borrowCounter;
	public AddBorrowRequest() {
	}
	public String getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	@Override
	public String toString() {
		return "AddBorrowRequest [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId
				+ ", deadline=" + deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter="
				+ borrowCounter + "]";
	}
	
	
}
