package com.vacina.apirest.domain;

public class VaccineApplication {

    private String name;
    private String email;
    private String vaccineDate;

    public VaccineApplication() {
    }

    public VaccineApplication(String name, String email, String vaccineDate) {
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

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
    }
}
