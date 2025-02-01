package com.mps.snapCart.controllers;

import com.mps.snapCart.entities.User;
import com.mps.snapCart.dtos.LoginUserDto;
import com.mps.snapCart.dtos.RegisterUserDto;
import com.mps.snapCart.responses.LoginResponse;
import com.mps.snapCart.services.AuthenticationService;
import com.mps.snapCart.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        Long expiratioTime = jwtService.getExpirationTime();

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(expiratioTime);

        return ResponseEntity.ok(loginResponse);
    }
}