package com.ahsansoftware.lms.controller;

import com.ahsansoftware.lms.dto.AuthRequestDTO;
import com.ahsansoftware.lms.dto.AuthResponseDTO;
import com.ahsansoftware.lms.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO authRequest) {
        AuthResponseDTO response = authService.login(authRequest);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody AuthRequestDTO authRequest) {
        AuthResponseDTO response = authService.register(authRequest);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/test")
    public String test() {
        return "Auth endpoint is working!";
    }
}