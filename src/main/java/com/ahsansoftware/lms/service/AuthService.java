package com.ahsansoftware.lms.service;

import com.ahsansoftware.lms.dto.AuthRequestDTO;
import com.ahsansoftware.lms.dto.AuthResponseDTO;
import com.ahsansoftware.lms.model.User;
import com.ahsansoftware.lms.repository.UserRepository;
import com.ahsansoftware.lms.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService userDetialsService;

    public AuthResponseDTO login(AuthRequestDTO authRequest){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername() , authRequest.getPassword())
        );

        UserDetails userDetials = userDetialsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetials);

        return new AuthResponseDTO(token , "Login Successfull" , authRequest.getUsername());
    }

    public AuthResponseDTO register(AuthRequestDTO authRequest){

        if(userRepository.existsByUsername(authRequest.getUsername())){
            throw new RuntimeException("Username is Already Taken");
        }

        User user = new User();

        user.setUsername(authRequest.getUsername());
        user.setEmail(authRequest.getUsername() + "@Comsats.edu.pk");
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        UserDetails userDetials = userDetialsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetials);

        return new AuthResponseDTO(token , "User Registered Successfully" , authRequest.getUsername());
        
    }
}
