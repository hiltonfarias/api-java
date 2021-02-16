package com.vacina.apirest.domain;

import java.time.LocalDate;

public class VaccineApplication {

    private String name;
    private String email;
    private LocalDate vaccineDate;

    public VaccineApplication() {
    }

    public VaccineApplication(String name, String email, LocalDate vaccineDate) {
        this.name = name;
        this.email = email;
        this.vaccineDate = vaccineDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }
}
