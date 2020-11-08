package com.nqhtour.service;

import com.nqhtour.dto.ClientDTO;

public interface IClientService {
	ClientDTO findById(long id);
	ClientDTO save(ClientDTO dto);
}
