package com.vacina.apirest.service;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {

    private static List<Users> usersList;
    private static List<VaccineApplication> vaccineApplicationList;

    static {
        usersList = new ArrayList<>(List.of(
                new Users(
                        1L,
                        "Hilton",
                        "hilton@email.com",
                        "999.999.999-99",
                        LocalDate.of(1980, Month.APRIL, 12)
                ),
                new Users(
                        2L,
                        "Adriana",
                        "adriana@email.com",
                        "888.888.888-88",
                        LocalDate.of(1981, Month.MAY, 13)
                )
        ));

        vaccineApplicationList = new ArrayList<>(List.of(
                new VaccineApplication(
                        "CoronaVac",
                        "hilton@email.com",
                        LocalDate.now()
                ),
                new VaccineApplication(
                        "CoronaVac",
                        "adriana@email.com",
                        LocalDate.now()
                )
        ));
    }

    public List<Users> listAll() {
        return usersList;
    }

    public Users findById(long id) {
        return usersList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID not found"));
    }

    public List<VaccineApplication> listAllApplication() {
        return vaccineApplicationList;
    }

    public VaccineApplication findByEmail(String email) {
        return vaccineApplicationList
                .stream()
                .filter(application -> application.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email not found"));
    }

    public Users save(Users users) {
        users.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        usersList.add(users);
        return users;
    }

    public VaccineApplication save(VaccineApplication vaccineApplication) {
        vaccineApplication.setEmail("miguel@email.com");
        vaccineApplication.setVaccineDate(LocalDate.now());
        vaccineApplicationList.add(vaccineApplication);
        return vaccineApplication;
    }
}
