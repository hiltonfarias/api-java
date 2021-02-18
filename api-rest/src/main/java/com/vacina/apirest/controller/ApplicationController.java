package com.vacina.apirest.controller;

import com.vacina.apirest.domain.Application;
import com.vacina.apirest.requests.requestsApplication.ApplicationPostRequestBody;
import com.vacina.apirest.requests.requestsApplication.ApplicationPutRequestBody;
import com.vacina.apirest.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> list() {
        return new ResponseEntity<>(applicationService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Application> find(@PathVariable Long id) {
        return new ResponseEntity<>(applicationService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Application> save(@RequestBody ApplicationPostRequestBody applicationPostRequestBody) {
        return new ResponseEntity<>(applicationService.save(applicationPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ApplicationPutRequestBody applicationPutRequestBody) {
        applicationService.replace(applicationPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
