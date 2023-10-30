package com.fennook.fennookmono.user.service;

import com.fennook.fennookmono.user.dto.JwtAuthenticationResponse;
import com.fennook.fennookmono.user.dto.UserSigninRequest;
import com.fennook.fennookmono.user.dto.UserSignupRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(UserSignupRequest request);
    JwtAuthenticationResponse signin(UserSigninRequest request);
}
