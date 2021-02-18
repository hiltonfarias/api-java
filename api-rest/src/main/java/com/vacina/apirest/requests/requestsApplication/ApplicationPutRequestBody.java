package com.vacina.apirest.requests.requestsApplication;

import com.vacina.apirest.domain.Patient;
import com.vacina.apirest.domain.Vaccine;

import java.time.LocalDate;
import java.util.Objects;

public class ApplicationPutRequestBody {

    private Long id;
    private Patient email;
    private Vaccine name;
    private LocalDate vaccineDate;

    public static ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder builder() {
        return new ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder();
    }

    public ApplicationPutRequestBody(Long id, Patient email, Vaccine name, LocalDate vaccineDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.vaccineDate = vaccineDate;
    }

    public ApplicationPutRequestBody() {
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
        ApplicationPutRequestBody that = (ApplicationPutRequestBody) o;
        return id.equals(that.id) && email.equals(that.email) && name.equals(that.name) && vaccineDate.equals(that.vaccineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, vaccineDate);
    }

    public static class ApplicationPutRequestBodyBuilder {
        private Long id;
        private Patient email;
        private Vaccine name;
        private LocalDate vaccineDate;

        public ApplicationPutRequestBodyBuilder() {
        }

        public ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder email(Patient email) {
            this.email = email;
            return this;
        }

        public ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder name(Vaccine name) {
            this.name = name;
            return this;
        }

        public ApplicationPutRequestBody.ApplicationPutRequestBodyBuilder vaccineDate(LocalDate vaccineDate) {
            this.vaccineDate = vaccineDate;
            return this;
        }

        public ApplicationPutRequestBody build() {
            return new ApplicationPutRequestBody(this.id, this.email, this.name, this.vaccineDate);
        }

        @Override
        public String toString() {
            return "ApplicationPutRequestBodyBuilder{" +
                    "id=" + id +
                    ", email=" + email +
                    ", name=" + name +
                    ", vaccineDate=" + vaccineDate +
                    '}';
        }
    }
}
