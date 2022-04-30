package com.parle.ParleMsg.SECURITY;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.parle.ParleMsg.MODEL.Inscription;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private Boolean active ;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(Inscription inscri) {
		this.userName = inscri.getUsername();
		this.password = inscri.getMdp();
		this.active = inscri.getActive();
		this.authorities = Arrays.stream(inscri.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public MyUserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;

	}
	
	

}
