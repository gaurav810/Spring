package com.demo.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("admin").password("{noop}pass").roles("ADMIN").and()
										.withUser("user").password("{noop}pass").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/user").hasAnyRole("USER", "ADMIN").
											antMatchers("/delete-user/*").hasRole("ADMIN").
											antMatchers("/").permitAll().and().httpBasic();
	}
}
