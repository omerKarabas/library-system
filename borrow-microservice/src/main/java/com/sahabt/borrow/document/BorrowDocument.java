package com.sahabt.borrow.document;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sahabt.borrow.validation.TcKimlikNo;
import com.sahabt.library.domain.borrow.Deadline;
import com.sahabt.library.domain.borrow.Delivery;



@Document(collection = "borrows")
public class BorrowDocument {
	
	@Id
	private int borrowId;
	
	@TcKimlikNo
	@NotBlank
	private String identity;
	@NotBlank
	private int bookId;
	
	
	private Deadline deadline; 
	
	private Delivery date;
	
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

	
	@Override
	public String toString() {
		return "BorrowDocument [borrowId=" + borrowId + ", identity=" + identity + ", bookId=" + bookId + ", deadline="
				+ deadline + ", date=" + date + ", punishment=" + punishment + ", borrowCounter=" + borrowCounter + "]";
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

	

}
