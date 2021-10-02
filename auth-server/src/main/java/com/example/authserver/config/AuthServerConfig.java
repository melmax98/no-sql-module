package com.example.authserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    @Value("${user.oauth.clientId}")
    private String clientID;
    @Value("${user.oauth.clientSecret}")
    private String clientSecret;
    @Value("${user.oauth.redirectUris}")
    private String redirectURLs;

    public AuthServerConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientID)
                .secret(passwordEncoder.encode(clientSecret))
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(true)
                .redirectUris(redirectURLs);
    }
}