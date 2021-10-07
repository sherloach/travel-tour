package com.nqhtour.service;

import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.UserDTO;

import java.util.List;

public interface IUserService {
	UserDTO findById(long id);
	List<EmployeeDTO> findAllByRole(String role);
	Long save(UserDTO dto);
	void delete(long id);
	boolean checkAccount(String username, String password);
}
