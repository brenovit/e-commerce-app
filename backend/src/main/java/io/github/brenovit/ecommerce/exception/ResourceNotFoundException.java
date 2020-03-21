package io.github.brenovit.ecommerce.exception;

import io.github.brenovit.ecommerce.util.ErrorCode;

public class ResourceNotFoundException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(ErrorCode.RESOURCE_NOT_FOUND);
	}
	
	public ResourceNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
