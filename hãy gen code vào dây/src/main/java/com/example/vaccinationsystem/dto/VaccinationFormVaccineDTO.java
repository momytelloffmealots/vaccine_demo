package com.example.vaccinationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VaccinationFormVaccineDTO {
    private String vaccineId;
    private String vaccineName;
    private String vaccineTypeName;
    private String manufacturer;

    private int cnt;
    private int dose;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate retentionDate;

    private BigDecimal price;

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineTypeName() {
        return vaccineTypeName;
    }

    public void setVaccineTypeName(String vaccineTypeName) {
        this.vaccineTypeName = vaccineTypeName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

