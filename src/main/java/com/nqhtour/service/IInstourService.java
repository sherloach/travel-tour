package com.nqhtour.service;

import com.nqhtour.dto.InstourDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInstourService {
    List<InstourDTO> findAll(Pageable pageable);
    int getTotalItem();
    InstourDTO findById(long id);
    InstourDTO save(InstourDTO dto);
    void delete(long id);
}
