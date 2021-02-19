package com.vacina.apirest.repository;

import com.vacina.apirest.domain.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    Vaccine findByName(String nameVaccine);
}
