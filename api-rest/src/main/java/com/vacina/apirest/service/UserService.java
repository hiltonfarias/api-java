package com.vacina.apirest.service;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {

    public List<Users> listAll() {
        return List.of(
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
        );
    }

    public List<VaccineApplication> listAllApplication() {
        return List.of(
                new VaccineApplication(
                        "CoronaVac",
                        "hilton@email.com",
                        LocalDate.now().toString()
                ),
                new VaccineApplication(
                        "CoronaVac",
                        "adriana@email.com",
                        LocalDate.now().toString()
                )
        );
    }
}
