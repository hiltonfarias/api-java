package com.vacina.apirest.domain;

import java.time.LocalDate;

public class VaccineApplication {

    private Long id;
    private String name;
    private String email;
    private LocalDate vaccineDate;

    public VaccineApplication() {
    }

    public VaccineApplication(Long id, String name, String email, LocalDate vaccineDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.vaccineDate = vaccineDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
