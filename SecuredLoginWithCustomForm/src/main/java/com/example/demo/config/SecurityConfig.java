package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true) 
public class SecurityConfig  implements WebMvcConfigurer{

	
	@Configuration
	public static class ApplicationSecurity extends WebSecurityConfigurerAdapter{
	
		@Override

		protected void configure(HttpSecurity http) throws Exception {
			   http.authorizeRequests().antMatchers("/first").fullyAuthenticated().and()
			   .formLogin().loginPage("/login").failureUrl("/login?error").
			             permitAll().and().
			             logout().invalidateHttpSession(true).permitAll();
	           
		
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub

			auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh").roles("USER");
		}

	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		
 registry.addViewController("/login").setViewName("login");
 registry.addViewController("/logout").setViewName("logout");

 
	}

	
}
