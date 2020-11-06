package com.nqhtour.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.ITourService;

@RestController(value = "TourAPIOfAdmin")
public class TourAPI {
	@Autowired
	private ITourService tourService;

	@PostMapping("/api/tour")
	public TourDTO createTour(@RequestBody TourDTO tour) {
		return tourService.save(tour);
	}

	@PutMapping("/api/tour")
	public TourDTO updateTour(@RequestBody TourDTO tourUpdate) {
		return tourService.save(tourUpdate);
	}

	@DeleteMapping("/api/tour")
	public void deleteTour(@RequestBody long id) {
		tourService.delete(id);
	}

}
