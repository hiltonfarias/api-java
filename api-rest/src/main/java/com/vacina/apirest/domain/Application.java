package com.vacina.apirest.domain;

import java.time.LocalDate;

public class Application {

    private Patient email;
    private Vaccine name;
    private LocalDate vaccineDate;

    public Application(Patient email, Vaccine name, LocalDate vaccineDate) {
        this.email = email;
        this.name = name;
        this.vaccineDate = vaccineDate;
    }

    public Patient getEmail() {
        return email;
    }

    public void setEmail(Patient email) {
        this.email = email;
    }

    public Vaccine getName() {
        return name;
    }

    public void setName(Vaccine name) {
        this.name = name;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }
}
