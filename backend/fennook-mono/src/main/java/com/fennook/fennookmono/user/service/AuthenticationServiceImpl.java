package com.fennook.fennookmono.user.service;

import com.fennook.common.errors.InvalidAuthenticationException;
import com.fennook.fennookmono.user.data.User;
import com.fennook.fennookmono.user.data.UserRole;
import com.fennook.fennookmono.user.dto.JwtAuthenticationResponse;
import com.fennook.fennookmono.user.dto.UserSigninRequest;
import com.fennook.fennookmono.user.dto.UserSignupRequest;
import com.fennook.fennookmono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(UserSignupRequest request) {
        logger.info("Signing up user: {},{}", request.getEmail(), request.getUsername());

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName()).
                email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(UserRole.USER).build();
        userRepository.save(user);

        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(UserSigninRequest request) {
        logger.info("Attempting to sign-in: {}", request.getEmail());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException ex) {
            throw new InvalidAuthenticationException();
        }

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(InvalidAuthenticationException::new);
        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
