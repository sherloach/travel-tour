package com.nqhtour.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.service.IEmployeeService;

@RestController(value = "EmplAPIOfAdmin")
public class EmployeeAPI {
	@Autowired
	private IEmployeeService emplService;
	
	@PostMapping("/api/empl")	
	public EmployeeDTO createEmpl(@RequestBody EmployeeDTO empl) {
		return emplService.save(empl);
	}

	@PutMapping("/api/empl")	
	public EmployeeDTO updateEmpl(@RequestBody EmployeeDTO oldEmpl) {
		return emplService.save(oldEmpl);
	}

	@DeleteMapping("/api/empl")
	public void deleteUser(@RequestBody long id) {
		emplService.delete(id);
	}
}
