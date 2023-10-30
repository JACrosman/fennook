package com.fennook.fennookmono.user.controller;

import com.fennook.fennookmono.user.dto.JwtAuthenticationResponse;
import com.fennook.fennookmono.user.dto.UserSigninRequest;
import com.fennook.fennookmono.user.dto.UserSignupRequest;
import com.fennook.fennookmono.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserSignupRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody UserSigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
