package com.te.springbootproject.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String messege) {
		super(messege);

	}
}
