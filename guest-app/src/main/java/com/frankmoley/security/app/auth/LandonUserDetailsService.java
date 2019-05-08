package com.frankmoley.security.app.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LandonUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public LandonUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (null == user) {
			throw new UsernameNotFoundException("cannot find username: " + userName);
		}
		return new LandonUserPrincipal(user);
	}
}
