package com.nqhtour.api.admin;

import com.nqhtour.dto.BookingDTO;
import com.nqhtour.dto.RouteDTO;
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

	@GetMapping("/api/route/tour")
	public TourDTO readTourOnRoute(@RequestParam("route") Long routeId) {
		TourDTO tourDTO = new TourDTO();
		tourDTO.setListResult(tourService.findAllByRouteId(routeId));
		return tourDTO;
	}

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

	@PostMapping("/api/report/revenue")
	public BookingDTO revenueByMonth(@RequestParam("month") String month, @RequestParam("year") String year) {
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setListResult(tourService.revenueByMonth(month, year));
		return bookingDTO;
	}
}
