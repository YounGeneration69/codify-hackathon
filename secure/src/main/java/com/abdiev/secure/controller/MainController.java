package com.abdiev.secure.controller;



import com.abdiev.secure.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> publicPage (){
        return ResponseEntity.ok("Main page");
    }

    @PostMapping("/")
    public ResponseEntity<Message> publicPage2(@RequestBody Message message){
        return ResponseEntity.ok(message);
    }

}
