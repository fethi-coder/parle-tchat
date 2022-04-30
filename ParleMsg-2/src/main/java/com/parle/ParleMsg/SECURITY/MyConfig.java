package com.parle.ParleMsg.SECURITY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		super.configure(auth);
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().and().authorizeRequests()
				.antMatchers("/forum/allMessage").permitAll()
				.antMatchers("/createInscri").permitAll()
				.antMatchers("/connexion/login").permitAll()
				.antMatchers("/connexion/logout").permitAll()
				.antMatchers("/forum/envoieMessage").permitAll()
				.antMatchers("/forum/createForum").permitAll()
				.antMatchers("/connexion/ok").permitAll()
				.antMatchers("/connexion/allConnecter").permitAll()
				.antMatchers("/connexion/goodbye").permitAll()
				.antMatchers("forum/allforum").permitAll()
				.antMatchers("/chat").permitAll().anyRequest().authenticated();
				
	}

}
