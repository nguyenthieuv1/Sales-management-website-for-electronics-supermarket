package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.security.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	
	
	
	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/home","/login","/items","/register").permitAll()
					.requestMatchers("/admin/**","/new-orders","/orders-detail","/detail-accounts/**","/products","/detail-products").hasAuthority("ADMIN")
					.requestMatchers("/carts","/user","/orders").hasAuthority("CUSTOMER")
					.anyRequest().authenticated()					
					)
			.formLogin(login->login
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.usernameParameter("username")
					.passwordParameter("password")
//					.defaultSuccessUrl("/admin",true)	
					.successHandler(new CustomAuthenticationSuccessHandler())
					.failureHandler(new CustomAuthenticationFailureHandler())
					)
			.logout(logout->logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
					)
			
			;
		
		
		
		return http.build();
	}
	
	@Bean
	 WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/css/**","/js/**","/img/**");
	}
}
