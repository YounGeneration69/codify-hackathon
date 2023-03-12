package com.abdiev.secure.service;



import com.abdiev.secure.model.*;
import com.abdiev.secure.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("This user has not been registered")
        );
    }

    public MessageResponse login(AuthenticationRequest request) {
        if (!repository.existsByUsername(request.getUsername())) throw new RuntimeException("User has not been registered");
        if (!encoder.matches(request.getPassword(),repository.findByUsername(request.getUsername()).get().getPassword())) throw new RuntimeException("Bad credentials");
        return MessageResponse
                    .builder()
                    .date(Date.from(Instant.now()))
                    .exceptionType(null)
                    .status(HttpStatus.ACCEPTED)
                    .message("User logged in successfully")
                    .build();
    }

    public MessageResponse registration(RegistrationRequest request) {
        if (repository.existsByUsername(request.getUsername())) throw new RuntimeException("User with username has been registered");
        User user = User
                .builder()
                .role(Role.ROLE_PRIME)
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .build();
        repository.save(user);
        return MessageResponse
                .builder()
                .message("User has been registered successfully")
                .date(Date.from(Instant.now()))
                .status(HttpStatus.CREATED)
                .exceptionType(null)
                .build();
    }


    @PostConstruct
    public void testSave() {
        User user = User.builder()
                .password(encoder.encode("user"))
                .firstName("Atai")
                .lastName("Atai")
                .role(Role.ROLE_ADMIN)
                .username("user@gmail.com")
                .build();
        repository.save(user);
    }


}
