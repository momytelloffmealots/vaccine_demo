package com.example.vaccinationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public class VaccinationFormCreateRequest {
    @Size(max = 10)
    private String vaccinationFormId; // optional (server can generate)

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vaccinationDate;

    @NotBlank
    private String customerId;

    @NotBlank
    private String doctorId;

    @NotBlank
    private String cashierId;

    @NotEmpty
    @Valid
    private List<VaccinationFormDetailCreateRequest> details;

    public String getVaccinationFormId() {
        return vaccinationFormId;
    }

    public void setVaccinationFormId(String vaccinationFormId) {
        this.vaccinationFormId = vaccinationFormId;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public List<VaccinationFormDetailCreateRequest> getDetails() {
        return details;
    }

    public void setDetails(List<VaccinationFormDetailCreateRequest> details) {
        this.details = details;
    }
}

