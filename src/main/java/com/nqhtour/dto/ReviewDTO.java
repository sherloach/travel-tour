package com.nqhtour.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDTO {
    private Long id;
    private String review;
    private Integer rating;
    private Date createdDate;
    private Long clientId;
    private Long tourId;
    private List<ReviewDTO> listResult = new ArrayList<>();

    public String getReview() {
        return review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public List<ReviewDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ReviewDTO> listResult) {
        this.listResult = listResult;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
}
