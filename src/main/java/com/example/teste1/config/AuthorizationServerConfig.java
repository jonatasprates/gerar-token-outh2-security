package com.example.teste1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Value("${client}")
	private String client;
	
	@Value("${secret}")
	private String secret;
	
	@Value("${acess_token}")
	private int acess_token;	
	
	@Value("${refresh_token}")
	private int refresh_token;
	
	@Value("${grant_type}")
	private String grant_type;
	
	@Value("${server_read}")
	private String server_read;
	
	@Value("${server_write}")
	private String server_write;
	
	@Autowired private AuthenticationManager authenticationManager;
	
	@Autowired
    private UserDetailsService userDetailsService;


	  @Override
	  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	    clients
	        .inMemory()
	        .withClient("user")
	        .secret("{noop}secret")
	        .authorizedGrantTypes("client_credentials")
	        .accessTokenValiditySeconds(1800)
	        .refreshTokenValiditySeconds(1800)
	        .scopes("resource-server-read", "resource-server-write");
	  }

	  @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        endpoints
	            .authenticationManager(authenticationManager)
	            .userDetailsService(userDetailsService);
	    }
	  
}
