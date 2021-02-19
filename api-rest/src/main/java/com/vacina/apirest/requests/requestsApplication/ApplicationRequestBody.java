package com.vacina.apirest.requests.requestsApplication;

public class ApplicationRequestBody {

    private Long id;
    private String email;
    private String nameVaccine;

    public static ApplicationRequestBodyBuilder builder() {
        return new ApplicationRequestBodyBuilder();
    }

    public ApplicationRequestBody(String email, String nameVaccine) {
        this.email = email;
        this.nameVaccine = nameVaccine;
    }

    public ApplicationRequestBody(Long id, String email, String nameVaccine) {
        this.id = id;
        this.email = email;
        this.nameVaccine = nameVaccine;
    }

    public ApplicationRequestBody() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameVaccine() {
        return nameVaccine;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    public static class ApplicationRequestBodyBuilder {
        private Long id;
        private String email;
        private String nameVaccine;

        public ApplicationRequestBodyBuilder() {
        }

        public ApplicationRequestBodyBuilder id (Long id) {
            this.id = id;
            return this;
        }

        public ApplicationRequestBodyBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ApplicationRequestBodyBuilder nameVaccine(String nameVaccine) {
            this.nameVaccine = nameVaccine;
            return this;
        }

        public ApplicationRequestBody build() {
            return new ApplicationRequestBody(this.id, this.email, this.nameVaccine);
        }
    }
}
