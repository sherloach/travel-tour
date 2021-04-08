package com.nqhtour.api.web;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "TourAPIOfWeb")
public class TourAPI {

    @Autowired
    private ITourService tourService;

    @GetMapping("/api/tours")
    public TourDTO readTours() {
        TourDTO model = new TourDTO();
        Pageable pageable = new PageRequest(0, 9);
        model.setListResult(tourService.findAll(pageable));
        return model;
        //return tourService.findAll(pageable);
    }

    @GetMapping("/api/tours/{id}")
    public TourDTO readTour(@PathVariable Long id) {
        TourDTO model = new TourDTO();
        model = tourService.findById(id);
        return model;
    }

}
