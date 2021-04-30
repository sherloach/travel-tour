package com.nqhtour.api;

import com.nqhtour.service.impl.CustomUserDetailsService;
import com.nqhtour.service.impl.UserService;
import com.nqhtour.util.JwtUtil;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherAPI {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    /*@PostMapping("/api/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }*/

    @PostMapping("/api/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody String data) throws Exception {
        JsonNode parent = new ObjectMapper().readTree(data);
        String username = parent.get("username").asText();
        String password = parent.get("password").asText();
        String result = "";
        HttpStatus httpStatus = null;

        try {
            if (userService.checkAccount(username, password)) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                //result = jwtUtil.generateToken(userDetails);
                result = "Login success";
                httpStatus = HttpStatus.OK;
            } else {
                result = "Incorrect username and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, httpStatus);
    }
}
