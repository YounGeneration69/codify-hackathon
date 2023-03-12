package com.abdiev.secure.controller;


import com.abdiev.secure.model.Institute;
import com.abdiev.secure.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/institutes")
@RequiredArgsConstructor
public class InstitutesController {
    private final InstituteRepository repository;

    @GetMapping()
    public ResponseEntity<List<Institute>> fetchALl() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> fetchALlNames() {
        return ResponseEntity.ok(repository.findAllNames());
    }
}
