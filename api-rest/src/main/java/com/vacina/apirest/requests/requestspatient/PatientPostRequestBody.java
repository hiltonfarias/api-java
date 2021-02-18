package com.vacina.apirest.requests.requestspatient;

import java.time.LocalDate;
import java.util.Objects;

public class PatientPostRequestBody {
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

    public static PatientPostRequestBody.PatientPostRequestBodyBuilder builder() {
        return new PatientPostRequestBody.PatientPostRequestBodyBuilder();
    }

    public PatientPostRequestBody(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public PatientPostRequestBody() {
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
        PatientPostRequestBody that = (PatientPostRequestBody) o;
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
        return "PatientPostRequestBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public static class PatientPostRequestBodyBuilder {
        private String name;
        private String email;
        private String cpf;
        private LocalDate birthDate;

        public PatientPostRequestBodyBuilder() {
        }

        public PatientPostRequestBody.PatientPostRequestBodyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PatientPostRequestBody.PatientPostRequestBodyBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PatientPostRequestBody.PatientPostRequestBodyBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PatientPostRequestBody.PatientPostRequestBodyBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PatientPostRequestBody build() {
            return new PatientPostRequestBody(this.name, this.email, this.cpf, this.birthDate);
        }

        @Override
        public String toString() {
            return "PatientPostRequestBodyBuilder{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", birthDate=" + birthDate +
                    '}';
        }
    }
}
