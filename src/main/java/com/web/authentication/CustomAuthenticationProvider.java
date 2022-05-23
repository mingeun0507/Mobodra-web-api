//package com.web.authentication;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private CustomLoadUserByUsername customLoadUserByUsername;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        UserDto user = (UserDto) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());
//
//        String reqPassword = authentication.getCredentials().toString();
//        if(!passwordEncoder.matches(reqPassword, user.getPassword())) throw new BadCredentialsException("Not Found User");
//
//        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//
//}
