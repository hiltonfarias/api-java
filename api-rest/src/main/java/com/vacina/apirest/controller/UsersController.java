package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    Users user1 = new Users("Hilton", "hilton@email.com", "999.999.999-99");
    Users user2 = new Users("Adriana", "adriana@email.com", "888.888.888-88");

    @GetMapping(path = "user")
    public List<Users> list() {
        return List.of(user1, user2);
    }
}
