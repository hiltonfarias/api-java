package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    Users user1 = new Users("Hilton", "hilton@email.com", "999.999.999-99", "10/10/1980");
    Users user2 = new Users("Adriana", "adriana@email.com", "888.888.888-88", "1/1/1980");
    VaccineApplication vaccineApplication1 = new VaccineApplication(
            "CoronaVac",
            "hilton@email.com",
            "15/02/2021");

    VaccineApplication vaccineApplication2 = new VaccineApplication(
            "CoronaVac",
            "adriana@email.com",
            "16/02/2021");

    @GetMapping(path = "user")
    public List<Users> list() {
        return List.of(user1, user2);
    }

    @GetMapping(path = "application")
    public List<VaccineApplication> listVaccine() {
        return List.of(vaccineApplication1, vaccineApplication2);
    }
}
