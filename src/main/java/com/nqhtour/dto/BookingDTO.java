package com.nqhtour.dto;


import java.util.Date;

public class BookingDTO {
    private Long id;
    private Integer adultQuantity;
    private Integer childrenQuantity;
    private Boolean paid;
    private String status;
    private Long instourId;
    private Long clientId;
    private Long employeeId;
    private String email;
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(Integer adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(Integer childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getInstourId() {
        return instourId;
    }

    public void setInstourId(Long instourId) {
        this.instourId = instourId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
