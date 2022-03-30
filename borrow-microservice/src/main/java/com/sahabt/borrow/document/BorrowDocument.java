package com.sahabt.borrow.document;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sahabt.borrow.validation.TcKimlikNo;



@Document(collection = "borrows")
public class BorrowDocument {
	
	@Id
	private String borrowId;
	
	@TcKimlikNo
	@NotBlank
	private String identity;
	@NotBlank
	private String bookId;
	
	
	private Deadline deadline; 
	
	private String date;
	
	private int punishment;
	
	private int borrowCounter;

	public BorrowDocument() {
		
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

	public String getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	
	
	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	@Override
	public int hashCode() {
		return Objects.hash(borrowId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowDocument other = (BorrowDocument) obj;
		return Objects.equals(borrowId, other.borrowId);
	}

	@Override
	public String toString() {
		return "BorrowDocument [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId + ", deadline="
				+ deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter=" + borrowCounter + "]";
	}

	
	

}
