package com.nqhtour.api.web;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.ITourService;
import com.nqhtour.specification.SearchCriteria;
import com.nqhtour.specification.TourSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "TourAPIOfWeb")
public class TourAPI {

    @Autowired
    private ITourService tourService;

    @GetMapping("/api/tours/{page}/{limit}")
    public TourDTO readTours(@PathVariable int page, @PathVariable int limit) {
        TourDTO model = new TourDTO();
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(tourService.findAll(pageable));
        //ResponseEntity.ok(true);
        return model;
    }

    @GetMapping("/api/tours/{id}")
    public TourDTO readTour(@PathVariable Long id) {
        TourDTO model = tourService.findById(id);
        return model;
    }

    @GetMapping("/api/tours/count")
    public int readTotalTour() {
        return tourService.getTotalItem();
    }

    @GetMapping("/api/tours/search/{name}")
    public TourDTO searchTours(@PathVariable String name) {
        if (name.contains(" ")) {
            name = name.replace(" ", "-");
        }
        TourDTO model = new TourDTO();
        TourSpecification tourSpecification = new TourSpecification(new SearchCriteria("tourID", ":", name));
        model.setListResult(tourService.findAll(tourSpecification));
        return model;
    }

    @GetMapping("/api/hot-tours")
    public TourDTO readHotTours(){
        TourDTO model = new TourDTO();
        model.setListResult(tourService.findHotTours());
        return model;
    }

    @GetMapping("/api/new-tours")
    public TourDTO readNewTours(){
        TourDTO model = new TourDTO();
        model.setListResult(tourService.findNewTours());
        return model;
    }
}
