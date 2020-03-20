package io.github.brenovit.ecommerce.validator.generic;

import io.github.brenovit.ecommerce.exception.ValidationException;

@FunctionalInterface
public interface ValidationMethodRunnable extends Runnable {
		
	public default void execute() throws ValidationException {
		try {
			run();
		} catch (Exception exception) {
			ValidationException ex = (ValidationException) exception;
			throw ex;
		}
	}

}
