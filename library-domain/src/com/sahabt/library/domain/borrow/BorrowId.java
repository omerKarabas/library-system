package com.sahabt.library.domain.borrow;

import java.util.Objects;

import com.sahabt.library.domain.annotations.ValueObject;

@ValueObject
public final class BorrowId {
 
	private String id;

	public static BorrowId of(String borrowId) {
		return new BorrowId(borrowId);
	}
	private BorrowId(String borrowId) {
		super();
		this.id = borrowId;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowId other = (BorrowId) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "BorrowId [borrowId=" + id + "]";
	}
	
	
}