package com.abdiev.secure.controller;



import com.abdiev.secure.model.AuthenticationRequest;
import com.abdiev.secure.model.MessageResponse;
import com.abdiev.secure.model.RegistrationRequest;
import com.abdiev.secure.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserDetailsService userDetailsService;
    @PostMapping("/auth/login")
    public ResponseEntity<MessageResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(userDetailsService.login(request));
    }

    @PostMapping("/auth/registration")
    public ResponseEntity<MessageResponse> registration(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(userDetailsService.registration(request));
    }
}
