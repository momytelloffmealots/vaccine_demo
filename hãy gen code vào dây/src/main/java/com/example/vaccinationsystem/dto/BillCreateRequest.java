package com.example.vaccinationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillCreateRequest {
    private String billId; // optional

    @NotBlank
    private String vaccinationFormId;

    @NotBlank
    private String cashierId;

    @NotNull
    @Min(0)
    private BigDecimal discount;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    // optional: if null/empty, backend can compute
    private BigDecimal totalAmount;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getVaccinationFormId() {
        return vaccinationFormId;
    }

    public void setVaccinationFormId(String vaccinationFormId) {
        this.vaccinationFormId = vaccinationFormId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}

