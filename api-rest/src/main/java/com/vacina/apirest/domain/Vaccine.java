package com.vacina.apirest.domain;

public class Vaccine {

    private Long id;
    private String name;
    private String laboratory;
    private String typeOfVaccine;

    public Vaccine(Long id, String name, String laboratory, String typeOfVaccine) {
        this.id = id;
        this.name = name;
        this.laboratory = laboratory;
        this.typeOfVaccine = typeOfVaccine;
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

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }

    public void setTypeOfVaccine(String typeOfVaccine) {
        this.typeOfVaccine = typeOfVaccine;
    }
}
