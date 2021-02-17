package com.vacina.apirest.service;

import com.vacina.apirest.domain.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VaccineService {

    private static List<Vaccine> vaccineList;

    static {
        vaccineList = new ArrayList<>(List.of(
                new Vaccine(
                        1L,
                        "CoronaVac",
                        "Sinovac",
                        "Inactivated"
                ),
                new Vaccine(
                        2L,
                        "Pfizer",
                        "Janssen Pharmaceutical Companies (Johnson)",
                        "viral vector"
                )
        ));
    }

    public List<Vaccine> listAll() {
        return vaccineList;
    }

    public static Vaccine findById(Long id) {
        return vaccineList
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vaccine Id not found"));
    }

    public Vaccine save(Vaccine vaccine) {
        vaccine.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        vaccineList.add(vaccine);
        return vaccine;
    }

    public void delete(Long id) {
        vaccineList.remove(findById(id));
    }

    public void replace(Vaccine vaccine) {
        delete(vaccine.getId());
        vaccineList.add(vaccine);
    }
}
