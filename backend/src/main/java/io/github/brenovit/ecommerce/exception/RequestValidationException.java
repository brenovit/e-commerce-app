package io.github.brenovit.ecommerce.exception;

import java.util.ArrayList;
import java.util.List;

import io.github.brenovit.ecommerce.util.ErrorCode;
import lombok.Getter;
import io.github.brenovit.ecommerce.payload.error.Error;

public class RequestValidationException extends GenericException{

	private static final long serialVersionUID = 8487592134793317048L;
	@Getter
	private List<Error> errors;
	
	public RequestValidationException(ErrorCode errorCode, List<Error> listErro) {
		super(errorCode);
		this.errors = new ArrayList<Error>(listErro);
	}
}
