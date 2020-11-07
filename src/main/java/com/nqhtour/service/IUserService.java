package com.nqhtour.service;

import com.nqhtour.dto.UserDTO;

public interface IUserService {
	UserDTO findById(long id);
	Long save(UserDTO dto);
	void delete(long id);
}
