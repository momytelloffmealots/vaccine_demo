package com.example.vaccinationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VaccinationFormDetailCreateRequest {
    @NotBlank
    private String vaccineId;

    @Min(1)
    private int cnt;

    @Min(1)
    private int dose;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate retentionDate;

    @NotNull
    private BigDecimal price;

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public LocalDate getRetentionDate() {
        return retentionDate;
    }

    public void setRetentionDate(LocalDate retentionDate) {
        this.retentionDate = retentionDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

