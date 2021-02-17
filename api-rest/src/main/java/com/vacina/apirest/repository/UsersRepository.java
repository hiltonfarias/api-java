package com.vacina.apirest.repository;

import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.domain.Vaccine;

import java.util.List;

public interface UsersRepository {
    List<Patient> listAll();
    List<Vaccine> listAllApplication();
}
