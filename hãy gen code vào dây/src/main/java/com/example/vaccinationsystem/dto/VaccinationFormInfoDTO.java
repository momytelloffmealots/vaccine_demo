package com.example.vaccinationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class VaccinationFormInfoDTO {
    private String vaccinationFormId;
    private String customerId;
    private String customerName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate customerBirthDate;

    private String gender;
    private String biography;
    private String email;
    private String phoneNum;

    private String doctorName;
    private String cashierName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vaccinationDate;

    public String getVaccinationFormId() {
        return vaccinationFormId;
    }

    public void setVaccinationFormId(String vaccinationFormId) {
        this.vaccinationFormId = vaccinationFormId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthDate() {
        return customerBirthDate;
    }

    public void setCustomerBirthDate(LocalDate customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}

