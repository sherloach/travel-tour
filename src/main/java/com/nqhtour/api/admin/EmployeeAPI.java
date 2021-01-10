package com.nqhtour.api.admin;

import java.io.File;
import java.util.Base64;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private UploadFileUtil uploadFileUtil;
	
	@Autowired
	private ServletContext context;
	
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
