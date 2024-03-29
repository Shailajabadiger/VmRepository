package com.mindtree.oauth2configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.mindtree.entity.DetailsService;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private DetailsService   userDetailsservice;
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsservice).passwordEncoder(encoder());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token").permitAll();
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
    /*@Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }*/
 
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    
    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }
 
    /*@Bean
    public ClientRegistrationRepository RegistrationRepository() {
        return new InMemoryClientRegistrationRepository();
    }*/
 
    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }
    
    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
 
}
 