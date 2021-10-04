package com.nqhtour.api.admin;

import com.nqhtour.dto.InstourDTO;
import com.nqhtour.service.IInstourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController(value = "InstourAPIOfAdmin")
public class InstourAPI {
    @Autowired
    IInstourService instourService;

    @GetMapping("/api/instours/{page}/{limit}")
    public InstourDTO readInstours(@PathVariable int page, @PathVariable int limit) {
        InstourDTO model = new InstourDTO();
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(instourService.findAll(pageable));
        return model;
    }

    @GetMapping("/api/instours/{id}")
    public InstourDTO readInstour(@PathVariable Long id) {
        InstourDTO model = instourService.findById(id);
        return model;
    }

    @PostMapping("/api/instours")
    public InstourDTO createInstour(@RequestBody InstourDTO dto) {
        return instourService.save(dto);
    }

    @PutMapping("/api/instours")
    public InstourDTO updateInstour(@RequestBody InstourDTO dto) {
        return instourService.save(dto);
    }

    @DeleteMapping("/api/instours")
    public void deleteInstour(@RequestBody Long instourId) {
        instourService.delete(instourId);
    }
}
