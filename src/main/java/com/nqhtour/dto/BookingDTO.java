package com.nqhtour.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<BookingDTO> listResult = new ArrayList<>();
    private Date createdDate;
    private String clientName;
    private String clientPhone;
    private String tourName;
    private String imageTour;
    private String destination;
    private String startDate;
    private Long adultPrice;
    private Long childrenPrice;
    private InvoiceDTO invoice;
    private Long tourId;

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getImageTour() {
        return imageTour;
    }

    public void setImageTour(String imageTour) {
        this.imageTour = imageTour;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public Long getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Long adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Long getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(Long childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public List<BookingDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<BookingDTO> listResult) {
        this.listResult = listResult;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
