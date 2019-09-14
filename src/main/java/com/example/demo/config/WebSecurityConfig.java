package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser("vimaluser").password(encoder.encode("testvimaluser")).roles("USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic()
			.and().authorizeRequests().anyRequest().permitAll();
		
//		http.logout().invalidateHttpSession(true).deleteCookies("JSESSIONID");
		
		http.cors().disable();
		
		http.csrf().disable();
	}
	
}
