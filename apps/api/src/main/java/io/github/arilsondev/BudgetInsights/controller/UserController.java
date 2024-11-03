package io.github.arilsondev.BudgetInsights.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arilsondev.BudgetInsights.model.User;
import io.github.arilsondev.BudgetInsights.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> users = userService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
    Optional<User> user = userService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<Optional<User>> findByEmail(@PathVariable String email) {
    Optional<User> user = userService.findByEmail(email);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User user) {
    user = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @PutMapping
  public ResponseEntity<User> update(@RequestBody User user) {
    user =  userService.update(user);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
