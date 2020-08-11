package io.github.brenovit.luvshop.payload.auth;

import lombok.Data;

@Data
public class SignInRequest {
	private String login;
	private String password;
}
