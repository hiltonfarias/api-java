package com.vacina.apirest.service;

import com.vacina.apirest.domain.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PatientService {

    private static List<Patient> patientList;

    static {
        patientList = new ArrayList<>(List.of(
                new Patient(
                        1L,
                        "Hilton",
                        "hilton@email.com",
                        "999.999.999-99",
                        LocalDate.of(1980, Month.APRIL, 12)
                ),
                new Patient(
                        2L,
                        "Adriana",
                        "adriana@email.com",
                        "888.888.888-88",
                        LocalDate.of(1981, Month.MAY, 13)
                )
        ));
    }

    public List<Patient> listAll() {
        return patientList;
    }

    public Patient findById(Long id) {
        return patientList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID not found"));
    }

    public Patient save(Patient patient) {
        patient.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        patientList.add(patient);
        return patient;
    }

    public void delete(Long id) {
        patientList.remove(findById(id));
    }

    public void replace(Patient patient) {
        delete(patient.getId());
        patientList.add(patient);
    }
}
