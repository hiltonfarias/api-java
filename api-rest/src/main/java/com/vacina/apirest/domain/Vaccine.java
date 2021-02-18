package com.vacina.apirest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String laboratory;
    private String typeOfVaccine;

    public static Vaccine.VaccineBuilder builder() {
        return  new Vaccine.VaccineBuilder();
    }

    public Vaccine(Long id, String name, String laboratory, String typeOfVaccine) {
        this.id = id;
        this.name = name;
        this.laboratory = laboratory;
        this.typeOfVaccine = typeOfVaccine;
    }

    public Vaccine() {
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

    public static class VaccineBuilder {
        private Long id;
        private String name;
        private String laboratory;
        private String typeOfVaccine;

        public VaccineBuilder() {
        }

        public Vaccine.VaccineBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Vaccine.VaccineBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Vaccine.VaccineBuilder laboratory(String laboratory) {
            this.laboratory = laboratory;
            return this;
        }

        public Vaccine.VaccineBuilder typeOfVaccine(String typeOfVaccine) {
            this.typeOfVaccine = typeOfVaccine;
            return this;
        }

        public Vaccine build() {
            return new Vaccine(this.id, this.name, this.laboratory, this.typeOfVaccine);
        }

        @Override
        public String toString() {
            return "VaccineBuilder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", laboratory='" + laboratory + '\'' +
                    ", typeOfVaccine='" + typeOfVaccine + '\'' +
                    '}';
        }
    }
}
