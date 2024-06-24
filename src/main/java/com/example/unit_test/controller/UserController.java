package com.example.unit_test.controller;

import com.example.unit_test.entity.User;
import com.example.unit_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  @PostMapping
  ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.create(user));
  }
}
