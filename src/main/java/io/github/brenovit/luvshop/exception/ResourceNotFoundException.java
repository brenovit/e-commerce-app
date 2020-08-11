package io.github.brenovit.luvshop.exception;

import io.github.brenovit.luvshop.util.ErrorCode;

public class ResourceNotFoundException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(ErrorCode.RESOURCE_NOT_FOUND);
	}
	
	public ResourceNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
