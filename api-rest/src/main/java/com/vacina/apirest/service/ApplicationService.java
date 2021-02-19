package com.vacina.apirest.service;

import com.vacina.apirest.domain.Application;
import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.domain.Vaccine;
import com.vacina.apirest.repository.ApplicationRepository;
import com.vacina.apirest.repository.PatientRepository;
import com.vacina.apirest.repository.VaccineRepository;
import com.vacina.apirest.requests.requestsApplication.ApplicationRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    private final VaccineRepository vaccineRepository;

    private final PatientRepository patientRepository;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            VaccineRepository vaccineRepository,
            PatientRepository patientRepository) {
        this.applicationRepository = applicationRepository;
        this.vaccineRepository = vaccineRepository;
        this.patientRepository = patientRepository;
    }

    public List<Application> listAll(){
        return applicationRepository.findAll();
    }

    public Application findByIdOrThrowBadRequestException(Long id) {
        return applicationRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Application Id not found"));
    }

    public Application save(ApplicationRequestBody applicationRequestBody) {
        Patient patient = patientRepository.findByEmail(applicationRequestBody.getEmail());
        Vaccine vaccine = vaccineRepository.findByName(applicationRequestBody.getNameVaccine());

        return applicationRepository.save(Application
                .builder()
                .patiente(patient)
                .vaccine(vaccine)
                .vaccineDate(LocalDate.now())
                .build()
        );
    }

    public void delete(Long id) {
        applicationRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ApplicationRequestBody applicationRequestBody) {
        Patient patient = patientRepository.findByEmail(applicationRequestBody.getEmail());
        Vaccine vaccine = vaccineRepository.findByName(applicationRequestBody.getNameVaccine());

        Application savedApplication = findByIdOrThrowBadRequestException(applicationRequestBody.getId());
        Application application = Application
                .builder()
                .id(savedApplication.getId())
                .patiente(patient)
                .vaccine(vaccine)
                .vaccineDate(LocalDate.now())
                .build();
        applicationRepository.save(application);
    }
}
