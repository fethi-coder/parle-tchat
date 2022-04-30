package com.parle.ParleMsg.SECURITY;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parle.ParleMsg.MODEL.Inscription;
import com.parle.ParleMsg.REPOSITORY.InscriptionRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	InscriptionRepository inscri;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Inscription> in = inscri.findByUsername(username);
		in.orElseThrow(()->new UsernameNotFoundException("utilisateur non trouvé" + username));
		return in.map(MyUserDetails::new).get();
	}
	
}
