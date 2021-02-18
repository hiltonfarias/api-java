package com.vacina.apirest.requests.requestspatient;

import java.time.LocalDate;
import java.util.Objects;

public class PatientPutRequestBody {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

    public static PatientPutRequestBody.PatientPutRequestBodyBuilder builder() {
        return new PatientPutRequestBody.PatientPutRequestBodyBuilder();
    }

    public PatientPutRequestBody(Long id, String name, String email, String cpf, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public PatientPutRequestBody() {
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
        PatientPutRequestBody that = (PatientPutRequestBody) o;
        return name.equals(that.name) &&
                email.equals(that.email) &&
                cpf.equals(that.cpf) &&
                birthDate.equals(that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, cpf, birthDate);
    }

    @Override
    public String toString() {
        return "PatientPutRequestBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public static class PatientPutRequestBodyBuilder {
        private Long id;
        private String name;
        private String email;
        private String cpf;
        private LocalDate birthDate;

        public PatientPutRequestBodyBuilder() {
        }

        public PatientPutRequestBody.PatientPutRequestBodyBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PatientPutRequestBody.PatientPutRequestBodyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PatientPutRequestBody.PatientPutRequestBodyBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PatientPutRequestBody.PatientPutRequestBodyBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PatientPutRequestBody.PatientPutRequestBodyBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PatientPutRequestBody build() {
            return new PatientPutRequestBody(this.id, this.name, this.email, this.cpf, this.birthDate);
        }

        @Override
        public String toString() {
            return "PatientPutRequestBodyBuilder{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", birthDate=" + birthDate +
                    '}';
        }
    }
}
