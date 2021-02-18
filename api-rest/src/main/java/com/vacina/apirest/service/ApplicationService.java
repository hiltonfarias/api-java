package com.vacina.apirest.service;

import com.vacina.apirest.domain.Application;
import com.vacina.apirest.repository.ApplicationRepository;
import com.vacina.apirest.requests.requestsApplication.ApplicationPostRequestBody;
import com.vacina.apirest.requests.requestsApplication.ApplicationPutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> listAll(){
        return applicationRepository.findAll();
    }

    public Application findByIdOrThrowBadRequestException(Long id) {
        return applicationRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Application Id not found"));
    }

    public Application save(ApplicationPostRequestBody applicationPostRequestBody) {
        return applicationRepository.save(Application
                .builder()
                .email(applicationPostRequestBody.getEmail())
                .name(applicationPostRequestBody.getName())
                .vaccineDate(applicationPostRequestBody.getVaccineDate())
                .build()
        );
    }

    public void delete(Long id) {
        applicationRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ApplicationPutRequestBody applicationPutRequestBody) {
        Application savedApplication = findByIdOrThrowBadRequestException(applicationPutRequestBody.getId());
        Application application = Application
                .builder()
                .id(savedApplication.getId())
                .email(applicationPutRequestBody.getEmail())
                .name(applicationPutRequestBody.getName())
                .vaccineDate(applicationPutRequestBody.getVaccineDate())
                .build();
        applicationRepository.save(application);
    }
}
