package com.ecomm.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecomm.Model.User;
import com.ecomm.Model.UserAuthDetails;
import com.ecomm.Repository.UserRepository;

@Service
public class UserAuthDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

    @Override
	public UserAuthDetails loadUserByUsername(String credential) throws UsernameNotFoundException {
		Optional<User> userInfo = userRepository.findByUsernameOrEmail(credential);

		UserAuthDetails userDetails = userInfo.map(UserAuthDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + credential));

		return  userDetails;

	}
    
}
