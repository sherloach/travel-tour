package com.nqhtour.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;

	public Long getId() {
		return id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
}
