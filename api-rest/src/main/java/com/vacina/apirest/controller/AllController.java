package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;
import com.vacina.apirest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class AllController {

    private final UserService userService;

    public AllController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "user")
    public ResponseEntity<List<Users>> listUsers() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Users> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(path = "/application")
    public ResponseEntity<List<VaccineApplication>> listVaccines() {
        return ResponseEntity.ok(userService.listAllApplication());
    }

    @GetMapping(path = "/application/{email}")
    public ResponseEntity<VaccineApplication> findVaccineByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {
        return new ResponseEntity<>(userService.save(users), HttpStatus.CREATED);
    }

    @PostMapping(path = "/application")
    public ResponseEntity<VaccineApplication> saveApplication(@RequestBody VaccineApplication vaccineApplication) {
        return new ResponseEntity<>(userService.save(vaccineApplication), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/application/{email}")
    public ResponseEntity<Void> deleteApplication(@PathVariable String email) {
        userService.deleteApplication(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceUser(@RequestBody Users users) {
        userService.replace(users);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/application")
    public ResponseEntity<Void> replaceApplication(@RequestBody VaccineApplication vaccineApplication) {
        userService.replaceVaccine(vaccineApplication);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
