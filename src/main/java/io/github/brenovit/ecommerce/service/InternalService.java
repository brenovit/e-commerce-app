package io.github.brenovit.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.brenovit.ecommerce.models.User;
import io.github.brenovit.ecommerce.security.jwt.JwtUtils;
import io.github.brenovit.ecommerce.util.HeaderHelper;

public class InternalService {
	
	@Autowired
	private HeaderHelper headerHelper;
	
	@Autowired	
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
		
	public User getLoggedUser() {
		String userName = jwtUtils.getUserNameFromJwtToken(headerHelper.getAuthorization());
		Optional<User> findedUser = userService.findByUsername(userName);
		if(findedUser.isPresent()) {
			return findedUser.get();
		}
		return null;
	}
}
