package io.github.brenovit.luvshop.validator.auth.sigin;

import io.github.brenovit.luvshop.payload.auth.SignInRequest;
import io.github.brenovit.luvshop.validator.generic.MultipleFieldValidator;

public class SignInValidator extends MultipleFieldValidator<SignInRequest> {

	@Override
	public void addValidationFor(SignInRequest request) {
		add(() -> requiredField(request.getLogin(), "login"));
		add(() -> requiredField(request.getPassword(), "password"));		
	}

}
