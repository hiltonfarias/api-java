package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.requests.requestspatient.PatientPostRequestBody;
import com.vacina.apirest.requests.requestspatient.PatientPutRequestBody;
import com.vacina.apirest.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> listPatient() {
        return ResponseEntity.ok(patientService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientPostRequestBody patientPostRequestBody) {
        return new ResponseEntity<>(patientService.save(patientPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PatientPutRequestBody patientPutRequestBody) {
        patientService.replace(patientPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
