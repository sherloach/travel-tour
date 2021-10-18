package com.nqhtour.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nqhtour.dto.EmployeeDTO;

public interface IEmployeeService {
	List<EmployeeDTO> findAll(Pageable pageable);
	int getTotalItem();
	EmployeeDTO findById(long id);
	String findRoleByUserId(long userID);
	EmployeeDTO findOneByEmail(String email);
	EmployeeDTO save(EmployeeDTO dto);
	void delete(long id);
}
