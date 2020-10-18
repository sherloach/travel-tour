package com.nqhtour.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nqhtour.dto.TourDTO;

@RestController(value = "TourAPIOfAdmin")
public class TourAPI {

	@PostMapping("/api/tour")
	public TourDTO createTour(@RequestBody TourDTO tourDTO) {
		return tourDTO;
	}

	@PutMapping("/api/tour")
	public TourDTO updateTour(@RequestBody TourDTO tourDTO) {
		return tourDTO;
	}

	@DeleteMapping("/api/tour")
	public void deleteTour(@RequestBody long[] ids) {
		System.out.print(ids[0] + ids[1] + ids[2]);
	}

}
