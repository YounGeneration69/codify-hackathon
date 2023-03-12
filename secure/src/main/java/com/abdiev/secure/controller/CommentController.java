package com.abdiev.secure.controller;


import com.abdiev.secure.model.Comment;
import com.abdiev.secure.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository repository;
    @GetMapping
    public ResponseEntity<List<Comment>> fetchComments() {
        return ResponseEntity.ok(repository.findAll());
    }
}
