package com.vacina.apirest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Patient email;
    @OneToOne(cascade = CascadeType.PERSIST)
    @NotEmpty
    private Vaccine name;
    @NotEmpty
    private LocalDate vaccineDate;

    public static Application.ApplicationBuilder builder() {
        return new Application.ApplicationBuilder();
    }

    public Application(Long id, Patient email, @NotEmpty Vaccine name, @NotEmpty LocalDate vaccineDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.vaccineDate = vaccineDate;
    }

    public Application() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id.equals(that.id) && email.equals(that.email) && name.equals(that.name) && vaccineDate.equals(that.vaccineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, vaccineDate);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", vaccineDate=" + vaccineDate +
                '}';
    }

    public static class ApplicationBuilder {

        private Long id;
        private Patient email;
        private Vaccine name;
        private LocalDate vaccineDate;

        public ApplicationBuilder() {
        }

        public Application.ApplicationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Application.ApplicationBuilder email(Patient email) {
            this.email = email;
            return this;
        }

        public Application.ApplicationBuilder name(Vaccine name) {
            this.name = name;
            return this;
        }

        public Application.ApplicationBuilder vaccineDate(LocalDate vaccineDate) {
            this.vaccineDate = vaccineDate;
            return this;
        }

        public Application build(){
            return new Application(this.id, this.email, this.name, this.vaccineDate);
        }

        @Override
        public String toString() {
            return "ApplicationBuilder{" +
                    "id=" + id +
                    ", email=" + email +
                    ", name=" + name +
                    ", vaccineDate=" + vaccineDate +
                    '}';
        }
    }
}
