package io.github.brenovit.ecommerce.payload.auth;

import lombok.Data;

@Data
public class SignInRequest {
	private String login;
	private String password;
}
