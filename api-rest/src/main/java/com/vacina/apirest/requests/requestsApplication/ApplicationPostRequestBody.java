package com.vacina.apirest.requests.requestsApplication;

import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.domain.Vaccine;

import java.time.LocalDate;
import java.util.Objects;

public class ApplicationPostRequestBody {

    private Patient email;
    private Vaccine name;
    private LocalDate vaccineDate;

    public static ApplicationPostRequestBody.ApplicationPostRequestBodyBuilder builder() {
        return new ApplicationPostRequestBody.ApplicationPostRequestBodyBuilder();
    }

    public ApplicationPostRequestBody(Patient email, Vaccine name, LocalDate vaccineDate) {
        this.email = email;
        this.name = name;
        this.vaccineDate = vaccineDate;
    }

    public ApplicationPostRequestBody(Patient email) {
        this.email = email;
    }

    public ApplicationPostRequestBody(Vaccine name) {
        this.name = name;
    }

    public ApplicationPostRequestBody(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public ApplicationPostRequestBody() {
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
        ApplicationPostRequestBody that = (ApplicationPostRequestBody) o;
        return email.equals(that.email) && name.equals(that.name) && vaccineDate.equals(that.vaccineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, vaccineDate);
    }

    public static class ApplicationPostRequestBodyBuilder {
        private Patient email;
        private Vaccine name;
        private LocalDate vaccineDate;

        public ApplicationPostRequestBodyBuilder() {
        }

        public ApplicationPostRequestBody.ApplicationPostRequestBodyBuilder email(Patient email) {
            this.email = email;
            return this;
        }

        public ApplicationPostRequestBody.ApplicationPostRequestBodyBuilder name(Vaccine name) {
            this.name = name;
            return this;
        }

        public ApplicationPostRequestBody.ApplicationPostRequestBodyBuilder vaccineDate(LocalDate vaccineDate) {
            this.vaccineDate = vaccineDate;
            return this;
        }

        public ApplicationPostRequestBody build() {
            return new ApplicationPostRequestBody(this.email, this.name, this.vaccineDate);
        }

        @Override
        public String toString() {
            return "ApplicationPostRequestBodyBuilder{" +
                    "email=" + email +
                    ", name=" + name +
                    ", vaccineDate=" + vaccineDate +
                    '}';
        }
    }
}
