package com.sahabt.borrow.dto.response;

public class BorrowResponse {

	private String borrowId;
	private String identity;
	private String bookId;	
	private String deadline; 	
	private String date;	
	private int punishment;
	private int borrowCounter;
	public BorrowResponse() {
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
		return "BorrowResponse [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId + ", deadline="
				+ deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter=" + borrowCounter + "]";
	}
	
	
	
	
	
}
