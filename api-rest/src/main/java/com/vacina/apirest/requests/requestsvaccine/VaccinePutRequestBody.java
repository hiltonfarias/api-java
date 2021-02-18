package com.vacina.apirest.requests.requestsvaccine;

import java.util.Objects;

public class VaccinePutRequestBody {

    private Long id;
    private String name;
    private String laboratory;
    private String typeOfVaccine;

    public VaccinePutRequestBody(Long id, String name, String laboratory, String typeOfVaccine) {
        this.id = id;
        this.name = name;
        this.laboratory = laboratory;
        this.typeOfVaccine = typeOfVaccine;
    }

    public VaccinePutRequestBody() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinePutRequestBody that = (VaccinePutRequestBody) o;
        return id.equals(that.id) && name.equals(that.name) && laboratory.equals(that.laboratory) && typeOfVaccine.equals(that.typeOfVaccine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, laboratory, typeOfVaccine);
    }

    @Override
    public String toString() {
        return "VaccinePutRequestBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", typeOfVaccine='" + typeOfVaccine + '\'' +
                '}';
    }

    public static class VaccinePutRequestBodyBuilder {
        private Long id;
        private String name;
        private String laboratory;
        private String typeOfVaccine;

        public VaccinePutRequestBodyBuilder() {
        }

        public VaccinePutRequestBody.VaccinePutRequestBodyBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public VaccinePutRequestBody.VaccinePutRequestBodyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VaccinePutRequestBody.VaccinePutRequestBodyBuilder laboratory(String laboratory) {
            this.laboratory = laboratory;
            return this;
        }

        public VaccinePutRequestBody.VaccinePutRequestBodyBuilder typeOfVaccine(String typeOfVaccine) {
            this.typeOfVaccine = typeOfVaccine;
            return this;
        }

        public VaccinePutRequestBody build() {
            return new VaccinePutRequestBody(this.id, this.name, this.laboratory, this.typeOfVaccine);
        }

        @Override
        public String toString() {
            return "VaccinePutRequestBodyBuilder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", laboratory='" + laboratory + '\'' +
                    ", typeOfVaccine='" + typeOfVaccine + '\'' +
                    '}';
        }
    }
}
