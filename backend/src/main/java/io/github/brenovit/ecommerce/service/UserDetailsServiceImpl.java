package io.github.brenovit.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.brenovit.ecommerce.models.User;
import io.github.brenovit.ecommerce.security.services.UserDetailsImpl;
import lombok.SneakyThrows;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsernameOrEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "+username));
		return UserDetailsImpl.builder(user);
	}
}
