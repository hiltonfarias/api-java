package com.vacina.apirest.service;

import com.vacina.apirest.domain.Vaccine;
import com.vacina.apirest.repository.VaccineRepository;
import com.vacina.apirest.requests.requestsvaccine.VaccinePostRequestBody;
import com.vacina.apirest.requests.requestsvaccine.VaccinePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

//    private static List<Vaccine> vaccineList;
//
//    static {
//        vaccineList = new ArrayList<>(List.of(
//                new Vaccine(
//                        1L,
//                        "CoronaVac",
//                        "Sinovac",
//                        "Inactivated"
//                ),
//                new Vaccine(
//                        2L,
//                        "Pfizer",
//                        "Janssen Pharmaceutical Companies (Johnson)",
//                        "viral vector"
//                )
//        ));
//    }

    public List<Vaccine> listAll() {
        return vaccineRepository.findAll();
    }

    public Vaccine findByIdOrThrowBadRequestException(Long id) {
        return vaccineRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vaccine Id not found"));
    }

    public Vaccine save(VaccinePostRequestBody vaccinePostRequestBody) {
        return vaccineRepository.save(Vaccine.builder()
                .name(vaccinePostRequestBody.getName())
                .laboratory(vaccinePostRequestBody.getLaboratory())
                .typeOfVaccine(vaccinePostRequestBody.getTypeOfVaccine())
                .build()
        );
    }

    public void delete(Long id) {
        vaccineRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(VaccinePutRequestBody vaccinePutRequestBody) {
        Vaccine savedVaccine = findByIdOrThrowBadRequestException(vaccinePutRequestBody.getId());
        Vaccine vaccine = Vaccine.builder()
                .id(savedVaccine.getId())
                .name(vaccinePutRequestBody.getName())
                .laboratory(vaccinePutRequestBody.getLaboratory())
                .typeOfVaccine(vaccinePutRequestBody.getTypeOfVaccine()).build();
        vaccineRepository.save(vaccine);
    }
}
