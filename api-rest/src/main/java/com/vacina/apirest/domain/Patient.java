package com.vacina.apirest.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NaturalId
    @Column(unique = true)
    @NotEmpty
    @NotNull
    private String email;
    @NaturalId
    @Column(unique = true)
    @NotEmpty
    @NotNull
    private String cpf;
    private LocalDate birthDate;

    public static Patient.PatientBuilder builder() {
        return new Patient.PatientBuilder();
    }

    public Patient(
            Long id,
            @NotEmpty String name,
            @NotEmpty @NotNull String email,
            @NotEmpty @NotNull String cpf,
            LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Patient() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(cpf, patient.cpf) &&
                Objects.equals(birthDate, patient.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf, birthDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public static class PatientBuilder {
        private Long id;
        private String name;
        private String email;
        private String cpf;
        private LocalDate birthDate;

        public PatientBuilder() {
        }

        public Patient.PatientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Patient.PatientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Patient.PatientBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Patient.PatientBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Patient.PatientBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Patient build() {
            return new Patient(this.id, this.name, this.email, this.cpf, this.birthDate);
        }

        @Override
        public String toString() {
            return "PatientBuilder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", birthDate=" + birthDate +
                    '}';
        }
    }
}
