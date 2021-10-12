package com.nqhtour.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
@EntityListeners(AuditingEntityListener.class)
public class BookingEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "instour_id")
    private InstourEntity instour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column
    @CreatedDate
    private Date createdDate;

    @Column
    private boolean paid;

    @Column
    private Integer adultQuantity;

    @Column
    private Integer childrenQuantity;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @OneToOne(mappedBy = "booking")
    private InvoiceEntity invoice;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public InstourEntity getInstour() {
        return instour;
    }

    public void setInstour(InstourEntity instour) {
        this.instour = instour;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
