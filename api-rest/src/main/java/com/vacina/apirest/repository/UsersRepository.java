package com.vacina.apirest.repository;

import com.vacina.apirest.domain.Users;
import com.vacina.apirest.domain.VaccineApplication;

import java.util.List;

public interface UsersRepository {
    List<Users> listAll();
    List<VaccineApplication> listAllApplication();
}
