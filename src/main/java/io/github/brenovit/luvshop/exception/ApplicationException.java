package io.github.brenovit.luvshop.exception;

import io.github.brenovit.luvshop.util.ErrorCode;

public class ApplicationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode);
	}

}
