package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override

	protected void configure(HttpSecurity http) throws Exception {
//	   http.authorizeRequests().
//	   antMatchers("/first").authenticated().and().formLogin();
//	   
          
		http.rememberMe().key("mykey").tokenValiditySeconds(4000).
		rememberMeParameter("remember-me").and().authorizeRequests().
		antMatchers("/first").
		authenticated().and().formLogin();
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh").roles("USER");
		
	
		
	}

}
