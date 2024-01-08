package com.example.users.infrastructure.controllers;

import com.example.users.application.services.UserService;
import com.example.users.domain.User;
import com.example.users.infrastructure.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        var userCreated = this.userService.saveUser(user);

        return ResponseEntity.ok(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        var userFound = this.userService.findById(id);
        return ResponseEntity.ok(userFound);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user){
        var userModify = this.userService.updateByID(id, user.getEmail());
        return ResponseEntity.ok(userModify);
    }
}
