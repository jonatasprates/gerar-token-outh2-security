package com.example.teste1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
//        UserDetails user = userBuilder
//                .username("admin")
//                .password("admin")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = userBuilder
//                .username("root")
//                .password("root")
//                .roles("USER","ADMIN")
//                .build();

        return new InMemoryUserDetailsManager();
    }
	  
	 
	
}
