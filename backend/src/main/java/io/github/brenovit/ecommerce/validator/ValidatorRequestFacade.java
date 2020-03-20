package io.github.brenovit.ecommerce.validator;

import io.github.brenovit.ecommerce.payload.auth.SignInRequest;
import io.github.brenovit.ecommerce.validator.auth.sigin.SignInValidator;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorRequestFacade {
	private static final SignInValidator signInValidator = new SignInValidator();
	
	@SneakyThrows	
	public void validate(SignInRequest request) {
		signInValidator.validate(request);
	}	
}
