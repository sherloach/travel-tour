package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	EmployeeEntity findOneByUser(long id); // Tìm nhân viên theo id của bảng User
}
