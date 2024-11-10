/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.arilsondev.BudgetInsights.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arilsondev.BudgetInsights.model.Preference;
import io.github.arilsondev.BudgetInsights.service.PreferenceService;




/**
 *
 * @author arilson
 */
@RestController
@RequestMapping("/preference")
public class PreferenceController {

  @Autowired
  private PreferenceService preferenceService;

  @GetMapping
  public ResponseEntity<List<Preference>> findAll() {
    List<Preference> preferences = preferenceService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(preferences);
  }

  @PostMapping
  public ResponseEntity<Preference> save(@RequestBody Preference entity) {
    Preference preference = preferenceService.save(entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(preference);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Preference>> findById(@PathVariable String id) {
    Optional<Preference> preference = preferenceService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(preference);
  }

  @PutMapping("/{id}")
  public String update(@PathVariable String id, @RequestBody String entity) {
      //TODO: process PUT request
      
      return entity;
  }
  

}
