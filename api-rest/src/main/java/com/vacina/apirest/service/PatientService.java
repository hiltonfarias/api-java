package com.vacina.apirest.service;

import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.repository.PatientRepository;
import com.vacina.apirest.requests.requestspatient.PatientPostRequestBody;
import com.vacina.apirest.requests.requestspatient.PatientPutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
//    private static List<Patient> patientList;
//
//    static {
//        patientList = new ArrayList<>(List.of(
//                new Patient(
//                        1L,
//                        "Hilton",
//                        "hilton@email.com",
//                        "999.999.999-99",
//                        LocalDate.of(1980, Month.APRIL, 12)
//                ),
//                new Patient(
//                        2L,
//                        "Adriana",
//                        "adriana@email.com",
//                        "888.888.888-88",
//                        LocalDate.of(1981, Month.MAY, 13)
//                )
//        ));
//    }

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> listAll() {
        return patientRepository.findAll();
    }

    public Patient findByIdOrThrowBadRequestException(Long id) {
        return patientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient ID not found"));
    }

    public Patient save(PatientPostRequestBody patientPostRequestBody) {
        return patientRepository.save(Patient.builder()
                .name(patientPostRequestBody.getName())
                .email(patientPostRequestBody.getEmail())
                .cpf(patientPostRequestBody.getCpf())
                .birthDate(patientPostRequestBody.getBirthDate())
                .build()
        );
    }

    public void delete(Long id) {
        patientRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(PatientPutRequestBody patientPutRequestBody) {
        Patient savedPatient = findByIdOrThrowBadRequestException(patientPutRequestBody.getId());
        Patient patient = Patient.builder()
                .id(savedPatient.getId())
                .name(patientPutRequestBody.getName())
                .email(patientPutRequestBody.getEmail())
                .cpf(patientPutRequestBody.getCpf())
                .birthDate(patientPutRequestBody.getBirthDate())
                .build();
        patientRepository.save(patient);
    }
}
