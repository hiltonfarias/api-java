package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;
import com.vacina.apirest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "user")
    public ResponseEntity<List<Users>> list() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping(path = "application")
    public ResponseEntity<List<VaccineApplication>> listVaccine() {
        return ResponseEntity.ok(userService.listAllApplication());
    }
}
