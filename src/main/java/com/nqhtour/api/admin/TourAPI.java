package com.nqhtour.api.admin;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
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
	public void deleteTour(@RequestBody long id) {
		//JsonNode parent = new ObjectMapper().readTree(data);
		//String tourID = parent.get("tourId").asText();
		tourService.delete(id);
	}

}
