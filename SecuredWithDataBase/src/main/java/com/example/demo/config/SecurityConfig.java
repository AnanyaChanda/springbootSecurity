package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource customDataSource;
	@Override

	protected void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests().antMatchers("/first").authenticated().and().formLogin();
		   
           
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(this.customDataSource);

		String query1 = "select userName,password,enabled from users where userName = ?";

				String query2  = "select userName,authority from  authorities where userName=?"; 
		
		auth.jdbcAuthentication()
		         .dataSource(this.customDataSource)
		         .authoritiesByUsernameQuery(query1)
		         .authoritiesByUsernameQuery(query2)
		         .passwordEncoder(new BCryptPasswordEncoder());
		
		
		
	}

}
