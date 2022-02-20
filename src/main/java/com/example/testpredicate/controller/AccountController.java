package com.example.testpredicate.controller;

import com.example.testpredicate.entity.domain.User;
import com.example.testpredicate.entity.security.JwtRequest;
import com.example.testpredicate.entity.security.JwtResponse;
import com.example.testpredicate.repository.UserRepository;
import com.example.testpredicate.security.JwtUtil;
import com.example.testpredicate.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    private CustomUserDetailsService domainUserDetailService;

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @PostMapping("/authenticate")
    public ResponseEntity generateToken(@RequestBody JwtRequest authRequest) throws Exception {
        try {
            User checkUser = userRepository.findByLogin(authRequest.getUsername());
            if(passwordEncoder().matches(authRequest.getPassword(),checkUser.getPassword())){
                return ResponseEntity.ok(jwtUtils.generateToken(authRequest.getUsername()));
            }
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        throw  new UsernameNotFoundException("User doesn't exist");
    }
}
