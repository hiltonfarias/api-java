package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Vaccine;
import com.vacina.apirest.requests.requestsvaccine.VaccinePostRequestBody;
import com.vacina.apirest.requests.requestsvaccine.VaccinePutRequestBody;
import com.vacina.apirest.service.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> list() {
        return new ResponseEntity<>(vaccineService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Vaccine> findVaccineById(@PathVariable Long id) {
        return new ResponseEntity<>(vaccineService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vaccine> save(@RequestBody VaccinePostRequestBody vaccinePostRequestBody) {
        return new ResponseEntity<>(vaccineService.save(vaccinePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vaccineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VaccinePutRequestBody vaccinePutRequestBody) {
        vaccineService.replace(vaccinePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
