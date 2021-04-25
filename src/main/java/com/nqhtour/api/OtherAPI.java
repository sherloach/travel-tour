package com.nqhtour.api;

import com.nqhtour.dto.AuthenticationRequest;
import com.nqhtour.dto.AuthenticationResponse;
import com.nqhtour.service.impl.ClientService;
import com.nqhtour.service.impl.CustomUserDetailsService;
import com.nqhtour.service.impl.UserService;
import com.nqhtour.util.JwtUtil;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherAPI {

    /*@Autowired
    private AuthenticationManager authenticationManager;*/

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
        /*try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }*/

        // Xác thực từ username và password.
        /*Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );*/

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        //SecurityContextHolder.getContext().setAuthentication(authentication);

        // call ajax ở bên Login form, thực hiện check usernam and password, nếu đúng thì tạo jwt => success thì post tới /j_spring_security_check

        JsonNode parent = new ObjectMapper().readTree(data);
        String username = parent.get("username").asText();
        String password = parent.get("password").asText();
        String result = "";
        HttpStatus httpStatus = null;

        try {
            if (userService.checkAccount(username, password)) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                result = jwtUtil.generateToken(userDetails);
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
