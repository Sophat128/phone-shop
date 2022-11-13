package com.piseth.java.school.phoneshop.jwt.service;

import com.piseth.java.school.phoneshop.jwt.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Authenticate {
    private final AuthenticationManager authenticationManager;
    private final JwtDetailsService jwtDetailsService;
    private final JwtUtil jwtUtil;
    public ResponseEntity<?> authenticate(AuthenticationRequest authRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
        final UserDetails userDetails = jwtDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }
}
