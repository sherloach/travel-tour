package com.nqhtour.api.admin;

import com.nqhtour.dto.TourLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nqhtour.dto.TourDTO;
import com.nqhtour.service.ITourService;

import java.io.IOException;

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
	public void deleteTourr(@RequestBody Long tourID) throws IOException {
		tourService.delete(tourID);
	}

	@PostMapping("/api/tour/location")
	public TourLocationDTO createTourLocation(@RequestBody TourLocationDTO tourLocation) {
		return tourService.save(tourLocation);
	}

	@PostMapping("/api/tour/delete")
	public String deleteTour(@RequestBody long id) {
		tourService.delete(id);
		return "true";
	}

}
