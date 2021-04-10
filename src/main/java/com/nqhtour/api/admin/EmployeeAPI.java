package com.nqhtour.api.admin;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IEmployeeService;
import com.nqhtour.util.UploadFileUtil;

@RestController(value = "EmplAPIOfAdmin")
public class EmployeeAPI {
	@Autowired
	private IEmployeeService emplService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/api/empl/{page}/{limit}")
	public EmployeeDTO readEmpls(@PathVariable int page, @PathVariable int limit) {
		EmployeeDTO model = new EmployeeDTO();
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(emplService.findAll(pageable));
		return model;
	}

	@GetMapping("/api/empl/{id}")
	private EmployeeDTO readEmpl(@PathVariable Long id) {
		EmployeeDTO model = emplService.findById(id);
		return model;
	}

	@GetMapping("/api/empl/count")
	public int readTotalEmpl() {
		return emplService.getTotalItem();
	}
	
	@PostMapping("/api/empl")	
	public EmployeeDTO createEmpl(@RequestBody EmployeeDTO empl) {
		//byte[] decodeBase64 = Base64.getDecoder().decode(empl.getImagePath().getBytes());
		//String uploadRootPath = context.getRealPath("upload");
		//uploadFileUtil.writeOrUpdate(decodeBase64, uploadRootPath, empl.getImage());
		
		/*
		 * String[] pathnames; File f = new File(context.getRealPath("upload"));
		 * pathnames = f.list(); for (String pathname : pathnames) { // Print the names
		 * of files and directories System.out.println(pathname); }
		 */
		String imagePath = empl.getImagePath();
		EmployeeDTO newEmployee = emplService.save(empl);
		newEmployee.setImagePath(imagePath);
		return newEmployee;
	}

	@PutMapping("/api/empl")	
	public EmployeeDTO updateEmpl(@RequestBody EmployeeDTO oldEmpl) {
		return emplService.save(oldEmpl);
	}

	@DeleteMapping("/api/empl")
	public void deleteUser(@RequestBody long id) {
		emplService.delete(id);
	}

	@PostMapping("/api/empl/checkemail")
	public boolean checkEmailExist(@RequestBody String username) {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity == null) {
			return false;
		}

		return true;
	}
}
