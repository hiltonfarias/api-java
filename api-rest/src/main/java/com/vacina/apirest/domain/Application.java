package com.vacina.apirest.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne //(cascade = CascadeType.PERSIST)
    private Patient patient;
    @ManyToOne //(cascade = CascadeType.PERSIST)
    private Vaccine vaccine;
    private LocalDate vaccineDate;

    public static Application.ApplicationBuilder builder() {
        return new Application.ApplicationBuilder();
    }

    public Application(Long id, Patient patient, Vaccine vaccine, LocalDate vaccineDate) {
        this.id = id;
        this.patient = patient;
        this.vaccine = vaccine;
        this.vaccineDate = vaccineDate;
    }

    public Application( Patient patient) {
        this.patient = patient;
    }

    public Application( Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Application( LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public Application(Long id) {
        this.id = id;
    }

    public Application() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id.equals(that.id) &&
                patient.equals(that.patient) &&
                vaccine.equals(that.vaccine) &&
                vaccineDate.equals(that.vaccineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, vaccine, vaccineDate);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", email=" + patient +
                ", name=" + vaccine +
                ", vaccineDate=" + vaccineDate +
                '}';
    }

    public static class ApplicationBuilder {

        private Long id;
        private Patient patient;
        private Vaccine vaccine;
        private LocalDate vaccineDate;

        public ApplicationBuilder() {
        }

        public Application.ApplicationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Application.ApplicationBuilder patiente(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Application.ApplicationBuilder vaccine(Vaccine vaccine) {
            this.vaccine = vaccine;
            return this;
        }

        public Application.ApplicationBuilder vaccineDate(LocalDate vaccineDate) {
            this.vaccineDate = vaccineDate;
            return this;
        }

        public Application build(){
            return new Application(this.id, this.patient, this.vaccine, this.vaccineDate);
        }

        @Override
        public String toString() {
            return "ApplicationBuilder{" +
                    "id=" + id +
                    ", email=" + patient +
                    ", name=" + vaccine +
                    ", vaccineDate=" + vaccineDate +
                    '}';
        }
    }
}
