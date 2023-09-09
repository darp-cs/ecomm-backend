package com.ecomm.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ecomm.Model.User;
import com.ecomm.Model.UserAuthDetails;
import com.ecomm.Repository.UserRepository;

public class UserAuthDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userInfo = userRepository.findByUser_name(username);
		return userInfo.map(UserAuthDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	}
    
}
