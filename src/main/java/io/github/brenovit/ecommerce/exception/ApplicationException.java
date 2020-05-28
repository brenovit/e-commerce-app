package io.github.brenovit.ecommerce.exception;

import io.github.brenovit.ecommerce.util.ErrorCode;

public class ApplicationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode);
	}

}
