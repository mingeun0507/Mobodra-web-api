package com.web.config;

import com.web.authentication.CustomAuthenticationFailureHandler;
//import com.web.authentication.CustomAuthenticationProvider;
import com.web.authentication.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
        ;

        http
                .authorizeRequests()
                .antMatchers("/api/user").hasAnyRole("USER")
                .anyRequest().permitAll()
        ;

        http
                .formLogin()
                .loginProcessingUrl("/api/login")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
        ;

        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
        ;

        http.httpBasic().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(customAuthenticationProvider);
    }



}

