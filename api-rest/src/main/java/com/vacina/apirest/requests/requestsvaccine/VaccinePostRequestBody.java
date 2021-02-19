package com.vacina.apirest.requests.requestsvaccine;

import java.util.Objects;

public class VaccinePostRequestBody {

    private String name;
    private String laboratory;
    private String typeOfVaccine;

    public static VaccinePostRequestBody.VaccinePostRequestBodyBuilder builder() {
        return new VaccinePostRequestBody.VaccinePostRequestBodyBuilder();
    }

    public VaccinePostRequestBody(String name, String laboratory, String typeOfVaccine) {
        this.name = name;
        this.laboratory = laboratory;
        this.typeOfVaccine = typeOfVaccine;
    }

    public VaccinePostRequestBody(String name) {
        this.name = name;
    }

    public VaccinePostRequestBody() {
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
        VaccinePostRequestBody that = (VaccinePostRequestBody) o;
        return name.equals(that.name) && laboratory.equals(that.laboratory) && typeOfVaccine.equals(that.typeOfVaccine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, laboratory, typeOfVaccine);
    }

    @Override
    public String toString() {
        return "VaccinePostRequestBody{" +
                "name='" + name + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", typeOfVaccine='" + typeOfVaccine + '\'' +
                '}';
    }

    public static class VaccinePostRequestBodyBuilder {
        private String name;
        private String laboratory;
        private String typeOfVaccine;

        public VaccinePostRequestBodyBuilder() {
        }

        public VaccinePostRequestBody.VaccinePostRequestBodyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VaccinePostRequestBody.VaccinePostRequestBodyBuilder laboratory(String laboratory) {
            this.laboratory = laboratory;
            return this;
        }

        public VaccinePostRequestBody.VaccinePostRequestBodyBuilder typeOfVaccine(String typeOfVaccine) {
            this.typeOfVaccine = typeOfVaccine;
            return this;
        }

        public VaccinePostRequestBody build() {
            return new VaccinePostRequestBody(this.name, this.laboratory, this.typeOfVaccine);
        }

        @Override
        public String toString() {
            return "VaccinePostRequestBodyBuilder{" +
                    "name='" + name + '\'' +
                    ", laboratory='" + laboratory + '\'' +
                    ", typeOfVaccine='" + typeOfVaccine + '\'' +
                    '}';
        }
    }
}
