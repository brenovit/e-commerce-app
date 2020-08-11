package io.github.brenovit.luvshop.exception;

import io.github.brenovit.luvshop.util.ErrorCode;

public class ValidationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ValidationException(ErrorCode errorCode, String extraMsg) {
		super(errorCode, extraMsg);
	}

}
