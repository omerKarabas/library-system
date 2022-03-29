package com.sahabt.admincrud.dto.request;

import java.util.Base64;
import java.util.Objects;

import com.sahabt.library.domain.annotations.ValueObject;

@ValueObject
public final class Photo {
	private final byte[] value;

	public static Photo of(String base64Value) {
		return new Photo(Base64.getDecoder().decode(base64Value));
	}

	public static Photo of(byte[] value) {
		return new Photo(value);
	}

	private Photo(byte[] value) {
		this.value = value;
	}

	public byte[] getValue() {
		return value;
	}

	public String getBase64Value() {
		return Base64.getEncoder().encodeToString(value);
	}

}
